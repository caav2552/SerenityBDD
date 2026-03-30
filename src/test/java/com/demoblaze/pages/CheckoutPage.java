package com.demoblaze.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageObject {

    @FindBy(id = "name")
    private WebElementFacade nameInput;

    @FindBy(id = "country")
    private WebElementFacade countryInput;

    @FindBy(id = "city")
    private WebElementFacade cityInput;

    @FindBy(id = "card")
    private WebElementFacade creditCardInput;

    @FindBy(id = "month")
    private WebElementFacade monthInput;

    @FindBy(id = "year")
    private WebElementFacade yearInput;

    @FindBy(css = "button[onclick='purchaseOrder()']")
    private WebElementFacade purchaseButton;

    @FindBy(css = "#orderModal .modal-content")
    private WebElementFacade orderModal;

    @FindBy(css = "#orderModal .modal-header .close")
    private WebElementFacade closeModalButton;

    public void waitForModalToAppear() {
        waitFor(orderModal);
        waitFor(nameInput);
    }

    public void fillName(String name) {
        nameInput.type(name);
    }

    public void fillCountry(String country) {
        countryInput.type(country);
    }

    public void fillCity(String city) {
        cityInput.type(city);
    }

    public void fillCreditCard(String cardNumber) {
        creditCardInput.type(cardNumber);
    }

    public void fillMonth(String month) {
        monthInput.type(month);
    }

    public void fillYear(String year) {
        yearInput.type(year);
    }

    public void fillCheckoutForm(String name, String country, String city, String card, String month, String year) {
        fillName(name);
        fillCountry(country);
        fillCity(city);
        fillCreditCard(card);
        fillMonth(month);
        fillYear(year);
    }

    public void clickPurchase() {
        purchaseButton.click();
        waitABit(1000);
    }

    public boolean isModalVisible() {
        return orderModal.isVisible();
    }
}
