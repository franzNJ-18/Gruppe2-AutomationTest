package tests.US_001_Login;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.ShopPage;

public class TC_001_Benutzername_mit_4_Zeichen extends TestBase {

    String username = "Franz";
    String password = "1234567";

    @Test(description = "TC_001")
    public void testAddItemToCart() {
        LoginPage loginPage  = new LoginPage(driver);

    }

}
