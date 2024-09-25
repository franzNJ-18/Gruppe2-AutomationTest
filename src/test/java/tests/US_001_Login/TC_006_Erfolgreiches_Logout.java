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

public class TC_006_Erfolgreiches_Logout extends TestBase {

    String username = "Giray1";
    String password = "Giraysogeti1";

    @Test(description = "TC_006")
    public void testErfolgreichesLogout() {
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
        Assert.assertTrue(loginPage.logoutOptionAfterLogin.isDisplayed());
        Assert.assertTrue(loginPage.profilOptionAfterLogin.isDisplayed());
        ReportHelper.createInfoLog("Step 4","Click Logout button");
        loginPage.logoutOptionAfterLogin.click();
        String screenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Screenshot of successful logout",screenshot);
        Assert.assertTrue(loginPage.loginButton.isDisplayed());

    }
}
