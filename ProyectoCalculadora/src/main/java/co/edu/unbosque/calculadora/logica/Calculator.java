package co.edu.unbosque.calculadora.logica;



import co.edu.unbosque.gui.CalculadoraGUI;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


/**
 *
 * @author Ana Maria
 */
public class Calculator {
    
    private static Scanner sc;
    private static String resultado;
    
//    public static void main(String[] arg) {
//        
//        resultado = "Sin resultado";
//        sc = new Scanner(System.in);
//        
//        System.out.println("=============== CALCULADORA ===============");
//        System.out.println("\t\t Ingresar expresion ");
//        
//        System.out.println("\n Digite la expresión a evaluar: ");
//        String expr = sc.next();
//        
//        if (null == expr || "".equals(expr) || 0 == expr.length()) {
//            System.out.println("Debe digitar una expresion, programa terminado");
//        } else {
//            
//            EvaluaExpresion evaluaExpresion = new EvaluaExpresion();
//            evaluaExpresion.setExpresion(expr);
//            
//            EjecutaExpresion ejecutaExpresion = new EjecutaExpresion(evaluaExpresion);
//            Invocador invocador = new Invocador(ejecutaExpresion);
//            
//            invocador.invocar();
//            resultado = evaluaExpresion.getResultado();
//        }
//        
//        System.out.println("El resultado de la operación es: ".concat(resultado));
//        
//        System.exit(0);
//    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Calculadora");
                CalculadoraGUI calculadora = new CalculadoraGUI();
                frame.add(calculadora);
//                Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("../resources/calculadora.png"));
//                frame.setIconImage(icon);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setResizable(false);
                frame.addKeyListener(calculadora);
            }
        });
    }
}