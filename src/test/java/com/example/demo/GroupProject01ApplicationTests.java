package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GroupProject01ApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	void contextLoads() {
	}

	@Test
	public void testThatGetNodesReturnsItemsFull() {
		ResponseEntity<List<Node>> responseEntity = restTemplate.exchange("/",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Node>>() {
				});
		assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
	}



}
