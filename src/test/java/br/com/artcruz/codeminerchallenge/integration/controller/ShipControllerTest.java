package br.com.artcruz.codeminerchallenge.integration.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


/**
 * @author: Arthur Cruz
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ShipControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
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

		mockMvc.perform(post("/ships").contentType(MediaType.APPLICATION_JSON).content(jsonString)).andDo(print())
				.andExpect(status().isCreated());
	}
}
