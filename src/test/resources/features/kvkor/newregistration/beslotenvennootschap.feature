@NieuweInschrijving
Feature: OR frontoffice inlog

  Background: Feature: OR frontoffice inlog

  Scenario: Registration Besloten Vennootschap
    Given the user opens the OR frontoffice application
    When the user is logged in and starts with a new registration with legal form "Besloten Vennootschap"
    And the mandatory data is entered
    Then the user can validate, sign and submit the assignment

  Scenario: Registration Vereniging van Eigenaars
    Given the user opens the OR frontoffice application
    When the user is logged in and starts with a new registration with legal form "Vereniging van Eigenaars"

  Scenario: Registration Naamloze Vennootschap
    Given the user opens the OR frontoffice application
    When the user is logged in and starts with a new registration with legal form "Naamloze Vennootschap"
    And within "Basisgegevens van de Naamloze Vennootschap" the user enters the unique "Naam_rechtspersoon"
    And within "Basisgegevens van de Naamloze Vennootschap" the user enters the "Zetel" with "Utrecht"
    And within "Basisgegevens van de Naamloze Vennootschap" the user enters the "Oprichtingskosten" with "250"
    And within "Basisgegevens van de Naamloze Vennootschap" the user enters the "Datum_akte_van_oprichting" with "01-01-2018"
    And within "Basisgegevens van de Naamloze Vennootschap" the user enters the "Datum_ingang" with "01-01-2018"
    And within "Basisgegevens van de Naamloze Vennootschap" the user chooses for "Bestuursmodel" the option "Dualistisch"
    And within "Basisgegevens van de Naamloze Vennootschap" the user chooses for "Beleggingsmaatschappij_met_veranderlijk_kapitaal?" the radiobutton "Ja"
    And within "Basisgegevens van de Naamloze Vennootschap" the user chooses for "Is_het_RSIN_bekend?" the radiobutton "Nee"
    Then click on the Volgende button
    And within "Kapitaalgegevens" the user chooses for "hasAandelen" the radiobutton "Nee"
    And within "Kapitaalgegevens" the user enters the "Maatschappelijk_kapitaal" with "1000"
    And within "Kapitaalgegevens" the user enters the "Geplaatst_kapitaal" with "2000"
    And within "Kapitaalgegevens" the user enters the "Gestort_kapitaal" with "5000"
    Then click on the Volgende button
    And within "Bestuurder(s)" the user enters the "Datum_waarop_de_functionaris_in_functie_is_getreden" with "01-01-2018"
    And within "Bestuurder(s)" the user chooses for "Type_bestuurder" the option "Bestuurder"