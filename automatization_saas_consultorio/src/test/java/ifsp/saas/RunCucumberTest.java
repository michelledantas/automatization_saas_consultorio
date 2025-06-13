package ifsp.saas;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("ifsp/saas/home")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "ifsp.saas.home")
public class RunCucumberTest {
}
