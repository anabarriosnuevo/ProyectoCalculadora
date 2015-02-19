package co.edu.unbosque.calculadora.logica;

/**
 * @ Clase que encapsula las propiedades que seran usadas dentro de la interfaz grafica de la calculadora
 * @author Ana Maria
 *
 */
public class EstadoValoresVista {

	private String expresion;
	private String formula;
	private boolean habilitarPunto;
	private String signo;
	private Double resultado;	
	private String memoria;

	/**
	 * Defualt Constructor
	 */
	public EstadoValoresVista() {

		habilitarPunto = true;
		expresion = "";
		signo = "";
		resultado = null;
		memoria = null;
	}

	/**
	 * @return the expresion
	 */
	public String getExpresion() {
		return expresion;
	}

	/**
	 * @param expresion the expresion to set
	 */
	public void setExpresion(String expresion) {
		this.expresion = expresion;
	}

	/**
	 * @return the formula
	 */
	public String getFormula() {
		return formula;
	}

	/**
	 * @param formula the formula to set
	 */
	public void setFormula(String formula) {
		this.formula = formula;
	}

	/**
	 * @return the habilitarPunto
	 */
	public boolean isHabilitarPunto() {
		return habilitarPunto;
	}

	/**
	 * @param habilitarPunto the habilitarPunto to set
	 */
	public void setHabilitarPunto(boolean habilitarPunto) {
		this.habilitarPunto = habilitarPunto;
	}

	/**
	 * @return the signo
	 */
	public String getSigno() {
		return signo;
	}

	/**
	 * @param signo the signo to set
	 */
	public void setSigno(String signo) {
		this.signo = signo;
	}

	/**
	 * @return the resultado
	 */
	public Double getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}

	/**
	 * @return the memoria
	 */
	public String getMemoria() {
		return memoria;
	}

	/**
	 * @param memoria the memoria to set
	 */
	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}



}
