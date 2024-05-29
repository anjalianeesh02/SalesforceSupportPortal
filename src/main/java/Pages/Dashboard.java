package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dashboard {

    private final WebDriver driver;
    private final WebDriverWait wait;

    //Locators

    private By logo = By.xpath("//div[@class='logoImage']");
    private By homeoption = By.xpath("//a[@class='comm-navigation__top-level-item-link js-top-level-menu-item linkBtn comm-navigation__top-level-item-link--active comm-navigation__home-link']");
    private By profileOption = By.xpath("//a[@id='1']");
    private By raiseSupportLonk = By.xpath("//a[@href='/s/contactsupport']");
    private By topicsLink = By.xpath("//a[@id='3']");
  //  By searchButton = By.xpath("//svg[@class='slds-button__icon slds-button_icon-inverse' and @data-key='search']");
 // private By searchButton = By.xpath("//button[@class='slds-button__icon slds-button_icon-inverse' and @data-key='search']");
    private By searchButton = By.xpath("/html/body/div[3]/div[1]/div[1]/div/div/div/div[3]/div[4]/div/div[1]/div/div[1]/button");

    private By notificationButton = By.xpath("//button[@class='slds-button slds-button slds-button_icon slds-button_icon slds-button_icon-container slds-button_icon-small slds-global-actions__notifications slds-global-actions__item-action forceHeaderButton']");
    private By profileButton = By.xpath("//div[@class='slds-media__figure slds-m-horizontal_xx-small comm-user-profile-menu__trigger-icon']");
    private By searchBar = By.id("129:0-input");
    private By featuredTab = By.xpath("(//span[@class='title'])[1]");
    private By discussionsTab = By.xpath("(//span[@class='title'])[2]");
    private By myFeedTab = By.xpath("(//span[@class='title'])[3]");


    public Dashboard(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Methods

    public boolean logoDisplay() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).isDisplayed();
    }

    public boolean homelinkDisplay() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homeoption)).isDisplayed();
    }

    public boolean profileDisplay() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profileOption)).isDisplayed();
    }

    public boolean rasieSupportDisplay() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(raiseSupportLonk)).isDisplayed();
    }

    public boolean topicsLinktDisplay() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(topicsLink)).isDisplayed();
    }

    public boolean searchButtonDisplay(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton)).isDisplayed();
    }


       /* public boolean searchButtonDisplay() {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
                return true; // Return true if search button is displayed
            } catch (TimeoutException e) {
                System.out.println("Search button not found within the specified time.");
                return false; // Return false if search button is not displayed
            }
        }*/



 /*    public boolean searchButtonDisplay() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton)).isDisplayed();
    }

   public void clickSearchButton() {
        try {
            WebElement searchButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
            searchButtonElement.click();
            System.out.println("Search button clicked successfully");
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("TimeoutException: Search button not found within the specified time");
            e.printStackTrace();
        }
    }*/




    public boolean notifiactionButtonDisplay() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(notificationButton)).isDisplayed();
    }

    public boolean profileButtonDisplay() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profileButton)).isDisplayed();
    }

    public boolean searchBarDisp() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar)).isDisplayed();
    }

    public boolean featureTabdisolay() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(featuredTab)).isDisplayed();

    }

    public boolean discussionTabDisp() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(discussionsTab)).isDisplayed();
    }

    public boolean myFeedDisp() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(myFeedTab)).isDisplayed();
    }
}
