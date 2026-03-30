package com.demoblaze.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends PageObject {

    private static final int SHORT_WAIT = 1000;

    @FindBy(css = ".card")
    private List<WebElementFacade> productCards;

    @FindBy(id = "tbodyid")
    private WebElementFacade productsContainer;

    @FindBy(id = "cartur")
    private WebElementFacade cartLink;

    @FindBy(id = "login2")
    private WebElementFacade loginLink;

    @FindBy(id = "signin2")
    private WebElementFacade signUpLink;

    @FindBy(css = "a[onclick*='byCat']")
    private List<WebElementFacade> categoryLinks;

    @FindBy(id = "next2")
    private WebElementFacade nextButton;

    @FindBy(id = "prev2")
    private WebElementFacade previousButton;

    @FindBy(css = "a.nav-link[href='index.html']")
    private WebElementFacade homeLink;

    public void openPage() {
        getDriver().get("https://www.demoblaze.com/index.html");
        getDriver().manage().window().maximize();
        waitForPageToLoad();
    }

    public void clickHomeLink() {
        homeLink.click();
        waitABit(SHORT_WAIT);
        waitForPageToLoad();
    }

    public void waitForPageToLoad() {
        waitFor(productsContainer);
    }

    public void clickProductByName(String productName) {
        WebElementFacade productLink = find(By.linkText(productName));
        waitFor(productLink);
        productLink.click();
    }

    public void clickProductByIndex(int index) {
        waitFor(productCards.get(index));
        WebElementFacade productLink = productCards.get(index).findBy(".hrefch");
        productLink.click();
    }

    public void goToCart() {
        cartLink.click();
    }

    public boolean isProductDisplayed(String productName) {
        return find(By.linkText(productName)).isVisible();
    }

    public int getNumberOfProducts() {
        return productCards.size();
    }

    public void selectCategory(String category) {
        WebElementFacade categoryLink = find(By.xpath("//a[contains(@onclick, '" + category + "')]"));
        categoryLink.click();
        waitABit(1000);
    }
}
