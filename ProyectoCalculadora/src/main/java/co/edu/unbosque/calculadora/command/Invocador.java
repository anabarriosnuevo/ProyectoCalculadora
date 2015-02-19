package co.edu.unbosque.calculadora.command;


/**
 *
 * @author Ana Maria
 */
public class Invocador {
    
    private Comando comando;

    /**
     * 
     * @param comando 
     */
    public Invocador(Comando comando) {
        this.comando = comando;
    }

    /**
     * 
     * @param comando 
     */
    public void setComando(Comando comando) {
        this.comando = comando;
    }
    
    /**
     * 
     */
    public void invocar() {
        this.comando.ejecutarComando();
    }
    
}
