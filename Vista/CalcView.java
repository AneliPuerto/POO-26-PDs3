package Vista;
import modelo.CalcModel;
import javax.swing.*; //es para componentes graficos
import java.awt.*;/*diseño */
import java.awt.event.ActionListener; /*botones eventos*/

public class CalcView extends JFrame {
    private static final String INITIAL_VALUE = "0";

    private JTextField m_userInputTf = new JTextField(5); 
    private JTextField m_totalTf = new JTextField(20); 
    private JButton m_multiplyBtn = new JButton("Multiply"); 
    private JButton m_sumaBtn = new JButton("Suma"); 
    private JButton m_clearBtn = new JButton("Clear"); 
    
    private CalcModel m_model;


    /*Constructor */
    public CalcView(CalcModel model) {
        m_model = model;
       
        m_totalTf.setText(INITIAL_VALUE); 
        m_totalTf.setEditable(false); 


        // Configura el panel principal 
        JPanel content = new JPanel(); 
        content.setLayout(new FlowLayout()); 

        // Añade los componentes visuales en el orden de la interfaz
        content.add(new JLabel("Input"));
        content.add(m_userInputTf);
        content.add(m_multiplyBtn);
        content.add(m_sumaBtn);
        content.add(new JLabel("Total"));
        content.add(m_totalTf);
        content.add(m_clearBtn);

        this.setContentPane(content);
        this.pack(); 
        this.setTitle("Calculadora"); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    public void reset() {
        m_totalTf.setText(INITIAL_VALUE);
    }

    public String getUserInput() {
        return m_userInputTf.getText();
    }

    public void setTotal(String newTotal) {
        m_totalTf.setText(newTotal);
    }
// Muestra una ventana emergente de error (JOptionPane) si ocurre algún fallo
    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    public void addMultiplyListener(ActionListener mal) {
        m_multiplyBtn.addActionListener(mal);
    }
     public void addSumaListener(ActionListener sal) {
    m_sumaBtn.addActionListener(sal);
    }

    public void addClearListener(ActionListener cal) {
        m_clearBtn.addActionListener(cal);
    }
}