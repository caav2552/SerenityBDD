package com.demoblaze.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends PageObject {

    @FindBy(css = ".name")
    private WebElementFacade productTitle;

    @FindBy(css = ".price-container")
    private WebElementFacade productPrice;

    @FindBy(css = "#tbodyid .card-block")
    private WebElementFacade productDescription;

    @FindBy(css = "a.btn.btn-success.btn-lg")
    private WebElementFacade addToCartButton;

    @FindBy(css = ".item.active img")
    private WebElementFacade productImage;

    public void waitForPageToLoad() {
        waitFor(productTitle);
        waitFor(addToCartButton);
    }

    public String getProductName() {
        return productTitle.getText();
    }

    public String getProductPrice() {
        return productPrice.getText().replace("*includes tax", "").trim();
    }

    public void addToCart() {
        addToCartButton.click();
        waitForAlert();
        acceptAlert();
    }

    private void waitForAlert() {
        waitForCondition().until(ExpectedConditions.alertIsPresent());
    }

    private void acceptAlert() {
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
        waitABit(1000);
    }

    public boolean isAddToCartButtonVisible() {
        return addToCartButton.isVisible();
    }
}
