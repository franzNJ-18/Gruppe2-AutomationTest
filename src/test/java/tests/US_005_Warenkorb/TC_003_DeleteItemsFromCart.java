package tests.US_005_Warenkorb;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.ShopPage;

public class TC_003_DeleteItemsFromCart extends TestBase {

    // When it the item deleted from the Cart, the message ends with a dot "Der Warenkorb ist leer.".
    // However, when nothing is added and deleted to Cart, the message does not end with a dot "Der Warenkorb ist leer".
    @Test(description = "TC_003")
    public void testDeleteItemsFromCart() {
        CartPage cartPage =new CartPage(driver);
        ShopPage shopPage = new ShopPage(driver);
        shopPage.navigateToShop();
        shopPage.addFirstItemToCart();
        shopPage.navigateToCart();
        cartPage.deleteItemsFromCart();
        Assert.assertTrue(cartPage.emptyMessageWarenkorb.isDisplayed());
    }
}
