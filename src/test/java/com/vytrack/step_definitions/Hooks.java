package com.vytrack.step_definitions;

import com.vytrack.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setupDriver(Scenario scenario){
        // To run before each method
        System.out.println(">> Scenario name: "+scenario.getName());
        System.out.println(">> Scenario tags: "+scenario.getSourceTagNames());

    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("Scenarios  failed? "+scenario.isFailed() );
        Driver.closeDriver();
    }
}
