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

public class TC_003_DeleteItemsFromCart extends TestBase {

    // When it the item deleted from the Cart, the message ends with a dot "Der Warenkorb ist leer.".
    // However, when nothing is added and deleted to Cart, the message does not end with a dot "Der Warenkorb ist leer".
    @Test(description = "TC_003")
    public void testDeleteItemsFromCart() {
        CartPage cartPage =new CartPage(driver);
        ShopPage shopPage = new ShopPage(driver);
        ReportHelper.createInfoLog("Step 1","Navigate to Shop");
        shopPage.navigateToShop();
        ReportHelper.createInfoLog("Step 2","Add first item to the cart");
        shopPage.addFirstItemToCart();
        ReportHelper.createInfoLog("Step 3","Navigate to Cart");
        shopPage.navigateToCart();
        ReportHelper.createInfoLog("Step 4","Delete the item from the cart");
        cartPage.deleteItemsFromCart();
        String screenshot = CaptureScreen.getSeleniumScreenshotAsBase64();
        ReportHelper.addScreenshot("Screenshot of successful adding multiple item to the cart",screenshot);
        Assert.assertTrue(cartPage.emptyMessageWarenkorb.isDisplayed());
    }
}
