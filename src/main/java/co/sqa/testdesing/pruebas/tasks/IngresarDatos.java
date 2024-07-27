package co.sqa.testdesing.pruebas.tasks;


import co.sqa.testdesing.pruebas.utils.DatosExcelListas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


import static co.sqa.testdesing.pruebas.userinterface.SqaTestDesingUi.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarDatos implements Task {


    private static ArrayList<Map<String, String>> datos = new ArrayList<Map<String, String>>();

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            datos = DatosExcelListas.leerExcel("Datos.xls", "Ingresar");
            actor.attemptsTo(
                    Enter.theValue(datos.get(0).get("Usuario")).into(TXT_NAMELOGIN),
                    Enter.theValue(datos.get(0).get("Contraseña")).into(TXT_PASSWORD),
                    Click.on(BTN_LOGIN)

            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static IngresarDatos inicioSesion(){return instrumented(IngresarDatos.class);}
}
