package org.stepdefintion;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void befScenario() {
		System.out.println("Scenario Start..........");
	}
	
	@After
	public void aftScenario() {
		System.out.println("Scenario Ends......");
	}
}
