package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;




@CucumberOptions
(
		features="FeatureFiles/adminlogin.feature",
		glue="stepdefenitions",
		dryRun = true,
		plugin= {"pretty","html:TestReports/loginreport.html"}
		
		
)
public class AdminLoginTest extends AbstractTestNGCucumberTests

{

	
}
