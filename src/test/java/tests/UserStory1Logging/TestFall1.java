package tests.UserStory1Logging;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TestFall1 extends TestBase {

    String username = "Franz";
    String password = "1234567";

    @Test(description = "Testfall 1 = ")
    public void Testfall1() {
        clickLoginButton();
        sendKeysToLogin(username);
        sendKeysToPassword(password);

    }

    public void clickLoginButton() {
        HomePage homepage = new HomePage(driver);
        homepage.clickLogin();
    }

    public void sendKeysToLogin(String username) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(username);
    }

    public void sendKeysToPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(password);
    }
}
