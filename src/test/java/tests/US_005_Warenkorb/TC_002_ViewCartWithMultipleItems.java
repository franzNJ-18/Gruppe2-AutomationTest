package tests.US_005_Warenkorb;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.ShopPage;

public class TC_002_ViewCartWithMultipleItems extends TestBase {

    @Test(description = "TC_002")
    public void testViewCartWithMultipleItems() {
        ShopPage shopPage = new ShopPage(driver);
        CartPage cartPage =new CartPage(driver);
        shopPage.navigateToShop();
        shopPage.addFirstItemToCart();
        shopPage.addSecondItemToCart();
        shopPage.navigateToCart();
        Assert.assertTrue(cartPage.isItemInCart("Bohne"), "Item not found in cart");
        Assert.assertTrue(cartPage.isItemInCart("Darjeeling Tee"), "Item not found in cart");
        Assert.assertTrue(cartPage.getTotalPrice().contains("6,98 €"));
    }
}
