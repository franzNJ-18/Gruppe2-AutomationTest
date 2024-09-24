package tests.US_001_Login;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_004_Benutzername_falsch_Passwort_falsch extends TestBase {

    String username = "Giray2";
    String password = "Giraysogeti2";

    @Test(description = "TC_004")
    public void testBenutzernameFalschPasswortFalsch() {
        LoginPage loginPage  = new LoginPage(driver);
        loginPage.loginButton.click();
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickLoginSubmit();
        Assert.assertTrue(loginPage.benutzernameOderPasswortFalschMeldung.isDisplayed());
    }
}
