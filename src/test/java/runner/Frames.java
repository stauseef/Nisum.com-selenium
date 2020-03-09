package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import resources.Utilities;

import javax.swing.*;
import java.io.IOException;
import static resources.Utilities.driver;
import static resources.Utilities.getGlobalValues;

public class Frames {
    public static void main(String[] args) throws IOException {


        Utilities.initialization();
        String baseUrl = getGlobalValues("frameUrl");
        driver.get(baseUrl);
        WebElement frame= driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frame);
        WebElement source =driver.findElement(By.id("draggable"));
        WebElement target =driver.findElement(By.id("droppable"));
        Actions  a= new Actions(driver);
        a.dragAndDrop(source,target).build().perform();
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.linkText("Revert draggable position")));


    }
}
