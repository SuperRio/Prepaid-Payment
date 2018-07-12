@guest_large
Feature: Login func
Scenario: login with valid credentials

 
Given that I am CallYa Guest user
    When I choose to top-up my/other person balance online
    Then Choose Large amount to Top-up
    And Choose to continue as a guest
    And Enter The Personal Data
    And Choose Payment Method credit card
    And complete Review step
    Then I shall view  Confirmation page