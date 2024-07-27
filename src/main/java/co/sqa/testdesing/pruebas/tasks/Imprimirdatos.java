package co.sqa.testdesing.pruebas.tasks;

import co.sqa.testdesing.pruebas.utils.DatosExcelListas;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@SuppressWarnings("resource")
public class Imprimirdatos implements Task {
    private static ArrayList<Map<String, String>> datos = new ArrayList<Map<String, String>>();

    @Override
    public <T extends Actor> void performAs(T actor) {
        String fileName="Datos.xlsx";
        try {
            datos = DatosExcelListas.leerExcel("Datos.xls", "Hoja1");
            System.out.println(datos.get(0).get("Usuario"));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Hoja1");
        for (int j = 0; j < 2; j++) {
            XSSFRow row = sheet.createRow(0);
            for (int i = 0; i < datos.size(); i++) {
                XSSFCell cell = row.createCell(i);
                cell.setCellValue(datos.get(i).get("Usuario"));
                try {
                    FileOutputStream fos = null;
                    File file;

                    file = new File(fileName);
                    fos = new FileOutputStream(file);

                    workbook.write(fos);
                    workbook.close();
                    fos.close();
                    System.out.println("Finalizado");

                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println(e.getMessage());
            }

            }
        }


    }

    public static Performable on() {
        return Instrumented.instanceOf(Imprimirdatos.class).withProperties();
    }
}



