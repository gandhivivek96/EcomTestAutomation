package io.github.gandhivivek96.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.gandhivivek96.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageStepDef {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp()
    {
        driver = new ChromeDriver();
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

        loginPage.enterEmail("test@test.com");
        loginPage.enterPassword("123");

    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() {

        loginPage.clickLogin();

    }
    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
    }





}
