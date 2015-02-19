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
public class TestCalculadoraPotencia {
    
    
     /**
     * Ana Maria
     */
    @Test
    public void operacionPotencia() {
        
        EvaluaExpresion evaluaExpresion = new EvaluaExpresion();
        System.out.println("Potenciacion --> ");
        String expr = "Math.pow(2,3)";
        evaluaExpresion.setExpresion(expr);
        EjecutaExpresion ejecutaExpresion = new EjecutaExpresion(evaluaExpresion);
        Invocador invocador = new Invocador(ejecutaExpresion);
        invocador.invocar();
        String resultado = evaluaExpresion.getResultado();
        Double numero = Double.parseDouble(resultado);
        
        int resEsperado = 8;
        Assert.assertEquals(numero.intValue(), resEsperado);
        
    }
}
