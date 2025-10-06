package myproject.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import myproject.abs.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class Hooks {
    private static ThreadLocal<WebDriver> threadLocalWebdriver = new ThreadLocal<>();
    private static ThreadLocal<TestContext> threadLocalContext = new ThreadLocal<>();

    @Before
    public void setUpDriver() {
        String browser = Config.getProperty("BROWSER").toLowerCase();
        Boolean headless = Boolean.parseBoolean(Config.getProperty("HEADLESS"));

        WebDriver driver = null;

        if (browser.equals("chrome")) {
            final Map<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            chromePrefs.put("profile.password_manager_leak_detection", false);

            final ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("prefs", chromePrefs);
            chromeOptions.addArguments("--window-size=1920,1080");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");

            if (headless) {
                chromeOptions.addArguments("--headless=new");
            }

            driver = new ChromeDriver(chromeOptions);
        }

        if (browser.equals("firefox")) {
            final FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--width=1920");
            firefoxOptions.addArguments("--height=1080");

            if (headless) {
                firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("--no-sandbox");
                firefoxOptions.addArguments("--disable-dev-shm-usage");
            }

            driver = new FirefoxDriver(firefoxOptions);
        }

        if (browser.equals("edge")) {
            final EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--window-size=1920,1080");

            if (headless) {
                edgeOptions.addArguments("--headless=new");
                edgeOptions.addArguments("--no-sandbox");
                edgeOptions.addArguments("--disable-dev-shm-usage");
            }

            driver = new EdgeDriver(edgeOptions);
        }

        threadLocalWebdriver.set(driver);
        threadLocalContext.set(new TestContext());
    }

    public static WebDriver getDriver() {
        return threadLocalWebdriver.get();
    }

    public static ThreadLocal<TestContext> getThreadLocalContext() {
        return threadLocalContext;
    }

    @After
    public void tearDownDriver() {
        WebDriver driver = threadLocalWebdriver.get();
        if (driver != null) {
            driver.quit();
            threadLocalWebdriver.remove();
        }
    }
}
