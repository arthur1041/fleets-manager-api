package br.com.artcruz.codeminerchallenge.integration.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ContractControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void list() throws Exception {
		mockMvc.perform(get("/contracts")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void listOpen() throws Exception {
		mockMvc.perform(get("/contracts/open")).andDo(print()).andExpect(status().isOk());
	}
	
	
	@Test
	public void find() throws Exception {
		mockMvc.perform(get("/contracts/4")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void add() throws Exception{
		String jsonString = "{ \"description\": \"Regular travel\", \"originPlanet\": \"Demeter\", \"destinationPlanet\": \"Aqua\", \"value\": 100000, \"pilot\": { \"id\": 2 }, \"resourcesTotalWeight\": 179 }";
		
		mockMvc.perform(post("/contracts").contentType(MediaType.APPLICATION_JSON).content(jsonString)).andDo(print())
		.andExpect(status().isCreated());
	}
	
	@Test
	public void acceptContract() throws Exception{
		mockMvc.perform(put("/contracts/accept/1")).andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	public void executeContract() throws Exception{
		mockMvc.perform(put("/contracts/accept/1")).andExpect(status().isOk());
		mockMvc.perform(put("/contracts/execute/1")).andDo(print())
		.andExpect(status().isOk());
	}
}
