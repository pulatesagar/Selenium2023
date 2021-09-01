package runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features="@rerun/failed_scenarios1.txt",
		glue="stepdefs",
        //tags={"@am"},
		monochrome = true,
		plugin = {"pretty",
				"html:target/html/",
				"json:target/json/file2.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
		strict=false,
		dryRun=false

		)
public class RunTestRerun {

}
