package tests.UserStory1Login;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import reporting.CaptureScreen;
import reporting.ExtentTestListener;
import reporting.ReportHelper;

@Listeners(ExtentTestListener.class)
public class TC005NoCredentialsEntered extends TestBase {
    String failTextPassword="Benutzername oder Passwort falsch";

    @Test(description = "Testfall 5 = No credentials entered")
    public void testSuccessfulLogin(){
        ReportHelper.createInfoLog("Step 1:","Click Login Icon");
        clickLogin();
        ReportHelper.createInfoLog("Step 2:","Click login Submit Button");
        clickLoginSubmitButton();
        ReportHelper.createInfoLog("Step 3:","Error message is displayed because credentials were not entered");
        String aScreenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Error message", aScreenshot);
        Assert.assertEquals(messageOfPassword(),failTextPassword,"Password error message will be showed");
    }

    public void clickLogin(){
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();
    }
    public void clickLoginSubmitButton(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginSubmit();
    }
    public String messageOfPassword() {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.getPasswordErrorMessage();
    }
}