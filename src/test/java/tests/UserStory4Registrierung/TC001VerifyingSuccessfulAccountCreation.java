package tests.UserStory4Registrierung;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrierungPage;
import reporting.*;

@Listeners(ExtentTestListener.class)
public class TC001VerifyingSuccessfulAccountCreation extends TestBase {
    String username = "Üser123";
    String password = "Ocaso18!96";
    String confirmPassword = "Ocaso18!96";

    @Test(description = "For TC001: Verifying successful account creation with valid credentials.")
    public void TestCase1() {
        ReportHelper.createInfoLog("Step 1:","Going to register page");
        clickRegisterButton();
        ReportHelper.createInfoLog("Step 2:","Sending keys for Register");
        String[][] aInfos = {
                {"Username", username},
                {"Password", password},
                {"Confirm Password", confirmPassword}
        };
        ReportHelper.createTable(aInfos);
        sendKeysToUsername(username);
        sendKeysToPassword(password);
        sendKeysToConfirmPassword(confirmPassword);
        ReportHelper.createInfoLog("Step 3:","Checking AGB");
        checkAGB();
        ReportHelper.createInfoLog("Step 4:","Clicking Registration Button");
        clickRegistration();
        String aScreenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Registration erfolgreich Modal PopUp", aScreenshot);
        Assert.assertEquals(getTextOfSuccessfulReg(),"Deine Registrierung war erfolgreich!", "The test is successful");
    }

    public void clickRegisterButton() {
        HomePage homepage = new HomePage(driver);
        homepage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationLink();
    }

    public void sendKeysToUsername(String username) {
        RegistrierungPage registrierungPage = new RegistrierungPage(driver);
        registrierungPage.enterUsername(username);
    }
    public String textOfMessageUnderUser(){
        RegistrierungPage registrierungPage = new RegistrierungPage(driver);
        return registrierungPage.getTextOfMessageUsername();
    }

    public void sendKeysToPassword(String password) {
        RegistrierungPage registrierungPage = new RegistrierungPage(driver);
        registrierungPage.enterPassword(password);
    }

    public void sendKeysToConfirmPassword(String confirmPassword) {
        RegistrierungPage registrierungPage = new RegistrierungPage(driver);
        registrierungPage.enterRePassword(confirmPassword);
    }

    public void checkAGB() {
        RegistrierungPage registrierungPage = new RegistrierungPage(driver);
        registrierungPage.checkAGB();
    }

    public void clickRegistration() {
        RegistrierungPage registrierungPage = new RegistrierungPage(driver);
        registrierungPage.clickRegister();
    }

    public String getTextOfSuccessfulReg() {
        RegistrierungPage registrierungPage = new RegistrierungPage(driver);
        return registrierungPage.getTextOfMessageOfSuccessfulRegistration();
    }

}
