
@tag
Feature: Employee Login
  

  @tag1
  Scenario: check employee login with valid credentials
    
		Given i open the browser with url "http://orangehrm.qedgetech.com"
   	Then i should see login page
   	When i enter username as "sravs2255"
   	And i enter password as "Sravlu244!"
   	And i click login
   	Then i should see Dashboard
   	When i click logout
   	Then i should see login page
   	When i close browser