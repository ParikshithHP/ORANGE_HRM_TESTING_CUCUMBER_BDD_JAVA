package com.hrm.orangehrm.pageobjectlibrary;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.corro.corrostudio.dataexcel.LoginCredentials;
import com.corro.corrostudio.locators.LoginPageLocators;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

import com.corro.corrostudio.utilities.*;

public class LoginPage extends PageObject {

    protected static final Logger LOGGER = Logger.getLogger(LoginPage.class.getName());

    GeneralMethods generalMethods = new GeneralMethods();

    @Step("Open Browser and Navigate to URL")
    public void openAndNavigatetoUrl() {
        replacePropertyValue();
    }

    @Step("Enter Username")
    public void enterUsername() {
        String strUsername = LoginCredentials.returnUsername();
        $(LoginPageLocators.USERNAME).sendKeys(strUsername);
    }

    @Step("Enter Password")
    public void enterPassword() {
        String strPassword = LoginCredentials.returnPassword();
        $(LoginPageLocators.PASSWORD).sendKeys(strPassword);
    }

    @Step("Enter Invalid Username")
    public void enterInvalidUsername(String username) {
        $(LoginPageLocators.USERNAME).sendKeys(username);
    }

    @Step("Enter Invalid Password")
    public void enterInvalidPassword(String password) {
        $(LoginPageLocators.PASSWORD).sendKeys(password);
    }

    @Step("Click Sigin")
    public void sigIn() {
        $(LoginPageLocators.SIGIN_BTN).click();
        generalMethods.waitForTimeInSeconds(2);
    }

    @Step("Click SigOut")
    public void signOut() {
        $(LoginPageLocators.SIGN_OUT).click();
    }

    @Step("Verify SigIn Page")
    public void verifySigInPage() {
        try {
            if ($(LoginPageLocators.SIGIN_TEXT).isDisplayed()) {
                LOGGER.log(Level.INFO, "SigIn Page is displayed");
            } else {
                LOGGER.log(Level.WARNING, "SigIn Page is not displayed");
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "SigIn Page is not displayed");
        }
    }

    @Step("Verify Home Page")
    public void verifyHomePage() {
        try {
            if ($(LoginPageLocators.HOMEPAGE_TEXT).isDisplayed()) {
                LOGGER.log(Level.INFO, "Home Page is displayed");
            } else {
                LOGGER.log(Level.WARNING, "Home Page is not displayed");
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Home Page is not displayed");
        }
    }

    @Step("Verify Error Messages")
    public void verifyErrorMessage() {

        if ($(LoginPageLocators.ERROR_MSG).getText().equalsIgnoreCase("Incorrect username or password.")) {
            LOGGER.log(Level.FINE, "Error Message is Displayed as expected ");
        } else {
            LOGGER.log(Level.WARNING, "Error Message is not Displayed as expected ");
        }
    }


    public void replacePropertyValue() {

        String strURL = LoginCredentials.returnURL();
        getDriver().get(strURL);
    }
}
