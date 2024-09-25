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
public class TC006LoginAppearInEachPage extends TestBase {
    String failTextPassword="Benutzername oder Passwort falsch";


    @Test(description = "Testfall 6 = Login present in each page")
    public void testSuccessfulLogin(){
        ReportHelper.createInfoLog("Step 1:","Navigate to the Home Page and check if Login present on it");
        String aScreenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("homepage", aScreenshot);
        Assert.assertTrue(isLoginPresent(),"Login is present in home page");

        ReportHelper.createInfoLog("Step 2:","Navigate to the About Page and check if Login present on it");
        navigateToAboutSite();
        String aScreenshot1 = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("homepage", aScreenshot1);
        Assert.assertTrue(isLoginPresent(),"Login is present in about page");

        ReportHelper.createInfoLog("Step 3:","Navigate to the Shop Page and check if Login present on it");
        navigateToShopSite();
        String aScreenshot2 = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("homepage", aScreenshot2);
        Assert.assertTrue(isLoginPresent(),"Login is present in shop page");

        ReportHelper.createInfoLog("Step 4:","Navigate to the Contact Page and check if Login present on it");
        navigateToContactSite();
        String aScreenshot3 = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("homepage", aScreenshot3);
        Assert.assertTrue(isLoginPresent(),"Login is present in contact page");

        ReportHelper.createInfoLog("Step 5:","Navigate to the Cart Page and check if Login present on it");
        navigateToCartSite();
        String aScreenshot4 = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("homepage", aScreenshot4);
        Assert.assertTrue(isLoginPresent(),"Login is present in cart page");

        ReportHelper.createInfoLog("Step 6:","Navigate to the AGB Page and check if Login present on it");
        navigateToAGBSite();
        String aScreenshot5 = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("homepage", aScreenshot5);
        Assert.assertTrue(isLoginPresent(),"Login is present in AGB page");
    }

    public Boolean isLoginPresent(){
        HomePage homePage = new HomePage(driver);
        return homePage.loginPresence();
    }
    public void navigateToAboutSite(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAboutPage();
    }
    public void navigateToShopSite(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToShopPage();
    }
    public void navigateToContactSite(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToContactPage();
    }
    public void navigateToCartSite(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToCart();
    }

    public void navigateToAGBSite(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAGBPage();
    }

    public String messageOfPassword() {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.getPasswordErrorMessage();
    }


}