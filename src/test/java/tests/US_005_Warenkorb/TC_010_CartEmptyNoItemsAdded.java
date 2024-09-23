package tests.US_005_Warenkorb;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.ShopPage;

public class TC_010_CartEmptyNoItemsAdded extends TestBase {

    @Test(description = "TC_010")
    public void testCartEmptyNoItemsAdded() {
        CartPage cartPage =new CartPage(driver);
        ShopPage shopPage = new ShopPage(driver);
        shopPage.navigateToShop();
        shopPage.navigateToCart();
        Assert.assertTrue(cartPage.emptyMessageWarenkorb.isDisplayed());
    }
}
