package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import resources.Utilities;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import static resources.Utilities.driver;
import static resources.Utilities.getGlobalValues;

public class DifferentTab {
    public static void main(String[] args) throws IOException {
        /*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/java/drivers/chromedriver.exe");
        WebDriver  driver1 = new ChromeDriver();*/
        Utilities.initialization();
        String baseUrl = getGlobalValues("doubleClickUrl");
        driver.get(baseUrl);
        WebElement parent = driver.findElement(By.className("Bgzgmd"));
        parent.findElement(By.tagName("li")).click();
        System.out.println(driver.getTitle());
        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String presentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        System.out.println(driver.getTitle());
        driver.switchTo().window(presentId);
    }
}
