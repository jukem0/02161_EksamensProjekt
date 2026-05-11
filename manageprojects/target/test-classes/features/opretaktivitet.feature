#lavet af Guillermo
Feature: oprettelse af aktivitet
    Description: en medarbejder eller projektleder opretter en aktivitet

    Background:
        Given følgende medarbejdere findes i systemet:
            | medarbejder   |
            | "huba"        |
            | "ambe"        |
            | "joni"        |
        Given følgende projekter findes i systemet:
            | projektnavn   |
            | "Website"     |
            | "Skylager"    |
            | "Kalender"    |

    Scenario Outline: opret aktivitet
        Given en <medarbejder> findes i systemet
        And et projekt <projektnavn> har en projektleder eller en ledig medarbejder
        When projektleder eller ledig medarbejder opretter aktivitet med navn <aktivitetsnavn>
        Then opret aktivitet med navn <aktivitetsnavn>

        Examples:
            | medarbejder   | projektnavn   | aktivitetsnavn    |
            | "huba"        | "Website"     | "Design"          |
            | "wilo"        | "Skylager"    | "Analyse"         |
            | "anda"        | "Kalender"    | "Programmering"   |

    Scenario Outline: aktivitet findes allerede
        Given der findes et projekt med navn <projektnavn>
        And projektet<projektnavn> har en projektleder<medarbejder>, eller en ledig medarbejder
        When projektleder eller ledig medarbejder opretter aktivitet med navn <aktivitetsnavn>
        And der findes allerede en aktivitet med navn <aktivitetsnavn>
        Then handling fejler med fejlbesked: "denne aktivitet findes allerede"

        Examples:
            | medarbejder   | projektnavn   | aktivitetsnavn     |
            | "joni"        | "Website"     | "Design"           |
            | "wilo"        | "Skylager"    | "Analyse"          |
            | "anda"        | "Kalender"    | "Programmering"    |
