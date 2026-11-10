import modelo.CalcModel;
import Vista.CalcView;
import controlador.CalcController;

public class CalcMVC {
    public static void main(String[] args) {
        CalcModel model = new CalcModel(); //instancia del Modelo 
        CalcView view = new CalcView(model);//se crea la vista que depende del modelo
        CalcController controlador = new CalcController(model, view); /*Crea el Controlador, que depende del modelo y vista*/

        view.setVisible(true);/*vista para el usuario */
    }
}