package tests.US_001_Login;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import reporting.CaptureScreen;
import reporting.ExtentTestListener;
import reporting.ReportHelper;
@Listeners(ExtentTestListener.class)

public class TC_007_Schließen_des_Login_Dialogs extends TestBase {

    @Test(description = "TC_007")
    public void testSchließenDesLoginDialogs() {
        LoginPage loginPage  = new LoginPage(driver);
        ReportHelper.createInfoLog("Step 1","Click Login Link");
        loginPage.loginButton.click();
        ReportHelper.createInfoLog("Step 2","Click outside of the login dialog");
        Actions clickAt = new Actions(driver);
        clickAt.moveByOffset(10, 10).click();
        clickAt.build().perform();
        String screenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Screenshot of closing the login dialog",screenshot);
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }
}
