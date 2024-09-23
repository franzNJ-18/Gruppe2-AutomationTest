package tests.UserStory4Registrierung;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AGBPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrierungPage;

public class TC010VerifyingTermsLink extends TestBase {

        @Test(description = "For TC008: Verifying that the AGB link works correctly.")
        public void TestCase8() {
            clickRegisterButton();
            checkAGB();
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
