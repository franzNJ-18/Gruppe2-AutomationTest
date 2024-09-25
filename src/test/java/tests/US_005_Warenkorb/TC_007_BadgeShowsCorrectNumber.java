package tests.US_005_Warenkorb;

import common.SynchronizationUtils;
import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.ShopPage;
import reporting.CaptureScreen;
import reporting.ExtentTestListener;
import reporting.ReportHelper;

@Listeners(ExtentTestListener.class)

public class TC_007_BadgeShowsCorrectNumber extends TestBase {

    @Test(description = "TC_007")
    public void testBadgeShowsCorrectNumber() throws InterruptedException {
        CartPage cartPage =new CartPage(driver);
        ShopPage shopPage = new ShopPage(driver);
        ReportHelper.createInfoLog("Step 1","Navigate to Shop");
        shopPage.navigateToShop();
        ReportHelper.createInfoLog("Step 2","Add first item to the cart");
        shopPage.addFirstItemToCart();
        ReportHelper.createInfoLog("Step 3","Add second item to the cart");
        shopPage.addSecondItemToCart();
        SynchronizationUtils.waitForVisibility(driver, cartPage.cartCount, 3);
        String screenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Screenshot of successful adding multiple item to the cart",screenshot);
        Assert.assertTrue(cartPage.cartCount.getText().contains("2"));
    }
}
