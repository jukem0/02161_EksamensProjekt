#Lavet af Fabrizio
Feature: tildele medarbejder til en aktivitet
    Description: medarbejdere i systemet kan tildeles aktiviteter under projekter


    Background: 
    Given følgende medarbejdere findes i systemet:
        |medarbejder  |
        |"huba"       |
        |"ambe"       |
        |"joni"       |

    Scenario Outline: tildel medarbejder en aktivitet
    Given der findes en aktivitet med navn <aktivitetsnavn>
    When en medarbejder <medarbejder> udpeger en anden medarbejder <medarbjeder> til at lave aktivitet med <aktivitetsnavn>
    Then tildel medarbejder <medarbejder> til aktivitet med navn <aktivitetsnavn>

    Scenario Outline: medarbejder er allerede tildelt aktivitet
    Given der findes en aktivitet med navn <aktivitetsnavn>
    When en anden medarbjeder udpeger <medarbjeder> til at lave aktivitet med <aktivitetsnavn>
    And <medarbejder> er allerede tildelt aktivitet
    Then handling fejler med fejlbesked: "Medarbejder er allerede tildelt denne aktivitet"

    Examples:
        | medarbejder | medarbjeder | aktivitetsnavn |
        | "huba"      | "ambe"      | "Design"       | 
|aktivitetsnavn    |
|"Design"          |
|"Analyse"         |
|"Programmering"   |
|"Mødeindkaldelse" |
|"Databehandling"  |