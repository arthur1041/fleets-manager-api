package br.com.artcruz.codeminerchallenge.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import br.com.artcruz.codeminerchallenge.domain.exception.EntityNotFoundException;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Pilot;
import br.com.artcruz.codeminerchallenge.domain.repository.Repository;

public class PilotService implements Service<Pilot>{

	@Autowired
	private Repository<Pilot> pilotRepository;

	@Override
	public Pilot save(Pilot pilot) {
		return pilotRepository.createOrUpdate(pilot);
	}

	@Override
	public Pilot update(int id, Pilot pilot) {
		Pilot currentPilot = pilotRepository.findById(id);
		
		if(currentPilot == null)
			throw new EntityNotFoundException(Pilot.class, id);
		
		if(pilot.getBirthDate() != null)
			currentPilot.setBirthDate(pilot.getBirthDate());
		
		if(pilot.getCredits() != null)
			currentPilot.setCredits(pilot.getCredits());
		
		if(pilot.getLocationPlanet() != null) 
			currentPilot.setLocationPlanet(pilot.getLocationPlanet());
		
		if(pilot.getName() != null) 
			currentPilot.setName(pilot.getName());
		
		if(pilot.getPilotCertification() != null)
			currentPilot.setPilotCertification(pilot.getPilotCertification());
		
		return pilotRepository.createOrUpdate(currentPilot);
			
	}

	@Override
	public Pilot find(int id) {
		Pilot pilot = pilotRepository.findById(id);
		
		if(pilot == null)
			throw new EntityNotFoundException(Pilot.class, id);
		
		return pilot;
	}

	@Override
	public List<Pilot> list() {
		return pilotRepository.list();
	}

	@Override
	public void remove(int id) {
		try {
			pilotRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(Pilot.class, id);
		}
	}
	
	
}
