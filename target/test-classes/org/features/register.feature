Feature: Register Test
  Register should display after clicking on Register link
  Fill all data and register
  User should get resistered and message should displayed
  
  Background: 
    Given I pass all test data in sheet name "REGISTER"
    Then I want to run test for row number "2"
    
    
@Register_Pos
Scenario Outline: Register a new User
  When I click on Register 
  Then I verify Register Label dislayed
  Then I click on male Radio button
  Then I enter "FIRST_NAME"
  Then I enter "LAST_NAME"
  Then I select "DAY"
  Then I will close browser for iteration
  	
  Examples:
  | FIRST_NAME | LAST_NAME | DAY |
  | "Test "| "test" |"03"|
  
  
  @Register_Neg
Scenario Outline: Register a new User
  When I click on Register 
  Then I click on Register button
  Then I verify first name message "FIRST_NAME_MESSAGE"
  Examples:
  | FIRST_NAME_MESSAGE | LAST_NAME | DAY |
  | "Tdsfsdfsdfsfsdfsdfs"| "test" |"03"|
  