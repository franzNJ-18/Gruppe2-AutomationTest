package tests.US_005_Warenkorb;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.ShopPage;

public class TC_009_CartAllowsMaximumNumberStock extends TestBase {

    @Test(description = "TC_009")
    public void testCartAllowsMaximumNumberStock() {
        CartPage cartPage =new CartPage(driver);
        ShopPage shopPage = new ShopPage(driver);
        shopPage.navigateToShop();
        shopPage.addFirstItemToCart();
        shopPage.navigateToCart();
        cartPage.anzahlInput.clear();
        cartPage.anzahlInput.sendKeys("9");
        cartPage.aktualisierenWarenkorb.click();
        Assert.assertTrue(cartPage.errorMaxStockMessageWarenkorb.isDisplayed());
    }
}
