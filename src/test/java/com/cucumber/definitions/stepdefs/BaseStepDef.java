package com.cucumber.definitions.stepdefs;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {"classpath:spring-properties/_cucumber-context.xml"})
public abstract class BaseStepDef {

    @Autowired
    public WebDriver webDriver;

    // NOTE!!
    // "You're not allowed to extend classes that define Step Definitions or hooks."
    // So don't add any steps here.
}
