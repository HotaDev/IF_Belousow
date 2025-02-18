
import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;

import static io.cucumber.junit.platform.engine.Constants.*;

@Cucumber
@SelectClasspathResource("src/test/resources/feature")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
public class CucumberRunnerTest {

}
