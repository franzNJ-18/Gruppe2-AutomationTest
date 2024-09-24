package tests.US_001_Login;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_002_Benutzername_falsch_Passwort_richtig extends TestBase {

    String username = "Giray2";
    String password = "Giraysogeti1";

    @Test(description = "TC_002")
    public void testBenutzernameFalschPasswortRichtig() {
        LoginPage loginPage  = new LoginPage(driver);
        loginPage.loginButton.click();
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickLoginSubmit();
        Assert.assertTrue(loginPage.benutzernameOderPasswortFalschMeldung.isDisplayed());
    }
}
