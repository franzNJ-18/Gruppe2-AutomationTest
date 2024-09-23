package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class AGBPage {
    WebDriver driver;
    @FindBy(xpath = "//div/h3")
    WebElement titleOfAGB;

    public AGBPage(WebDriver pDriver) {
        driver = pDriver;
        PageFactory.initElements(driver,this);
    }

    public String getTitleOfAGB() {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return titleOfAGB.getText();
    }
}
