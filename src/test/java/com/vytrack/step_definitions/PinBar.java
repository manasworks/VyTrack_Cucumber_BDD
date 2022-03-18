package com.vytrack.step_definitions;

import com.vytrack.pages.PinBarPage;
import com.vytrack.utils.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PinBar {

    PinBarPage pinBarPage;

    @When("user clicks the button {string}")
    public void user_clicks_the_button(String string) {
        pinBarPage = new PinBarPage();
        BrowserUtils.highlight(pinBarPage.pinBarHelp);
        Assert.assertEquals(pinBarPage.pinBarHelp.getText(), string);
        pinBarPage.pinBarHelp.click();
    }

    @Then("user should see page {string} page")
    public void user_should_see_page_page(String string) {

        BrowserUtils.highlight(pinBarPage.topic);
        Assert.assertEquals(pinBarPage.topic.getText(), string);

    }

    @Then("user click pin icon on the right top corner")
    public void user_click_pin_icon_on_the_right_top_corner() {

        BrowserUtils.highlight(pinBarPage.pinBarButton);
        Assert.assertTrue(pinBarPage.pinBarButton.isDisplayed());
        pinBarPage.pinBarButton.click();

    }

    @Then("user should see {string} message pinned on top of page")
    public void user_should_see_message_pinned_on_top_of_page(String string) {

        BrowserUtils.highlight(pinBarPage.pinHolder);
        Assert.assertEquals(pinBarPage.pinHolder.getText(), string);
        pinBarPage.pinBarButton.click();

    }

    @Then("user should see an image {string} on the page")
    public void user_should_see_an_image_on_the_page(String string) {

        BrowserUtils.highlight(pinBarPage.image);
        Assert.assertTrue(pinBarPage.image.getAttribute("src").contains(string));

    }
}
