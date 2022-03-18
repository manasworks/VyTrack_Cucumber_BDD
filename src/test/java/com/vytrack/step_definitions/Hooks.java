package com.vytrack.step_definitions;

import com.vytrack.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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

        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        System.out.println("Scenarios  failed? "+scenario.isFailed() );
        Driver.closeDriver();
    }
}
