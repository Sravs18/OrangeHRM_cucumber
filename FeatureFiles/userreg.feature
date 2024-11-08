
@tag
Feature: New User Registration
  

  @tag1
  Scenario: Check new user Registrstion 
     Given i open the browser with url "http://orangehrm.qedgetech.com"
   	Then i should see login page
   	When i enter username as "Admin"
   	And i enter password as "Qedge123!@#"
   	And i click login
   	Then i should see admin module
   	When i go to user page
   	And i click add	
   	Then i select role as ESS
   	And i enter user name as "sravs2255"
   	And i enter employee name  as "Ajay k"
   	And i enter password  as "Sravlu244!"
   	And i click save button	
   	Then i should see registered user in the list
   	When i click logout
   	Then i should see login page
   	When i close browser