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