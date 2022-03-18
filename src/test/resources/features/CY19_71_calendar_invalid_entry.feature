@Regression @Smoke
Feature: CY19-71 / As a user, I should see error messages when entering an invalid integer into the calendar repeat day input box.

  AC : Users see error messages for entering invalid integers.
  If enters less than 1 —> user should see “The value have not to be less than 1.”
  If enters more than 99 —> user should see “The value have not to be more than 99.”
  Negative Scenarios:
  If enters special character-> error message should be displayed.
  If enters letters - error message should be displayed
  If no input is put in the days box -> error message should be displayed.
  [Note: no need to test valid number, data type, etc in this story.]

  Accounts are: Drivers, Store Managers, Sales Managers

  Scenario Outline: Users should see error messages when entering an invalid data
    Given user '<username>' login to the Dashboard
    When user on Dashboard page
    And user navigates to "Activities" module and clicks "Calendar Events"
    And user click the Create Calendar Event button
    Then user should see "Create Calendar Event" page
    When user click Repeat checkbox
    And user enters "-5"
    Then user should see an error message "The value have not to be less than 1."
    When user cancel and start over
    And user click Repeat checkbox
    And user enters "106"
    Then user should see an error message "The value have not to be more than 99."
    When user cancel and start over
    And user click Repeat checkbox
    And user enters "%"
    Then user should see an error message "Please enter a valid number."
    When user cancel and start over
    And user click Repeat checkbox
    And user enters "d"
    Then user should see an error message "Please enter a valid number."
    When user cancel and start over
    And user click Repeat checkbox
    And user enters "  "
    Then user should see an error message "The value have not to be less than 1."

    Examples:
      | username        |
      | user31          |
      | storemanager67  |
      | salesmanager125 |