package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SynchronizationUtils {

    public static void waitForClickable(WebDriver pDriver, WebElement pWebElement, long pTimer) {
        WebDriverWait wait = new WebDriverWait(pDriver, Duration.ofSeconds(pTimer));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(pWebElement)));
    }

    public static void waitForVisibility(WebDriver pDriver, WebElement pElement, long pTimer) {
        WebDriverWait aWait = new WebDriverWait(pDriver, Duration.ofSeconds(pTimer));
        aWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(pElement)));
    }

    public static void waitForElementToBeVisibleWithBy(WebDriver pDriver, By pName, long pTimer) {
        WebDriverWait aWait = new WebDriverWait(pDriver, Duration.ofSeconds(pTimer));
        aWait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(pName)));
    }

    public static void waitForElementToBeMoreThanZero(WebDriver pDriver, By pName, long pTimer) {
        WebDriverWait aWait = new WebDriverWait(pDriver, Duration.ofSeconds(pTimer));
        aWait.until(ExpectedConditions.refreshed(ExpectedConditions.numberOfElementsToBeMoreThan(pName, 0)));
    }

    public static void waitForIFrame(WebDriver pDriver, WebElement pElement, long pTimer) {
        WebDriverWait aWait = new WebDriverWait(pDriver, Duration.ofSeconds(pTimer));
        aWait.until(ExpectedConditions.refreshed(ExpectedConditions.frameToBeAvailableAndSwitchToIt(pElement)));
    }

    public static void waitTillTextIsVisible(WebDriver pDriver, String aXpath, String aText, long aDuration) {
        WebDriverWait aWait = new WebDriverWait(pDriver, Duration.ofSeconds(aDuration));
        aWait.until(ExpectedConditions.textToBe(By.xpath(aXpath), aText));
    }

    public static void waitForAlert(WebDriver pDriver, long aDuration) {
        WebDriverWait aWait = new WebDriverWait(pDriver, Duration.ofSeconds(aDuration));
        aWait.until(ExpectedConditions.alertIsPresent());
    }
}