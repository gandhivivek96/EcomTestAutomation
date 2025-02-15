package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


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
}
