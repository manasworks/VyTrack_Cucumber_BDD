@Regression @Smoke
Feature: CY19-74 / As a user, I want to filter customers’ info on the Account page.

  AC1: managers should see 8 filter items on the Accounts page

  Expected filter names: Account Name, Contact Name, Contact Email, Contact Phone, Owner, Business Unit, Created At, Updated At.

  Accounts are: Drivers, Store Managers, Sales Managers

  Scenario Outline: Managers should see 8 filter items on the Accounts page
    Given user '<username>' login to the Dashboard
    When user on Dashboard page
    And user navigates to "Customers" module and clicks "Accounts"
    And user click Filter button
    Then user should see 8 filters on the page
    Then user should see filters
      | Account Name  |
      | Contact Name  |
      | Contact Email |
      | Contact Phone |
      | Owner         |
      | Business Unit |
      | Created At    |
      | Updated At    |

    Examples:
      | username        |
      | storemanager67  |
      | salesmanager125 |