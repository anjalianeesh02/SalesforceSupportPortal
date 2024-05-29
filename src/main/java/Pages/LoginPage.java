package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.UserCredentials;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public void waitForElementVisibility(By locator, int timeout) {
        System.out.println("Waiting for element with locator: " + locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        System.out.println("Element found!");
    }


    // Locators
    By username = By.xpath("//*[@id='48:2;a']");
 //   By password = By.xpath("//input[@class='oxd-input oxd-input--active' and @name='password']");
    By password = By.xpath("//*[@id='61:2;a']");
    By loginButton = By.xpath("//span[@class=' label bBody']");



    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Methods
    public void enterUsername(String usernameText) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        usernameElement.sendKeys(UserCredentials.getUsername());
    }

    public void enterPassword(String passwordText) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        passwordElement.sendKeys(UserCredentials.getPassword());
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButtonElement.click();
        System.out.println("User successfully Logged in to the Salesforce Website");
    }
}
