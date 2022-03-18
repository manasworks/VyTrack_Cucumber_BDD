package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.ConfigurationReader;
import com.vytrack.utils.Driver;
import com.vytrack.utils.VytrackUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class Login {

    LoginPage loginPage;

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        loginPage = new LoginPage();
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        VytrackUtils.waitTillLoaderMaskDisappear();
        BrowserUtils.titleContains("Dashboard");
    }

    @When("user enters {string} and user enters {string}")
    public void user_enters_and_user_enters(String username, String password) {
        BrowserUtils.highlight(loginPage.usernameInput);
        loginPage.usernameInput.sendKeys(username);
        BrowserUtils.highlight(loginPage.passwordInput);
        loginPage.passwordInput.sendKeys(password);
    }

    @When("user clicks the Login button")
    public void user_clicks_the_login_button() {
        BrowserUtils.highlight(loginPage.logInButton);
        loginPage.logInButton.click();
    }

    @Then("user should see warning message")
    public void user_should_see_warning_message() {
        BrowserUtils.highlight(loginPage.alertMessage);
        Assert.assertEquals(loginPage.alertMessage.getText(), "Invalid user name or password.");
        BrowserUtils.titleContains("Login");
    }

    @Given("user {string} login to the Dashboard")
    public void userUsernameLoginToTheDashboard(String user) {
        VytrackUtils.login(user);
    }
}
