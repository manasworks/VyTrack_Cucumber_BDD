package com.vytrack.step_definitions;

import com.vytrack.pages.MainModule;
import com.vytrack.pages.VehicleContactsPage;
import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import com.vytrack.utils.VytrackUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class VehicleContracts {

    MainModule mainModule;

    @When("user navigates to {string} module and clicks {string}")
    public void user_clicks(String module, String submodule) {
        VytrackUtils.navigateTo(submodule);
    }

    @Then("user should see expected URL {string}")
    public void user_should_see_expected_url(String expectedURL) {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), expectedURL);
    }

    @Then("users should see expexted title {string}")
    public void users_should_see_expexted_title(String expectedTitle) {
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    @Then("user should see error message {string}")
    public void user_should_see_error_message(String expectedMessage) {
        mainModule = new MainModule();
        BrowserUtils.highlight(mainModule.warningMessage);
        Assert.assertTrue(mainModule.warningMessage.isDisplayed());
        Assert.assertEquals(mainModule.warningMessage.getText(), expectedMessage);
    }

}
