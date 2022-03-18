@Regression @Smoke
Feature: CY19-68 / As a user, I want to view edit car info icons from the Vehicles page.

  AC #1: users should see “view, edit, delete” when they hover the mouse to the three dots “...”.

  Accounts are: Drivers, Store Managers, Sales Managers

  Scenario Outline: Users should see “view, edit, delete” when they hover over "..."
    Given user '<username>' login to the Dashboard
    When user on Dashboard page
    And user navigates to "Fleet" module and clicks "Vehicles"
    And user hover over three dots ...
    Then user should see three buttons
      | View   |
      | Edit   |
      | Delete |

    Examples:
      | username        |
      | storemanager67  |
      | salesmanager125 |