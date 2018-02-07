package com.cucumber.functionaltest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber/cucumber.json"},
        features = "src/test/resources/features",
        tags = {"~@ignored"},
        strict = true)
public class RunCucumberTest {
    // intentionally empty
}

