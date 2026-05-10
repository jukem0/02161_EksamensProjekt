#lavet af Guillermo
Feature: Opret projekt
	Description: en medarbejder opretter et nyt projekt.

	Background:
		Given følgende medarbejdere findes i systemet:
			| medarbejder |
			| "huba"      |
			| "wilo"      |
			| "anda"      |

	Scenario Outline: Opret projekt
		Given en <medarbejder> findes i systemet
		When en medarbejder opretter et projekt med navn <projektnavn>
		Then er projektet oprettet og har projekt-nummer <projektNummer>

		Examples:
			| projektnavn | medarbejder | projektNummer |
			| "Website"   | "huba"      | "26001"       |
			| "Skylager"  | "wilo"      | "26002"       |
			| "Kalender"  | "anda"      | "26003"       |