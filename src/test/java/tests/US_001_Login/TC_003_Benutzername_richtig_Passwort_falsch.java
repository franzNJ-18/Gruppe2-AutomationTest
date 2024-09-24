package tests.US_001_Login;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_003_Benutzername_richtig_Passwort_falsch extends TestBase {

    String username = "Giray1";
    String password = "Giraysogeti2";

    @Test(description = "TC_003")
    public void testBenutzernameRichtigPasswortFalsch() {
        LoginPage loginPage  = new LoginPage(driver);
        loginPage.loginButton.click();
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickLoginSubmit();
        Assert.assertTrue(loginPage.benutzernameOderPasswortFalschMeldung.isDisplayed());
    }
}
