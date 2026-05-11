#Lavet af Fabrizio
Feature: Registrering af brugt tid
    Description: Medarbejdere registrerer brugt tid på en aktivitet hvor dette rettes til nærmeste halve time

    Background:
        Given følgende medarbejdere findes i systemet:
            | medarbejder |
            | "huba"      |
            | "wilo"      |
            | "anda"      |

    Scenario Outline: Medarbejder skriver deres brugte tid til aktivitet
        Given en <medarbejder> findes i systemet
        When en <medarbejder> indtaster deres tid brugt på en <aktivitetsnavn> i et <projekt> som decimaltal eller heltal <timer>
        Then Under <aktivitetsnavn> findes <timer> brugt af <medarbejder> rundet op til nærmeste halve

        Examples:
            | medarbejder | aktivitetsnavn  |  projekt          | timer | 
            | "huba"      | "Design"        |  "Settings"       | 5.0   |
            | "wilo"      | "Analyse"       |  "Kowalski"       | 1.3   |
            | "anda"      | "Programmering" |  "CucumberSad"    | 12.2  |

    Scenario Outline: Medarbejder skriver en negativ tid ind
        Given en <medarbejder> findes i systemet
        When en <medarbejder> indtaster deres tid brugt på et projekt som decimaltal eller heltal <timer>
        Then handling fejler med fejlbesked: "Tiden kan ikke indtastes som negativt"

        Examples:
            | medarbejder | aktivitetsnavn  | timer |
            | "huba"      | "Design"        | -2.0  |
            | "wilo"      | "Analyse"       | -3.2  |
            | "anda"      | "Programmering" | -12.1 |
