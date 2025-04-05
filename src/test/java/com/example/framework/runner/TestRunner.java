package com.example.framework.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/example/bdd_framework/features",
        glue = "com/example/bdd_framework/stepDefinition")
public class TestRunner {

}

