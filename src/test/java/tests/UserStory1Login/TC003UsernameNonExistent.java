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
public class TC003UsernameNonExistent extends TestBase {
    String username="tester1";
    String password="passwort";
    String failTextUsername="Dieser User existiert nicht.";

    @Test(description = "Testfall 3 = Username does not exist")
    public void nonExistentUsername(){
        ReportHelper.createInfoLog("Step 1:","Click Login Icon");
        clickLogin();
        ReportHelper.createInfoLog("Step 2:","Send keys to username and Password");
        String[][] aInfos = {
                {"Username", username},
                {"Password", password},
        };
        ReportHelper.createTable(aInfos);
        loginToApplication(username,password);
        ReportHelper.createInfoLog("Step 3:","Error message is displayed because user does not exist");
        String aScreenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Error message", aScreenshot);
        Assert.assertEquals(messageOfUsername(),failTextUsername,"The username does not exist");
    }

    public void clickLogin(){
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();
    }

    public void loginToApplication(String Username, String Password){
        LoginPage loginPage= new LoginPage(driver);
        loginPage.setUserName(Username);
        loginPage.setPassword(Password);
    }

    public String messageOfUsername() {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.getUsernameErrorMessage();
    }

}
