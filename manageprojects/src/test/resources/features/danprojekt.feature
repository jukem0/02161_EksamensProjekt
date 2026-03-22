Feature: opret projekt
#lavet af Guillermo
    Beskrivelse: en medarbejder opretter et nyt projekt.

Background: 
    Given følgende medarbejdere findes i systemet:
        |medarbejder  |
        |"huba"       |
        |"ambe"       |
        |"joni"       |

Scenario: Opret projekt
    Given en <medarbejder> findes i systemet 
    When en <medarbejder> opretter et projekt med navn <projektnavn>
    And et projekt med navn <projektnavn> ikke findes i systemet
    Then opret projekt med navn <projektnavn> og unikt projektnummer



Scenario: Projekt findes allerede
    Given en <medarbejder> findes i systemet
    When en <medarbejder> opretter et projekt med navn <projektnavn>
    And et projekt med navn <projektnavn> findes i systemet
    Then Fejler handling med besked "et projekt med dette navn findes allerede i systemet"


Examples: 
|projektnavn        |
|"Website"          |
|"Skylager"         |
|"Kalender"         |
|"Q1rapport"        |
|"test"             |
