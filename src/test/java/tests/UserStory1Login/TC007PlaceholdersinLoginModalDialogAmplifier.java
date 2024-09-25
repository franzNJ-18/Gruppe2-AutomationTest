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
public class TC007PlaceholdersinLoginModalDialogAmplifier extends TestBase {
    String placeholderUsername="Username";
    String placeholderPassword="Passwort";

    @Test(description = "Testfall 7 = Placeholder checking")
    public void testSuccessfulLogin(){
        ReportHelper.createInfoLog("Step 1:","Click Login Icon");
        clickLogin();
        ReportHelper.createInfoLog("Step 2:","Check placeholders of username and Password");
        String[][] aInfos = {
                {"Username placeholder", placeholderUsername},
                {"Password placeholder", placeholderPassword},
        };
        ReportHelper.createTable(aInfos);
        String aScreenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Placeholders", aScreenshot);
        Assert.assertEquals(getPlaceholderOfUsername(),placeholderUsername,"Placeholder Username match");
        Assert.assertEquals(getPlaceholderOfPassword(),placeholderPassword,"Placeholder Password match");
    }

    public void clickLogin(){
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();
    }

    public String getPlaceholderOfPassword() {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.getPasswordPlaceholder();
    }

    public String getPlaceholderOfUsername() {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.getUserNamePlaceholder();
    }

}