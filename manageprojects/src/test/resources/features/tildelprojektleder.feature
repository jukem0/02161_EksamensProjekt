#lavet af Guillermo
Feature: tildeling af rollen projektleder
    Description: en medarbejder tildeler rollen projektleder til en anden ledig medarbejder

    Background: 
    Given følgende medarbejdere findes i systemet:
        |medarbejder  |
        |"huba"       |
        |"ambe"       |
        |"joni"       |

    
    Scenario: tildel projektleder
    Given et projekt med navn <projektnavn> eksisterer i systemet
    And en <medarbejder> er ledig
    When en anden medarbjeder udpeger <medarbjeder> som projektleder for projektet
    Then er <medarbjeder> registreret som projektleder for <projektnavn>

    Scenario: medarbejder er allerede projektleder i et andet projekt
    Given et projekt med <projektnavn> eksisterer i systemet
    And en <medarbejder> er projektleder i et andet projekt med navn <projektnavn>
    When en anden medarbejder udpeger <medarbejder> som projektleder for det nuværende projekt
    Then fejler handling med fejlbesked: "denne medarbejder er allerede projektleder i <projektnavn>"


    Examples: 
|projektnavn        |
|"Website"          |
|"Skylager"         |
|"Kalender"         |
|"Q1rapport"        |
|"test"             |