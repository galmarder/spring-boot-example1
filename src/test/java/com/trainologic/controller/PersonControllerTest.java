package com.trainologic.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import com.trainologic.DemoApplication;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class PersonControllerTest {
	

	private MockMvc mockMvc;





	@Test
	public void shoudlReturnPersonForGet() {
	}

}
