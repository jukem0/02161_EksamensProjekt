Feature: opret projekt
    Description: en medarbejder opretter et nyt projekt.

Scenario: Opret projekt
    Given en medarbejder vil oprette et projekt
    When medarbejderen opretter et projekt med navn <projektnavn>
    And et projekt med navn <projektnavn> ikke findes i systemet
    Then opret projekt med navn <projektnavn>



Scenario: Projekt findes allerede
    Given en medarbejder vil oprette et projekt
    When medarbejderen opretter et projekt med navn <projektnavn>
    And et projekt med navn <projektnavn> findes i systemet
    Then Fejler handling med besked "projektet findes allerede"


Examples: 
|projektnavn        |
|"Website"          |
|"Skylager"         |
|"Kalender"         |
|"Q1rapport"        |
|"test"             |
