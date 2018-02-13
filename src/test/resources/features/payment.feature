Feature: Login func. Test
Scenario: login with valid credentials

 
 Given that I am CallYa Guest user 
    When I choose to top-up my/other person balance online vodafone.de
    And Choose Top-up Amount
    And  Choose To continue as a Guest
    And	 Enter The Personal Data
    And  Choose Payment Method credit card
    And  complete Review step
    Then I shall view  Confirmation page
