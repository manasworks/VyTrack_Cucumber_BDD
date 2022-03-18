package com.vytrack.step_definitions;

import com.vytrack.pages.AccountsPage;
import com.vytrack.utils.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Accounts {

    AccountsPage accountsPage = new AccountsPage();

    @When("user click Filter button")
    public void user_click_filter_button() {
        BrowserUtils.highlight(accountsPage.filters);
        accountsPage.filters.click();
    }

    @Then("user should see {int} filters on the page")
    public void user_should_see_filters_on_the_page(int number) {
        BrowserUtils.highlight(accountsPage.manageFilters);
        Assert.assertEquals(number, accountsPage.allFilters.size());
    }

    @Then("user should see filters")
    public void user_should_see_filters(List<String> expectedFilterNames) {
        List<String> actualFilterNames = new ArrayList<>();
        for (WebElement each : accountsPage.allFilters) {
            BrowserUtils.highlight(each);
            actualFilterNames.add( each.getText().replace(": All", "") );
        }
        Assert.assertEquals(expectedFilterNames, actualFilterNames);
    }
}
