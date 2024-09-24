package tests.US_001_Login;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_001_Benutzername_richtig_Passwort_richtig extends TestBase {

    String username = "Giray1";
    String password = "Giraysogeti1";

    @Test(description = "TC_001")
    public void testBenutzernameRichtigPasswortRichtig() {
        LoginPage loginPage  = new LoginPage(driver);
        loginPage.loginButton.click();
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickLoginSubmit();
        Assert.assertTrue(loginPage.logoutOptionAfterLogin.isDisplayed());
        Assert.assertTrue(loginPage.profilOptionAfterLogin.isDisplayed());
    }
}
