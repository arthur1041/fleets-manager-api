package br.com.artcruz.codeminerchallenge.domain.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.artcruz.codeminerchallenge.domain.model.entity.Transaction;
import br.com.artcruz.codeminerchallenge.domain.repository.IRepository;
import br.com.artcruz.codeminerchallenge.helper.PilotPercentageHelper;
import br.com.artcruz.codeminerchallenge.helper.PlanetWeightReportHelper;
import br.com.artcruz.codeminerchallenge.infrastructure.repository.ReportRepository;

/**
 * @author: Arthur Cruz
 */
@Service
public class ReportService {

	@Autowired
	private ReportRepository reportRepository;

	@Autowired
	private IRepository<Transaction> transactionRepository;

	public Map<String, PlanetWeightReportHelper> sentAndReceivedTotals() {

		try {
			return reportRepository.sentAndReceivedTotals();
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong while generating the report");
		}

	}

	public Map<Integer, PilotPercentageHelper> pilotTravelsStats() {
		try {
			return reportRepository.pilotTravelsStats();
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong while generating the report");
		}

	}

	public List<Transaction> transactionHistory() {
		try {
			List<Transaction> transactions = transactionRepository.list();
			Collections.reverse(transactions);

			return transactions;
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong while generating the report");
		}

	}

}
