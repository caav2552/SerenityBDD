package com.demoblaze.steps;

import com.demoblaze.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseSteps {

    private HomePage homePage = new HomePage();
    private ProductPage productPage = new ProductPage();
    private CartPage cartPage = new CartPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private ConfirmationPage confirmationPage = new ConfirmationPage();

    private String firstProductName;
    private String secondProductName;

    @Given("the user is on the Demoblaze home page")
    public void userIsOnHomePage() {
        homePage.openPage();
    }

    @When("the user adds {string} to the cart")
    public void userAddsProductToCart(String productName) {
        homePage.clickProductByName(productName);
        productPage.waitForPageToLoad();
        productPage.addToCart();
        homePage.clickHomeLink();
    }

    @When("the user adds the first product to the cart")
    public void userAddsFirstProductToCart() {
        homePage.clickProductByIndex(0);
        productPage.waitForPageToLoad();
        firstProductName = productPage.getProductName();
        productPage.addToCart();
        homePage.clickHomeLink();
    }

    @When("the user adds the second product to the cart")
    public void userAddsSecondProductToCart() {
        homePage.clickProductByIndex(1);
        productPage.waitForPageToLoad();
        secondProductName = productPage.getProductName();
        productPage.addToCart();
        homePage.clickHomeLink();
    }

    @When("the user navigates to the cart")
    public void userNavigatesToCart() {
        homePage.goToCart();
        cartPage.waitForPageToLoad();
    }

    @Then("the cart should contain {int} product\\(s)")
    public void cartShouldContainProducts(int expectedCount) {
        int actualCount = cartPage.getNumberOfItemsInCart();
        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @Then("the cart should display {string}")
    public void cartShouldDisplayProduct(String productName) {
        assertThat(cartPage.isProductInCart(productName)).isTrue();
    }

    @Then("the cart should display the added products")
    public void cartShouldDisplayAddedProducts() {
        assertThat(cartPage.isProductInCart(firstProductName)).isTrue();
        assertThat(cartPage.isProductInCart(secondProductName)).isTrue();
    }

    @When("the user proceeds to place the order")
    public void userProceedsToPlaceOrder() {
        cartPage.clickPlaceOrder();
        checkoutPage.waitForModalToAppear();
    }

    @When("the user fills the checkout form with:")
    public void userFillsCheckoutForm(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        checkoutPage.fillCheckoutForm(
            data.get("Name"),
            data.get("Country"),
            data.get("City"),
            data.get("Credit card"),
            data.get("Month"),
            data.get("Year")
        );
    }

    @When("the user completes the purchase")
    public void userCompletesThePurchase() {
        checkoutPage.clickPurchase();
        confirmationPage.waitForConfirmation();
    }

    @Then("the purchase should be confirmed")
    public void purchaseShouldBeConfirmed() {
        assertThat(confirmationPage.isConfirmationDisplayed()).isTrue();
        assertThat(confirmationPage.getConfirmationTitle()).contains("Thank you for your purchase!");
    }

    @Then("the confirmation should display order details")
    public void confirmationShouldDisplayOrderDetails() {
        assertThat(confirmationPage.containsOrderDetails()).isTrue();
    }

    @And("the total price should be displayed")
    public void totalPriceShouldBeDisplayed() {
        assertThat(cartPage.getTotalPrice()).isNotEmpty();
    }
}
