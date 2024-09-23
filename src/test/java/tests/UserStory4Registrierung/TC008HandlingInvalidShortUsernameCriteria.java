package tests.UserStory4Registrierung;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrierungPage;

public class TC008HandlingInvalidShortUsernameCriteria extends TestBase {
    String username = "u";

    @Test(description = "For TC008: Handling registration with a username that doesn't meet criteria.")
    public void TestCase6() {
        clickRegisterButton();
        sendKeysToUsername(username);
        Assert.assertEquals(textOfMessageUnderUsername(),"Bitte mindestens 4 Zeichen eingeben.");

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
