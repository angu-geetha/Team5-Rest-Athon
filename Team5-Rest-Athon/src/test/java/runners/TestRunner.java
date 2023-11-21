package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			plugin = {"pretty", "html:target/Cucumber.html",
					"json:target/cucumber.json",
					"junit:target/cucumber-reports/Cucumber.xml",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
					}, //reporting purpose
			monochrome=false,  //console output color
			features = {"src/test/resources/features/Login.feature",
					    "src/test/resources/features/Logout.feature",
					    "src/test/resources/features/Patient.feature",
					    "src/test/resources/features/PatientLogout.feature",
					    "src/test/resources/features/PatientLogin.feature",
					    "src/test/resources/features/Putpatient.feature",
					    "src/test/resources/features/Getallpatients.feature",
					    "src/test/resources/features/GetAllMorbidity.feature",
					    }, //location of feature files
					glue= "stepdefinitions" //location of step definition files
		)
public class TestRunner {
	
}
