package org.runnerclass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\featureFiles", glue = "org.stepdefintion",
dryRun=false, strict = true, monochrome = false,snippets=SnippetType.UNDERSCORE,tags="@project")
public class RunnerClass {

}
