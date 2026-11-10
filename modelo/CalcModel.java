package modelo;

import java.math.BigDecimal; 

public class CalcModel {

    private static final String INITIAL_VALUE = "1";
    private BigDecimal m_total; /*Variable que almacena el total actual de la calculadora */

    /*private boolean esPrimerValor = true; Bandera para saber si es la primera operación */
//constructor

    public CalcModel() {
        reset(); 
    }
   

    public void reset() {
        m_total = new BigDecimal(INITIAL_VALUE); /*regrsa al valor 1.0 */
        
    }

    public void multiplyBy(String operand) { /*El metodo multiplica el total actual por el número ingresado cadena */
        m_total = m_total.multiply(new BigDecimal(operand)); //convierte a bigdecimal  y realisa la multi.
      
    }

    public void setValue(String value) { //asigna valor especificvo convirtiendo de texto a bigdeci//
        m_total = new BigDecimal(value);
    }

    public String getValue() { // Devuelve el valor actual del total convertido a String para que la vista pueda mostrarlo
        return m_total.toString();
    }
}
