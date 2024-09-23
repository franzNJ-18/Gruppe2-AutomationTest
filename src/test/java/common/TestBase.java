package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public abstract class TestBase {

    protected WebDriver driver;

    protected DevTools devTools;

    @BeforeClass
    protected void setUp() throws MalformedURLException {
        String aDriverType = System.getProperty("driverType","EDGE");
        CreateWebDriver.getInstance().createWebDriver(aDriverType);
        WebDriver aDriver = CreateWebDriver.getInstance().getWebDriver();
        aDriver.get("http://10.40.226.38/BC_Team_2/index.php");
        driver =aDriver;
    }

    @BeforeMethod
    public void beforeMethod(ITestResult pResult) {
        String aTestDescription = pResult.getMethod().getDescription();
        System.out.println();
        System.out.println("=== Start Test: " + aTestDescription + " ===");
        System.out.println();
    }

    @AfterMethod
    public void afterMethod(ITestResult pResult) {
        String aTestDescription = pResult.getMethod().getDescription();
        System.out.println("*** Test abgeschlossen: " + aTestDescription + " ***");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        CreateWebDriver.getInstance().closeWebDriver();
        driver.quit();
    }
}