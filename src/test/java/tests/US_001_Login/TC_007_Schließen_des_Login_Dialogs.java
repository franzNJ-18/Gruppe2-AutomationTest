package tests.US_001_Login;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_007_Schließen_des_Login_Dialogs extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(TC_007_Schließen_des_Login_Dialogs.class);

    @Test(description = "TC_007")
    public void testSchließenDesLoginDialogs() {
        LoginPage loginPage  = new LoginPage(driver);
        loginPage.loginButton.click();
        loginPage.ausserhalbDerLoginDialog.click();
        Actions clickAt = new Actions(driver);
        clickAt.moveByOffset(10, 10).click();
        clickAt.build().perform();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }
}
