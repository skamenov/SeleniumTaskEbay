package pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.base.BasePage;

public class ShoppingCartPage extends BasePage {

    private static final By PRICE_FOR_TWO_ITEMS = By.cssSelector("div[class='item-price font-title-3'] span[class='text-display-span'] span span");
    private static final By PRICE_OF_THE_SELECTED_ITEM = By.cssSelector("div[class='x-price-primary'] span[class='ux-textspans']");

    public static String checkThePriceForTwoItems() {
        return driver.findElement(PRICE_FOR_TWO_ITEMS).getText();
    }

    public static double extractPrice(String priceText) {
        String cleanedPriceText = priceText.replaceAll("[^\\d.,]", "");
        cleanedPriceText = cleanedPriceText.replace(",", ".");
        double priceValue = Double.parseDouble(cleanedPriceText);
        return priceValue;
    }

    public static String takeThePriceOfTheSelectedItem() {
        return driver.findElement(PRICE_OF_THE_SELECTED_ITEM).getText();
    }

    public static void verifyTheSelectedQuantity(String expectedQuantity) throws InterruptedException {
        Thread.sleep(10000);
        WebElement dropdownCounter = driver.findElement(By.cssSelector("select[data-test-id='qty-dropdown']"));
        Select dropdown = new Select(dropdownCounter);
        String selectedQuantity = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedQuantity, expectedQuantity);
    }
}


