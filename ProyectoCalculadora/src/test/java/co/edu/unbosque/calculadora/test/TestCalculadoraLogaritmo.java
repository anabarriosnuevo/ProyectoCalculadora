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
public class TestCalculadoraLogaritmo {
    
        /**
     * Ana Maria
     */
    @Test
    public void operacionLogaritmo() {
        
        EvaluaExpresion evaluaExpresion = new EvaluaExpresion();
        System.out.println("Funcion Logaritmo --> ");
        String expr = "Math.log(10)";
        evaluaExpresion.setExpresion(expr);
        EjecutaExpresion ejecutaExpresion = new EjecutaExpresion(evaluaExpresion);
        Invocador invocador = new Invocador(ejecutaExpresion);
        invocador.invocar();
        String resultado = evaluaExpresion.getResultado();
        Double numero = Double.parseDouble(resultado);
        System.out.println("numero" + numero);
        Double resEsperado = 2.302585092994046;
        Assert.assertEquals(numero, resEsperado);
        
    }
    
}
