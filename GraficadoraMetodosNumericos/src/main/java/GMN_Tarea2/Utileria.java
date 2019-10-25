/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GMN_Tarea2;

/**
 *
 * @author Aguilera Luzania José Luis.
 * @author Castro Márquez Francisco Javier.
 * @author Monge Tinoco Manuel Crisólogo.
 */
public class Utileria {
    
    // Inicio Función TruncarSignificativos ---------------------------------------------------------
    public static double TruncarSignificativos(double numero, int cifras_sign) {
        try {
            String auxiliar = Double.toString(numero);
            auxiliar = auxiliar.substring(0, auxiliar.indexOf('.') + cifras_sign + 1);

            return Double.parseDouble(auxiliar);
            
        } catch (Exception exception) {
            return numero;
        }
    }
    // Fin Función TruncarSignificativos ------------------------------------------------------------

}
