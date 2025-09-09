package myproject.steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class Hooks {
    private static ThreadLocal<WebDriver> threadLocalWebdriver=new ThreadLocal<>();
    private static ThreadLocal<TestContext> threadLocalContext = new ThreadLocal<>();


    @Before
    public void setUpDriver(){

        final Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        chromePrefs.put("profile.password_manager_leak_detection", false);

        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        threadLocalWebdriver.set(new ChromeDriver(chromeOptions));
        threadLocalContext.set(new TestContext());
    }
    public static WebDriver getDriver(){
        return threadLocalWebdriver.get();
    }


    public static ThreadLocal<TestContext> getThreadLocalContext() {
        return threadLocalContext;
    }

    @After
    public void tearDownDriver(){
        WebDriver driver=threadLocalWebdriver.get();
        if(driver != null){
            driver.quit();
            threadLocalWebdriver.remove();
        }
    }
}
