package com.vytrack.step_definitions;

import com.vytrack.pages.VehicleCostsPage;
import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.WebTableUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class VehicleCosts {

    VehicleCostsPage vehicleCostsPage = new VehicleCostsPage();

    @Then("user should see {int} three columns")
    public void user_should_see_three_columns(int number) {
        Assert.assertEquals(number, WebTableUtils.getHeadersFromVehicleModelTable().size());
    }

    @Then("user should see names of columns")
    public void user_should_see_names_of_columns(List<String> expectedColumnNames) {
        List<String> actualColumnNames = WebTableUtils.getHeadersFromVehicleModelTable();
        Assert.assertEquals(expectedColumnNames, actualColumnNames);
    }

    @Then("user should be able to use all filters")
    public void user_should_be_able_to_use_all_filters() {
        BrowserUtils.highlight(vehicleCostsPage.thirdFilter);
        vehicleCostsPage.thirdFilter.click();
        BrowserUtils.highlight(vehicleCostsPage.secondFilter);
        vehicleCostsPage.secondFilter.click();
        BrowserUtils.highlight(vehicleCostsPage.firstFilter);
        vehicleCostsPage.firstFilter.click();
    }
}
