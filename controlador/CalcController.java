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

        m_view.addMultiplyListener(new MultiplyListener());
         m_view.addSumaListener(new SumaListener());
        m_view.addClearListener(new ClearListener());
    }
   
    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                /*obtiene el texto ingresado por el usuario desde la Vista*/ 
                userInput = m_view.getUserInput();
                m_model.multiplyBy(userInput); 
                m_view.setTotal(m_model.getValue()); 
            } catch (NumberFormatException nfex) {
                
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    } 
       class SumaListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String userInput = "";
        try {
            userInput = m_view.getUserInput();
            m_model.addBy(userInput); // Llama al método de suma del modelo
            m_view.setTotal(m_model.getValue());
        } catch (NumberFormatException nfex) {
            m_view.showError("Bad input: '" + userInput + "'");
        }
    }
}
//maneja la lógica cuando se presiona el botón "Clear"
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_model.reset(); 
            m_view.reset(); 
        }
    }
}