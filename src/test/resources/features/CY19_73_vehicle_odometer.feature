@Regression @Smoke
Feature: CY19-73 / As a user, I want to view car odometer info on the Vehicles Odometers page.

  AC1: Store and Sales managers should see an error message “You do not have permission to perform this action.”
  when they click the “Vehicle Odometer” module.

  AC2: Drivers should see the default page as 1.

  AC3: Drivers should see the View Per Page is 25 by default.

  Scenario Outline: Store and Sales managers should see an error message
    Given user '<username>' login to the Dashboard
    When user on Dashboard page
    And user navigates to "Fleet" module and clicks "Vehicle Odometer"
    Then user should see error message "You do not have permission to perform this action."
    Examples:
      | username        |
      | storemanager67  |
      | salesmanager125 |

  Scenario Outline: Drivers should see the default page as 1 and 25 view per page.
    Given user '<username>' login to the Dashboard
    When user on Dashboard page
    And user navigates to "Fleet" module and clicks "Vehicle Odometer"
    Then user should see default page is "1"
    Then user should see default view per page "25"
    Examples:
      | username |
      | user31   |