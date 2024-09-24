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

import java.time.Duration;

@Listeners(ExtentTestListener.class)
public class TC007HandlingInvalidLongUsernameCriteria extends TestBase {
    String username = "user1234567890";
    String password = "Password!Password!123";

    @Test(description = "For TC007: Handling registration with a username that doesn't meet criteria.")
    public void TestCase7() {
        ReportHelper.createInfoLog("Step 1:","Going to register page");
        clickRegisterButton();
        ReportHelper.createInfoLog("Step 2:","Send Keys for registration");
        String[][] aInfos = {
                {"Username(Long)", username},
        };
        ReportHelper.createTable(aInfos);
        sendKeysToUsername(username);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String aScreenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Username long", aScreenshot);
        Assert.assertEquals(textOfMessageUnderUsername(),"Bitte einen gültigen Namen eingeben:\n" +
                "4-12 Zeichen: a-z, A-Z, 0-9, Umlaute");

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

    public String textOfMessageUnderUsername(){
        RegistrierungPage registrierungPage = new RegistrierungPage(driver);
        return registrierungPage.getTextOfMessageUsername();
    }


}
