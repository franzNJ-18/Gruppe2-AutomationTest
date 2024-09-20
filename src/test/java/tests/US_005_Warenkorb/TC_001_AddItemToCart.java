package tests.US_005_Warenkorb;

import common.SynchronizationUtils;
import common.TestBase;
import org.testng.Assert;
import pageObjects.LoginPage;
import pageObjects.ShopPage;
import pageObjects.CartPage;
import org.testng.annotations.Test;

public class TC_001_AddItemToCart extends TestBase {

    @Test(description = "TC_001")
    public void testAddItemToCart() {
        ShopPage shopPage  = new ShopPage(driver);
        CartPage cartPage =new CartPage(driver);
        shopPage.navigateToShop();
        shopPage.addFirstItemToCart();
        shopPage.navigateToCart();
        Assert.assertTrue(cartPage.isItemInCart("Bohne"), "Item not found in cart");
        Assert.assertTrue(cartPage.getTotalPrice().contains("2,99 €"));
    }

}

