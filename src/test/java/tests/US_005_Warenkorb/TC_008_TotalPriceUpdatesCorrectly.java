package tests.US_005_Warenkorb;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.ShopPage;

public class TC_008_TotalPriceUpdatesCorrectly extends TestBase {

    @Test(description = "TC_008")
    public void testTotalPriceUpdatesCorrectly() {
        CartPage cartPage =new CartPage(driver);
        ShopPage shopPage = new ShopPage(driver);
        shopPage.navigateToShop();
        shopPage.addFirstItemToCart();
        shopPage.navigateToCart();
        Assert.assertTrue(cartPage.getTotalPrice().contains("2,99 €"));
        cartPage.anzahlInput.clear();
        cartPage.anzahlInput.sendKeys("4");
        cartPage.aktualisierenWarenkorb.click();
        Assert.assertTrue(cartPage.getTotalPrice().contains("11,96 €"));
    }
}
