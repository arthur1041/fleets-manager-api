package br.com.artcruz.codeminerchallenge.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.artcruz.codeminerchallenge.domain.exception.EmptyAttributeException;
import br.com.artcruz.codeminerchallenge.domain.exception.EntityNotFoundException;
import br.com.artcruz.codeminerchallenge.domain.exception.InvalidPlanetNameException;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Contract;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Pilot;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Ship;
import br.com.artcruz.codeminerchallenge.domain.repository.IRepository;
import br.com.artcruz.codeminerchallenge.util.Utils;

/**
 * @author: Arthur Cruz
 */
@Service
public class ContractService implements IService<Contract> {

	@Autowired
	private IRepository<Contract> contractRepository;
	
	@Autowired
	private IRepository<Pilot> pilotRepository;
	
	@Autowired
	private IRepository<Ship> shipRepository;
	
	
	@Override
	public Contract save(Contract contract) {
		if(!Utils.validatePlanetName(contract.getDestinationPlanet())) {
			throw new InvalidPlanetNameException();
		}
		
		if(!Utils.validatePlanetName(contract.getOriginPlanet())) {
			throw new InvalidPlanetNameException();
		}
		
		if(contract.getPilot() == null)
			throw new EmptyAttributeException("pilot id");
		
		if(contract.getPilot().getId() == null)
			throw new EmptyAttributeException("pilot id");
		
		if(contract.getPilot().getId() == 0)
			throw new EmptyAttributeException("pilot id");
		
		if(contract.getShip() == null)
			throw new EmptyAttributeException("ship id");
		
		if(contract.getShip().getId() == null)
			throw new EmptyAttributeException("ship id");
		
		if(contract.getShip().getId() == 0)
			throw new EmptyAttributeException("ship id");
		
		if(contract.getDescription() == null)
			throw new EmptyAttributeException("description");
		
		if(contract.getDescription().isEmpty())
			throw new EmptyAttributeException("description");
		
		if(contract.getValue() == null)
			throw new EmptyAttributeException("value");
		
		return contractRepository.createOrUpdate(contract);
	}

	@Override
	public Contract update(int id, Contract contract) {
		Contract currentContract = contractRepository.findById(id);
		
		if(currentContract == null)
			throw new EntityNotFoundException(Contract.class, id);
		
		if(contract.getPilot() != null) {
			Pilot pilot = pilotRepository.findById(contract.getPilot().getId());
			
			if(pilot == null)
				throw new EntityNotFoundException(Pilot.class, id);
			
			currentContract.setPilot(pilot);
		}
		
		if(contract.getShip() != null) {
			Ship ship = shipRepository.findById(contract.getShip().getId());
			
			if(ship == null)
				throw new EntityNotFoundException(Ship.class, id);
			
			currentContract.setShip(ship);
		}
		
		if(contract.getDescription() != null)
			currentContract.setDescription(contract.getDescription());
		
		if(contract.getDestinationPlanet() != null) {
			if(!Utils.validatePlanetName(contract.getDestinationPlanet()))
				throw new InvalidPlanetNameException();

			currentContract.setDestinationPlanet(contract.getDestinationPlanet());
		}
		
		if(contract.getOriginPlanet() != null) {
			if(!Utils.validatePlanetName(contract.getOriginPlanet()))
				throw new InvalidPlanetNameException();

			currentContract.setOriginPlanet(contract.getOriginPlanet());
		}
		
		if(contract.getValue() != null)
			currentContract.setValue(contract.getValue());
		
		return contractRepository.createOrUpdate(currentContract);
	}

	@Override
	public Contract find(int id) {
		Contract contract = contractRepository.findById(id);
		
		if(contract == null)
			throw new EntityNotFoundException(Contract.class, id);
		
		return contract;
	}

	@Override
	public List<Contract> list() {
		return contractRepository.list();
	}

	@Override
	public void remove(int id) {
		try {
			contractRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(Contract.class, id);
		}
		
	}

}
