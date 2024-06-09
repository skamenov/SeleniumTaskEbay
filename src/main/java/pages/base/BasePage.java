package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Browser;

public class BasePage {
    protected static WebDriver driver;

    static {
        driver = Browser.getDriver();
    }

    public static void click(By locator) {
        driver.findElement(locator).click();
    }

    public static void write(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }
}
