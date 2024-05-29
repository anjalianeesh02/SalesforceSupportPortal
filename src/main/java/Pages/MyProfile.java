package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyProfile {
    private final WebDriver driver;
    private final WebDriverWait wait;

   By ProfileOption = By.xpath("//a[@id='1']");


    public MyProfile(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

   //Methods

    public void myProfileClick() {
        WebElement myProfileElement = wait.until(ExpectedConditions.elementToBeClickable(ProfileOption));
        myProfileElement.click();
        //System.out.println("Clicked on the login button");
    }

}


