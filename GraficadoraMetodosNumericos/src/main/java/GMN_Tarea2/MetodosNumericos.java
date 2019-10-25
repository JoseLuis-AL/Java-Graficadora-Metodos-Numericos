package GMN_Tarea2;

/**
 *
 * @author Aguilera Luzania José Luis.
 * @author Castro Márquez Francisco Javier.
 * @author Monge Tinoco Manuel Crisólogo.
 */
public class MetodosNumericos {
    
    // Inicio Función F -----------------------------------------------------------------------------
    public static double F(double _x) { return Math.pow(_x, 2) - 2; }
    // Fin Función F --------------------------------------------------------------------------------
    
    // Inicio Función F -----------------------------------------------------------------------------
    public static double Df(double _x) { return 2 * _x; }
    // Fin Función F --------------------------------------------------------------------------------
    
    // Inicio Función HayCambioDeSigno --------------------------------------------------------------
    public static Boolean HayCambioDeSigno(double _a, double _b) { return F(_a)*F(_b) < 0; }
    // Fin Función HayCambioDeSigno -----------------------------------------------------------------

    
    // Inicio Función EsRaiz ------------------------------------------------------------------------
    public static Boolean EsRaiz(double _x) { return F(_x) == 0; }
    // Fin Función EsRaiz ---------------------------------------------------------------------------
    
    
    // Inicio Función Biseccion ---------------------------------------------------------------------
    public static double Biseccion(double _a, double _b, double _errorDeTruncamiento)
    {
        // Comprobamos que el extremo _a del interavlo no sea raíz, si lo es, regresamos _a.
        if (!EsRaiz(_a)) {
            
            // Comprobamos que el extremo _b del interavlo no sea raíz, si lo es, regresamos _b.
            if (!EsRaiz(_b)) {
                
                // Comprobamos cambio de signo en el intervalo.
                if (HayCambioDeSigno(_a, _b)) {
                    
                    // Declaramos las variables a utilizar durante el proceso.
                    double a_n = _a, b_n = _b;
                    double x_n = (a_n + b_n) / 2, fx_n = 1;
                    
                    // Calculamos el número de iteraciones a realizar.
                    int numeroDeIteraciones = (int)( Math.log((_b - _a) / _errorDeTruncamiento) / Math.log(2) ) + 1;
                    
                    // Inicializamos el número de iteraciones actuales.
                    int iteraciones = 0;
                    while (iteraciones < numeroDeIteraciones) 
                    {
                        
                        // Intentamos ejecutar el algoritmo sobre la función.
                        try {
                            // Calculamos nuestra x_n.
                            x_n = (a_n + b_n) / 2;

                            fx_n = F(x_n);

                            b_n = (F(a_n)*fx_n < 0) ? x_n : b_n;
                            a_n = (F(b_n)*fx_n < 0) ? x_n : a_n;
                            
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        
                        // Si nuestra x_n no es una raíz, continuamos con la siguiente iteración.
                        iteraciones = (fx_n == 0) ? numeroDeIteraciones : ++iteraciones;
                    }
                    
                    return x_n;
                }
                
                throw new IllegalArgumentException("---> ERROR: No tiene raíz.");
                
            } else {
                return _b;
            }
        } else {
            return _a;
        }
    }
    // Fin Función Biseccion ------------------------------------------------------------------------
    
    
    // Inicio Función NewtonRaphson -----------------------------------------------------------------
    public static double NewtonRaphson(double _x0) 
    {
        // Revisamos si x0 es raíz, si lo es regresamos la raíz, si no lo es, calculamos con newton.
        if (!EsRaiz(_x0)) {
            
            // Definimos el número máximo de iteraciones.
            int iteracionesMaximas = 100;
            
            // Definimos las variables a utilizar durante el proceso
            double x_n = 0.0;
            
            // Ejecutamos el algoritmo sobre la función.
            try {
                x_n = _x0 - (F(_x0) / Df(_x0));
                
                // Ciclo para calcular la raíz.
                for (int iteracion = 0; iteracion < iteracionesMaximas; ++iteracion) {

                    // Calculamos x_n
                    x_n = x_n - (F(x_n) / Df(x_n));

                    // Comprobamos si x_n es raiz.
                    if (EsRaiz(x_n)) break;
                }
                
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            
            
            return x_n;
            
        } else {
            return _x0;
        }
    }
    // Fin Función NewtonRaphson --------------------------------------------------------------------

    
}
