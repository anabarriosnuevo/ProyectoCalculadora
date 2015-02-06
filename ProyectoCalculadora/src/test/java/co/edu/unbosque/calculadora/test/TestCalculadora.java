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
public class TestCalculadora {
    
    /**
     * Andres Romero
     */
    @Test
    public void operacionSuma() {
        System.out.println("iniciando prueba suma ");
        // String expr ="2+3";
        //String expr ="2+3+(1+5)";
        String expr ="-5+2+(1-2)+(9+1)";
        
        EvaluaExpresion evaluaExpresion = new EvaluaExpresion();
        evaluaExpresion.setExpresion(expr);
        EjecutaExpresion ejecutaExpresion = new EjecutaExpresion(evaluaExpresion);
        Invocador invocador = new Invocador(ejecutaExpresion);
        invocador.invocar();
        String resultado =evaluaExpresion.getResultado();
        Double numero = Double.parseDouble(resultado);
        //int aux =5;
        //int aux =11;
        int aux =6;
        Assert.assertTrue(numero==aux);
        
    }
    
    /**
     * Andres Romero
     * Se debe validar operacion suma algebraica, es decir sumas y restas
     */
    @Test
    public void operacionResta() {
        System.out.println("iniciando prueba resta ");
        //String expr ="2-3";
        //String expr ="2-3-(1-5)";
        String expr ="-5+2+(1-2)+(9-1)";
        
        EvaluaExpresion evaluaExpresion = new EvaluaExpresion();
        evaluaExpresion.setExpresion(expr);
        EjecutaExpresion ejecutaExpresion = new EjecutaExpresion(evaluaExpresion);
        Invocador invocador = new Invocador(ejecutaExpresion);
        invocador.invocar();
        String resultado =evaluaExpresion.getResultado();
        Double numero = Double.parseDouble(resultado);
        //int aux =-1;
        //int aux =3;
        int aux =4;
        Assert.assertTrue(numero==aux);
        
    }
    
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
    
    /**
     * Ana Maria
     */
    @Test
    public void operacionRaiz() {
        
        EvaluaExpresion evaluaExpresion = new EvaluaExpresion();
        System.out.println("Raiz cuadrada --> ");
        String expr = "Math.sqrt(25)";
        evaluaExpresion.setExpresion(expr);
        EjecutaExpresion ejecutaExpresion = new EjecutaExpresion(evaluaExpresion);
        Invocador invocador = new Invocador(ejecutaExpresion);
        invocador.invocar();
        String resultado = evaluaExpresion.getResultado();
        Double numero = Double.parseDouble(resultado);
        
        int resEsperado = 5;
        Assert.assertEquals(numero.intValue(), resEsperado);
        
    }
    
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

