#Lavet af Fabrizio
Feature: Registrering af brugt tid
    Description: Medarbejdere registrerer brugt tid på en aktivitet hvor dette rettes til nærmeste halve time


    Background: 
        Given følgende medarbejdere findes i systemet:
            |medarbejder  |
            |"huba"       |
            |"ambe"       |
            |"joni"       |

    Scenario Outline: Medarbejder skriver deres brugte tid til aktivitet
        Given en <medarbejder> findes i systemet
        When en <medarbejder> indtaster deres tid brugt på et projekt som decimaltal eller heltal
        Then Under <aktivitetsnavn> findes tiden brugt af <medarbejder> rundet op til nærmeste halve

    Scenario Outline: Medarbejder skriver en negativ tid ind
        Given en <medarbejder> findes i systemet
        When en <medarbejder> indtaster deres tid brugt på et projekt som decimaltal eller heltal
        And tiden indtastet er negativt
        Then handling fejler med fejlbesked: "Tiden kan ikke indtastes som negativt"

    Examples:
        | medarbejder | aktivitetsnavn |
        | "huba"      | "Design"       |



    Examples: 
|aktivitetsnavn    |
|"Design"          |
|"Analyse"         |
|"Programmering"   |
|"Mødeindkaldelse" |
|"Databehandling"  |