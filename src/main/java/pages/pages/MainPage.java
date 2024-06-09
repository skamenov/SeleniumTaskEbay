package pages.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import pages.base.BasePage;
import utils.WaitTool;

public class MainPage extends BasePage {

    private static final By MONOPOLY_ITEM_ONE = By.xpath("//li[@data-gr4='2']");
    private static final By SHOP_BY_CATEGORY_DROP_MENU = By.id("gh-shop-a");
    private static final By TOYS_AND_HOBBIES_MENU = By.xpath("//a[normalize-space()='Toys & hobbies']");
    private static final By SEARCH_FOR_ANYTHING_INPUT_FIELD = By.id("gh-ac");
    private static final By SEARCH_BUTTON = By.id("gh-btn");
    private static final By MONOPOLY_ITEM_TWO = By.xpath("//li[@data-gr4='3']");
    private static final By MONOPOLY_ITEM_PRICE = By.xpath("//li[@data-gr4='2']//span[contains(@class, 's-item__price')]");
    private static final By SHIPPING_OPTION = By.xpath("//span[normalize-space()='Bulgaria']");

    public static void clickOnTheFirstMonopolyItem() {
        WaitTool.elementToBeVisible(MONOPOLY_ITEM_ONE, 10);
        click(MONOPOLY_ITEM_ONE);
    }

    public static void searchForMonopolyItems(String searchText) {
        click(SHOP_BY_CATEGORY_DROP_MENU);
        WaitTool.elementToBeVisible(TOYS_AND_HOBBIES_MENU, 10);
        click(TOYS_AND_HOBBIES_MENU);
        write(SEARCH_FOR_ANYTHING_INPUT_FIELD, searchText);
        click(SEARCH_BUTTON);
    }

    public static void isItemTitleContainsMonopoly() {
        driver.findElement(MONOPOLY_ITEM_ONE).getText().contains("Monopoly");
        driver.findElement(MONOPOLY_ITEM_TWO).getText().contains("Monopoly");
    }

    public static void checkTheCurrentWebPage(String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl);
    }

    public static void isPriceDisplayed() {
        driver.findElement(MONOPOLY_ITEM_PRICE).isDisplayed();
    }

    public static void isThereShippingToBulgaria() {
        String shippingCountry = driver.findElement(SHIPPING_OPTION).getText();
        Assert.assertEquals(shippingCountry, "Bulgaria");
    }

    public static String gettingThePriceOfTheMainPageItem() {
        return driver.findElement(MONOPOLY_ITEM_PRICE).getText();
    }

}
