package pageObjects;

import common.SynchronizationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='login-username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='login-password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='login-submit']")
    WebElement loginSummitButton;

    @FindBy(xpath = "")
    WebElement errorMessage;
    @FindBy(xpath = "")
    WebElement logoutButton;

    public LoginPage(WebDriver pDriver) {
        driver = pDriver;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String strUserName) {
        username.sendKeys(strUserName);
    }

    public void setPassword(String strPassword) {
        password.sendKeys(strPassword);
    }

    public void clickLoginSubmit() {
        loginSummitButton.click();
    }

    public void verifyErrorMessage() {
        SynchronizationUtils.waitForVisibility(driver, errorMessage, 10);

    }

    public void logout() {
        logoutButton = driver.findElement(By.xpath("//button[@id='logout']"));
        logoutButton.click();
    }

}
