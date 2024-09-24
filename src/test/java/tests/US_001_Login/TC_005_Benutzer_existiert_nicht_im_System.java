package tests.US_001_Login;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_005_Benutzer_existiert_nicht_im_System extends TestBase {

    String username = "Giray12121212";
    String password = "Giraysogeti1";

    @Test(description = "TC_005")
    public void testBenutzerExistiertNichtImSystem() {
        LoginPage loginPage  = new LoginPage(driver);
        loginPage.loginButton.click();
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        Assert.assertTrue(loginPage.userNichtExistiertMeldung.isDisplayed());
    }
}
