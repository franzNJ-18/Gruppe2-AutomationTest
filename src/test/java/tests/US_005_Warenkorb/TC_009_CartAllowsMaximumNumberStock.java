package tests.US_005_Warenkorb;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.ShopPage;
import reporting.CaptureScreen;
import reporting.ReportHelper;

public class TC_009_CartAllowsMaximumNumberStock extends TestBase {

    @Test(description = "TC_009")
    public void testCartAllowsMaximumNumberStock() {
        CartPage cartPage =new CartPage(driver);
        ShopPage shopPage = new ShopPage(driver);
        ReportHelper.createInfoLog("Step 1","Navigate to Shop");
        shopPage.navigateToShop();
        ReportHelper.createInfoLog("Step 2","Add first item to the cart");
        shopPage.addFirstItemToCart();
        ReportHelper.createInfoLog("Step 3","Navigate to Cart");
        shopPage.navigateToCart();
        ReportHelper.createInfoLog("Step 4","Update the number of the item");
        cartPage.anzahlInput.clear();
        cartPage.anzahlInput.sendKeys("9");
        cartPage.aktualisierenWarenkorb.click();
        String screenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Screenshot of successful adding multiple item to the cart",screenshot);
        Assert.assertTrue(cartPage.errorMaxStockMessageWarenkorb.isDisplayed());
    }
}
