package br.com.artcruz.codeminerchallenge.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.artcruz.codeminerchallenge.domain.exception.EmptyAttributeException;
import br.com.artcruz.codeminerchallenge.domain.exception.EntityNotFoundException;
import br.com.artcruz.codeminerchallenge.domain.exception.NotEnoughMoneyException;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Pilot;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Ship;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Transaction;
import br.com.artcruz.codeminerchallenge.domain.repository.IRepository;

/**
 * @author: Arthur Cruz
 */
@Service
public class ShipService implements IService<Ship>{

	@Autowired
	private IRepository<Ship> shipRepository;
	
	@Autowired
	private IRepository<Pilot> pilotRepository;
	
	@Autowired
	private IService<Pilot> pilotService;

	@Autowired
	private IRepository<Transaction> transactionRepository;
	
	@Override
	public Ship save(Ship ship) {
		if(ship.getFuelCapacity() == null)
			throw new EmptyAttributeException("fuelCapacity");
		
		if(ship.getPilot() == null)
			throw new EmptyAttributeException("pilot id");
		
		if(ship.getPilot().getId() == null)
			throw new EmptyAttributeException("pilot id");
		
		if(ship.getPilot().getId() == 0)
			throw new EmptyAttributeException("pilot id");
			
		return shipRepository.createOrUpdate(ship);
	}

	@Override
	public Ship update(Integer id, Ship ship) {
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
	public Ship find(Integer id) {
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
	public void remove(Integer id) {
		try {
			shipRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(Ship.class, id);
		}
		
	}
	
	public void refuel(Ship spaceship, Integer amount) {
		Ship ship = shipRepository.findById(spaceship.getId());
		
		Integer price = 7*(amount);
		Pilot pilot = ship.getPilot();
		
		if(pilot.getCredits()<price)
			throw new NotEnoughMoneyException();
		
		ship.addFuel(amount);
		
		
		pilot.addCredits(-price);
		Transaction transaction = new Transaction();
		
		transaction.setDescription(pilot.getName() + " bought fuel");
		transaction.setValue(Math.abs(price));
		
		pilotService.update(pilot.getId(), pilot);
		transactionRepository.createOrUpdate(transaction);
	}

}
