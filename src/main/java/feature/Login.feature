Feature: Login Application Feature

  @Regression @Smoke
  Scenario Outline: Search in Google
    Given Google home page is available
    Then Verify the Title
    When User clicks on Business Footer Link
    Then Verify the Business Page Title
    And Click on FAQs
    And Verify the page has Skillshop footer link
    And Click on the Skillshop Link
    And Search for this words <searchKey>
    Examples:
      | searchKey       |
      | "Prem" |
      |"Suganya"|
