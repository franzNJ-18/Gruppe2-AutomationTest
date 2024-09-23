package pageObjects;

import common.SynchronizationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrierungPage {
    WebDriver driver;
    @FindBy(id = "register-username")
    WebElement usernameInput;

    @FindBy(id = "register-pw")
    WebElement passwordInput;

    @FindBy(id = "register-pwrep")
    WebElement confirmPasswordInput;

    @FindBy(id = "register-check")
    WebElement checkBoxAGB;

    @FindBy(xpath = "//a[@href='agb.php']")
    WebElement AGBLink;

    @FindBy(xpath = "//input[@value='Registrieren']")
    WebElement registrationButton;

    @FindBy(xpath = "//div[@id='register-overlay']/div/h2")
    WebElement textOfSuccessfulRegistration;

    @FindBy(id = "usrmsg")
    WebElement messageUnderUsername;

    @FindBy(id = "pwmsg")
    WebElement messageUnderPassword;

    @FindBy(id = "repwmsg")
    WebElement messageUnderConfirmPassword;

    @FindBy(id = "agbmsg")
    WebElement messageUnderAGB;



    public RegistrierungPage(WebDriver pDriver) {
        driver = pDriver;
        PageFactory.initElements(driver,this);
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterRePassword(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void checkAGB() {
        checkBoxAGB.click();
    }

    public void clickLinkAGB() {
        AGBLink.click();
    }

    public String getTextOfMessageUsername() {
        SynchronizationUtils.waitForVisibility(driver,messageUnderUsername,10);
        return messageUnderUsername.getText();
    }

    public String getTextOfMessageOfSuccessfulRegistration() {
        SynchronizationUtils.waitForVisibility(driver,textOfSuccessfulRegistration,10);
        driver.switchTo().activeElement();
        return textOfSuccessfulRegistration.getText();
    }

    public String getTextOfMessagePassword() {
        SynchronizationUtils.waitForVisibility(driver,messageUnderPassword,10);
        return messageUnderPassword.getText();
    }

    public String getTextOfMessageConfirmPassword() {
        SynchronizationUtils.waitForVisibility(driver,messageUnderConfirmPassword,10);
        return messageUnderConfirmPassword.getText();

    }

    public String getTextOfMessageAGB() {
        SynchronizationUtils.waitForVisibility(driver,messageUnderAGB,10);
        return messageUnderAGB.getText();

    }
    public void clickRegister() {
        registrationButton.click();
    }
}
