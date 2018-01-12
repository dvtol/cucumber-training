@NewRegistrationStichting
Feature: OR frontoffice login

  Background: Feature: OR frontoffice login

  Scenario: Registration Stichting
    Given the user opens the OR frontoffice application
    When the user is logged in and starts with a new registration with legal form "Stichting"
    And within "Basisgegevens van de Stichting" the user enters the unique "Naam_rechtspersoon" with "Stichting"
    And within "Basisgegevens van de Stichting" the user enters the "Eventueel_verkorte_naam" with "Jojo Stichting"
    And within "Basisgegevens van de Stichting" the user enters the "Zetel" with "Amsterdam"
    And within "Basisgegevens van de Stichting" the user enters the "Datum_akte_van_oprichting" with "01-01-2018"
    And within "Basisgegevens van de Stichting" the user enters the "Datum_ingang" with "01-01-2018"
    And within "Basisgegevens van de Stichting" the user chooses for "Zijn_er_buiten_een_eventuele_onderneming_nog_vestigingen?" the radiobutton "Nee"
    And within "Basisgegevens van de Stichting" the user chooses for "Is_het_RSIN_bekend?" the radiobutton "Nee"
    Then click on the Volgende button
    And within "Adresgegevens rechtspersoon" the user chooses for "isBezoekAdresBuitenlandsAdres" the radiobutton "Nee"
    And within "Adresgegevens rechtspersoon" the user enters the "Postcode" with "1061tl"
    And within "Adresgegevens rechtspersoon" the user enters the Huisnummer with "17"
    And within "Adresgegevens rechtspersoon" the user enters the "Toevoeging_adres" with "7953"
    And within "Adresgegevens rechtspersoon" the user chooses for "isPostAdresGelijkAanBezoekAdres" the radiobutton "Ja"
    And within "Adresgegevens rechtspersoon" the user enters the "Activiteitomschrijving" with "Dit is een activiteitomschrijving"
    And within "Adresgegevens rechtspersoon" the user enters the "Indien_meerdere_activiteiten,_wat_is_dan_de_belangrijkste?" with "Dit is belangrijk"
    And within "Adresgegevens rechtspersoon" the user chooses for Activiteit "1" the option "0170 - Jacht"
    And within "Adresgegevens rechtspersoon" the user chooses for Activiteit "2" the option "4615 - Handelsbemiddeling in meubels, huishoudelijke artikelen en ijzerwaren"
    And within "Adresgegevens rechtspersoon" the user chooses for "Wat_is_de_hoofdactiviteit?" the option "0170 - Jacht"
    And within "Adresgegevens rechtspersoon" the user enters the "Nummer_deletableTelefoonnummer_1" with "0301234567"
    And within "Adresgegevens rechtspersoon" the user enters the "Nummer_deletableFaxnummer_1" with "0301234567"
    And within "Adresgegevens rechtspersoon" the user chooses for "hasEmailadressen" the radiobutton "Nee"
    And within "Adresgegevens rechtspersoon" the user chooses for "hasDomeinnamen" the radiobutton "Nee"
    Then click on the Opslaan button
    Then click on the Volgende button
    And within "Bestuurder(s)" the user enters the "Datum_waarop_de_functionaris_in_functie_is_getreden" with "01-01-2018"
    And within "Bestuurder(s)" the user chooses for "Type_bestuurder" the option "Persoon krachtens statuten bevoegd bij ontstentenis belet van de bestuurders"
    And within "Bestuurder(s)" the user chooses for "isNatuurlijkPersoon" the radiobutton "Ja"
    And within "Bestuurder(s)" the user chooses for "hasBsn" the radiobutton "Nee"
    And within "Bestuurder(s)" the user enters the "Achternaam" with "Koekenbakker"
    And within "Bestuurder(s)" the user enters the "Voorna(a)m(en)_(voluit)" with "Johannes Cornelis Jacob"
    And within "Bestuurder(s)" the user enters the "Tussenvoegsel(s)" with "van der"
    And within "Bestuurder(s)" the user enters the Geboortedatum with "24-11-1987"
    And within "Bestuurder(s)" the user chooses for Geboorteland the option "Christmaseiland"
    And within "Bestuurder(s)" the user enters the "Geboorteplaats" with "Amsterdam"
    And within "Bestuurder(s)" the user chooses for "Geslacht" the option "Mannelijk"
    And within "Bestuurder(s)" the user chooses for "isBuitenlandsAdres" the radiobutton "Nee"
    And within "Bestuurder(s)" the user enters the "Postcode" with "1061tl"
    And within "Bestuurder(s)" the user enters the Huisnummer with "17"
    And within "Bestuurder(s)" the user enters the "Toevoeging_adres" with "AB"
    And within "Bestuurder(s)" the user chooses for "Bevoegdheid_van_de_bestuurder" the option "Alleen/zelfstandig bevoegd"
    Then click on the Opslaan button
    Then click on the Volgende button
    And within "Vestiging(en)" the user chooses for "question" the radiobutton "Nee"
    Then click on the Opslaan button
    Then click on the Volgende button
    And within "Functionaris(sen)" the user chooses for "question" the radiobutton "Nee"
    Then click on the Opslaan button
    Then click on the Volgende button
    And within "Gemachtigde(n)" the user chooses for "question" the radiobutton "Nee"
    Then click on the Opslaan button
    Then click on the Volgende button
    And within "Bijlage(n)" the user uploads the attachment "Datacard.pdf" for "Datacard Johannes Cornelis Jacob van der Koekenbakker (verplicht)"
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