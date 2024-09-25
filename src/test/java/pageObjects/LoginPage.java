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

    @FindBy(xpath = "//a[@href='register.php']")
    WebElement registrationButton;

    @FindBy(id = "loginContainer")
    WebElement loginModalTitle;

    @FindBy(id = "login-username-msg")
    WebElement messageUnderUsername;

    @FindBy(id = "login-password-msg")
    WebElement messageUnderPassword;

    public LoginPage(WebDriver pDriver) {
        driver = pDriver;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String strUserName) {
        username.sendKeys(strUserName);
    }

    public Boolean presenceOfLoginTitle(){
        return loginModalTitle.isDisplayed();
    }
    public void setPassword(String strPassword) {
        password.sendKeys(strPassword);
    }

    public String getUserNamePlaceholder() {
        return username.getAttribute("placeholder");
    }

    public String getPasswordPlaceholder() {
        return password.getAttribute("placeholder");
    }

    public void clickLoginSubmit() {
        loginSummitButton.click();}

    public String getUsernameErrorMessage(){
        SynchronizationUtils.waitForVisibility(driver,messageUnderUsername,10);
        return messageUnderUsername.getText();
    }

    public String getPasswordErrorMessage(){
        SynchronizationUtils.waitForVisibility(driver,messageUnderPassword,10);
        return messageUnderPassword.getText();
    }

    public void clickRegistrationLink() {
        registrationButton.click();}

}