package co.edu.unbosque.calculadora.logica;

import co.edu.unbosque.calculadora.command.EvaluaExpresion;
import co.edu.unbosque.calculadora.command.Invocador;
import co.edu.unbosque.calculadora.command.EjecutaExpresion;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author Ana Maria
 *
 */
public class OperacionesCalculadora {
    
    /**
     * Defualt Constructor
     */
    public OperacionesCalculadora() {
        
    }
    
    /**
     *
     * @param expresion
     * @return
     * @throws ScriptException
     */
    public Double operar(String expresion) throws ScriptException {
        
        EvaluaExpresion evaluaExpresion = new EvaluaExpresion();
        evaluaExpresion.setExpresion(expresion);
        
        EjecutaExpresion ejecutaExpresion = new EjecutaExpresion(evaluaExpresion);
        Invocador invocador = new Invocador(ejecutaExpresion);
        
        invocador.invocar();
        String resultado = evaluaExpresion.getResultado();
        
        return Double.parseDouble(resultado);
    }
    
    
}
