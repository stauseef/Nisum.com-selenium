package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesDeleteSSBackgroundProcess {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
    }
}
