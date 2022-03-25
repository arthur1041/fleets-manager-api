package br.com.artcruz.codeminerchallenge.integration.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TravelControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void list() throws Exception {
		mockMvc.perform(put("/travel/from/1/to/3/withpilot/2")).andDo(print()).andExpect(status().isOk());
	}
	
}
