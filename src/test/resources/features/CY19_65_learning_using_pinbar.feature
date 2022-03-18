@Regression @Smoke
Feature: CY19-65 / As a user, I want to learn how to use the Pinbar.

  AC1: when users click click the “Learn how to use this space” link on the homepage, users should see:
  “How To Use Pinbar” and “Use pin icon on the right top corner of the page to create fast access link in the pinbar.”

  AC2: users should see an image on the page.
  [in automation testing, just verify the image source.]
  Expected source: /bundles/oronavigation/images/pinbar-location.jpg

  Accounts are: Drivers, Store Managers, Sales Managers

  Scenario Outline: User learning using PinBar
    Given user '<username>' login to the Dashboard
    When user on Dashboard page
    And user clicks the button "Learn how to use this space"
    Then user should see page "How To Use Pinbar" page
    And user click pin icon on the right top corner
    Then user should see "How To Use Pinbar" message pinned on top of page
    Then user should see an image "pinbar-location.jpg" on the page
    Examples:
      | username        |
      | user31          |
      | storemanager67  |
      | salesmanager125 |