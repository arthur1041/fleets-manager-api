package br.com.artcruz.codeminerchallenge.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.artcruz.codeminerchallenge.domain.exception.EntityNotFoundException;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Pilot;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Ship;
import br.com.artcruz.codeminerchallenge.domain.repository.IRepository;

@Service
public class ShipService implements IService<Ship>{

	@Autowired
	private IRepository<Ship> shipRepository;
	
	@Autowired
	private IRepository<Pilot> pilotRepository;
	
	@Override
	public Ship save(Ship ship) {
		return shipRepository.createOrUpdate(ship);
	}

	@Override
	public Ship update(int id, Ship ship) {
		Ship currentShip = shipRepository.findById(id);
		
		if(currentShip == null)
			throw new EntityNotFoundException(Ship.class, id);
		
		if(ship.getPilot() != null) {
			Pilot pilot = pilotRepository.findById(ship.getPilot().getId());
			
			if(pilot == null)
				throw new EntityNotFoundException(Pilot.class, ship.getPilot().getId());
		
			currentShip.setPilot(pilot);
		}
		
		if(ship.getFuelCapacity() != null)
			currentShip.setFuelCapacity(ship.getFuelCapacity());
			
		if(ship.getFuelLevel() != null)
			currentShip.setFuelLevel(ship.getFuelLevel());
		
		return shipRepository.createOrUpdate(currentShip);		
	}

	@Override
	public Ship find(int id) {
		Ship ship = shipRepository.findById(id);
		
		if(ship == null)
			throw new EntityNotFoundException(Ship.class, id);
		
		return ship;
	}

	@Override
	public List<Ship> list() {
		return shipRepository.list();
	}

	@Override
	public void remove(int id) {
		try {
			shipRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(Ship.class, id);
		}
		
	}

}
