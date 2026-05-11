package stepdefinitions;

import com.projectmanager.model.Project;
import com.projectmanager.services.RuntimeContext;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private static String lastFeatureUri = "";

    @Before
    public void setup(Scenario scenario) {
        String currentFeatureUri = scenario.getUri().toString();
        if (!currentFeatureUri.equals(lastFeatureUri)) {
            Project.resetSerialNumber();
            lastFeatureUri = currentFeatureUri;
        }
        RuntimeContext.reset();
    }
}
