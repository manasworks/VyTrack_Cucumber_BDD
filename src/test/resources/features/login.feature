@Regression
Feature: Vytrack login (CY19-00)
  User Story:
  Users should be able to successfully login to the Vytrack Page
  and land to the dash board

  Accounts are: Drivers, Store Managers, Sales Managers


  @LoginPositive
  Scenario Outline: User should successfully login with correct credentials
    Given user on the login page
    When user enters '<username>' and user enters '<password>'
    And user clicks the Login button
    Then user should see the dashboard
    Examples:
      | username        | password    |
      | user31          | UserUser123 |
      | user37          | UserUser123 |
      | storemanager67  | UserUser123 |
      | storemanager70  | UserUser123 |
      | salesmanager125 | UserUser123 |
      | salesmanager128 | UserUser123 |


  Scenario Outline: User should not able to login with wrong credentials
    Given user on the login page
    When user enters '<username>' and user enters '<password>'
    And user clicks the Login button
    Then user should see warning message
    Examples:
      | username    | password    |
      | user31      | user31      |
      | UserUser123 | UserUser123 |
      | qwerty      | UserUser123 |
      | UserUser123 | user31      |
      | !33342      | admin       |
      | admin       | admin       |
      | user31      | *********   |
      | ****        | ***         |
