package com.vytrack.pages;

import com.vytrack.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleContactsPage {

    public VehicleContactsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-Status']") public WebElement tableCell;
}
