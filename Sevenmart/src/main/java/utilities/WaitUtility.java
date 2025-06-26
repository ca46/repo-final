package utilities;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitUtility {
    public static final int EXPLICIT_WAIT_SECONDS = 50;
    public static final long IMPLICIT_WAIT_SECONDS = 10;
	public static final long IMPLICIT_WAIT = 0;

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_SECONDS))
            .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_SECONDS))
            .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeInvisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_SECONDS))
            .until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForTextToBePresent(WebDriver driver, WebElement element, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_SECONDS))
            .until(ExpectedConditions.textToBePresentInElement(element, text));
    
    }
}


