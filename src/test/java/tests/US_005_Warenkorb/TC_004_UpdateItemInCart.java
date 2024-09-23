package tests.US_005_Warenkorb;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.ShopPage;

public class TC_004_UpdateItemInCart extends TestBase {

    @Test(description = "TC_004")
    public void testUpdateItemInCart() {
        CartPage cartPage =new CartPage(driver);
        ShopPage shopPage = new ShopPage(driver);
        shopPage.navigateToShop();
        shopPage.addFirstItemToCart();
        shopPage.navigateToCart();
        cartPage.anzahlInput.sendKeys("4");
        cartPage.aktualisierenWarenkorb.click();
        Assert.assertTrue(cartPage.getTotalPrice().contains("11,96 €"));
    }
}
