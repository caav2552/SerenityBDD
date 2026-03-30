package com.demoblaze.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

public class Hooks {

    @Before
    public void beforeScenario() {
        Serenity.getCurrentSession().clear();
        // Maximize browser window
        ThucydidesWebDriverSupport.getDriver().manage().window().maximize();
    }

    @After
    public void afterScenario() {
        Serenity.getCurrentSession().clear();
    }
}
