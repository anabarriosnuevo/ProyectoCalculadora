package co.edu.unbosque.calculadora.command;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


/**
 *
 * @author Ana Maria
 */
public class EvaluaExpresion {
    
    private String expresion;
    private String resultado;
    
    /**
     *
     */
    public EvaluaExpresion() {
        this.expresion = null;
        this.resultado = "Sin Resultado";
    }
    
    
    public void evaluar() {
        
        try {
            if (null == expresion) {
                return;
            }
            
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            
            this.resultado = engine.eval(expresion).toString();
        } catch (ScriptException ex) {
            this.resultado = "Expresión inválida";
        }
        
    }
    
    /**
     *
     * @return
     */
    public String getExpresion() {
        return expresion;
    }
    
    /**
     *
     * @param expresion
     */
    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }
    
    /**
     *
     * @return
     */
    public String getResultado() {
        return resultado;
    }
    
    /**
     *
     * @param resultado
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
