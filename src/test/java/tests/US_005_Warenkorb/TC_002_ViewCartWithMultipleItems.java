package tests.US_005_Warenkorb;

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


public class TC_002_ViewCartWithMultipleItems extends TestBase {

    @Test(description = "TC_002")
    public void testViewCartWithMultipleItems() {
        ShopPage shopPage = new ShopPage(driver);
        CartPage cartPage =new CartPage(driver);
        ReportHelper.createInfoLog("Step 1","Navigate to Shop");
        shopPage.navigateToShop();
        ReportHelper.createInfoLog("Step 2","Add first item to the cart");
        shopPage.addFirstItemToCart();
        ReportHelper.createInfoLog("Step 3","Add second item to the cart");
        shopPage.addSecondItemToCart();
        ReportHelper.createInfoLog("Step 3","Navigate to Cart");
        shopPage.navigateToCart();
        String screenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Screenshot of successful adding multiple item to the cart",screenshot);
        Assert.assertTrue(cartPage.isItemInCart("Bohne"), "Item not found in cart");
        Assert.assertTrue(cartPage.isItemInCart("Darjeeling Tee"), "Item not found in cart");
        Assert.assertTrue(cartPage.getTotalPrice().contains("6,98 €"));
    }
}
