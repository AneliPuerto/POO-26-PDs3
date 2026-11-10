package controlador;

import modelo.CalcModel;
import Vista.CalcView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcController {
    private CalcModel m_model;
    private CalcView m_view;
// Constructor del Controlador*/
    public CalcController(CalcModel model, CalcView view) {
        m_model = model;
        m_view = view;
// Registra las acciones al hacer clic en los botones
        m_view.addMultiplyListener(new MultiplyListener());
        m_view.addClearListener(new ClearListener());
    }
/*lógica cuando se presiona el botón "Multiply"*/
    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                /* obtiene el texto ingresado por el usuario desde la Vista*/ 
                userInput = m_view.getUserInput();
                m_model.multiplyBy(userInput); /*Le ordena al Modelo que multiplique el total por ese texto*/
                m_view.setTotal(m_model.getValue()); // obtiene el resultado actualizado del Modelo y se lo manda a la Vista para que lo muestre
            } catch (NumberFormatException nfex) {
                /* Captura el error he imprime*/ 
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    } 
//maneja la lógica cuando se presiona el botón "Clear"
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_model.reset(); // Reinicia los datos en el Modelo
            m_view.reset(); // Reinicia la interfaz visual en la Vista
        }
    }
}