package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    protected WebDriver driver;

    @FindBy(xpath = "//div[@id='accountbar']/a")
    WebElement loginButton;

    public HomePage (WebDriver pDriver){
        driver= pDriver;
        PageFactory.initElements(driver,this);
    }

    public void clickLogin() {
        loginButton.click();
    }
}