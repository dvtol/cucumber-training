@NewRegistrationNV
Feature: OR frontoffice login

  Background: Feature: OR frontoffice login

  Scenario: Registration Naamloze Vennootschap
    Given the user opens the OR frontoffice application
    When the user is logged in and starts with a new registration with legal form "Naamloze Vennootschap"
    And within "Basisgegevens van de Naamloze Vennootschap" the user enters the unique "Naam_rechtspersoon" with "N.V."
    And within "Basisgegevens van de Naamloze Vennootschap" the user enters the "Zetel" with "Utrecht"
    And within "Basisgegevens van de Naamloze Vennootschap" the user enters the "Oprichtingskosten" with "250"
    And within "Basisgegevens van de Naamloze Vennootschap" the user enters the "Datum_akte_van_oprichting" with "01-01-2018"
    And within "Basisgegevens van de Naamloze Vennootschap" the user enters the "Datum_ingang" with "01-01-2018"
    And within "Basisgegevens van de Naamloze Vennootschap" the user chooses for "Bestuursmodel" the option "Dualistisch"
    And within "Basisgegevens van de Naamloze Vennootschap" the user chooses for "Beleggingsmaatschappij_met_veranderlijk_kapitaal?" the radiobutton "Ja"
    And within "Basisgegevens van de Naamloze Vennootschap" the user chooses for "Is_het_RSIN_bekend?" the radiobutton "Nee"
    Then click on the Volgende button
    And within "Kapitaalgegevens" the user chooses for "hasAandelen" the radiobutton "Nee"
    And within "Kapitaalgegevens" the user enters the "Maatschappelijk_kapitaal" with "3000"
    And within "Kapitaalgegevens" the user enters the "Geplaatst_kapitaal" with "2000"
    And within "Kapitaalgegevens" the user enters the "Gestort_kapitaal" with "2000"
    Then click on the Opslaan button
    Then click on the Volgende button
    And within "Bestuurder(s)" the user enters the "Datum_waarop_de_functionaris_in_functie_is_getreden" with "01-01-2018"
    And within "Bestuurder(s)" the user chooses for "Type_bestuurder" the option "Bestuurder"
    And within "Bestuurder(s)" the user chooses for "isEnigAandeelhouder" the radiobutton "Nee"
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
    And within "Bestuurder(s)" the user chooses for "isFunctieTitelStatutairBepaald" the radiobutton "Nee"
    And within "Bestuurder(s)" the user chooses for "standaardFunctieTitel" the radiobutton "Ja"
    And within "Bestuurder(s)" the user chooses for Functietitel the option "Directeur"
    And within "Bestuurder(s)" the user chooses for "Bevoegdheid_van_de_bestuurder" the option "Alleen/zelfstandig bevoegd"
    Then click on the Opslaan button
    Then click on the Volgende button
    And within "Vestiging(en)" the user enters the "Datum_ingang" with "01-01-2018"
    And within "Vestiging(en)" the user chooses for "isBezoekAdresBuitenlandsAdres" the radiobutton "Nee"
    And within "Vestiging(en)" the user enters the "Postcode" with "1061tl"
    And within "Vestiging(en)" the user enters the Huisnummer with "17"
    And within "Vestiging(en)" the user enters the "Toevoeging_adres" with "AB"
    And within "Vestiging(en)" the user chooses for "isPostAdresGelijkAanBezoekAdres" the radiobutton "Ja"
    And within "Vestiging(en)" the user enters the "Activiteitomschrijving" with "Dit is een activiteitomschrijving"
    And within "Vestiging(en)" the user enters the "Indien_meerdere_activiteiten,_wat_is_dan_de_belangrijkste?" with "Dit is belangrijk"
    And within "Vestiging(en)" the user chooses for "importeer" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "exporteer" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for Activiteit "1" the option "01134 - Teelt van aardappels en overige wortel- en knolgewassen"
    And within "Vestiging(en)" the user chooses for Activiteit "2" the option "4615 - Handelsbemiddeling in meubels, huishoudelijke artikelen en ijzerwaren"
    And within "Vestiging(en)" the user chooses for "Wat_is_de_hoofdactiviteit?" the option "01134 - Teelt van aardappels en overige wortel- en knolgewassen"
    And within "Vestiging(en)" the user chooses for "inEenWinkelOfKiosk" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "opDeMarkt" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "viaStraathandel" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "viaInternet" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "vanuitHuis" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "perPostorder" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "andersNamelijk" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "verkoopAanGroothandel" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "hasDomeinnamen" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "hasEmailadressen" the radiobutton "Nee"
    And within "Vestiging(en)" the user enters the "Hoeveel_personen_werken_er_fulltime_(15_uur_of_meer_per_week)_in_de_onderneming?" with "2"
    And within "Vestiging(en)" the user enters the "Hoeveel_personen_werken_er_parttime_(minder_dan_15_uur_per_week)_in_de_onderneming?" with "2"
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
    And within "Bijlage(n)" the user uploads the attachment "Akte van oprichting met € teken.pdf" for "Accountantsverklaring (verplicht)"
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