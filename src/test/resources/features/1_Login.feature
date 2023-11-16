Feature: Orange HRM Login Feature

  @Login_Functionality @Smoke_Scenario @All
  Scenario: Orange HRM Login
    Given Open Browser and Navigate to URL
    When Sign In page is displayed
    Then I enter username and password
    And I click on Sign In button
    And I verify Home page is displayed
    And Click SignOut Link