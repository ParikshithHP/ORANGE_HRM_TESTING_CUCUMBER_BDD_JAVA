package com.hrm.orangehrm.stepdefinitions;

import com.corro.corrostudio.pageobjectlibrary.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

    protected LoginPage loginPage = new LoginPage();

    @Given("Open Browser and Navigate to URL")
    public void openBrowserAndNavigateToUrl() {

        loginPage.openAndNavigatetoUrl();
    }

    @When("Sign In page is displayed")
    public void signInPageIsDisplayed() {

        loginPage.verifySigInPage();
    }

    @Then("I enter username and password")
    public void iEnterUsernameAndPassword() {

        loginPage.enterUsername();
        loginPage.enterPassword();
    }

    @And("I click on Sign In button")
    public void iClickOnSignInButton() {

        loginPage.sigIn();
    }

    @And("I verify Home page is displayed")
    public void iVerifyHomePageIsDisplayed() {

        loginPage.verifyHomePage();
    }

    @And("Click SignOut Link")
    public void clickSignOutLink() {

        loginPage.signOut();
    }

    @Then("I enter username as {string}")
    public void iEnterUsernameAs(String username) {
        loginPage.enterInvalidUsername(username);
    }

    @Then("I enter password as {string}")
    public void iEnterPasswordAs(String password) {
        loginPage.enterInvalidPassword(password);
    }

    @And("Verify Error Messages")
    public void verifyErrorMessages() {
        loginPage.verifyErrorMessage();
    }

}
