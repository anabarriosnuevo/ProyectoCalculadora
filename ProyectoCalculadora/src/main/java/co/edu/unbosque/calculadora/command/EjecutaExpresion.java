package co.edu.unbosque.calculadora.command;


/**
 *
 * @author Ana Maria
 */
public class EjecutaExpresion implements Comando {
    
    private final EvaluaExpresion evaluaExpresion;

    /**
     * 
     * @param evaluaExpresion 
     */
    public EjecutaExpresion(EvaluaExpresion evaluaExpresion) {
        this.evaluaExpresion = evaluaExpresion;
    }    
    

    /**
     * 
     */
    @Override
    public void ejecutarComando() {
        this.evaluaExpresion.evaluar();
    }
    
}
