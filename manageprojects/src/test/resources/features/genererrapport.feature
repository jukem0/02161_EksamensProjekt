#lavet af Gustav
Feature: Generer rapport
    Description: En medarbejder eller projektleder genererer en rapport

Background:
    Given følgende medarbejdere findes i systemet:
        |medarbejder  |
        |"huba"       |
        |"ambe"       |
        |"joni"       |


    Scenario Outline: Generer rapport
    Given en <medarbejder> findes i systemet
    And en <medarbejder> er tilmeldt projekt <projektnavn>
    When en <medarbejder> genererer rapport
    Then generer rapport ved navn <projektnavn>-rapport-uge-<int>

    Scenario Outline: Genererer uge-rapport uden aktiviteter
    Given en <medarbejder> findes i systemet
    And en <medarbejder> er tilmeldt projekt <projektnavn>
    When en <medarbejder> genererer rapport
    And der ikke er nogle aktiviteter i projektet
    Then handling fejler med fejlbesked: "ingen aktiviteter i projekt"

    Examples:
        | medarbejder | projektnavn | int |
        | "huba"      | "Website"   | 1   |


    Examples: 
        |projektnavn       |
        |"Website"         |
        |"Skylager"        |
        |"Kalender"        |
        |"Q1rapport"       |
        |"test"            |

