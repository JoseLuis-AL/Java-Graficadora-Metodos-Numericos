package gmn;

import com.formdev.flatlaf.FlatLightLaf;

/**
 *
 * @author Aguilera Luzania José Luis.
 * @author Castro Márquez Francisco Javier.
 * @author Monge Tinoco Manuel Crisólogo.
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatLightLaf.setup();
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.crear();
    }
}
