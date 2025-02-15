package io.github.gandhivivek96.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.gandhivivek96.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class LoginPageStepDef {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown()
    {
        if(driver!=null)
            driver.quit();
    }


    @Given("I am on the OpenCart login page")
    public void i_am_on_the_open_cart_login_page() {

        String url = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
        driver.get(url);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);

    }
    @Given("I have entered a valid email address and password")
    public void i_have_entered_a_valid_email_address_and_password() {

        loginPage.enterEmail("qasdet@gmail.com");
        loginPage.enterPassword("test123");

    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String email, String pwd) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.enterEmail(email);
        loginPage.enterPassword(pwd);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {

        loginPage.clickLogin();

    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {

        Assert.assertEquals(loginPage.checkLogoutLink(),true);
    }

    @Then("I should see an error message containing {string}")
    public void i_should_see_an_error_message_containing(String errormsg) {
        // Write code here that turns the phrase above into concrete actions

        Assert.assertEquals( loginPage.errorMessage(errormsg),true);
    }

}
