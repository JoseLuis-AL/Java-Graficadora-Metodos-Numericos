/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GMN_Tarea2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 *
 * @author Aguilera Luzania José Luis.
 * @author Castro Márquez Francisco Javier.
 * @author Monge Tinoco Manuel Crisólogo.
 */
public class MainPanel extends javax.swing.JPanel {
    
    /** VARIABLES **/
    // Dimensiones del plano.
    private int xMin = -20, xMax = 20, yMin = -20, yMax = 20;
    
    // Arreglos para guardar los puntos de la función.
    private ArrayList<Point2D.Double> puntosFuncion = new ArrayList();
    
    
    /** CONSTRUCTOR**/
    public MainPanel() {
        initComponents();
        
        Evalua();
    }
    
    // Inicio Función Evalua ------------------------------------------------------------------------
    public void Evalua() {
        
        for (int x = xMin; x <= xMax; x++) {
            puntosFuncion.add(new Point2D.Double(x, (MetodosNumericos.F(x)) ));
        }
        
    }
    // Fin Función Evalua ---------------------------------------------------------------------------
    
    // Inicio Función Grafica -----------------------------------------------------------------------
    public void Grafica(int _ancho, int _alto, Graphics _graphics) {
        
        // Borramos la pantalla.
        _graphics.setColor(Color.white);
        _graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        Transforma transforma = new Transforma(xMin, yMin,
                                               xMax, yMax, 
                                               0, 0,
                                               this.getWidth(), this.getHeight());
        
        // Dibujar la cuadricula.
        _graphics.setColor(Color.lightGray);
        
        int escalaAncho = this.getWidth() / 40;
        int escalaAlto = this.getHeight() / 40;
        
        int inicioCicloAnchura = this.getWidth() / 2;
        int inicioCicloAltura = this.getHeight() / 2;
        
        for (int i = inicioCicloAltura; i < this.getHeight(); i += escalaAlto)
            _graphics.drawLine(0, i, this.getWidth(), i);
        
        for (int i = inicioCicloAltura; i > 0; i -= escalaAlto)
            _graphics.drawLine(0, i, this.getWidth(), i);
        
        for (int i = inicioCicloAnchura; i < this.getWidth(); i+= escalaAncho)
            _graphics.drawLine(i, 0, i, this.getHeight());
        
        for(int i = inicioCicloAnchura; i > 0; i -= escalaAncho)
            _graphics.drawLine(i, 0, i, this.getHeight());
        
           
        // Graficamos la función
        _graphics.setColor(Color.blue);
        
        for (int i = 0; i < puntosFuncion.size() - 1; ++i) {
            
            Point2D.Double p = puntosFuncion.get(i);
            Point2D.Double q = puntosFuncion.get(i + 1);
            
            Point r = transforma.proyecta(p.x, p.y);
            Point s = transforma.proyecta(q.x, q.y);
            
            _graphics.drawLine(r.x, r.y, s.x, s.y);
        }
        
        // Dibujar los ejes.
        _graphics.setColor(Color.black); // Asignar el color del eje.
        
        // Dibujar el eje X.
        Point punto1 = transforma.proyecta(xMin, 0);
        Point punto2 = transforma.proyecta(xMax, 0);
        
        _graphics.drawLine(punto1.x, punto1.y, punto2.x, punto2.y);
        
        // Dibujar el eje Y.
        punto1 = transforma.proyecta(0, yMin);
        punto2 = transforma.proyecta(0, yMax);
        
        _graphics.drawLine(punto1.x, punto1.y, punto2.x, punto2.y);
        
    }
    // Fin Función Grafica --------------------------------------------------------------------------   
    
    
    // Inicio Función EstablecerRaiz ----------------------------------------------------------------
    public void DibujarRaiz(double _xs) 
    { 
        Graphics graphics = this.getGraphics();
        
        // Redibujamos la grafica y la función.
        Grafica(this.getWidth(), this.getHeight(), graphics);
        
        Transforma transforma = new Transforma(xMin, yMin,
                                               xMax, yMax, 
                                               0, 0,
                                               this.getWidth(), this.getHeight());
        
        // Pintar la raíz.
        graphics.setColor(Color.red);
        Point r = transforma.proyecta(_xs - 1, 1);
        Point s = transforma.proyecta(_xs + 1, -1);
        
        graphics.drawLine(r.x, r.y, s.x, s.y);
        
        r = transforma.proyecta(_xs + 1, 1);
        s = transforma.proyecta(_xs - 1, -1);
        
        graphics.drawLine(r.x, r.y, s.x, s.y);
    }
    // Fin Función EstablecerRaiz -------------------------------------------------------------------

    
    // Inicio Función paint -------------------------------------------------------------------------
     @Override
    public void paint(Graphics _graphics)
    {
        Grafica(this.getWidth(), this.getHeight(), _graphics);
    }
    // Fin Función paint ----------------------------------------------------------------------------


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
