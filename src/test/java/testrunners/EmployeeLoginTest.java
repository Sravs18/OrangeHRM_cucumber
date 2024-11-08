package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features="FeatureFiles/employeelogin.feature",
		glue="stepdefenitions",
		dryRun = false,
		plugin= {"pretty","html:TestReports/employeelogin_reports.html"}
			
)

public class EmployeeLoginTest extends AbstractTestNGCucumberTests
{

}
