#lavet af Guillermo
Feature: opret projekt
    Description: en medarbejder opretter et nyt projekt.

Scenario: Opret projekt
    Given medarbejderen "huba" er logget ind
    When en <medarbejder> opretter et projekt med navn <projektnavn>
    And et projekt med navn <projektnavn> ikke findes i systemet
    Then opret projekt med navn <projektnavn> og unikt projektnummer

Scenario: Projekt findes allerede
    Given en <medarbejder> findes i systemet
    When en <medarbejder> opretter et projekt med navn <projektnavn>
    And et projekt med navn <projektnavn> findes i systemet
    Then Fejler handling med besked "et projekt med dette navn findes allerede i systemet"