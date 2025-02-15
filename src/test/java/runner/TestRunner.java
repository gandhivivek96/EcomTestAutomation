package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Configuration;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@CucumberOptions(features = "src/test/resources/features",
        glue = "io.github.gandhivivek96.stepdefs",
        plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"},
        monochrome = true)
      //  publish = true)
public class TestRunner extends AbstractTestNGCucumberTests{

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios()
    {
       return super.scenarios();
    }

    @AfterSuite
    public void generateReport() {

            File reportOutputDirectory = new File("target/detailed-cucumber-reports");
            List<String> jsonFiles = new ArrayList<>();
            jsonFiles.add("target/cucumber.json");

            String projectName = "EcomTestAutomation";

            Configuration configuration = new Configuration(reportOutputDirectory, projectName);
            configuration.setBuildNumber("1");

            ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
            reportBuilder.generateReports();

    }
}
