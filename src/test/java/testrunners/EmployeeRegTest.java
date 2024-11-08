package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions
(
		features="FeatureFiles/employeereg.feature",
		glue="stepdefenitions",
		dryRun = false,
		plugin= {"pretty","html:TestReports/employeereg_report.html"}
)





public class EmployeeRegTest extends AbstractTestNGCucumberTests
{

}
