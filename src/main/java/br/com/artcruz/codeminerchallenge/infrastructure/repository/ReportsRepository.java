package br.com.artcruz.codeminerchallenge.infrastructure.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;


@Component
public class ReportsRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void sentAndReceivedTotals() {
		Query q = entityManager.createQuery("SELECT c.destinationPlanet, sum(r.weight) from Resource r "
				+ "INNER JOIN r.contract c WHERE c.destinationPlanet in (:andvari, :aqua, :calas, :demeter)");
	}
	
}
