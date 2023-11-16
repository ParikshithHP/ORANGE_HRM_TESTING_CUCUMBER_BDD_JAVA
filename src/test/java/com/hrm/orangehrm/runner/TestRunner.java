package com.hrm.orangehrm.datadrivenexcel;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
       tags="@Login_Functionality",
       features="src/test/resources/features/",
       glue={"com.corro.ec2.stepdefenitions"},
       monochrome=true,
       plugin = { "pretty" }
)
public class TestRunner {
}