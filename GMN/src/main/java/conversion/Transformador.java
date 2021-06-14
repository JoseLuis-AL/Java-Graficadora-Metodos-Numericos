package conversion;

import java.awt.Point;

/**
 *
 * @author Aguilera Luzania José Luis.
 * @author Castro Márquez Francisco Javier.
 * @author Monge Tinoco Manuel Crisólogo.
 */
public class Transformador {

    // Limites de la ventana.
    public double xmin, xmax, ymin, ymax;
    // Limites del viewport (canvas).
    public double umin, umax, vmin, vmax;

    /**
     * Permite transformar las coordenadas (x, y) de un punto p para que puedan
     * ser proyectadaas en el viewport (canvas).
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param u1
     * @param v1
     * @param u2
     * @param v2
     */
    public Transformador(double x1, double y1, double x2, double y2,
            double u1, double v1, double u2, double v2) {
        // Coordenadas de la ventana.
        xmin = x1;
        ymin = y1;
        xmax = x2;
        ymax = y2;

        // Coordenadas del viewport (canvas).
        umin = u1;
        vmin = v1;
        umax = u2;
        vmax = v2;
    }

    /**
     * Proyecta un punto p, de coordenadas (x, y) en la ventana a coordenadas en
     * el viewport (canvas).
     *
     * @param x
     * @param y
     * @return Point(u,v)
     */
    public Point proyecta(double x, double y) {
        Point q;

        int u = (int) ((umax - umin) / (xmax - xmin) * (x - xmin) + umin);
        int v = (int) (vmax - ((vmax - vmin) / (ymax - ymin)) * (y - ymin));

        q = new Point(u, v);

        return q;
    }
}
