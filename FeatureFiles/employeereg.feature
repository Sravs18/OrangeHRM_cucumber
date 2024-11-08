
@tag
Feature: New Employee Registrstion
 

  @tag1
  Scenario: Check new employee Registrstion with valid inputs
     Given i open the browser with url "http://orangehrm.qedgetech.com"
   	Then i should see login page
   	When i enter username as "Admin"
   	And i enter password as "Qedge123!@#"
   	And i click login
   	Then i should see admin module
   	When i goto add employee page
   	And i enter first name as "Richards"
   	And i enter last name as "Demo"
    And i click save
    Then i should see registered employee in employee list
    When i click logout
   	Then i should see login page
   	When i close browser

 
