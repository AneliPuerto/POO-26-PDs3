package modelo;
import java.math.BigDecimal;

public class CalcModel {
    private static final String INITIAL_VALUE = "0"; // Iniciamos en 0 para que la suma funcione bien al arrancar
    private BigDecimal m_total;
    private boolean m_primeraOperacion = true; // Bandera para saber si es la primera operación

    public CalcModel() {
        reset();
    }

    public void reset() {
        m_total = new BigDecimal(INITIAL_VALUE);
        m_primeraOperacion = true;
    }


    // Función para sumar//
    public void addBy(String operand) {
        BigDecimal numeroIngresado = new BigDecimal(operand);
        if (m_primeraOperacion) {
            m_total = numeroIngresado; 
            m_primeraOperacion = false;
        } else {
            m_total = m_total.add(numeroIngresado); // Suma acumulativa
        }
    }

    // Función para multiplicar
    public void multiplyBy(String operand) {
        BigDecimal numeroIngresado = new BigDecimal(operand); 
        if (m_primeraOperacion) {
            m_total = numeroIngresado; 
            m_primeraOperacion = false;
        } else {
            m_total = m_total.multiply(numeroIngresado); // Multiplicación acumulativa
        }
    }

    public void setValue(String value) {
        m_total = new BigDecimal(value);
    }

    public String getValue() {
        return m_total.toString();
    }
}