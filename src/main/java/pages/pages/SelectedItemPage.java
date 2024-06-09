package pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.base.BasePage;
import utils.WaitTool;
import java.util.List;
import java.util.Set;

public class SelectedItemPage extends BasePage {
    private static final By QUANTITY_INPUT_FIELD = By.id("qtyTextBox");
    private static final By ADD_TO_CART_BUTTON = By.xpath("//a[@id='atcBtn_btn_1']");
    private static final By SWITCH_VIEW_OPTION = By.cssSelector("#TABS_SPR > span");
    private static final By MONOPOLY_ITEM_TITLE = By.xpath("//div[@class='vim x-item-title']//span[1]");
    public static final double EXPECTED_PRICE = 99.0;
    public static final double EXPECTED_PRICE_FOR_TWO_ITEMS = EXPECTED_PRICE * 2;

    public static void chooseQuantityAndAddToCart(String quantity) {
        switchTab();
        WaitTool.elementToBeVisible(QUANTITY_INPUT_FIELD, 20);
        driver.findElement(QUANTITY_INPUT_FIELD).click();
        driver.findElement(QUANTITY_INPUT_FIELD).clear();
        write(QUANTITY_INPUT_FIELD, quantity);
        click(ADD_TO_CART_BUTTON);
    }

    public static void switchViewMenu() {
        WaitTool.elementToBeVisible(SWITCH_VIEW_OPTION, 20);
        click(SWITCH_VIEW_OPTION);
    }

    public static Boolean checkForBulgariaOption() {
        WebElement dropdown = driver.findElement(By.id("shCountry"));
        Select dropDownMenu = new Select(dropdown);
        List<WebElement> countryList = dropDownMenu.getOptions();

        boolean isOptionAvailable = false;
        String desiredOption = "Bulgaria";

        for (WebElement option : countryList) {
            if (option.getText().equals(desiredOption)) {
                isOptionAvailable = true;
                break;
            }
        }
        return true;
    }

    public static void checkItemTitle() {
        switchTab();
        driver.findElement(MONOPOLY_ITEM_TITLE).getText().contains("Monopoly");
    }

    public static void switchTab() {
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            driver.switchTo().window(tab);
        }
    }
}

