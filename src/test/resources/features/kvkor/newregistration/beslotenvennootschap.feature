@NewRegistrationBV
Feature: OR frontoffice inlog

  Background: Feature: OR frontoffice inlog

  Scenario: Registration Besloten Vennootschap
    Given the user opens the OR frontoffice application
    When the user is logged in and starts with a new registration with legal form "Besloten Vennootschap"
    And within "Besloten Vennootschap" the user enters the unique "Naam_rechtspersoon" with "B.V."
    And within "Besloten Vennootschap" the user enters the "Zetel" with "Woerden"
    And within "Besloten Vennootschap" the user enters the "Datum_akte_van_oprichting" with "01-01-2018"
    And within "Besloten Vennootschap" the user enters the "Datum_ingang" with "01-01-2018"
    Then click on the Volgende button
    And within "Kapitaalgegevens" the user enters the "Geplaatst_kapitaal" with "2000"
    And within "Kapitaalgegevens" the user enters the "Gestort_kapitaal" with "1000"
    Then click on the Volgende button
    And within "Bestuurder(s)" the user enters the "Datum_waarop_de_functionaris_in_functie_is_getreden" with "01-01-2018"
    And within "Bestuurder(s)" the user enters the "Burgerservicenummer" with "999916464"
    And the user clicks checkbox to validate the BSN number
    Then click on the Volgende button
    And within "Vestiging(en)" the user enters the "Datum_ingang" with "01-01-2018"
    And within "Vestiging(en)" the user enters the "Postcode" with "1061TL"
    And within "Vestiging(en)" the user enters the Huisnummer with "17"
    And within "Vestiging(en)" the user enters the "Activiteitomschrijving" with "Dit is een activiteitomschrijving"
    And within "Vestiging(en)" the user enters the "deletableHandelsnaam_1_*_" with "Dit is een TestHandel"
    And within "Vestiging(en)" the user enters the "Hoeveel_personen_werken_er_fulltime_(15_uur_of_meer_per_week)_in_de_onderneming?" with "2"
    And within "Vestiging(en)" the user enters the "Hoeveel_personen_werken_er_parttime_(minder_dan_15_uur_per_week)_in_de_onderneming?" with "2"
    Then click on the Volgende button
    Then click on the Volgende button
    Then click on the Volgende button
    And within "Bijlage(n)" the user uploads the attachment "Datacard.pdf" for "Datacard Vanya Ebben (verplicht)"
    And within "Bijlage(n)" the user uploads the attachment "Akte van oprichting.pdf" for "Akte van oprichting (verplicht)"
    Then click on the Opslaan button
    Then click on the Volgende button
    And within "Referentie informatie" the user enters the Naam_berichtenbox with "123"
    And within "Referentie informatie" the user chooses for "uitsluiten" the radiobutton "Nee"
    And within "Referentie informatie" the user chooses for "uitlenen" the radiobutton "Nee"
    And within "Referentie informatie" the user chooses for "uitreksel" the radiobutton "Nee"
    And within "Referentie informatie" the user chooses for "engelsUittreksel" the radiobutton "Nee"
    And within "Referentie informatie" the user enters the "Naam_contactpersoon" with "Simon de Tester"
    And within "Referentie informatie" the user enters the "E-mailadres_contactpersoon" with "noreply@kvk.nl"
    And within "Referentie informatie" the user enters the "Telefoonnummer_contactpersoon" with "0612345678"
    And within "Referentie informatie" the user enters the "Uw_referentie" with "referentie"
    And within "Referentie informatie" the user enters the "Aanvullende_informatie" with "Aanvullende informatie"
    Then click on the Opslaan button
    Then click on the Volgende button
    Then click on the Valideren button
    Then the message Validate is succesvol is shown