#lavet af Gustav
Feature: Generer rapport
    Description: En medarbejder eller projektleder genererer en rapport

Background:
    Given følgende medarbejdere findes i systemet:
        |medarbejder  |
        |"huba"       |
        |"ambe"       |
        |"joni"       |


    Scenario: Generer rapport
    Given en <medarbejder> findes i systemet
    And en <medarbejder> er tilmeldt projekt <projektnavn>
    When en <medarbejder> genererer rapport
    Then generer rapport ved navn <projektnavn>-rapport-uge-<int>

    Scenario: Genererer uge-rapport uden aktiviteter
    Given en <medarbejder> findes i systemet
    And en <medarbejder> er tilmeldt projekt <projektnavn>
    When en <medarbejder> generer rapport
    And der ikke er nogle aktiviteter i projektet
    Then handling fejler med fejlbesked: "ingen aktiviteter i projekt"


    Examples: 
        |projektnavn       |
        |"Website"         |
        |"Skylager"        |
        |"Kalender"        |
        |"Q1rapport"       |
        |"test"            |

