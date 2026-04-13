#lavet af Guillermo
Feature: oprettelse af aktivitet
    Description: en medarbejder eller projektleder opretter en aktivitet


    Background: 
    Given følgende medarbejdere findes i systemet:
        |medarbejder  |
        |"huba"       |
        |"ambe"       |
        |"joni"       |

    Scenario: opret aktivitet
    Given en <medarbejder> findes i systemet
    And <projektnavn> har en projektleder eller en ledig medarbejder
    When projektleder eller <medarbejder> opretter aktivitet med navn <aktivitetsnavn>
    Then opret aktivitet med navn <aktivitetsnavn>

    Scenario: aktivitet findes allerede
    Given der findes et projekt med navn <projektnavn>
    And projektet har en projektleder, eller en ledig medarbejder
    When projektleder eller <medarbejder> opretter aktivitet med navn <aktivitetsnavn>
    And der findes en aktivitet med navn <aktivitetsnavn>
    Then handling fejler med fejlbesked: "denne aktivitet findes allerede"



    Examples: 
        |projektnavn       |
        |"Website"         |
        |"Skylager"        |
        |"Kalender"        |
        |"Q1rapport"       |
        |"test"            |

    Examples: 
        |aktivitetsnavn    |
        |"Design"          |
        |"Analyse"         |
        |"Programmering"   |
        |"Mødeindkaldelse" |
        |"Databehandling"  |

