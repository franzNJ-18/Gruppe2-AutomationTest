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
public class TC001SuccesfullLogin extends TestBase {
    String username="tester";
    String password="passwort";
    String title="FEINSTER KAFFEE";

    @Test(description = "Testfall 1 = Successful Login")
    public void testSuccessfulLogin(){
        ReportHelper.createInfoLog("Step 1:","Click Login Icon");
        clickLogin();
        ReportHelper.createInfoLog("Step 2:","Send keys to username and Password");
        String[][] aInfos = {
                {"Username", username},
                {"Password", password},
        };
        ReportHelper.createTable(aInfos);
        loginToApplication(username,password);
        ReportHelper.createInfoLog("Step 3:","Click login Submit Button");
        clickLoginSubmitButton();
        ReportHelper.createInfoLog("Step 4:","Successful login remained in the same webpage");
        String aScreenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Successful registration", aScreenshot);
        Assert.assertEquals(titleOfPage(),title,"After Successful login remained in the same webpage");
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

    public void clickLoginSubmitButton(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginSubmit();
    }

    public String titleOfPage() {
        HomePage homePage = new HomePage(driver);
        return homePage.getStringOfTitle();
    }

}
