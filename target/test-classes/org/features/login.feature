Feature: This is to test login functionality

@Login_Sm_pos
Scenario Outline: to test Login positive flow
	Given browser is opened and URL is placed
    Then I will click on Login Link
    Then I enter user mail<emailID>
    Then I enter password<Password>
    When I click on Login
    Then Login should successful
    And Account information page should displayed
    
		
		Examples:
		| emailID | Password | 
		| "test@test.com" | "test2222" |
		
		
		 
		