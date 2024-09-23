package tests.UserStory4Registrierung;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrierungPage;

public class TC005HandlingInvalidShortPasswordCriteria extends TestBase {
    String username = "User123";
    String password = "123";

    @Test(description = "For TC005: Handling registration with a password that doesn't meet criteria.")
    public void TestCase5() {
        clickRegisterButton();
        sendKeysToUsername(username);
        sendKeysToPassword(password);
        Assert.assertEquals(textOfMessageUnderPassword(),"8-20 Zeichen: a-z, A-Z, 0-9, @$!%*?");

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

    public String textOfMessageUnderPassword(){
        RegistrierungPage registrierungPage = new RegistrierungPage(driver);
        return registrierungPage.getTextOfMessagePassword();
    }

}
