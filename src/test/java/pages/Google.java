package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.Utilities;

import java.util.concurrent.TimeUnit;

public class Google extends Utilities {


    @FindBy(how = How.CSS, using = "input[name='q']")
    public WebElement searchKey;

    @FindBy(how = How.CLASS_NAME, using = "i4J0ge")
    public WebElement div;

    public Google() {
        PageFactory.initElements(driver, this);
    }

    public void search(String searchKeyValue) {
        searchKey.sendKeys(searchKeyValue);
        searchKey.submit();
    }

    public void webPageLoadsPage() {
        //WebDriverWait wdw = new WebDriverWait(driver,5);
        //wdw.until(ExpectedConditions.visibilityOf(div));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        div.isDisplayed();
    }

    public String getAddress(){
        WebElement extractAdd= div.findElement(By.cssSelector("span[class='LrzXr']"));
        return extractAdd.getText();
    }

}
