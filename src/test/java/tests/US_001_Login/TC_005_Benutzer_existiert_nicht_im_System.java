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

public class TC_005_Benutzer_existiert_nicht_im_System extends TestBase {

    String username = "Giray12121212";
    String password = "Giraysogeti1";

    @Test(description = "TC_005")
    public void testBenutzerExistiertNichtImSystem() {
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
        String screenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Screenshot of user does not exists",screenshot);
        Assert.assertTrue(loginPage.userNichtExistiertMeldung.isDisplayed());
    }
}
