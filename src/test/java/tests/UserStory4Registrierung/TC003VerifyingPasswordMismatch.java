package tests.UserStory4Registrierung;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrierungPage;
import reporting.CaptureScreen;
import reporting.ExtentTestListener;
import reporting.ReportHelper;

@Listeners(ExtentTestListener.class)
public class TC003VerifyingPasswordMismatch extends TestBase {
    String username = "User123";
    String password = "Ocaso18!96";
    String confirmPassword = "Ocaso18!97";

    @Test(description = "For TC003: Verifying that the passwords match.")
    public void TestCase3() {
        ReportHelper.createInfoLog("Step 1:","Going to register page");
        clickRegisterButton();
        ReportHelper.createInfoLog("Step 2:","Send Keys for registration");
        String[][] aInfos = {
                {"Username", username},
                {"Password", password},
                {"Confirm Password (Not the same as password)", confirmPassword}
        };
        ReportHelper.createTable(aInfos);

        sendKeysToUsername(username);
        sendKeysToPassword(password);
        sendKeysToConfirmPassword(confirmPassword);

        String aScreenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Failure in Password", aScreenshot);
        Assert.assertEquals(textOfMessageUnderConfirmPassword(),"Die Passwörter stimmen nicht überein", "Passwords do not match");
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

    public void sendKeysToPassword(String password) {
        RegistrierungPage registrierungPage = new RegistrierungPage(driver);
        registrierungPage.enterPassword(password);
    }
    public void sendKeysToConfirmPassword(String confirmPassword) {
        RegistrierungPage registrierungPage = new RegistrierungPage(driver);
        registrierungPage.enterRePassword(confirmPassword);
    }
    public String textOfMessageUnderConfirmPassword(){
        RegistrierungPage registrierungPage = new RegistrierungPage(driver);
        return registrierungPage.getTextOfMessageConfirmPassword();
    }
}
