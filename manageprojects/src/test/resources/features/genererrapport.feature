#lavet af Gustav
Feature: Generer rapport
    Description: En medarbejder eller projektleder genererer en rapport

    Background:
        Given følgende medarbejdere findes i systemet:
            | medarbejder |
            | "huba"      |
            | "wilo"      |
            | "anda"      |

    Scenario Outline: Generer rapport
        Given en <medarbejder> findes i systemet
        And en <medarbejder> er tilmeldt projekt <projektnavn>
        When en <medarbejder> genererer rapport
        Then generer rapport ved navn <projektnavn>-rapport-uge-<int>

        Examples:
            | medarbejder | projektnavn | int |
            | "huba"      | "Website"   | 1   |
            | "wilo"      | "Skylager"  | 2   |
            | "anda"      | "Kalender"  | 3   |
            | "argh"      | "Q1rapport" | 4   |
            | "sara"      | "test"      | 5   |

    Scenario Outline: Genererer uge-rapport uden aktiviteter
        Given en <medarbejder> findes i systemet
        And en <medarbejder> er tilmeldt projekt <projektnavn>
        When der ikke er nogle aktiviteter i projektet
        And en <medarbejder> genererer rapport
        Then handling fejler med fejlbesked: "ingen aktiviteter i projekt"

        Examples:
            | medarbejder | projektnavn | int |
            | "huba"      | "Website"   | 1   |
            | "wilo"      | "Skylager"  | 2   |
            | "anda"      | "Kalender"  | 3   |
            | "argh"      | "Q1rapport" | 4   |
            | "sara"      | "test"      | 5   |