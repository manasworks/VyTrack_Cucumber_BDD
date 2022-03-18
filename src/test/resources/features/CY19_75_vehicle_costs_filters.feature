@Regression @Smoke
Feature: CY19-75 / As a user, I want to manage filters on the Vehicle Costs page.

  AC #1: Users should see three columns on the Vehicle Costs page.
  Expected Column names:
  TYPE, TOTAL PRICE, DATE

  AC #2: users check the first checkbox to check all the Vehicle Costs

  Accounts are: Drivers, Store Managers, Sales Managers

  Scenario Outline: Users should see three columns on the Vehicle Costs page
    Given user '<username>' login to the Dashboard
    When user on Dashboard page
    And user navigates to "Fleet" module and clicks "Vehicle Costs"
    Then user should see 3 three columns
    Then user should see names of columns
      | TYPE        |
      | TOTAL PRICE |
      | DATE        |
    Then user should be able to use all filters
    Examples:
      | username        |
      | user31          |
      | storemanager67  |
      | salesmanager125 |

  Scenario Outline: Users check the first checkbox to check all the Vehicle Costs
    Given user '<username>' login to the Dashboard
    When user on Dashboard page
    And user navigates to "Fleet" module and clicks "Vehicle Costs"
    And user click firs checkbox
    Then user should see all the chechboxes are checked
    Examples:
      | username        |
      | storemanager67  |
      | salesmanager125 |