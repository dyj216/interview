package hu.dizs;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("hu/dizs/")  // Path to feature files
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "hu.dizs")  // Path to step definitions
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-report.html")  // Reports
public class CucumberTestRunner {
}
