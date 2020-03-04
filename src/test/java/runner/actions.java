package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.Utilities;

import java.io.IOException;

import static resources.Utilities.driver;
import static resources.Utilities.getGlobalValues;

public class actions {

    public static void main(String[] args) throws IOException {
        /*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/java/drivers/chromedriver.exe");
        WebDriver  driver1 = new ChromeDriver();*/
        Utilities.initialization();
        String baseUrl = getGlobalValues("amazonUrl");
        driver.get(baseUrl);
        Actions a = new Actions(driver);
        WebElement move =driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
        a.moveToElement(move).contextClick().build().perform();

        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("gfdgsd").doubleClick().build().perform();



    }
}
