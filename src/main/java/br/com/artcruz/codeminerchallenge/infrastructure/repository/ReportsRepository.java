package br.com.artcruz.codeminerchallenge.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import br.com.artcruz.codeminerchallenge.domain.enums.PlanetEnum;
import br.com.artcruz.codeminerchallenge.domain.enums.ResourceEnum;
import br.com.artcruz.codeminerchallenge.helper.MovHelper;
import br.com.artcruz.codeminerchallenge.helper.PlanetWeightReportHelper;

@Component
public class ReportsRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Map<String, PlanetWeightReportHelper> sentAndReceivedTotals() {

		String sqlStringSent = "select c.origin_planet, r.name, sum(r.weight) "
				+ "from contract c inner join resource r on c.id = r.contract_id "
				+ "where c.accomplished = true and c.origin_planet "
				+ "in (:aqua, :demeter, :calas, :andvari) "
				+ "group by c.origin_planet, r.name;";

		
		
		Query qSent = entityManager.createNativeQuery(sqlStringSent);
		
		qSent.setParameter("aqua", PlanetEnum.AQUA.label);
		qSent.setParameter("demeter", PlanetEnum.DEMETER.label);
		qSent.setParameter("calas", PlanetEnum.CALAS.label);
		qSent.setParameter("andvari", PlanetEnum.ANDVARI.label);
		
		String sqlStringRec = "select c.destination_planet, r.name, sum(r.weight) "
				+ "from contract c inner join resource r on c.id = r.contract_id "
				+ "where c.accomplished = true and c.destination_planet "
				+ "in (:aqua, :demeter, :calas, :andvari) "
				+ "group by c.destination_planet, r.name;";
		
		Query qRec = entityManager.createNativeQuery(sqlStringRec);
		
		qRec.setParameter("aqua", PlanetEnum.AQUA.label);
		qRec.setParameter("demeter", PlanetEnum.DEMETER.label);
		qRec.setParameter("calas", PlanetEnum.CALAS.label);
		qRec.setParameter("andvari", PlanetEnum.ANDVARI.label);
		
		@SuppressWarnings("unchecked")
		List<Object> sentObjList = qSent.getResultList();
		@SuppressWarnings("unchecked")
		List<Object> recObjList = qRec.getResultList();
		
		Map<String, PlanetWeightReportHelper> weightReportMap = new TreeMap<>();
		
		weightReportMap.put(PlanetEnum.ANDVARI.label, new PlanetWeightReportHelper(new MovHelper(), new MovHelper()));
		weightReportMap.put(PlanetEnum.AQUA.label, new PlanetWeightReportHelper(new MovHelper(), new MovHelper()));
		weightReportMap.put(PlanetEnum.CALAS.label, new PlanetWeightReportHelper(new MovHelper(), new MovHelper()));
		weightReportMap.put(PlanetEnum.DEMETER.label, new PlanetWeightReportHelper(new MovHelper(), new MovHelper()));
	
		for (Object object : sentObjList) {
			Object[] objArray = (Object[])object;
			String planetName = ((String)objArray[0]);
			String restName = ((String)objArray[1]);
			Integer qty = ((BigDecimal)objArray[2]).intValue();
			
			if(restName.equalsIgnoreCase(ResourceEnum.FOOD.label))
				weightReportMap.get(planetName).sent.food = qty;

			if(restName.equalsIgnoreCase(ResourceEnum.MINERALS.label))
				weightReportMap.get(planetName).sent.minerals = qty;
			
			if(restName.equalsIgnoreCase(ResourceEnum.WATER.label))
				weightReportMap.get(planetName).sent.water = qty;
		}
		
		for (Object object : recObjList) {
			Object[] objArray = (Object[])object;
			String planetName = ((String)objArray[0]);
			String restName = ((String)objArray[1]);
			Integer qty = ((BigDecimal)objArray[2]).intValue();
			
			if(restName.equalsIgnoreCase(ResourceEnum.FOOD.label))
				weightReportMap.get(planetName).received.food = qty;

			if(restName.equalsIgnoreCase(ResourceEnum.MINERALS.label))
				weightReportMap.get(planetName).received.minerals = qty;
			
			if(restName.equalsIgnoreCase(ResourceEnum.WATER.label))
				weightReportMap.get(planetName).received.water = qty;
		}
			
		return weightReportMap;
	}

}
