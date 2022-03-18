package com.vytrack.pages;

import com.vytrack.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountsPage {

    public AccountsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//a[@title='Filters']") public WebElement filters;
    @FindBy (xpath = "//a[.='Manage filters']") public WebElement manageFilters;
    @FindBy (xpath = "//div[@class='filter-item oro-drop']")
    public List<WebElement> allFilters;

}
