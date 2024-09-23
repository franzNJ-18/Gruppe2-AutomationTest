package tests.UserStory4Registrierung;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrierungPage;

public class TC001VerifyingSuccessfulAccountCreation extends TestBase {
    String username = "Üser123";
    String password = "Ocaso18!96";
    String confirmPassword = "Ocaso18!96";

    @Test(description = "For TC001: Verifying successful account creation with valid credentials.")
    public void TestCase1() {
        clickRegisterButton();
        sendKeysToUsername(username);
        sendKeysToPassword(password);
        sendKeysToConfirmPassword(confirmPassword);
        checkAGB();
        clickRegistration();
        Assert.assertEquals(getTextOfSuccessfulReg(),"Deine Registrierung war erfolgreich!");
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
    public String textOfMessageUnderUser(){
        RegistrierungPage registrierungPage = new RegistrierungPage(driver);
        return registrierungPage.getTextOfMessageUsername();
    }

    public void sendKeysToPassword(String password) {
        RegistrierungPage registrierungPage = new RegistrierungPage(driver);
        registrierungPage.enterPassword(password);
    }

    public void sendKeysToConfirmPassword(String confirmPassword) {
        RegistrierungPage registrierungPage = new RegistrierungPage(driver);
        registrierungPage.enterRePassword(confirmPassword);
    }

    public void checkAGB() {
        RegistrierungPage registrierungPage = new RegistrierungPage(driver);
        registrierungPage.checkAGB();
    }

    public void clickRegistration() {
        RegistrierungPage registrierungPage = new RegistrierungPage(driver);
        registrierungPage.clickRegister();
    }

    public String getTextOfSuccessfulReg() {
        RegistrierungPage registrierungPage = new RegistrierungPage(driver);
        return registrierungPage.getTextOfMessageOfSuccessfulRegistration();
    }

}
