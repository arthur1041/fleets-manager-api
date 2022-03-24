package br.com.artcruz.codeminerchallenge.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.artcruz.codeminerchallenge.util.Utils;

@SpringBootTest
public class UtilsTest {

	@Test
	public void getJsonBody() {	
		System.out.println(Utils.getJsonBody("message", "just a test"));
	}
}
