package co.sqa.testdesing.pruebas.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://testdesign.sqasa.co/login.php?note=logout")
public class SqaTestDesingUi extends PageObject {

    public static final Target TXT_NAMELOGIN = Target.the("Ingreso Nombre del Usuario").locatedBy("//input[@name=\"tl_login\"]");
    public static final Target TXT_PASSWORD = Target.the("Ingreso Clave").locatedBy("//input[@name=\"tl_password\"]");
    public static final Target BTN_LOGIN = Target.the("Click Boton Login").locatedBy("//input[@name=\"login_submit\"]");


}