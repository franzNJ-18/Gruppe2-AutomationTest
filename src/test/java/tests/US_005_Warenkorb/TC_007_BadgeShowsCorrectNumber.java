package tests.US_005_Warenkorb;

import common.SynchronizationUtils;
import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.ShopPage;

public class TC_007_BadgeShowsCorrectNumber extends TestBase {

    @Test(description = "TC_007")
    public void testBadgeShowsCorrectNumber() throws InterruptedException {
        CartPage cartPage =new CartPage(driver);
        ShopPage shopPage = new ShopPage(driver);
        shopPage.navigateToShop();
        shopPage.addFirstItemToCart();
        shopPage.addSecondItemToCart();
        SynchronizationUtils.waitForVisibility(driver, cartPage.cartCount, 3);
        Assert.assertTrue(cartPage.cartCount.getText().contains("2"));
    }
}
