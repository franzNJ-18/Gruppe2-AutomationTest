package tests.US_001_Login;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_006_Erfolgreiches_Logout extends TestBase {

    String username = "Giray1";
    String password = "Giraysogeti1";

    @Test(description = "TC_006")
    public void testErfolgreichesLogout() {
        LoginPage loginPage  = new LoginPage(driver);
        loginPage.loginButton.click();
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickLoginSubmit();
        Assert.assertTrue(loginPage.logoutOptionAfterLogin.isDisplayed());
        Assert.assertTrue(loginPage.profilOptionAfterLogin.isDisplayed());
        loginPage.logoutOptionAfterLogin.click();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());

    }
}
