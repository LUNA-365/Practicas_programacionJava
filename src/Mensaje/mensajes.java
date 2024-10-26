/*
 */
package Mensaje;
import javax.swing.JOptionPane;

public class mensajes {
    private JOptionPane ms = new JOptionPane();

    public JOptionPane getMs() {
        return this.ms;
    }

    public void setMs(JOptionPane ms) {
        this.ms = ms;
    }
    
    public String entrada(String mensaje){
        String enter = this.getMs().showInputDialog(mensaje);
        return enter;
    }
    
    public int entradaInt(String mensaje){
        String enter = this.getMs().showInputDialog(mensaje);
        int x = Integer.parseInt(enter);
        return x;
    }
    
    public void mensaje(String mensaje){
        this.getMs().showMessageDialog(null,mensaje);
    }
    
    public String mostrar(String mensaje){
        this.getMs().showMessageDialog(null,mensaje+"\n");
        return mensaje;
    }
}
