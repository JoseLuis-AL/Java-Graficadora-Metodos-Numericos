/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GMN_Tarea2;

import java.awt.Point;

/**
 *
 * @author Aguilera Luzania José Luis.
 * @author Castro Márquez Francisco Javier.
 * @author Monge Tinoco Manuel Crisólogo.
 */
public class Transforma {
      public double xmin, xmax, ymin, ymax;  // Limites de la ventana
    public double umin, umax, vmin, vmax;  // Limites del viewport (canvas)

    /*
     * Constructor
     */
    public Transforma(double x1, double y1, double x2, double y2,
                      double u1, double v1, double u2, double v2)
    {
        // Ventana
        xmin = x1;
        ymin = y1;
        xmax = x2;
        ymax = y2;

        // Viewport
        umin = u1;
        vmin = v1;
        umax = u2;
        vmax = v2;
    }

    /*
     * Proyecta un punto, p, de coordenadas en la ventana a coordenadas
     * en el viewport 
     */
    public Point proyecta (double x, double y)
    {
        Point q;

        int u = (int) ((umax - umin) / (xmax - xmin) * (x - xmin) + umin);
        int v = (int) (vmax - ((vmax - vmin) / (ymax - ymin)) * (y - ymin));

        q = new Point(u, v);

        return q;
    }
}
