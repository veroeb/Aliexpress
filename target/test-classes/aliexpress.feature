#Veronica Echezarreta
#01/14/2022

Feature: Aliexpress

  Scenario: Verify there's at least one iPhone available
    Given I access Aliexpress webpage
    When I search for "iPhone" with the search bar
    And I click on the next search results page
    Then I can see all results
    When I click on the second card
    Then I can verify that there's at least one item available
