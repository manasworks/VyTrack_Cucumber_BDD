@Regression @Smoke
Feature: CY19-70 / As a user, I want to create a recurring / repetitive calendar event.

  AC #1: user should see the number “1” by default.

  AC #2: user should see an error message “This value should not be blank.” when the Calendar event
         repeat field is cleared(delete the number 1).

  Accounts are: Drivers, Store Managers, Sales Managers

  Scenario Outline: Users should see “view, edit, delete” when they hover over "..."
    Given user '<username>' login to the Dashboard
    When user on Dashboard page
    And user navigates to "Activities" module and clicks "Calendar Events"
    And user click the Create Calendar Event button
    Then user should see "Create Calendar Event" page
    When user click Repeat checkbox
    Then user should see the number "1" by default
    When user delete the number "1"
    Then user should see an error message "This value should not be blank."
    Examples:
      | username        |
      | user31          |
      | storemanager67  |
      | salesmanager125 |