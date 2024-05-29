package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RaiseSupportIssue {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private By raiseSupportLink = By.xpath("//a[@href='/s/contactsupport']");
    private By getPageTitle = By.xpath("(//h1[@class='slds-page-header__title'])[1]");
    private By subtitle1 = By.xpath("(//span[@class='subtitle'])[1]");
    private By pageTitle2 = By.xpath("(//h1[@class='slds-page-header__title'])[2]");
    private By subtitle2 = By.xpath("(//span[@class='subtitle'])[2]");
    private By accountText = By.xpath("//span[contains(text(), 'Account')]");
    private By caseOrigin = By.xpath("//span[contains(text(), 'Case Origin')]");
    private By caseReason = By.xpath("//span[contains(text(), 'Case Reason')]");
    private By productDisplay = By.xpath("//span[contains(text(), 'Product')]");
    private By subjectDisplay = By.xpath("//span[contains(text(), 'Subject')]");
    private By descriptionDisplay = By.xpath("//span[contains(text(), 'Description')]");
    private By priorityDisplay = By.xpath("//span[contains(text(), 'Priority')]");
    private By escalatedDis = By.xpath("//span[contains(text(), 'Escalated')]");
    private By statusDisplay = By.xpath("//span[contains(text(), 'Status')]");
    private By uploadFile = By.xpath("//button[@class='slds-button' and @title='Upload File']");
    private By caseOriginDropdown = By.xpath("(//a[@class='select' and text()='--None--'])[1]");
    private By caseReasonDropdownele = By.xpath("(//a[@class='select' and text()='--None--'])[1]");
    private By caseOrigindropdownOptions = By.xpath("//div[contains(@class, 'select-options')]//ul[@role='presentation'][1]/li[@role='presentation']");
   // private By caseReasonDropdownOptions = By.xpath("//div[contains(@class, 'select-options')]//ul[@role='presentation'][1]/li[@role='presentation']");
    private By caseReasonDropdownOptions = By.xpath("//*[@id=\"649:0\"]/div/a");
    private By selectedOptionLocator = By.xpath("//a[text()='Email']/parent::div[contains(@class, 'select-option-selected')]");

    public RaiseSupportIssue(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public void clickRaiseSupportLink() throws InterruptedException {
        WebElement raiseSupportButtonElement = wait.until(ExpectedConditions.elementToBeClickable(raiseSupportLink));
        raiseSupportButtonElement.click();
        Thread.sleep(2000);
    }

    public boolean pageTitle1Displayed() {
        WebElement title1 = wait.until(ExpectedConditions.visibilityOfElementLocated(getPageTitle));
        return title1.isDisplayed();
    }

    public boolean subTitle1Displayed() {
        WebElement subtitle1displ = wait.until(ExpectedConditions.visibilityOfElementLocated(subtitle1));
        return subtitle1displ.isDisplayed();
    }

    public boolean pageTitle2Displayed() {
        WebElement title2 = wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle2));
        return title2.isDisplayed();
    }

    public boolean subTitle2Displayed() {
        WebElement subtitle2dis = wait.until(ExpectedConditions.visibilityOfElementLocated(subtitle2));
        return subtitle2dis.isDisplayed();
    }

    public boolean accountTextDisplay() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountText)).isDisplayed();
    }

    public boolean caseOriginDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(caseOrigin)).isDisplayed();
    }

    public boolean caseReasonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(caseReason)).isDisplayed();
    }

    public boolean productDisplayText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productDisplay)).isDisplayed();
    }

    public boolean subjectDisplayText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(subjectDisplay)).isDisplayed();
    }

    public boolean descriptionDisplayText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionDisplay)).isDisplayed();
    }

    public boolean priorityDisplayText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(priorityDisplay)).isDisplayed();
    }

    public boolean escalatedDisplayText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(escalatedDis)).isDisplayed();
    }

    public boolean statusDisplayText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(statusDisplay)).isDisplayed();
    }

    public boolean uploadFileOption() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(uploadFile)).isDisplayed();
    }

    public void caseOriginDropdownClick() {
        WebElement caseOriginElement = wait.until(ExpectedConditions.elementToBeClickable(caseOriginDropdown));
        caseOriginElement.click();
    }

    public void selectCaseOrigin(String optionToSelect) {
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(caseOrigindropdownOptions));
        for (WebElement option : options) {
            if (option.getText().equals(optionToSelect)) {
                option.click();
                break;
            }
        }
    }

    public void selectCaseReasn(String optionToSelect) {
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(caseReasonDropdownOptions));
        for (WebElement option : options) {
            if (option.getText().equals(optionToSelect)) {
                option.click();
                break;
            }
        }
    }

    /*public void selectCaseReasonUsingKeyboard(String optionToSelect) {
        WebElement caseReasonDropdown = wait.until(ExpectedConditions.elementToBeClickable(caseReasonDropdownele));
        caseReasonDropdown.click();

        // Send keys to navigate to the desired option
        caseReasonDropdown.sendKeys(Keys.ARROW_DOWN); // Navigate down
        caseReasonDropdown.sendKeys(Keys.ENTER); // Select the option
    }*/

    public void selectCaseReasonUsingKeyboard(String optionToSelect) {
        // Locate and click the dropdown to open it
        WebElement caseReasonDropdown = wait.until(ExpectedConditions.elementToBeClickable(caseReasonDropdownele));
        caseReasonDropdown.click();

        // Wait for the dropdown options to be visible
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(caseReasonDropdownOptions));

        // Initialize a flag to determine if the option is found
        boolean optionFound = false;

        // Iterate through options to find the desired option
        for (WebElement option : options) {
            String optionText = option.getText().trim();

            // Scroll into view using JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);

            // Add a small delay to ensure the scroll is complete
            try {
                Thread.sleep(500);  // Adjust the sleep time if necessary
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Check if the current option is the one to select
            if (optionText.equals(optionToSelect)) {
                // Send ENTER key to select the option
                option.sendKeys(Keys.ENTER);
                optionFound = true;
                break;
            }

            // Send ARROW_DOWN key to move to the next option
            option.sendKeys(Keys.ARROW_DOWN);
        }

        // Handle case if the option was not found
        if (!optionFound) {
            System.out.println("Option not found: " + optionToSelect);
        }
    }

    public void printCaseReasonDropdownOptions() {
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(caseReasonDropdownOptions));
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }

  /*  public void printCaseOriginDropdownOptions() {
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(caseOrigindropdownOptions));
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }*/

    public void printCaseOriginDropdownOptions() {
        // Wait until all dropdown options are visible
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(caseOrigindropdownOptions));

        // Iterate over each option and scroll it into view before printing its text
        for (WebElement option : options) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
            // Optionally add a small delay to ensure the scroll is complete before printing the text
            try {
                Thread.sleep(500);  // Adjust the sleep time if necessary
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(option.getText());
        }
    }



    public void caseReasonDropdownClick() {
        WebElement caseOriginElement = wait.until(ExpectedConditions.elementToBeClickable(caseReasonDropdownele));
        caseOriginElement.click();
    }
}

