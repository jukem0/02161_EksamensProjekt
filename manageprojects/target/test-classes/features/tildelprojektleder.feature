#lavet af Guillermo
Feature: tildeling af rollen projektleder
	Description: en medarbejder tildeler rollen projektleder til en anden ledig medarbejder

	Background:
		Given følgende medarbejdere findes i systemet:
			| medarbejder |
			| "huba"      |
			| "ambe"      |
			| "joni"      |

	Scenario Outline: tildel projektleder
		Given der findes et projekt med navn <projektnavn>
		And en medarbejder <medarbejder> er ledig
		When en anden medarbejder "ambe" udpeger <medarbejder> som projektleder for projektet
		Then er <medarbejder> registreret som projektleder for <projektnavn>

		Examples:
			| medarbejder | projektnavn |
			| "huba"      | "Website"   |
			| "ambe"      | "Skylager"  |

	Scenario Outline: medarbejder er allerede projektleder i et andet projekt
		Given der findes et projekt med navn <projektnavn>
		And medarbejder <medarbejder> allerede er projektleder for et andet projekt med navn "AndetProjekt"
		When en anden medarbejder "ambe" udpeger medarbejder <medarbejder> som projektleder for projekt <projektnavn>
		Then fejler handling med fejlbesked: "Medarbejder er allerede projektleder for et andet projekt"

		Examples:
			| medarbejder | projektnavn |
			| "huba"      | "Website"   |
			| "ambe"      | "Skylager"  |
