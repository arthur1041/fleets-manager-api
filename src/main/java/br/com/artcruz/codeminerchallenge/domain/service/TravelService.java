package br.com.artcruz.codeminerchallenge.domain.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.artcruz.codeminerchallenge.domain.exception.BlockedRouteException;
import br.com.artcruz.codeminerchallenge.domain.exception.InvalidTravelDestinationException;
import br.com.artcruz.codeminerchallenge.domain.exception.NoShipsAvailableException;
import br.com.artcruz.codeminerchallenge.domain.exception.NotEnoughFuelException;
import br.com.artcruz.codeminerchallenge.domain.exception.PilotTooYoungException;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Pilot;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Ship;
import br.com.artcruz.codeminerchallenge.helper.PlanetHelper;
import br.com.artcruz.codeminerchallenge.helper.RouteHelper;

@Service
public class TravelService {

	@Autowired
	private IService<Pilot> pilotService;

	@Autowired
	private IService<Ship> shipService;
	
	public void doFreeTravel(Integer idFrom, Integer idTo, Integer idPilot) {
		RouteHelper route = new RouteHelper(idFrom, idTo);

		if ((idFrom < 1 || idFrom > 4) || (idTo < 1 || idTo > 4)) {
			throw new InvalidTravelDestinationException();
		}

		List<RouteHelper> routeHelper = PlanetHelper.getRoutesInfo();

		int index = routeHelper.indexOf(route);

		route = routeHelper.get(index);

		if (route.isBlocked()) {
			throw new BlockedRouteException();
		}

		Pilot pilot = pilotService.find(idPilot);

		if (pilot != null) {
			if(pilot.getAge() < 18)
				throw new PilotTooYoungException();
			
			if (pilot.getShips().size() <= 0) {
				throw new NoShipsAvailableException();
			}

			Ship shipWithMostFuel = pilot.getShips().get(0);
			for (Ship ship : pilot.getShips()) {
				if (ship.getFuelLevel() > shipWithMostFuel.getFuelLevel()) {
					shipWithMostFuel = ship;
				}
			}

			if (shipWithMostFuel.getFuelLevel() < route.getFuelCost()) {
				throw new NotEnoughFuelException();
			}

			shipWithMostFuel.setFuelLevel(shipWithMostFuel.getFuelLevel() - route.getFuelCost());

			Map<Integer, String> planets = PlanetHelper.getPlanetsMap();
			
			shipService.update(shipWithMostFuel.getId(), shipWithMostFuel);
			pilot.setLocationPlanet(planets.get(idTo));
			pilotService.update(pilot.getId(), pilot);
		}
	}

}
