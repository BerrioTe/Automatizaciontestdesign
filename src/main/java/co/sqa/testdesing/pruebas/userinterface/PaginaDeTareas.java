package co.sqa.testdesing.pruebas.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaDeTareas {
    public static final Target LIST_PROYECTOS = Target.the("Ingreso Nombre del Usuario").locatedBy("//select[@name=\"testproject\"]");
    public static final Target OPTN_PROYECTOS = Target.the("Ingreso Nombre del Usuario").locatedBy("//option[contains(text(), '{0}')]");

}
