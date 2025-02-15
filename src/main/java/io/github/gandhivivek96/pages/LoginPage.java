package io.github.gandhivivek96.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    //locators
    By emailInputLocator = By.id("input-email");
    By passwordInputLocator = By.id("input-password");
    By loginButtonLocator = By.xpath("//input[@value='Login']");

    //constructor
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //actions
    public void enterEmail(String email)
    {
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String pwd)
    {
        WebElement enterpwd = driver.findElement(passwordInputLocator);
        enterpwd.sendKeys(pwd);
    }

    public void clickLogin()
    {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public void login(String email, String pwd)
    {
        enterEmail(email);
        enterPassword(pwd);
        clickLogin();
    }

}
