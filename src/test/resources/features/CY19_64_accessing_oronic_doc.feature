@Regression @Smoke
Feature: CY19-64 / As a user, I should be access to the Oroinc Documentation page.

  AC #1: users access the Oronic Documentation page by clicking the question icon.
  The page URL: https://doc.oroinc.com/

  Accounts are: Drivers, Store Managers, Sales Managers

  Scenario Outline: Users should be able access to the Oroinc Documentation page.
    Given user '<username>' login to the Dashboard
    When user on Dashboard page
    And user sees and click question icon "Get help"
    Then user should see pup up window with url "https://doc.oroinc.com/"
    Examples:
      | username        |
      | user31          |
      | storemanager67  |
      | salesmanager125 |