/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.unbosque.calculadora.test;

import co.edu.unbosque.calculadora.command.EjecutaExpresion;
import co.edu.unbosque.calculadora.command.EvaluaExpresion;
import co.edu.unbosque.calculadora.command.Invocador;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Ana Maria
 */
public class TestCalculadoraTrigonometicas {
    
    /**
     * Ana Maria
     */
    @Test
    public void operacionSeno() {
        
        EvaluaExpresion evaluaExpresion = new EvaluaExpresion();
        System.out.println("Funcion Seno --> ");
        String expr = "Math.sin(0)";
        evaluaExpresion.setExpresion(expr);
        EjecutaExpresion ejecutaExpresion = new EjecutaExpresion(evaluaExpresion);
        Invocador invocador = new Invocador(ejecutaExpresion);
        invocador.invocar();
        String resultado = evaluaExpresion.getResultado();
        Double numero = Double.parseDouble(resultado);
        
        int resEsperado = 0;
        Assert.assertEquals(numero.intValue(), resEsperado);
        
    }
    
    /**
     * Ana Maria
     */
    @Test
    public void operacionCoseno() {
        
        EvaluaExpresion evaluaExpresion = new EvaluaExpresion();
        System.out.println("Funcion Coseno --> ");
        String expr = "Math.cos(0)";
        evaluaExpresion.setExpresion(expr);
        EjecutaExpresion ejecutaExpresion = new EjecutaExpresion(evaluaExpresion);
        Invocador invocador = new Invocador(ejecutaExpresion);
        invocador.invocar();
        String resultado = evaluaExpresion.getResultado();
        Double numero = Double.parseDouble(resultado);
        
        int resEsperado = 1;
        Assert.assertEquals(numero.intValue(), resEsperado);
        
    }
    
    /**
     * Ana Maria
     */
    @Test
    public void operacionTangente() {
        
        EvaluaExpresion evaluaExpresion = new EvaluaExpresion();
        System.out.println("Funcion Tangente --> ");
        String expr = "Math.tan(0)";
        evaluaExpresion.setExpresion(expr);
        EjecutaExpresion ejecutaExpresion = new EjecutaExpresion(evaluaExpresion);
        Invocador invocador = new Invocador(ejecutaExpresion);
        invocador.invocar();
        String resultado = evaluaExpresion.getResultado();
        Double numero = Double.parseDouble(resultado);
        
        int resEsperado = 0;
        Assert.assertEquals(numero.intValue(), resEsperado);
        
    }
}
