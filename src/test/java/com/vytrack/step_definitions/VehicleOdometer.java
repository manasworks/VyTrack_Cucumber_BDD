package com.vytrack.step_definitions;

import com.vytrack.pages.VehicleOdometerPage;
import com.vytrack.utils.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class VehicleOdometer {

    VehicleOdometerPage vehicleOdometerPage = new VehicleOdometerPage();

    @Then("user should see default page is {string}")
    public void user_should_see_default_page_is(String number) {
        BrowserUtils.highlight(vehicleOdometerPage.pageNumber);
        Assert.assertEquals(number, vehicleOdometerPage.pageNumber.getAttribute("value"));
    }

    @Then("user should see default view per page {string}")
    public void user_should_see_default_view_per_page(String number) {
        BrowserUtils.highlight(vehicleOdometerPage.viewPerPage);
        Assert.assertEquals(number, vehicleOdometerPage.viewPerPage.getText());
    }
}
