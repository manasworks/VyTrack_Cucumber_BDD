package com.vytrack.step_definitions;

import com.vytrack.pages.MainModule;
import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import com.vytrack.utils.VytrackUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Oronic_Documentation {

    MainModule mainModule;

    @When("user sees and click question icon {string}")
    public void user_sees_and_click_question_icon(String string) {
        mainModule = new MainModule();
        BrowserUtils.highlight(mainModule.getHelpIcon);
        Assert.assertEquals(mainModule.getHelpQuestionIcon.getAttribute("title"), string);
        mainModule.getHelpIcon.click();
    }
    @Then("user should see pup up window with url {string}")
    public void user_should_see_pup_up_window_with_title(String string) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        String mainHandle = Driver.getDriver().getWindowHandle();
        for(String each: Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(each);
        }
        wait.until(ExpectedConditions.urlContains(string));
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://doc.oroinc.com/");

        Driver.getDriver().switchTo().window(mainHandle);

        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
    }
}
