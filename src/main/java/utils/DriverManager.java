package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }
            else if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            }
            else {
                throw new IllegalArgumentException("Invalid browser name: " + browser);
            }
        }
        return driver;
    }

    public void setUp() {
        DriverManager.getDriver(UserCredentials.getAppURL());
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private void takeScreenshot(String fileName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        Path destinationPath = Path.of("screenshots", fileName + ".png");
        Files.copy(sourceFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
    }

}
