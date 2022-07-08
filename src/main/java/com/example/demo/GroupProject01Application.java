/*Spring boot project - Jakub & Shauna
* Date: 07-07-2022
* The purpose of this project is to create a microservice - simple network management system.  */

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class GroupProject01Application
{

	public static void main(String[] args)
	{
		SpringApplication.run(GroupProject01Application.class, args);

//		Node node = new Node(4, "Test", "Dublin", 40.405, 40.605);
//
//		System.out.println(node);
	}

	@Bean
	@Scope("application")
	public Map<Integer, Node> catalog() {
		Map<Integer, Node> nodes = new HashMap<>();
		nodes.put(0, new Node( "Node1", "Ireland", 40.50, 50.40));
		nodes.put(1, new Node( "Node2", "France", 40.50, 50.40));
		nodes.put(2, new Node( "Node3", "UK", 40.50, 50.40));
		return nodes;
	}

}
