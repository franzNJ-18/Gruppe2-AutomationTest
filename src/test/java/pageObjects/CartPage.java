package pageObjects;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.ref.WeakReference;


public class CartPage{

    WebDriver driver;

    public CartPage(WebDriver pDriver){
        driver= pDriver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//table[@id='cartTable']//td[contains(@class, 'item-id')]")
    private  WebElement cartItem;

    @FindBy(xpath = "//p[@id='gsum']")
    private  WebElement totalPrice;

    @FindBy(xpath = "//button[@name='delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[contains(text(),'Der Warenkorb ist leer')]")
    public WebElement emptyMessageWarenkorb;

    @FindBy(xpath = "//input[@name='quantity[2]']")
    public WebElement anzahlInput;

    @FindBy(xpath = "//button[@name='aktualisieren']")
    public WebElement aktualisierenWarenkorb;

    @FindBy(xpath = "//div[@id='cartCount']")
    public WebElement cartCount;

    @FindBy(xpath = "//*[contains(text(),'.Es kann nur die aktuell verfügbare Menge bestellt werden.')]")
    public WebElement errorMaxStockMessageWarenkorb;

    @FindBy(xpath = "//div[contains(text(),'1')]")
    public WebElement cartCount1;

    @FindBy(xpath = "//*[@id=\"shoppingcart\"]")
    public WebElement cartLogo;




    public boolean isItemInCart(String itemName) {
        WebElement item = driver.findElement(By.xpath("//td[contains(text(), '" + itemName + "')]"));
        return item != null && item.isDisplayed();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public void deleteItemsFromCart() {
        deleteButton.click();
    }

    public void navigateToCart() {
        cartLogo.click();
    }

}
