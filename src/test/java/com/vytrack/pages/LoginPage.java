package com.vytrack.pages;

import com.vytrack.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='prependedInput']")
    public WebElement usernameInput;

    @FindBy(xpath = "//*[@id='prependedInput2']")
    public WebElement passwordInput;

    @FindBy(xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement rememberMeCheckBox;

    @FindBy(id = "_submit")
    public WebElement logInButton;

    @FindBy(xpath = "//a[text()='Forgot your password?']")
    public WebElement forgotYourPassword;

    @FindBy (xpath = "//li[@id=\"user-menu\"]/a")
    public WebElement profileTab;

    @FindBy (xpath = "//a[@class='no-hash']")
    public WebElement logoutBtn;

    @FindBy (xpath = "//div[@class='alert alert-error']/div")
    public WebElement alertMessage;

}