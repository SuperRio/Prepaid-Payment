@guest_large
Feature: Login func
Scenario: login with valid credentials

 
Given that I am CallYa Guest user
    When I choose to top-up my/other person balance online
    Then Choose VARIOUS amount to Top-up
    And  login with user has from 2 to 10 MSISDNs
    Then Check user's MSISDNs
