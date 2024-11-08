package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features="FeatureFiles/userreg.feature",
		glue="stepdefenitions",
		dryRun = false,
		plugin= {"pretty","html:TestReports/userreg_reports.html"}		
)

public class UserRegTest extends AbstractTestNGCucumberTests
{

}
