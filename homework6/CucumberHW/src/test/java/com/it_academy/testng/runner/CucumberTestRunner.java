package com.it_academy.testng.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/CucumberTestRunner.html",
                "json:target/cucumber-reports/CucumberTestRunner.json",
                "testng:target/cucumber-reports/CucumberTestRunner.xml"},
        monochrome = true,
        tags = "",
        glue = "com.it_academy.testng",
        features = "classpath:com/it_academy/testng/features"
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}

