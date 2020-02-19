package resources;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Utilities {

    public static WebDriver driver;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;
    JsonPath jPath;

    public static String getGlobalValues(String key) throws IOException {
        Properties propOjb = new Properties();
        String dirPath = System.getProperty("user.dir");
        FileInputStream fIS = new FileInputStream(dirPath + "\\src\\test\\resources\\global.properties");
        propOjb.load(fIS);
        return propOjb.getProperty(key);
    }

    public String getJsonPath(Response response, String key){
        String res = response.asString();
        jPath = new JsonPath(res);
        return jPath.get(key).toString();

    }

    public static void initialization() throws IOException {
        String browserName =getGlobalValues("browser");
        if (browserName.equals("chrome")) {


            // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            driver = new ChromeDriver(options);
        } else if (browserName.equals("FF")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        /*e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;*/

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

}
