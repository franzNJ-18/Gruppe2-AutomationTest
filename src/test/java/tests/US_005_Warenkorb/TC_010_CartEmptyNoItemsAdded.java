package tests.US_005_Warenkorb;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.ShopPage;
import reporting.CaptureScreen;
import reporting.ReportHelper;

public class TC_010_CartEmptyNoItemsAdded extends TestBase {

    @Test(description = "TC_010")
    public void testCartEmptyNoItemsAdded() {
        CartPage cartPage =new CartPage(driver);
        ShopPage shopPage = new ShopPage(driver);
        ReportHelper.createInfoLog("Step 1","Navigate to Shop");
        shopPage.navigateToShop();
        ReportHelper.createInfoLog("Step 3","Navigate to Cart");
        shopPage.navigateToCart();
        String screenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Screenshot of successful adding multiple item to the cart",screenshot);
        Assert.assertTrue(cartPage.emptyMessageWarenkorb.isDisplayed());
    }
}
