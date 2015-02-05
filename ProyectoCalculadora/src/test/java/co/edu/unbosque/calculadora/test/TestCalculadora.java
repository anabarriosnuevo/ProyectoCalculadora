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
 * @author abarriosnuevo
 */
public class TestCalculadora {
    
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
            int numero = Integer.parseInt(resultado);
            //int aux =5;
            //int aux =11;
            int aux =6;
            Assert.assertTrue(numero==aux);    
        
    }
    
    /**
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
            int numero = Integer.parseInt(resultado);
            //int aux =-1;
            //int aux =3;
           int aux =4;
            Assert.assertTrue(numero==aux); 
        
    }
    
    @Test
    public void operacionMultiplicacion() {
        
    }
    
    @Test
    public void operacionDivision() {
        
    }
    
    @Test
    public void operacionPotencia() {
        
    }
    
}
