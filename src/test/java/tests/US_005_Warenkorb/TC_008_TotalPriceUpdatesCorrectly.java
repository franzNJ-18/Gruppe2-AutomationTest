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

public class TC_008_TotalPriceUpdatesCorrectly extends TestBase {

    @Test(description = "TC_008")
    public void testTotalPriceUpdatesCorrectly() {
        CartPage cartPage =new CartPage(driver);
        ShopPage shopPage = new ShopPage(driver);
        ReportHelper.createInfoLog("Step 1","Navigate to Shop");
        shopPage.navigateToShop();
        ReportHelper.createInfoLog("Step 2","Add first item to the cart");
        shopPage.addFirstItemToCart();
        ReportHelper.createInfoLog("Step 3","Navigate to Cart");
        shopPage.navigateToCart();
        Assert.assertTrue(cartPage.getTotalPrice().contains("2,99 €"));
        ReportHelper.createInfoLog("Step 4","Update the number of the item");
        cartPage.anzahlInput.clear();
        cartPage.anzahlInput.sendKeys("4");
        cartPage.aktualisierenWarenkorb.click();
        String screenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Screenshot of successful adding multiple item to the cart",screenshot);
        Assert.assertTrue(cartPage.getTotalPrice().contains("11,96 €"));
    }
}
