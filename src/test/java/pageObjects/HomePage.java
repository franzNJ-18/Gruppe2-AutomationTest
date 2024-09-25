package pageObjects;

import common.SynchronizationUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    protected WebDriver driver;

    @FindBy(xpath = "//div[@class='mpshopdiv clearfix']/h1")
    WebElement titleOfHomePage;

    @FindBy(xpath = "//div[@id='accountbar']/a")
    WebElement loginButton;

    @FindBy(xpath = "//a[@href='login.php']")
    WebElement logoutButton;

    @FindBy(xpath = "//a[@href='index.php']")
    WebElement homeLink;

    @FindBy(xpath = "//a[@href='about.php']")
    WebElement aboutLink;

    @FindBy(xpath = "//a[@href='shop.php']")
    WebElement shopLink;

    @FindBy(xpath = "//a[@href='#footer']")
    WebElement contactLink;

    @FindBy(xpath = "//a[@href='agb.php']")
    WebElement agbLink;

    @FindBy(xpath = "//a[contains(@href, 'shoppingcart.php')]")
    public WebElement cartIcon;

    public HomePage (WebDriver pDriver){
        driver= pDriver;
        PageFactory.initElements(driver,this);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickLogout() {
        logoutButton.click();
    }

    public String getStringOfTitle() {
        SynchronizationUtils.waitForVisibility(driver,titleOfHomePage,10);
        return titleOfHomePage.getText();
    }
    public Boolean loginPresence(){
        return loginButton.isDisplayed();
    }
    public void navigateToAboutPage() {
        aboutLink.click();
    }
    public void navigateToShopPage() {
        shopLink.click();
    }

    public void navigateToContactPage() {
        contactLink.click();
    }

    public void navigateToAGBPage() {
        contactLink.click();
        agbLink.click();
    }

    public void navigateToCart() {
        SynchronizationUtils.staleElementSolution(driver,cartIcon);
    }

}