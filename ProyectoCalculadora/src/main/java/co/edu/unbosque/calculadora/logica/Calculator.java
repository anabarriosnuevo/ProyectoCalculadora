package co.edu.unbosque.calculadora.logica;



import java.util.Scanner;


/**
 *
 * @author Ana Maria
 */
public class Calculator {
    
    private static Scanner sc;
    private static String resultado;
    
    public static void main(String[] arg) {
        
        resultado = "Sin resultado";
        sc = new Scanner(System.in);
        
        System.out.println("=============== CALCULADORA ===============");
        System.out.println("\t\t Ingresar expresion ");
        
        System.out.println("\n Digite la expresión a evaluar: ");
        String expr = sc.next();
        
        if (null == expr || "".equals(expr) || 0 == expr.length()) {
            System.out.println("Debe digitar una expresion, programa terminado");
        } else {
            
            EvaluaExpresion evaluaExpresion = new EvaluaExpresion();
            evaluaExpresion.setExpresion(expr);
            
            EjecutaExpresion ejecutaExpresion = new EjecutaExpresion(evaluaExpresion);
            Invocador invocador = new Invocador(ejecutaExpresion);
            
            invocador.invocar();
            resultado = evaluaExpresion.getResultado();
        }
        
        System.out.println("El resultado de la operación es: ".concat(resultado));
        
        System.exit(0);
    }
}