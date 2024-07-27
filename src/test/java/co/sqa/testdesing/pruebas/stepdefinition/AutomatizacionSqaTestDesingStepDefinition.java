package co.sqa.testdesing.pruebas.stepdefinition;


import co.sqa.testdesing.pruebas.tasks.Imprimirdatos;
import co.sqa.testdesing.pruebas.userinterface.SqaTestDesingUi;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;

import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.Map;

public class AutomatizacionSqaTestDesingStepDefinition {
    @Managed(driver = "chrome")
    private WebDriver navegador;
    private Actor actor = Actor.named("Jota");

    private SqaTestDesingUi sqaTestDesingUi = new SqaTestDesingUi();
    private static ArrayList<Map<String, String>> datos = new ArrayList<Map<String, String>>();
    @Before
    public void configuracion() {
        actor.can(BrowseTheWeb.with(navegador));
    }

    @Dado("^Que nos encontramos en la pagina de SqaTestDesing$")
    public void queNosEncontramosEnLaPaginaDeSqaTestDesing() {

        OnStage.theActorInTheSpotlight().wasAbleTo(Open.browserOn(sqaTestDesingUi));
    }

    @Cuando("^Elegimos el proyecto asignado$")
    public void elegimosElProyectoAsignado() {

        actor.attemptsTo(Imprimirdatos.on());

    }

    @Entonces("^Ingresamos los Casos de Pruebas$")
    public void ingresamosLosCasosDePruebas() {

    }

}
