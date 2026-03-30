package com.demoblaze.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends PageObject {

    @FindBy(id = "tbodyid")
    private WebElementFacade cartTableBody;

    @FindBy(css = "#tbodyid tr")
    private List<WebElementFacade> cartItems;

    @FindBy(id = "totalp")
    private WebElementFacade totalPrice;

    @FindBy(css = "button[data-target='#orderModal']")
    private WebElementFacade placeOrderButton;

    @FindBy(css = ".col-lg-1 a")
    private List<WebElementFacade> deleteButtons;

    public void waitForPageToLoad() {
        waitFor(cartTableBody);
        waitABit(1000);
    }

    public int getNumberOfItemsInCart() {
        return cartItems.size();
    }

    public boolean isProductInCart(String productName) {
        return find(By.xpath("//td[contains(text(), '" + productName + "')]")).isVisible();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public void clickPlaceOrder() {
        placeOrderButton.click();
        waitABit(1000);
    }

    public void removeFirstItem() {
        if (!deleteButtons.isEmpty()) {
            deleteButtons.get(0).click();
            waitABit(1000);
        }
    }

    public String getProductNameByIndex(int index) {
        return cartItems.get(index).findBy("td:nth-child(2)").getText();
    }

    public String getProductPriceByIndex(int index) {
        return cartItems.get(index).findBy("td:nth-child(3)").getText();
    }
}
