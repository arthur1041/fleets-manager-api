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
public class PilotControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IService<Contract> contractService;

	@MockBean
	private IService<Pilot> pilotService;

	@MockBean
	private ReportService reportService;

	@MockBean
	private IService<Ship> shipService;

	@MockBean
	private TravelService travelService;

	@Test
	public void list() throws Exception {
		mockMvc.perform(get("/pilots")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void find() throws Exception {
		mockMvc.perform(get("/pilots/1")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void add() throws Exception {
		String jsonString = "{ \"pilotCertification\": \"0000000\", \"name\": \"Will\", \"birthDate\": \"1996-04-29\", \"credits\": 5000, \"locationPlanet\": \"Aqua\", \"age\": 10 }";

		mockMvc.perform(post("/pilots").contentType(MediaType.APPLICATION_JSON).content(jsonString)).andDo(print())
				.andExpect(status().isCreated());
	}
}
