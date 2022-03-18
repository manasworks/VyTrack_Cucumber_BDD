package com.vytrack.step_definitions;

import com.vytrack.pages.CalendarPage;
import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.VytrackUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Calendar {

    CalendarPage calendarPage;

    @When("user click the Create Calendar Event button")
    public void user_click_the_create_calendar_event_button() {
        calendarPage = new CalendarPage();
        BrowserUtils.highlight(calendarPage.createEvent);
        calendarPage.createEvent.click();
    }

    @Then("user should see {string} page")
    public void user_should_see_page(String pageLabel) {
        VytrackUtils.waitTillLoaderMaskDisappear();
        BrowserUtils.highlight(calendarPage.pageLabel);
        Assert.assertEquals(pageLabel, calendarPage.pageLabel.getText());
    }

    @When("user click Repeat checkbox")
    public void user_click_repeat_checkbox() {
        BrowserUtils.highlight(calendarPage.repeatCheckbox);
        calendarPage.repeatCheckbox.click();
    }

    @Then("user should see the number {string} by default")
    public void user_should_see_the_number_by_default(String days) {
        BrowserUtils.highlight(calendarPage.daysInput);
        Assert.assertEquals(days, calendarPage.daysInput.getAttribute("value"));
    }

    @When("user delete the number {string}")
    public void user_delete_the_number(String days) {
        BrowserUtils.highlight(calendarPage.daysInput);
        calendarPage.daysInput.sendKeys(Keys.BACK_SPACE);
        calendarPage.inputTitle.click();
    }

    @Then("user should see an error message {string}")
    public void user_should_see_an_error_message(String message) {
        Assert.assertEquals(message, calendarPage.errorMessage.getText());
    }

    @When("user enters {string}")
    public void user_enters(String entry) {
        BrowserUtils.highlight(calendarPage.daysInput);
        calendarPage.daysInput.sendKeys(Keys.BACK_SPACE+entry);
        calendarPage.inputTitle.click();
    }

    @When("user cancel and start over")
    public void userCancelAndStartOver() {
        BrowserUtils.highlight(calendarPage.cancelButton);
        calendarPage.cancelButton.click();
        BrowserUtils.highlight(calendarPage.createEvent);
        calendarPage.createEvent.click();
    }
}
