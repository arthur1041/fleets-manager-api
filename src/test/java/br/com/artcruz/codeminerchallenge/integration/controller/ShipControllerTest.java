package br.com.artcruz.codeminerchallenge.integration.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.com.artcruz.codeminerchallenge.domain.model.entity.Contract;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Pilot;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Ship;
import br.com.artcruz.codeminerchallenge.domain.service.IService;
import br.com.artcruz.codeminerchallenge.domain.service.ReportService;
import br.com.artcruz.codeminerchallenge.domain.service.TravelService;

@WebMvcTest
public class ShipControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IService<Ship> shipIService;
	
	@MockBean
	private IService<Contract> contractIService;
	
	@MockBean
	private IService<Pilot> pilotService;

	@MockBean
	private ReportService reportService;
	
	@MockBean
	private TravelService travelService;
	
	@Test
	public void list() throws Exception {
		mockMvc.perform(get("/ships")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void find() throws Exception {
		mockMvc.perform(get("/ships/1")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void add() throws Exception {
		String jsonString = "{ \"fuelCapacity\": 100, \"fuelLevel\": 70, \"weightCapacity\": 100, \"pilot\": { \"id\": 1 } }";

		mockMvc.perform(post("/ships").contentType(MediaType.APPLICATION_JSON).content(jsonString))
				.andExpect(status().isCreated());
	}
}
