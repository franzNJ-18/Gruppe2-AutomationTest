package common;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CreateWebDriver {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static CreateWebDriver instance = null;

    public static synchronized CreateWebDriver getInstance() {
        if (instance == null) {
            instance = new CreateWebDriver();
        }

        return instance;
    }
    public synchronized WebDriver getWebDriver() {
        return webDriver.get();
    }
    public synchronized boolean hasWebDriver() {
        return (getWebDriver() != null);
    }
    public synchronized void closeWebDriver() {
        if (hasWebDriver()) {
            getWebDriver().quit();
            webDriver.set(null);
        }
    }

    public WebDriver createWebDriver(String pBrowserName) throws MalformedURLException {
        WebDriver aDriver = null;
        switch (pBrowserName.toUpperCase()) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.default_content_setting_values.notifications", 1);
                options.addArguments("--use-fake-ui-for-media-stream");
                options.addArguments("--use-fake-device-for-media-stream");
                options.setAcceptInsecureCerts(true);
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("--remote-allow-origins=*");
                DesiredCapabilities cp = new DesiredCapabilities();
                cp.setCapability(ChromeOptions.CAPABILITY, options);
                options.merge(cp);
                aDriver = new ChromeDriver(options);
                break;
        }
        aDriver.manage().window().maximize();

        aDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        aDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        webDriver.set(aDriver);
        return aDriver;
    }
}