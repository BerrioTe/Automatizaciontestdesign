package co.sqa.testdesing.pruebas.tasks;

import co.sqa.testdesing.pruebas.utils.DatosExcelListas;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static co.sqa.testdesing.pruebas.userinterface.PaginaDeTareas.*;

public class SeleccionProyecto implements Task {

    private static ArrayList<Map<String, String>> datos = new ArrayList<Map<String, String>>();

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            datos = DatosExcelListas.leerExcel("Datos.xlsx", "Ingresar");

            actor.attemptsTo(
                Switch.toParentFrame(),
                Switch.toFrame("titlebar"),
                Click.on(LIST_PROYECTOS),
                Click.on(OPTN_PROYECTOS.of(datos.get(0).get("Proyecto")))
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Performable on() {
        return Instrumented.instanceOf(SeleccionProyecto.class).withProperties();
    }
}

