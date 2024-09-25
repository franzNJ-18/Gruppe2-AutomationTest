package tests.US_001_Login;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import reporting.CaptureScreen;
import reporting.ExtentTestListener;
import reporting.ReportHelper;
@Listeners(ExtentTestListener.class)

public class TC_004_Benutzername_falsch_Passwort_falsch extends TestBase {

    String username = "Giray2";
    String password = "Giraysogeti2";

    @Test(description = "TC_004")
    public void testBenutzernameFalschPasswortFalsch() {
        LoginPage loginPage  = new LoginPage(driver);
        ReportHelper.createInfoLog("Step 1","Click Login Link");
        loginPage.loginButton.click();
        String[][] aInfosUsername = {
                {"Username",username},
                {"Passwort",password}
        };
        ReportHelper.createInfoLog("Step 2","Send keys to username and password");
        ReportHelper.createTable(aInfosUsername);
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        ReportHelper.createInfoLog("Step 3","Click Submit button");
        loginPage.clickLoginSubmit();
        String screenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Screenshot of unsuccessful login",screenshot);
        Assert.assertTrue(loginPage.benutzernameOderPasswortFalschMeldung.isDisplayed());
    }
}
