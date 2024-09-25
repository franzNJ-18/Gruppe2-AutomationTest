package tests.US_005_Warenkorb;

import common.SynchronizationUtils;
import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.ShopPage;
import reporting.CaptureScreen;
import reporting.ExtentTestListener;
import reporting.ReportHelper;

@Listeners(ExtentTestListener.class)

public class TC_005_CartRetainsItemsAfterLogIn extends TestBase {

    String username = "Giray";
    String password = "sogetisogeti1";

    @Test(description = "TC_005")
    public void testCartRetainsItemsAfterLogIn() {
        CartPage cartPage =new CartPage(driver);
        ShopPage shopPage = new ShopPage(driver);
        LoginPage loginPage =new LoginPage(driver);
        ReportHelper.createInfoLog("Step 1","Navigate to Shop");
        shopPage.navigateToShop();
        ReportHelper.createInfoLog("Step 2","Add first item to the cart");
        shopPage.addFirstItemToCart();
        SynchronizationUtils.waitForVisibility(driver, cartPage.cartCount1, 3);
        Assert.assertTrue(cartPage.cartCount.getText().contains("1"));
        ReportHelper.createInfoLog("Step 3","Click login button");
        loginPage.loginButton.click();
        ReportHelper.createInfoLog("Step 4","Send username and password");
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        ReportHelper.createInfoLog("Step 5","Click submit button");
        loginPage.clickLoginSubmit();
        SynchronizationUtils.staleElementSolution(driver, cartPage.cartLogo);
        String screenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Screenshot of successful adding multiple item to the cart",screenshot);
        Assert.assertTrue(cartPage.isItemInCart("Bohne"), "Item not found in cart");
    }
}
