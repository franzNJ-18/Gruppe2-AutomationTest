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
public class TC004SuccessfulLoginAndLogout extends TestBase {
    String username="tester";
    String password="passwort";
    String title="FEINSTER KAFFEE";

    @Test(description = "Testfall 4 = Successful login and logout")
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
        ReportHelper.createInfoLog("Step 3:","Click login Submit Button");
        clickLoginSubmitButton();
        Assert.assertEquals(titleOfPage(),title,"After Successful login remained in the same webpage");
        ReportHelper.createInfoLog("Step 4:","Navigate to another page:Cart");
        navigateToCart();
        ReportHelper.createInfoLog("Step 5:","Click Logout");
        clickLogout();
        ReportHelper.createInfoLog("Step 6:","Successful logout returned to homepage");
        String aScreenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Successful Logout", aScreenshot);
        Assert.assertEquals(titleOfPage(),title,"After Successful logout it returned to homepage");
    }

    public void clickLogin(){
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();
    }

    public void clickLogout(){
        HomePage homePage = new HomePage(driver);
        homePage.clickLogout();
    }

    public void navigateToCart(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToCart();
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
