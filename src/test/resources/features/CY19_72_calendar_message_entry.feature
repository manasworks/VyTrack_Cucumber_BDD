@Regression @Smoke
Feature: CY19-72 / As a user, I want to write the “Description” when I create a calendar event.

  AC1: users should be able to write messages in the Description field on the calendar event page.

  Accounts are: Drivers, Store Managers, Sales Managers

  Scenario Outline: Users should see 1 by default
    Given user '<username>' login to the Dashboard
    When user on Dashboard page
    And user navigates to "Activities" module and clicks "Calendar Events"
    And user click the Create Calendar Event button
    Then user should see "Create Calendar Event" page
    When user write a "message" in the Description field
    Then user should see his "message" in the Description
    Examples:
      | username        |
      | user31          |
      | storemanager67  |
      | salesmanager125 |