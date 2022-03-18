package com.vytrack.step_definitions;

import com.vytrack.pages.CampaignsPage;
import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.VytrackUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Campaigns {

    CampaignsPage campaignsPage = new CampaignsPage();

    @When("user click Manage Filters button")
    public void user_click_manage_filters_button() {
        BrowserUtils.highlight(campaignsPage.manageFilters);
        campaignsPage.manageFilters.click();
    }

    @Then("user should see all {int} filters checked")
    public void user_should_see_all_filters_checked(int num) {
        Assert.assertEquals(num, campaignsPage.filterCheckboxes.size());
        for (WebElement each : campaignsPage.filterCheckboxes) {
            BrowserUtils.highlight(each);
            Assert.assertTrue(each.isSelected());
        }
    }

    @Then("user uncheck all filters")
    public void user_uncheck_all_filters() {
        for (int i = 0; i < campaignsPage.filterCheckboxes.size(); i++) {
            BrowserUtils.highlight(campaignsPage.filterCheckboxes.get(i));
            campaignsPage.filterCheckboxes.get(i).click();
            VytrackUtils.waitTillLoaderMaskDisappear();
        }
    }

    @Then("user should see all {int} filters unchecked")
    public void user_should_see_all_filters_unchecked(Integer num) {
        for (WebElement each : campaignsPage.filterCheckboxes) {
            Assert.assertFalse(each.isSelected());
        }
    }
}
