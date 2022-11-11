Feature: As a user
  I want to get ability to use menu sections
  So that I can navigate to needed resources


  Scenario: Go to Houses and apartments
    Given the user opens Onliner website
    When the user navigate on the section "Дома и квартиры"
    Then a drop-down menu appeared
    And categories are displayed