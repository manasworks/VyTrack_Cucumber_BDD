package com.vytrack.utils;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.MainModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VytrackUtils {

    public static void login(String username) {
        //go to website
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // create an object from pages package and pass username
        LoginPage loginpage = new LoginPage();

        //pass username
        BrowserUtils.highlight(loginpage.usernameInput);
        loginpage.usernameInput.sendKeys(username);

        //pass password
        BrowserUtils.highlight(loginpage.passwordInput);
        loginpage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));

        //click login button
        BrowserUtils.highlight(loginpage.logInButton);
        loginpage.logInButton.click();

        VytrackUtils.waitTillLoaderMaskDisappear();
    }

    public static void loginAsDriver() {
        LoginPage loginpage = new LoginPage();
        //go to website
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));

        // pass username
        BrowserUtils.highlight(loginpage.usernameInput);
        loginpage.usernameInput.sendKeys(ConfigurationReader.getProperty("driver1"));

        //pass password
        BrowserUtils.highlight(loginpage.passwordInput);
        loginpage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));

        //click login button
        BrowserUtils.highlight(loginpage.logInButton);
        loginpage.logInButton.click();

        waitTillLoaderMaskDisappear();
    }

    public static void loginAsStoreManager() {
        LoginPage loginpage = new LoginPage();
        //go to website
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));

        // pass username
        BrowserUtils.highlight(loginpage.usernameInput);
        loginpage.usernameInput.sendKeys(ConfigurationReader.getProperty("storeManager1"));

        //pass password
        BrowserUtils.highlight(loginpage.passwordInput);
        loginpage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));

        //click login button
        BrowserUtils.highlight(loginpage.logInButton);
        loginpage.logInButton.click();

        waitTillLoaderMaskDisappear();
    }

    public static void loginAsSalesManager() {
        LoginPage loginpage = new LoginPage();
        //go to website
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // pass username

        // pass username
        BrowserUtils.highlight(loginpage.usernameInput);
        loginpage.usernameInput.sendKeys(ConfigurationReader.getProperty("salesManager1"));

        //pass password
        BrowserUtils.highlight(loginpage.passwordInput);
        loginpage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));

        //click login button
        BrowserUtils.highlight(loginpage.logInButton);
        loginpage.logInButton.click();

        waitTillLoaderMaskDisappear();
    }

    public static void waitTillLoaderMaskDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
            WebElement loaderMask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logout(){
        LoginPage loginpage = new LoginPage();
        //locate user's profile tab
        BrowserUtils.highlight(loginpage.profileTab);
        loginpage.profileTab.click();
        //locate "Log Out" button and click it
        BrowserUtils.highlight(loginpage.logoutBtn);
        loginpage.logoutBtn.click();
    }

    // Method to navigate through main menu
    public static void navigateTo(String pageName){

        Actions actions = new Actions(Driver.getDriver());
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        MainModule mainModule = new MainModule();
        int tabDepth = 1;
        WebElement superModule = mainModule.dashboardsModule;
        WebElement subModule1 = mainModule.dashboardSub_Dashboard;
        WebElement subModule2 = mainModule.dashboardSub_Dashboard;
        WebElement subModule3 = mainModule.dashboardSub_Dashboard;

        if (pageName.equalsIgnoreCase("Dashboard")) {
            superModule = mainModule.dashboardsModule;
            subModule1 = mainModule.dashboardSub_Dashboard;
        } else if (pageName.equalsIgnoreCase("Manage Dashboards")){
            superModule = mainModule.dashboardsModule;
            subModule1 = mainModule.dashboardSub_ManageDashboards;
        } else if (pageName.equalsIgnoreCase("vehicles")){
            superModule = mainModule.fleetModule;
            subModule1 = mainModule.fleetSub_Vehicles;
        } else if (pageName.equalsIgnoreCase("vehicle odometer")){
            superModule = mainModule.fleetModule;
            subModule1 = mainModule.fleetSub_VehiclesOdometer;
        } else if (pageName.equalsIgnoreCase("vehicle costs")){
            superModule = mainModule.fleetModule;
            subModule1 = mainModule.fleetSub_VehiclesCosts;
        } else if (pageName.equalsIgnoreCase("vehicle contracts")){
            superModule = mainModule.fleetModule;
            subModule1 = mainModule.fleetSub_VehiclesContracts;
        } else if (pageName.equalsIgnoreCase("vehicle fuel logs")){
            superModule = mainModule.fleetModule;
            subModule1 = mainModule.fleetSub_VehiclesFuelLogs;
        } else if (pageName.equalsIgnoreCase("vehicle service logs")){
            superModule = mainModule.fleetModule;
            subModule1 = mainModule.fleetSub_VehiclesServiceLogs;
        } else if (pageName.equalsIgnoreCase("vehicles model")){
            superModule = mainModule.fleetModule;
            subModule1 = mainModule.fleetSub_VehiclesModels;
        } else if (pageName.equalsIgnoreCase("accounts")){
            superModule = mainModule.customersModule;
            subModule1 = mainModule.customersSubAccounts;
        } else if (pageName.equalsIgnoreCase("contacts")){
            superModule = mainModule.customersModule;
            subModule1 = mainModule.customersSubContacts;
        } else if (pageName.equalsIgnoreCase("opportunities")){
            superModule = mainModule.salesModule;
            subModule1 = mainModule.salesSubOpportunities;
        } else if (pageName.equalsIgnoreCase("calls")){
            superModule = mainModule.activitiesModule;
            subModule1 = mainModule.activitiesSubCalls;
        } else if (pageName.equalsIgnoreCase("calendar events")){
            superModule = mainModule.activitiesModule;
            subModule1 = mainModule.activitiesSubCalendar;
        } else if (pageName.equalsIgnoreCase("campaigns")){
            superModule = mainModule.marketingModule;
            subModule1 = mainModule.marketingSubCampaigns;
        } else if (pageName.equalsIgnoreCase("email campaigns")){
            superModule = mainModule.marketingModule;
            subModule1 = mainModule.marketingSubEmailCampaigns;
        } else if (pageName.equalsIgnoreCase("life time")){
            superModule = mainModule.reportsAndSegmentsModule;
            subModule1 = mainModule.reportsSub_1_Reports;
            subModule2 = mainModule.reportsSub_1_1_Accounts;
            subModule3 = mainModule.reportsSubLifeTime;
            tabDepth = 3;
        } else if (pageName.equalsIgnoreCase("By Opportunities")){
            superModule = mainModule.reportsAndSegmentsModule;
            subModule1 = mainModule.reportsSub_1_Reports;
            subModule2 = mainModule.reportsSub_1_1_Accounts;
            subModule3 = mainModule.reportsSubByOpportunities;
            tabDepth = 3;
        } else if (pageName.equalsIgnoreCase("Leads by date")){
            superModule = mainModule.reportsAndSegmentsModule;
            subModule1 = mainModule.reportsSub_1_Reports;
            subModule2 = mainModule.reportsSub_1_2_Leads;
            subModule3 = mainModule.reportsSubLeadsByDate;
            tabDepth = 3;
        }  else if (pageName.equalsIgnoreCase("Opportunities By Status")){
            superModule = mainModule.reportsAndSegmentsModule;
            subModule1 = mainModule.reportsSub_1_Reports;
            subModule2 = mainModule.reportsSub_1_3_Opportunities;
            subModule3 = mainModule.reportsSubOpportunitiesByStatus;
            tabDepth = 3;
        } else if (pageName.equalsIgnoreCase("Won Opportunities By Date Period")){
            superModule = mainModule.reportsAndSegmentsModule;
            subModule1 = mainModule.reportsSub_1_Reports;
            subModule2 = mainModule.reportsSub_1_3_Opportunities;
            subModule3 = mainModule.reportsSubWonOpportunitiesByPeriod;
            tabDepth = 3;
        } else if (pageName.equalsIgnoreCase("Total Forecast")){
            superModule = mainModule.reportsAndSegmentsModule;
            subModule1 = mainModule.reportsSub_1_Reports;
            subModule2 = mainModule.reportsSub_1_3_Opportunities;
            subModule3 = mainModule.reportsSubTotalForecast;
            tabDepth = 3;
        } else if (pageName.equalsIgnoreCase("Manage Custom Reports")){
            superModule = mainModule.reportsAndSegmentsModule;
            subModule1 = mainModule.reportsSub_2_ManageCustomReports;
        } else if (pageName.equalsIgnoreCase("Campaign Performance")){
            superModule = mainModule.reportsAndSegmentsModule;
            subModule1 = mainModule.reportsSub_3_Campaigns;
            subModule2 = mainModule.reportsSubCampaignPerformance;
            tabDepth = 2;
        } else if (pageName.equalsIgnoreCase("Business Units")){
            superModule = mainModule.systemModule;
            subModule1 = mainModule.systemSubUserManagement;
            subModule2 = mainModule.systemSubBusinessUnits;
            tabDepth = 2;
        } else if (pageName.equalsIgnoreCase("Contact Groups")){
            superModule = mainModule.systemModule;
            subModule1 = mainModule.systemSubContactGroups;
        } else if (pageName.equalsIgnoreCase("Jobs")){
            superModule = mainModule.systemModule;
            subModule1 = mainModule.systemSubJobs;
        } else if (pageName.equalsIgnoreCase("Menus")){
            superModule = mainModule.systemModule;
            subModule1 = mainModule.systemSubMenus;
        } else if (pageName.equalsIgnoreCase("System Calendars")){
            superModule = mainModule.systemModule;
            subModule1 = mainModule.systemSubSystemCalendars;
        } else {
            System.out.println("Wrong page name");
        }

        if (mainModule.warningCloseBtn.isDisplayed()) mainModule.warningCloseBtn.click();
        wait.until(ExpectedConditions.visibilityOf(superModule));
        if (tabDepth == 3){
            BrowserUtils.highlight(superModule);
            actions.moveToElement(superModule).perform();
            BrowserUtils.highlight(subModule1);
            actions.moveToElement(subModule1).perform();
            BrowserUtils.highlight(subModule2);
            actions.moveToElement(subModule2).perform();
            BrowserUtils.highlight(subModule3);
            subModule3.click();
        } else if (tabDepth == 2){
            BrowserUtils.highlight(superModule);
            actions.moveToElement(superModule).perform();
            BrowserUtils.highlight(subModule1);
            actions.moveToElement(subModule1).perform();
            BrowserUtils.highlight(subModule2);
            subModule2.click();
        } else {
            BrowserUtils.highlight(superModule);
            actions.moveToElement(superModule).perform();
            BrowserUtils.highlight(subModule1);
            subModule1.click();
        }
        VytrackUtils.waitTillLoaderMaskDisappear();
    }

}
