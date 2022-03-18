package com.vytrack.pages;

import com.vytrack.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehiclesPage {

    public VehiclesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//tr[1]//a[@class='dropdown-toggle']") public WebElement dots;
    @FindBy (xpath = "//li[@class='launcher-item']/a") public List<WebElement> iconsList;
    @FindBy (xpath = "//tr[20]//td[20]") public WebElement lastCell;

    @FindBy (xpath = "//input[@type='checkbox']") public List<WebElement> checkboxes;
    @FindBy (xpath = "//th//input[@type='checkbox']") public WebElement firstCheckbox;
    @FindBy (xpath = "//td//input[@type='checkbox']") public List<WebElement> carCheckboxes;
}
