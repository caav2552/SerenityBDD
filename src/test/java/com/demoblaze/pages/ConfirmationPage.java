package com.demoblaze.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends PageObject {

    @FindBy(css = ".sweet-alert")
    private WebElementFacade confirmationModal;

    @FindBy(css = ".sweet-alert h2")
    private WebElementFacade confirmationTitle;

    @FindBy(css = ".sweet-alert .lead")
    private WebElementFacade confirmationMessage;

    @FindBy(css = ".sweet-alert .confirm")
    private WebElementFacade okButton;

    public void waitForConfirmation() {
        waitFor(confirmationModal);
        waitFor(confirmationTitle);
    }

    public boolean isConfirmationDisplayed() {
        return confirmationModal.isVisible();
    }

    public String getConfirmationTitle() {
        return confirmationTitle.getText();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    public void clickOk() {
        okButton.click();
        waitABit(500);
    }

    public boolean containsOrderDetails() {
        String message = getConfirmationMessage();
        return message.contains("Id:") && 
               message.contains("Amount:") && 
               message.contains("Card Number:") &&
               message.contains("Name:") &&
               message.contains("Date:");
    }
}
