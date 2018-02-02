@NewRegistrationVereniging
Feature: OR frontoffice login

  Background: Feature: OR frontoffice login

  Scenario: Registration Vereniging
    Given the user opens the OR frontoffice application
    When the user is logged in and starts with a new registration with legal form "Vereniging"
    And within "Basisgegevens van de Vereniging" the user enters the unique "Naam_rechtspersoon" with "Vereniging"
    And within "Basisgegevens van de Vereniging" the user enters the "Zetel" with "Alkmaar"
    And within "Basisgegevens van de Vereniging" the user enters the "Datum_oprichting" with "01-01-2018"
    And within "Basisgegevens van de Vereniging" the user enters the "Akte_datum" with "01-01-2018"
    Then click on the Volgende button
    And within "Adresgegevens rechtspersoon" the user enters the "Postcode" with "3447GT"
    And within "Adresgegevens rechtspersoon" the user enters the Huisnummer with "1"
    And within "Adresgegevens rechtspersoon" the user enters the "Activiteitomschrijving" with "Dit is een activiteitomschrijving"
    Then click on the Volgende button
    And within "Bestuurder(s)" the user enters the "Datum_waarop_de_functionaris_in_functie_is_getreden" with "01-01-2018"
    And within "Bestuurder(s)" the user enters the "Burgerservicenummer" with "999916464"
    And the user clicks checkbox to validate the BSN number
    Then click on the Volgende button
    Then click on the Volgende button
    Then click on the Volgende button
    Then click on the Volgende button
    And within "Bijlage(n)" the user uploads the attachment "Datacard.pdf" for "Datacard Vanya Ebben (verplicht)"
    And within "Bijlage(n)" the user uploads the attachment "Akte van oprichting.pdf" for "Akte van oprichting (verplicht)"
    Then click on the Volgende button
    And within "Referentie informatie" the user enters the Naam_berichtenbox with "123"
    And within "Referentie informatie" the user enters the "Naam_contactpersoon" with "Miep de Tester"
    And within "Referentie informatie" the user enters the "E-mailadres_contactpersoon" with "noreply@kvk.nl"
    Then click on the Volgende button
    Then click on the Opslaan button
    Then click on the Valideren button

