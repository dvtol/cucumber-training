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
#@zoeken
#Functionaliteit: regressie zoeken

#  Achtergrond: Feature: Zoeken functionaliteit op de politie.nl website
#    Gegeven dat gebruiker is ingelogd op de homepage van politie.nl


#  Scenario: zoeken op de politie.nl website
#    Als ik op een searchterm ga zoeken