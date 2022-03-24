package br.com.artcruz.codeminerchallenge.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.artcruz.codeminerchallenge.domain.exception.EntityNotFoundException;
import br.com.artcruz.codeminerchallenge.domain.exception.InvalidResourceNameException;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Contract;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Resource;
import br.com.artcruz.codeminerchallenge.domain.repository.IRepository;
import br.com.artcruz.codeminerchallenge.util.Utils;

/**
 * @author: Arthur Cruz
 */
@Service
public class ResourceService implements IService<Resource> {

	@Autowired
	private IRepository<Resource> resourceRepository;
 	
	@Autowired
	private IRepository<Contract> contractRepository;
	
	@Override
	public Resource save(Resource resource) {
		if(!Utils.validateResourceName(resource.getName()))
			throw new InvalidResourceNameException();
		
		return resourceRepository.createOrUpdate(resource);
	}

	@Override
	public Resource update(Integer id, Resource resource) {
		Resource currentResource = resourceRepository.findById(id);
		
		if(currentResource == null)
			throw new EntityNotFoundException(Resource.class, id);
		
		if(resource.getContract() != null) {
			Contract contract = contractRepository.findById(id);
			
			if(contract == null)
				throw new EntityNotFoundException(Contract.class, resource.getContract().getId());
		}
		
		if(resource.getName() != null) {
			if(!Utils.validateResourceName(resource.getName()))
				throw new InvalidResourceNameException();
			
			currentResource.setName(resource.getName());
		}
		
		if(resource.getWeight() != null)
			currentResource.setWeight(resource.getWeight());
		
		return resourceRepository.createOrUpdate(currentResource);
		
	}

	@Override
	public Resource find(Integer id) {
		Resource resource = resourceRepository.findById(id);
		
		if(resource == null)
			throw new EntityNotFoundException(Resource.class, id);
		
		
		return resource;
	}

	@Override
	public List<Resource> list() {
		return resourceRepository.list();
	}

	@Override
	public void remove(int id) {
		try {
			resourceRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(Resource.class, id);
		}
		
	}

	
	
}
