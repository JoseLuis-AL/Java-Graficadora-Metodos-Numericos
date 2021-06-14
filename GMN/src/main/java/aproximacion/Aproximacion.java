package aproximacion;

/**
 *
 * @author Aguilera Luzania José Luis.
 * @author Castro Márquez Francisco Javier.
 * @author Monge Tinoco Manuel Crisólogo.
 */
public class Aproximacion {

    public static double f(double x) {
        return 0.5 * Math.pow(x, 2) - 2.5;
    }

    public static double df(double x) {
        return x;
    }

    public static boolean hayCambioDeSigno(double a, double b) {
        return f(a) * f(b) < 0;
    }

    private static boolean esRaiz(double x) {
        return f(x) == 0;
    }

    /**
     * Utiliza el método de bisección para calcular la mejor aproximación de la
     * raíz de la función f con un error de truncamiento.
     *
     * @param a Límite inferior del intervalo.
     * @param b Límite superior del intervalo.
     * @param error Error de truncamiento.
     * @return
     */
    public static double Biseccion(double a, double b, double error) {
        if (esRaiz(a)) {
            return a;
        }
        if (esRaiz(b)) {
            return b;
        }

        if (!hayCambioDeSigno(a, b)) {
            throw new IllegalArgumentException("---> ERROR: No tiene raíz.");
        }

        double a_n = a;
        double b_n = b;
        double x_n = (a + b) / 2.0;
        double fx_n = 1;

        int iteraciones = (int) (Math.log((b - a) / error) / Math.log(2)) + 1;

        System.out.println("Iter: " + iteraciones);

        try {

            for (int i = 0; i < iteraciones; i++) {
                x_n = (a_n + b_n) / 2.0;
                fx_n = f(x_n);

                b_n = (f(a_n) * fx_n < 0) ? x_n : b_n;
                a_n = (f(b_n) * fx_n < 0) ? x_n : a_n;

                if (fx_n == 0) {
                    break;
                }
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("---> ERROR: No fue posible completar el algorito.");
        }

        return x_n;
    }

    /**
     * Utiliza el método de Newton-Raphson para calcular le mejor aproximación
     * de la raíz de la función f.
     *
     * @param x_0 Valor inicial de x.
     * @return
     */
    public static double NewtonRaphson(double x_0) {
        if (esRaiz(x_0)) {
            return x_0;
        }

        int iteraciones = 100;
        double x_n = x_0 - (f(x_0) / df(x_0));

        try {

            for (int i = 0; i < iteraciones; i++) {
                x_n -= (f(x_n) / df(x_n));
                if (esRaiz(x_n)) {
                    break;
                }
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("---> ERROR: No fue posible completar el algorito.");
        }

        return x_n;
    }
}
