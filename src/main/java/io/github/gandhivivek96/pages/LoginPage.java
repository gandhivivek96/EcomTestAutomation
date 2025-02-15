package io.github.gandhivivek96.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    //locators
    private By emailInputLocator = By.id("input-email");
    private By passwordInputLocator = By.id("input-password");
    private By loginButtonLocator = By.xpath("//input[@value='Login']");
    private By logoutLocator = By.xpath("//a[@class='list-group-item' and normalize-space(text())='Logout']");
    private By errorMsgLocator = By.cssSelector("div.alert.alert-danger");

    //constructor
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //actions
    public void enterEmail(String email)
    {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputLocator));
        emailInput.sendKeys(email);
    }

    public void enterPassword(String pwd)
    {
        WebElement enterpwd = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputLocator));
        enterpwd.sendKeys(pwd);
    }

    public void clickLogin()
    {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
        loginButton.click();
    }

    public boolean checkLogoutLink()
    { //return true if log out link is displayed or false
        WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLocator));
        return logoutLink.isDisplayed();
    }

    public boolean errorMessage(String expectedErrorMessage)
    {
        String altErrorMessage = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
        WebElement errorM = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsgLocator));
        return (errorM.getText().equals(expectedErrorMessage) || errorM.getText().equals(altErrorMessage));
    }

    public void login(String email, String pwd)
    {
        enterEmail(email);
        enterPassword(pwd);
        clickLogin();
    }

}
