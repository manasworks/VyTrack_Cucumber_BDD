package com.vytrack.utils;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BrowserUtils {

    /*
    This method will accept int (in seconds) and execute Thread.sleep
    for given duration
     */
    public static void sleep(double second){

        try {
            Thread.sleep( (int)(second*1000));
        }catch (InterruptedException e ) {
            e.printStackTrace();
        }
    }

    // Method to find a window with expected URL
    public static WebDriver switchWindowAndVerify(String expectedInUrl){

        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles) {
            Driver.getDriver().switchTo().window(each);
            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) break;
        }
        return Driver.getDriver();
    }

    public static void titleVerify(String expectedTitle){
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    public static void titleContains(String expectedTitle){
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    public static void scrollPage(int y, int x){
        // Use below JavaScript method and scroll
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy("+y+","+x+")");
    }

    public static void highlight(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        jsExecutor.executeScript("arguments[0].style.border='3px solid orange'", element);
        jsExecutor.executeScript("arguments[0].style.backgroundColor='yellow'", element);
        jsExecutor.executeScript("arguments[0].style.color='black'", element);
        //BrowserUtils.sleep(0.01);

        jsExecutor.executeScript("arguments[0].style.backgroundColor=''", element);
        jsExecutor.executeScript("arguments[0].style.border='0px solid black'", element);
        jsExecutor.executeScript("arguments[0].style.color=''", element);
    }

    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}