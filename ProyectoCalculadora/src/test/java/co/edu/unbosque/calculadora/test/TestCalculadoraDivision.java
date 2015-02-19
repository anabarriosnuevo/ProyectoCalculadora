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
public class TestCalculadoraDivision {
    
    
     /**
     * Andres Romero
     */
    @Test
    public void operacionDivision() {
        
        System.out.println("iniciando prueba Division ");
        //String expr ="4/2";
        //String expr ="4*3/(1+2)";
        String expr ="(-5*-2+(1-3))/(8*1)";
        
        EvaluaExpresion evaluaExpresion = new EvaluaExpresion();
        evaluaExpresion.setExpresion(expr);
        EjecutaExpresion ejecutaExpresion = new EjecutaExpresion(evaluaExpresion);
        Invocador invocador = new Invocador(ejecutaExpresion);
        invocador.invocar();
        String resultado = evaluaExpresion.getResultado();
        Double numero = Double.parseDouble(resultado);
        //int aux =2;
        //int aux =4;
        int aux =1;
        Assert.assertTrue(numero==aux);
        
    }
}
