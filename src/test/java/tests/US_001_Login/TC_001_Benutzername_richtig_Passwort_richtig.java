package tests.US_001_Login;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import reporting.CaptureScreen;
import reporting.ExtentTestListener;
import reporting.ReportHelper;

@Listeners (ExtentTestListener.class)

public class TC_001_Benutzername_richtig_Passwort_richtig extends TestBase {

    String username = "Giray1";
    String password = "Giraysogeti1";

    @Test(description = "TC_001")
    public void testBenutzernameRichtigPasswortRichtig() {
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
        ReportHelper.addScreenshot("Screenshot of successful login",screenshot);
        Assert.assertTrue(loginPage.logoutOptionAfterLogin.isDisplayed());
        Assert.assertTrue(loginPage.profilOptionAfterLogin.isDisplayed());
    }
}
