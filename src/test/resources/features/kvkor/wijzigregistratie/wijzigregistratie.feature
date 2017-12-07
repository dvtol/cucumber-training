#language: nl
@Googletest
Functionaliteit: extra t.b.v. test buiten het politie netwerk met Google

  Achtergrond: Feature: Google calculator
    Gegeven open google

  Scenario: 1 eerste berekening met google
    Als enter "2+2" in searchbox
    Dan I should get result as "4"

  Scenario: 2 tweede berekening met google
    Als enter "665+335" in searchbox
    Dan I should get result as "1000"

  Scenario: 3 search testdata met google
    Als enter testdata in searchbox


#language: nl
#@meldmisbruik
#Functionaliteit: regressie meldmisbruik

#  Achtergrond: Feature: Het proces voor meld misbruik
#    Gegeven dat gebruiker is ingelogd op de homepage van politie.nl


#  Scenario: meld misbruik middels contact formulier
#    Als ik via de home een melding inschiet via een contactformulier