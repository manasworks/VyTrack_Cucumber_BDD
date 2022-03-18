package com.vytrack.pages;

import com.vytrack.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainModule {

    public MainModule() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".dropdown-level-1.first a[href='#'] span")
    public WebElement dashboardsModule;

    @FindBy (xpath = "//span[@class='title title-level-1']") public List<WebElement> allModuleElements;

    @FindBy (xpath = "//div[@id='main-menu']/ul/li/a/span[contains(text(),'Fleet')]")
    public WebElement fleetModule;

    @FindBy (xpath = "//div[@id='main-menu']/ul/li/a/span[contains(text(),'Customers')]")
    public WebElement customersModule;

    @FindBy (xpath = "//div[@id='main-menu']/ul/li/a/span[contains(text(),'Sales')]")
    public WebElement salesModule;

    @FindBy(xpath = "//div[@id='main-menu']/ul/li/a/span[contains(text(),'Activities')]")
    public WebElement activitiesModule;

    @FindBy(xpath = "//li[@class='dropdown dropdown-level-1'][.//a[@href='/campaign/email/']]//a[@href='#']//span")
    public WebElement marketingModule;

    @FindBy(xpath = "//li[@class='dropdown dropdown-level-1'][.//a[@href='/report']]//span[@class='title title-level-1']")
    public WebElement reportsAndSegmentsModule;

    @FindBy(css = ".mobile-hide.last .title-level-1")
    public WebElement systemModule;

    // Fleet Sub elements
    @FindBy (xpath = "//span[.='Vehicles']/../..") public WebElement fleetSub_Vehicles;
    @FindBy (xpath = "//span[.='Vehicle Odometer']/../..") public WebElement fleetSub_VehiclesOdometer;
    @FindBy (xpath = "//span[.='Vehicle Costs']/../..") public WebElement fleetSub_VehiclesCosts;
    @FindBy (xpath = "//span[.='Vehicle Contracts']/../..") public WebElement fleetSub_VehiclesContracts;
    @FindBy (xpath = "//span[.='Vehicles Fuel Logs']/../..") public WebElement fleetSub_VehiclesFuelLogs;
    @FindBy (xpath = "//span[.='Vehicle Services Logs']/../..") public WebElement fleetSub_VehiclesServiceLogs;
    @FindBy (xpath = "//span[.='Vehicles Model']/../..") public WebElement fleetSub_VehiclesModels;

    // Dashboard sub elements
    @FindBy (xpath = "//span[.='Dashboard']/../..") public WebElement dashboardSub_Dashboard;
    @FindBy (xpath = "//span[.='Manage Dashboards']/../..") public WebElement dashboardSub_ManageDashboards;

    // Activities sub elements
    @FindBy (xpath = "//span[.='Calls']/../..") public WebElement activitiesSubCalls;
    @FindBy (xpath = "//span[.='Calendar Events']/../..") public WebElement activitiesSubCalendar;

    // Sales sub elements
    @FindBy (xpath = "//span[.='Opportunities']/../..") public WebElement salesSubOpportunities;

    // Customers sub elements
    @FindBy (xpath = "//span[.='Accounts']/../..") public WebElement customersSubAccounts;
    @FindBy (xpath = "//span[.='Contacts']/../..") public WebElement customersSubContacts;

    // Marketing sub elements
    @FindBy (xpath = "//span[.='Campaigns']/../..") public WebElement marketingSubCampaigns;
    @FindBy (xpath = "//span[.='Email Campaigns']/../..") public WebElement marketingSubEmailCampaigns;

    // Reports & Segments sub elements
    @FindBy (xpath = "//span[.='Reports']/../..") public WebElement reportsSub_1_Reports;
    @FindBy (xpath = "//span[.='Manage Custom Reports']/../..") public WebElement reportsSub_2_ManageCustomReports;
    @FindBy (xpath = "(//span[.='Campaigns']/../..)[2]") public WebElement reportsSub_3_Campaigns;
    @FindBy (xpath = "//li[@class='dropdown dropdown-level-3 first active']//span[.='Accounts']/../..") public WebElement reportsSub_1_1_Accounts;
    @FindBy (xpath = "//span[.='Leads']/../..") public WebElement reportsSub_1_2_Leads;
    @FindBy (xpath = "(//span[.='Opportunities']/../..)[2]") public WebElement reportsSub_1_3_Opportunities;
    @FindBy (xpath = "//span[.='By Opportunities']/../..") public WebElement reportsSubByOpportunities;
    @FindBy (xpath = "//span[.='Leads By Date']/../..") public WebElement reportsSubLeadsByDate;
    @FindBy (xpath = "//span[.='Life Time']/../..") public WebElement reportsSubLifeTime;
    @FindBy (xpath = "//li[@class='dropdown dropdown-level-3 last']//span[.='Opportunities']/../..") public WebElement reportsSubOpportunities;
    @FindBy (xpath = "//span[.='Opportunities By Status']/../..") public WebElement reportsSubOpportunitiesByStatus;
    @FindBy (xpath = "//span[.='Won Opportunities By Period']/../..") public WebElement reportsSubWonOpportunitiesByPeriod;
    @FindBy (xpath = "//span[.='Total Forecast']/../..") public WebElement reportsSubTotalForecast;
    @FindBy (xpath = "//span[.='Campaign Performance']/../..") public WebElement reportsSubCampaignPerformance;

    // System sub elements
    @FindBy (xpath = "//span[.='User Management']/../..") public WebElement systemSubUserManagement;
    @FindBy (xpath = "//span[.='Contact Groups']/../..") public WebElement systemSubContactGroups;
    @FindBy (xpath = "//span[.='Jobs']/../..") public WebElement systemSubJobs;
    @FindBy (xpath = "//span[.='Menus']/../..") public WebElement systemSubMenus;
    @FindBy (xpath = "//span[.='System Calendars']/../..") public WebElement systemSubSystemCalendars;
    @FindBy (xpath = "//span[.='Business Units']/../..") public WebElement systemSubBusinessUnits;

    // HomeButton
    @FindBy (xpath = "//h1//a[@title='Fleet Management']") public WebElement homeButton;

    // Top right icons
    @FindBy (xpath = "//a[@class='help no-hash']") public WebElement getHelpIcon;
    @FindBy (xpath = "//i[@class='fa-question-circle']") public WebElement getHelpQuestionIcon;

    // Warning Message
    @FindBy (xpath = "//div[@class='message']") public WebElement warningMessage;

    // Warning message close button
    @FindBy (xpath = "//button[@class='close']") public WebElement warningCloseBtn;

    // get help question icon locator

}