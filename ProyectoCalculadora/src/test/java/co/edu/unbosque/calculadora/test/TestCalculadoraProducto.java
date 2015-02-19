/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.unbosque.calculadora.test;

import co.edu.unbosque.calculadora.logica.EjecutaExpresion;
import co.edu.unbosque.calculadora.logica.EvaluaExpresion;
import co.edu.unbosque.calculadora.logica.Invocador;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Ana Maria
 */
public class TestCalculadoraProducto  {
    
    
    /**
     * Andres Romero
     */
    @Test
    public void operacionMultiplicacion() {
        System.out.println("iniciando prueba Multiplicacion ");
        //String expr ="2*3";
        // String expr ="2*3+(1*5)";
        String expr ="-5*2+(1-2)+(9*1)";
        
        EvaluaExpresion evaluaExpresion = new EvaluaExpresion();
        evaluaExpresion.setExpresion(expr);
        EjecutaExpresion ejecutaExpresion = new EjecutaExpresion(evaluaExpresion);
        Invocador invocador = new Invocador(ejecutaExpresion);
        invocador.invocar();
        String resultado =evaluaExpresion.getResultado();
        Double numero = Double.parseDouble(resultado);
        //int aux =6;
        //int aux =11;
        int aux =-2;
        Assert.assertTrue(numero==aux);
        
    }
}
