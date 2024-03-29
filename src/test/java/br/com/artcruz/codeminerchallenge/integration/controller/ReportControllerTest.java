package br.com.artcruz.codeminerchallenge.integration.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author: Arthur Cruz
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ReportControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void weightmov() throws Exception {
		mockMvc.perform(get("/reports/weightmovimentation")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void pilotsstats() throws Exception {
		mockMvc.perform(get("/reports/pilotspercentages")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void transactions() throws Exception {
		mockMvc.perform(get("/reports/transactions")).andDo(print()).andExpect(status().isOk());
	}
}
