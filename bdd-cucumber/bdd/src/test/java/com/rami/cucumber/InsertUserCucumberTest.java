package com.rami.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/InsertUser.feature",
        glue="com.rami.steps.insertuser",
        plugin={"pretty","html:target/cucumber-html-report","json:target/cucumber.json"}
)
public class InsertUserCucumberTest {
}
