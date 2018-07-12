@guest_small
Feature: Login func
Scenario: login with valid credentials

 
Given that I am CallYa Guest user
    When I choose to top-up my/other person balance online
    Then Choose Top-up Amount
    And Choose to continue as a guest
    And Enter The Valid Personal Data
    And Choose PayPal Payment Method
    And complete Review step
    And login with valid PayPal account and submit the transaction
    Then I shall view  Confirmation page