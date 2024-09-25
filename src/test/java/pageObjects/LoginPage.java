package pageObjects;

import common.SynchronizationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='login-username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='login-password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='login-submit']")
    WebElement loginSummitButton;

    @FindBy(xpath = "//a[@href='register.php']")
    WebElement registrationButton;

    @FindBy(xpath = "//a[@onclick='displayLoginForm()']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"accountbar\"]/table/tbody/tr[2]/td/a[2]")
    public WebElement logoutButton;

    @FindBy(xpath = "//span[text()='Dieser User existiert nicht.']")
    public WebElement userNichtExistiertMeldung;

    @FindBy(xpath = "//a[text()='Profil']")
    public WebElement profilOptionAfterLogin;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logoutOptionAfterLogin;

    @FindBy(xpath = "//*[text()='Benutzername oder Passwort falsch']")
    public WebElement benutzernameOderPasswortFalschMeldung;

    @FindBy(xpath = "//div[@id='overlay']")
    public WebElement ausserhalbDerLoginDialog;



    @FindBy(xpath = "")
    WebElement errorMessage;


    public LoginPage(WebDriver pDriver) {
        driver = pDriver;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String strUserName) {
        username.sendKeys(strUserName + Keys.SHIFT);
    }

    public void setPassword(String strPassword) {
        password.sendKeys(strPassword);
    }

    public void clickLoginSubmit() {
        loginSummitButton.click();}

    public void clickRegistrationLink() {
        registrationButton.click();}

}