package com.vytrack.step_definitions;

import com.vytrack.pages.MainModule;
import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.VytrackUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dashboard {

    MainModule mainModule;

    @When("driver on Dashboard page")
    public void driver_on_dashboard_page() {
        VytrackUtils.loginAsDriver();
        BrowserUtils.titleContains("Dashboard");
    }

    @Then("driver should see four main modules")
    public void driver_should_see_four_main_modules(List<String> expected) {
        mainModule = new MainModule();
        List<String> actualModuleNames = new ArrayList<>();
        System.out.println(expected);
        for (WebElement each : mainModule.allModuleElements) {
            BrowserUtils.highlight(each);
            actualModuleNames.add(each.getText());
        }
        Assert.assertEquals(actualModuleNames.size(), 4);
        Assert.assertEquals(actualModuleNames, expected);
    }

    @When("store manager on Dashboard page")
    public void store_manager_on_dashboard_page() {
        VytrackUtils.loginAsStoreManager();
        BrowserUtils.titleContains("Dashboard");
    }
    @Then("manager should see eight main modules")
    public void manager_should_see_eight_main_modules(List<String> expected) {
        mainModule = new MainModule();
        List<String> actualModuleNames = new ArrayList<>();
        for (WebElement each : mainModule.allModuleElements) {
            BrowserUtils.highlight(each);
            actualModuleNames.add(each.getText());
        }
        Assert.assertEquals(actualModuleNames.size(), 8);
        Assert.assertEquals(actualModuleNames, expected);
    }

    @When("sale manager on Dashboard page")
    public void saleManagerOnDashboardPage() {
        VytrackUtils.loginAsSalesManager();
        BrowserUtils.titleContains("Dashboard");
    }

    @When("user on Dashboard page")
    public void userOnDashboardPage() {
        BrowserUtils.titleContains("Dashboard");
    }
}
