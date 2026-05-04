#lavet af Guillermo
Feature: opret projekt
    Description: en medarbejder opretter et nyt projekt.

Background: 
    Given følgende medarbejdere findes i systemet:
        |medarbejder  |
        |"huba"       |
        |"ambe"       |
        |"joni"       |

Scenario Outline: Opret projekt
    Given en <medarbejder> findes i systemet 
    When en medarbejder opretter et projekt med navn <projektnavn>
    And et projekt med navn <projektnavn> ikke findes i systemet
    Then opret projekt med navn <projektnavn> og unikt projektnummer "1234"

    Examples: 
        | projektnavn | medarbejder |
        | "Website"   | "huba"      |
        | "Skylager"  | "ambe"      |
        | "Kalender"  | "joni"      |

Scenario Outline: Projekt findes allerede
    Given en <medarbejder> findes i systemet
    When en medarbejder opretter et projekt med navn <projektnavn>
    And et projekt med navn <projektnavn> findes i systemet
    Then Fejler handling med besked "et projekt med dette navn findes allerede i systemet"

    Examples: 
        | projektnavn | medarbejder |
        | "Website"   | "huba"      |
        | "Skylager"  | "ambe"      |
        | "Kalender"  | "joni"      |