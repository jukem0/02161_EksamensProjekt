Feature: tildele medarbejder til en aktivitet
#Lavet af Fabrizio
    Beskrivelse: medarbejdere i systemet kan tildeles aktiviteter under projekter


    Background: 
    Given følgende medarbejdere findes i systemet:
        |medarbejder  |
        |"huba"       |
        |"ambe"       |
        |"joni"       |

    Scenario: tildel medarbejder en aktivitet
    Given der findes en aktivitet med navn <aktivitetsnavn>
    When en anden medarbjeder udpeger <medarbjeder> til at lave aktivitet med <aktivitetsnavn>
    Then tildel <medarbejder> <aktivitetsnavn>

    Scenario: medarbejder er allerede tildelt aktivitet
    Given der findes en aktivitet med navn <aktivitetsnavn>
    When en anden medarbjeder udpeger <medarbjeder> til at lave aktivitet med <aktivitetsnavn>
    And <medarbejder> er allerede tildelt aktivitet
    Then handling fejler med fejlbesked: "Medarbejder er allerede tildelt denne aktivitet"


    Examples: 
|aktivitetsnavn    |
|"Design"          |
|"Analyse"         |
|"Programmering"   |
|"Mødeindkaldelse" |
|"Databehandling"  |