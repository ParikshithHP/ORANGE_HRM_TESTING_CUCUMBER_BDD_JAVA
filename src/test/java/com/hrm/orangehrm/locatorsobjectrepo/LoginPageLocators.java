package com.hrm.orangehrm.locatorsobjectrepo;

import org.openqa.selenium.By;

public class LoginPageLocators {

    private LoginPageLocators() {
    }

    public static final By SIGIN_TEXT = By.xpath("(//*[text()='Sign in with your username and password'])[2]");
    public static final By USERNAME = By.xpath("(//input[@class='oxd-input oxd-input--active' and @name='username'])");
    public static final By PASSWORD = By.xpath("(//input[@class='oxd-input oxd-input--active' and @name='password'])");
    public static final By SIGIN_BTN = By.xpath("(//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button' and text()=' Login '])");
    public static final By HOMEPAGE_TEXT = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    public static final By SIGN_OUT = By.xpath("//a[@class='oxd-userdropdown-link' and text()='Logout']");
    public static final By ERROR_MSG = By.xpath("(//button[@class='oxd-icon-button' and @title= 'Help']");