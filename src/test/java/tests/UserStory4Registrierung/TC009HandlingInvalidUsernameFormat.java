package tests.UserStory4Registrierung;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrierungPage;

public class TC009HandlingInvalidUsernameFormat extends TestBase {
    String username = "user@$!%*?123";

    @Test(description = "For TC009: Handling invalid username formats.")
    public void TestCase7() {
        clickRegisterButton();
        sendKeysToUsername(username);
        Assert.assertEquals(textOfMessageUnderUsername(),"Bitte einen gültigen Namen eingeben:");
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
