package tests.UserStory4Registrierung;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.AGBPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrierungPage;
import reporting.CaptureScreen;
import reporting.ExtentTestListener;
import reporting.ReportHelper;

@Listeners(ExtentTestListener.class)
public class TC010VerifyingTermsLink extends TestBase {

        @Test(description = "For TC008: Verifying that the AGB link works correctly.")
        public void TestCase10() {
            ReportHelper.createInfoLog("Step 1:","Going to register page");
            clickRegisterButton();
            ReportHelper.createInfoLog("Step 2:","Clicking AGB");
            checkAGB();
            String aScreenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
            ReportHelper.addScreenshot("AGB Seite", aScreenshot);
            Assert.assertEquals(textOfAGBHomepage(),"Allgemeine Geschäftsbedingungen");
        }

        public void clickRegisterButton() {
            HomePage homepage = new HomePage(driver);
            homepage.clickLogin();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickRegistrationLink();
        }

        public void checkAGB() {
            RegistrierungPage registrierungPage = new RegistrierungPage(driver);
            registrierungPage.clickLinkAGB();
        }

        public String textOfAGBHomepage() {
            AGBPage agbPage = new AGBPage(driver);
            return agbPage.getTitleOfAGB();
        }
}
