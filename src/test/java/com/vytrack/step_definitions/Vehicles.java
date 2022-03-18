package com.vytrack.step_definitions;

import com.vytrack.pages.VehiclesPage;
import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Vehicles {

    VehiclesPage vehiclesPage;
    Actions actions;

    @When("user hover over three dots ...")
    public void user_hover_over_three_dots() {
        vehiclesPage = new VehiclesPage();
        actions = new Actions(Driver.getDriver());
        BrowserUtils.highlight(vehiclesPage.dots);
        actions.moveToElement(vehiclesPage.dots).perform();
    }
    @Then("user should see three buttons")
    public void user_should_see_three_buttons(List<String> expectedButtons) {
        List<String> actualButtons = new ArrayList<>();
        for (WebElement each : vehiclesPage.iconsList) {
            BrowserUtils.highlight(each);
            Assert.assertTrue(each.isDisplayed());
            actualButtons.add(each.getAttribute("title"));
        }
        Assert.assertEquals(expectedButtons, actualButtons);
    }
}
