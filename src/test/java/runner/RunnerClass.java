package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = {"progress", "html:target/cucumber-html-report"},
        features = "src/test/resources",
        dryRun = false,
        snippets = SnippetType.CAMELCASE,
        monochrome = true,
        tags = "@verify_search_options",
        glue = "steps")
public class RunnerClass extends AbstractTestNGCucumberTests {
}
