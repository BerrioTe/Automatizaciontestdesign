package co.sqa.testdesing.pruebas.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/AutomatizacioonTestDesing.feature",
        glue = "co.sqa.testdesing.pruebas.stepdefinition",
        snippets = SnippetType.CAMELCASE)
public class AutomatizacionSqaTestDesingUiRunner {
}
