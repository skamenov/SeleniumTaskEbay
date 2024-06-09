package steps;

import cucumber.api.java.en.*;
import org.testng.Assert;
import pages.home.GoToWebPage;
import pages.pages.MainPage;
import pages.pages.SelectedItemPage;
import pages.pages.ShoppingCartPage;


public class StepDefinitions {

    @Given("Navigate to {string}")
    public void navigateTo(String string) {
        GoToWebPage.goToWebPage(string);
    }

    @Then("Verify that the page is correct and opened")
    public void verifyThatThePageIsCorrectAndOpened() {
        MainPage.checkTheCurrentWebPage("https://www.ebay.com/");
    }

    @When("Select from drop down list “Toys & Games”, then search for Monopoly")
    public void selectFromDropDownListToysGamesThenSearchForMonopoly() {
        MainPage.searchForMonopolyItems("Monopoly");
    }

    @Then("Verify that the first items have the title: Monopoly")
    public void verifyThatTheFirstItemsHaveTheTitleMonopoly() {
        MainPage.isItemTitleContainsMonopoly();
    }

    @And("Verify that there is a shipping to Bulgaria")
    public void verifyThatThereIsAShippingToBulgaria() {
        MainPage.isThereShippingToBulgaria();
    }

    @And("Verify that there is a price of the item")
    public void verifyThatThereIsAPriceOfTheItem() {
        MainPage.isPriceDisplayed();
    }

    @When("Click on the first item to navigate to details page")
    public void clickOnTheFirstItemToNavigateToDetailsPage() {
        MainPage.clickOnTheFirstMonopolyItem();
    }

    @Then("Verify that the title of the item contains Monopoly")
    public void verifyThatTheTitleOfTheItemContainsMonopoly() {
        SelectedItemPage.checkItemTitle();
    }

    @And("Verify that the price is the same as on the first page")
    public void verifyThatThePriceIsTheSameAsOnTheFirstPage() {
        String selectedItemPrice = ShoppingCartPage.takeThePriceOfTheSelectedItem();
        double itemPrice = ShoppingCartPage.extractPrice(selectedItemPrice);
        Assert.assertEquals(itemPrice, SelectedItemPage.EXPECTED_PRICE);
    }

    @When("Switch view from Description to Shipping and payments")
    public void switchViewFromDescriptionToShippingAndPayments() {
        SelectedItemPage.switchViewMenu();
    }

    @Then("Verify that Bulgaria exists in the country drop down list")
    public void verifyThatBulgariaExistsInTheCountryDropDownList() {
        SelectedItemPage.checkForBulgariaOption();
    }

    @When("Select quantity {string} and click Add to cart")
    public void selectQuantityAndClickAddToCart(String string) {
        SelectedItemPage.chooseQuantityAndAddToCart(string);
    }

    @Then("Verify that you are on {string}")
    public void verifyThatYouAreOn(String string) {
        MainPage.checkTheCurrentWebPage(string);
    }

    @Then("Verify that in the Qty Drop Down List the quantity is {string}")
    public void verifyThatInTheQtyDropDownListTheQuantityIs(String string) throws InterruptedException {
        ShoppingCartPage.verifyTheSelectedQuantity(string);
    }

    @And("Verify that the price is displayed for two items")
    public void verifyThatThePriceIsDisplayedForTwoItems() {
        String nonExtractedPrice= ShoppingCartPage.checkThePriceForTwoItems();
        double extractedPrice = ShoppingCartPage.extractPrice(nonExtractedPrice);
        Assert.assertEquals(extractedPrice, SelectedItemPage.EXPECTED_PRICE_FOR_TWO_ITEMS);
    }
}

