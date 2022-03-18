@Regression @Smoke
Feature: CY19-76 /  As a user, I want to manage filters on the Marketing page.

  AC #1: Store and sales managers should see all the five filter options are checked by default.

  AC #2: any amount of boxes should be unchecked. (can check only 1, or multiple)

  Accounts are: Store Managers, Sales Managers

  Scenario Outline: Store and sales managers should see all the five filter options checked and uncheck any
    Given user '<username>' login to the Dashboard
    When user on Dashboard page
    And user navigates to "Marketing" module and clicks "Campaigns"
    And user click Filter button
    And user click Manage Filters button
    Then user should see all 5 filters checked
    And user uncheck all filters
    Then user should see all 5 filters unchecked
    Examples:
    | username        |
    | storemanager67  |
    | salesmanager125 |