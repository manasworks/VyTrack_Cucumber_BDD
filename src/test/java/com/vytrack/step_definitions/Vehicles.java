package com.vytrack.step_definitions;

import com.vytrack.pages.VehiclesPage;
import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.List;

public class Vehicles {

    VehiclesPage vehiclesPage = new VehiclesPage();
    Actions actions = new Actions(Driver.getDriver());

    @When("user hover over three dots ...")
    public void user_hover_over_three_dots() {
        BrowserUtils.highlight(vehiclesPage.dots);
        actions.moveToElement(vehiclesPage.dots).perform();
    }

    @Then("user should see three buttons")
    public void user_should_see_three_buttons(List<String> expectedButtons) {
        List<String> actualButtons = new ArrayList<>();
        actualButtons.add(vehiclesPage.button1.getAttribute("title"));
        actualButtons.add(vehiclesPage.button2.getAttribute("title"));
        actualButtons.add(vehiclesPage.button3.getAttribute("title"));
        Assert.assertEquals(expectedButtons, actualButtons);
    }

    @Then("user should see all the checkboxes are unchecked")
    public void user_should_see_all_the_checkboxes_are_unchecked() {
        for (WebElement checkbox : vehiclesPage.carCheckboxes) {
            Assert.assertTrue(checkbox.isDisplayed());
            Assert.assertFalse(checkbox.isSelected());
        }
    }

    @Then("user click firs checkbox")
    public void user_click_firs_checkbox() {
        vehiclesPage.firstCheckbox.click();
    }

    @Then("user should see all the chechboxes are checked")
    public void user_should_see_all_the_chechboxes_are_checked() {
        for (WebElement checkbox : vehiclesPage.carCheckboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }
    }

    public int random = (int) (Math.random()*(20)) + 1;
    public WebElement randomCheckbox = Driver.getDriver().findElement(By.xpath("//tr["+random+"]//td//input[@type='checkbox']"));

    @Then("user click any checkbox")
    public void user_click_any_checkbox() {
        randomCheckbox.click();
    }

    @Then("user should see that checkbox is selected")
    public void user_should_see_that_checkbox_is_selected() {
        Assert.assertTrue(randomCheckbox.isSelected());
    }
}
