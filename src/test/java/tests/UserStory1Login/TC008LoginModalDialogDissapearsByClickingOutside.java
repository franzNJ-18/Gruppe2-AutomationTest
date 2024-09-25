package tests.UserStory1Login;

import common.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import reporting.ExtentTestListener;
import reporting.ReportHelper;

@Listeners(ExtentTestListener.class)
public class TC008LoginModalDialogDissapearsByClickingOutside extends TestBase {

    @Test(description = "Testfall 8 = Login Modal Dialog disappears by clicking outside the modal dialog ")
    public void testSuccessfulLogin(){
        ReportHelper.createInfoLog("Step 1:","Click Login Icon");
        clickLogin();
        ReportHelper.createInfoLog("Step 2:","Click outside Login modal Dialog");
        clickOutsideModalDialog();
        ReportHelper.createInfoLog("Step 3:","Check if Modal Dialog disappeared");
        Assert.assertFalse(isLoginStillPresent(),"Login Modal Dialog disappeared");
    }

    public void clickLogin(){
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();
    }

    public void clickOutsideModalDialog(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "document.elementFromPoint(1850, 900).click();";
        js.executeScript(script);
    }

    public boolean isLoginStillPresent() {
        LoginPage loginPage=new LoginPage(driver);
        return loginPage.presenceOfLoginTitle();
    }
}