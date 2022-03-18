@Regression @Smoke
Feature: CY19-67 / As a user, I want to view columns on the Vehicle models page.
  AC #1: The store manager and sales manager should see 10 columns on the Vehicle Model page.
  Expected Column names:
  MODEL NAME, MAKE, CAN BE REQUESTED, CVVI, CO2 FEE (/MONTH), COST (DEPRECIATED),
  TOTAL COST (DEPRECIATED), CO2 EMISSIONS, FUEL TYPE, VENDORS

  AC #2: Drivers should not able to access the Vehicle Model page, users should see
  “You do not have permission to perform this action.”

  Scenario Outline: Store and Sales managers access the Vehicles Model page
    Given user '<username>' login to the Dashboard
    When user on Dashboard page
    And user navigates to "Fleet" module and clicks "Vehicles Model"
    Then user should see table column names
      | MODEL NAME               |
      | MAKE                     |
      | CAN BE REQUESTED         |
      | CVVI                     |
      | CO2 FEE (/MONTH)         |
      | COST (DEPRECIATED)       |
      | TOTAL COST (DEPRECIATED) |
      | CO2 EMISSIONS            |
      | FUEL TYPE                |
      | VENDORS                  |

    Examples:
      | username        |
      | storemanager67  |
      | salesmanager125 |


  Scenario Outline: Drivers should NOT able to access the Vehicle contracts page
    Given user '<username>' login to the Dashboard
    When user on Dashboard page
    And user navigates to "Fleet" module and clicks "Vehicles Model"
    Then user should see error message "You do not have permission to perform this action."
    Examples:
      | username |
      | user31   |