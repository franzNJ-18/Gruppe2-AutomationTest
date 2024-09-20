package tests.US_005_Warenkorb;

import common.SynchronizationUtils;
import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.ShopPage;

public class TC_006_CartEmptyAfterLogOut extends TestBase {

    String username = "Giray";
    String password = "sogetisogeti1";

    @Test(description = "TC_006")
    public void testCartEmptyAfterLogOut() {
        CartPage cartPage =new CartPage(driver);
        ShopPage shopPage = new ShopPage(driver);
        LoginPage loginPage =new LoginPage(driver);
        shopPage.navigateToShop();
        shopPage.addFirstItemToCart();
        SynchronizationUtils.waitForVisibility(driver, cartPage.cartCount1, 3);
        Assert.assertTrue(cartPage.cartCount.getText().contains("1"));
        loginPage.loginButton.click();
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickLoginSubmit();
        SynchronizationUtils.staleElementSolution(driver, cartPage.cartLogo);
        Assert.assertTrue(cartPage.isItemInCart("Bohne"), "Item not found in cart");
        loginPage.logoutButton.click();
        SynchronizationUtils.staleElementSolution(driver, cartPage.cartLogo);
        Assert.assertTrue(cartPage.emptyMessageWarenkorb.isDisplayed());
    }
}
