package pageObjects;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage{

    WebDriver driver;
    @FindBy(xpath = "//a[@class='mpshopbtn']")
    public static WebElement shopButton;

    @FindBy(xpath = "//a[contains(@href, 'shoppingcart.php')]")
    public static WebElement cartIcon;

    @FindBy(xpath = "//*[@id='cartCount']")
    public static WebElement cartCount;

    public ShopPage(WebDriver pDriver){
        driver= pDriver;
        PageFactory.initElements(driver,this);
    }


    public void navigateToShop() {
        shopButton.click();
    }

    public void addFirstItemToCart() {
        WebElement addItemButton = driver.findElement(By.xpath("(//a[text()='Einkaufen'][1])[1]"));
        addItemButton.click();
    }

    public void addSecondItemToCart() {
        WebElement addItemButton = driver.findElement(By.xpath("(//a[text()='Einkaufen'][1])[2]"));
        addItemButton.click();
    }

    public void navigateToCart() {
        cartIcon.click();
    }

    public String getCartCount() {
        return cartCount.getText();
    }





}