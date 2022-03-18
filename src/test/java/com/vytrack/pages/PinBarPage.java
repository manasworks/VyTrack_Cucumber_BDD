package com.vytrack.pages;

import com.vytrack.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinBarPage {

    public PinBarPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//div/a[@href='/pinbar/help']") public WebElement pinBarHelp;
    @FindBy (xpath = "//div[@class='clearfix']/h3") public WebElement topic;
    @FindBy (xpath = "//button[@title='Pin/unpin the page']") public WebElement pinBarButton;
    @FindBy (xpath = "//li[@class='pin-holder active']/a[.='How To Use Pinbar']") public WebElement pinHolder;
    @FindBy (xpath = "//img") public WebElement image;
}
