@Regression @Smoke
Feature: CY19-66 / As a user, I want to access to Vehicle contracts page.

  AC1: Store managers and Sales managers access the Vehicle contracts page.
  Expected URL: https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract
  Expected title: All - Vehicle Contract - Entities - System - Car - Entities - System.

  AC2: Drivers should NOT able to access the Vehicle contracts page, the app should display
  “You do not have permission to perform this action.”

  Accounts are: Drivers, Store Managers, Sales Managers

  Scenario Outline: Store and Sales managers access the Vehicle contracts page
    Given user '<username>' login to the Dashboard
    When user on Dashboard page
    And user navigates to "Fleet" module and clicks "Vehicle Contracts"
    Then user should see expected URL "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract"
    Then users should see expexted title "All - Vehicle Contract - Entities - System - Car - Entities - System"
    Examples:
      | username        |
      | storemanager67  |
      | salesmanager125 |

  Scenario Outline: Drivers should NOT able to access the Vehicle contracts page
    Given user '<username>' login to the Dashboard
    When user on Dashboard page
    And user navigates to "Fleet" module and clicks "Vehicle Contracts"
    Then user should see error message "You do not have permission to perform this action."
    Examples:
      | username |
      | user31   |