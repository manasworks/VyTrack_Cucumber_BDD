package com.vytrack.step_definitions;

import com.vytrack.pages.VehicleModelPage;
import com.vytrack.utils.WebTableUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class VehiclesModels {

    @Then("user should see table column names")
    public void user_should_see_table_column_names(List<String> expectedNames) {
        List<String> actualNames = WebTableUtils.getHeadersFromVehicleModelTable();
        Assert.assertEquals(10, actualNames.size());
        Assert.assertEquals(expectedNames, actualNames);
    }
}
