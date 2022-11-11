Feature: As a user
  I want to get ability to use menu sections
  So that I can navigate to needed resources


  Scenario: Go to car market
    Given the user opens Onliner website
    When the user navigate on the section "Автобарахолка"
    Then a drop-down menu appeared
    And categories are displayed