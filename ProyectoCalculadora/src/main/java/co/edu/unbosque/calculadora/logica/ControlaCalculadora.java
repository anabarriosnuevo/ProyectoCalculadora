package co.edu.unbosque.calculadora.logica;

/**
 * @author Ana Maria
 *
 */
import java.util.HashSet;
import java.util.Set;

import javax.script.ScriptException;

public class ControlaCalculadora {
    
    private final Set<String> numeros = new HashSet<>();
    private final Set<String> operacionesArit = new HashSet<>();
    private final Set<String> memorias = new HashSet<>();
    private static final String PUNTO = ".";
    private static final String IGUAL = "=";
    public static final String RETROCESO_LABEL = "←";
    public static final String LIMPIAR_TODO_LABEL = "C";
    public static final String LIMPIAR_FORMULA_LABEL = "CE";
    public static final String CAMBIO_SIGNO = "±";
    public static final String RAIZ = "Raiz";
    public static final String INVERSO = "1/x";
    public static final String MULTIPLICACION = "*";
    public static final String PORCENTAJE = "%";
    public static final String INFINITY = "Infinity";
    public static final String ERROR = "Error";
    public static final String NAN = "NaN";
    private boolean memoriaRecuperada = false;
    private final OperacionesCalculadora operaCal = new OperacionesCalculadora();
    private final EstadoValoresVista retorno = new EstadoValoresVista();
    
    /**
     *
     */
    public ControlaCalculadora() {
        cargarNumeros();
        cargarOperaAritmeticas();
        cargarMemorias();
    }
    
    /**
     *
     */
    private void cargarMemorias() {
        memorias.add("MC");
        memorias.add("MR");
        memorias.add("MS");
        memorias.add("M+");
        memorias.add("M-");
    }
    
    /**
     *
     */
    private void cargarOperaAritmeticas() {
        operacionesArit.add("/");
        operacionesArit.add("+");
        operacionesArit.add("-");
        operacionesArit.add("*");
        operacionesArit.add("%");
    }
    
    /**
     *
     */
    private void cargarNumeros() {
        numeros.add("1");
        numeros.add("2");
        numeros.add("3");
        numeros.add("4");
        numeros.add("5");
        numeros.add("6");
        numeros.add("7");
        numeros.add("8");
        numeros.add("9");
        numeros.add("0");
    }
    
    /**
     *
     * @param valorActual
     * @param valorColocar
     * @return
     */
    private String validarColocarValorInicial(String valorActual, String valorColocar) {
        String salida = valorActual;
        if (valorActual.length() == 0) {
            salida = valorColocar;
        }
        
        return salida;
    }
    
    /**
     *
     * @param teclaDigitada
     * @param valorActual
     * @return
     */
    public EstadoValoresVista operacionGrafica(String teclaDigitada, String valorActual) {
        
        try {
            if (LIMPIAR_TODO_LABEL.equals(teclaDigitada)) {
                colocarValoresRetorno("0", "", "true", -1D, "");
            }
            if (LIMPIAR_FORMULA_LABEL.equals(teclaDigitada)) {
                colocarValoresRetorno("0", null, "true", -1D, "");
            }
            if (INFINITY.equals(valorActual) || ERROR.equals(valorActual) || NAN.equals(valorActual)) {
                return retorno;
            }
            if (numeros.contains(teclaDigitada)) {
                
                concatenarNumeros(teclaDigitada, valorActual);
                
            } else if (RETROCESO_LABEL.equals(teclaDigitada)) {
                
                borrar(valorActual);
                
            } else if (operacionesArit.contains(teclaDigitada)) {
                
                operacionesAritmeticas(teclaDigitada, valorActual);
                
            } else if (PUNTO.equals(teclaDigitada)) {
                
                colocarPunto(teclaDigitada, valorActual);
                
            } else if (CAMBIO_SIGNO.equals(teclaDigitada)) {
                
                cambiarSigno(valorActual);
                
            } else if (RAIZ.equals(teclaDigitada)) {
                
                colocarRaiz(valorActual);
                
            } else if (INVERSO.equals(teclaDigitada)) {
                
                tomarInverso(valorActual);
                
            } else if (memorias.contains(teclaDigitada)) {
                
                gestionarMemorias(valorActual, teclaDigitada);
                
            } else if (IGUAL.equals(teclaDigitada)) {
                
                calcularResultado(valorActual);
            }
            
        } catch (ScriptException e) {
            colocarValoresRetorno("Error", valorActual + IGUAL, "true", -1D, "");
        }
        
        return retorno;
    }
    
    /**
     * @param valorActual
     * @return
     * @throws ScriptException
     */
    private void calcularResultado(String valorActual) throws ScriptException {
        if (valorActual.length() == 0) {
            if (!"".equals(retorno.getExpresion())) {
                valorActual = retorno.getExpresion().substring(0, retorno.getExpresion().length() - 1);
            } else {
                valorActual = "0";
            }
        }
        
        String valorActualCopy = valorActual;
        valorActualCopy = valorActualCopy.replace("sqrt(", "Math.sqrt(");
        
        while (valorActualCopy.contains(PORCENTAJE)) {
            int posInicial = valorActualCopy.indexOf(PORCENTAJE);
            int posFinal = 0;
            for (int i = posInicial - 1; i >= 0; i--) {
                char caracter = valorActualCopy.charAt(i);
                String caracterString = String.valueOf(caracter);
                if (operacionesArit.contains(caracterString)) {
                    posFinal = i + 1;
                    break;
                }
            }
            
            String cadenaRemplazar = valorActualCopy.substring(posFinal, posInicial + 1);
            String termino = valorActualCopy.substring(posFinal, posInicial);
            valorActualCopy = valorActualCopy.replace(cadenaRemplazar, "(" + termino + "/100)");
        }  
        Double resultado = operaCal.operar(valorActualCopy);
        colocarValoresRetorno(resultado.toString(), valorActual + IGUAL, "true", resultado, null);
    }
    
    /**
     * @param valorActual
     * @return
     */
    private void tomarInverso(String valorActual) {
        if (valorActual.length() == 0) {
            valorActual = "Infinity";
        } else {
            String ultimo = tomarUltimoTermino(valorActual);
            if (ultimo != null) {
                String inverso = "(1/" + ultimo + ")";
                valorActual = valorActual.substring(0, valorActual.length() - ultimo.length()) + inverso;
            } else {
                valorActual = "(1/" + valorActual + ")";
            }
        }
        retorno.setFormula(valorActual);
    }
    
    /**
     * @param valorActual
     * @return
     */
    private void colocarRaiz(String valorActual) {
        if (valorActual.length() == 0) {
            valorActual = "sqrt(0)";
        } else {
            String ultimo = tomarUltimoTermino(valorActual);
            if (ultimo != null) {
                String raiz = "sqrt(" + ultimo + ")";
                
                valorActual = valorActual.substring(0, valorActual.length() - ultimo.length()) + raiz;
            } else {
                valorActual = "sqrt(" + valorActual + ")";
            }
        }
        retorno.setFormula(valorActual);
    }
    
    /**
     * @param valorActual
     * @return
     */
    private void cambiarSigno(String valorActual) {
        if (valorActual.length() == 0) {
            valorActual = "0";
            String signo = ("".equals(retorno.getSigno())) ? "-" : "";
            retorno.setSigno(signo);
            valorActual = "(" + signo + valorActual + ")";
        } else {
            String ultimo = tomarUltimoTermino(valorActual);
            if (ultimo != null) {
                String signo = ("".equals(retorno.getSigno())) ? "-" : "";
                retorno.setSigno(signo);
                
                ultimo = ultimo.replace("(", "");
                ultimo = ultimo.replace(")", "");
                
                valorActual = valorActual.replace("(", "");
                valorActual = valorActual.replace(")", "");
                String cambio = "(" + signo + ultimo + ")";
                
                if (signo.equals("-")) {
                    valorActual = valorActual.substring(0, valorActual.length() - ultimo.length()) + cambio;
                } else {
                    valorActual = valorActual.substring(0, valorActual.length() - (ultimo.length() + 1)) + cambio;
                }
            }
        }
        retorno.setFormula(valorActual);
    }
    
    /**
     * @param teclaDigitada
     * @param valorActual
     */
    private void colocarPunto(String teclaDigitada, String valorActual) {
        
        retorno.setHabilitarPunto(false);
        if (retorno.getResultado() == null && !memoriaRecuperada) {
            valorActual = validarColocarValorInicial(valorActual, "0");
            
            if (operacionesArit.contains(valorActual.substring(valorActual.length() - 1, valorActual.length()))) {
                valorActual = valorActual.concat("0");
            }
            String ultimo = tomarUltimoTermino(valorActual);
            if (ultimo != null) {
                if (!ultimo.contains(PUNTO)) {
                    if (!ultimo.contains(")")) {
                        valorActual = valorActual.concat(teclaDigitada);
                    }
                }
            }
            colocarValoresRetorno(valorActual, null, null, null, null);
            
        } else {
            colocarValoresRetorno("0.", "", "false", -1D, null);
            memoriaRecuperada = false;
        }
    }
    
    /**
     * @param teclaDigitada
     * @param valorActual
     */
    private void concatenarNumeros(String teclaDigitada, String valorActual) {
        if (retorno.getResultado() == null && !memoriaRecuperada) {
            if (valorActual.endsWith(PORCENTAJE)) {
                valorActual = valorActual.concat(MULTIPLICACION).concat(teclaDigitada);
            } else {
                valorActual = valorActual.concat(teclaDigitada);
            }
            colocarValoresRetorno(valorActual, null, null, null, null);
        } else {
            valorActual = teclaDigitada;
            colocarValoresRetorno(valorActual, "", null, -1D, null);
            memoriaRecuperada = false;
        }
    }
    
    /**
     * @param teclaDigitada
     * @param valorActual
     */
    private void operacionesAritmeticas(String teclaDigitada, String valorActual) {
        
        valorActual = validarColocarValorInicial(valorActual, "0" + teclaDigitada);
        String subValorActual = valorActual.substring(valorActual.length() - 1, valorActual.length());
        
        if (numeros.contains(subValorActual) || ")".equals(subValorActual) || PORCENTAJE.equals(subValorActual)) {
            valorActual = valorActual + teclaDigitada;
        } else {
            valorActual = valorActual.substring(0, valorActual.length() - 1) + teclaDigitada;
        }
        
        colocarValoresRetorno(valorActual, null, "true", -1D, "");
        memoriaRecuperada = false;
    }
    
    /**
     * @param valorActual
     * @return
     */
    private void borrar(String valorActual) {
        if (valorActual.length() > 0) {
            valorActual = valorActual.substring(0, valorActual.length() - 1);
            colocarValoresRetorno(valorActual, null, null, null, null);
        }
        valorActual = validarColocarValorInicial(valorActual, "0");
        if (valorActual.equals("0")) {
            colocarValoresRetorno(valorActual, null, "true", null, null);
        }
        
    }
    
    /**
     *
     * @param formula
     * @param expresion
     * @param habilPunto
     * @param resultado
     * @param signo
     */
    private void colocarValoresRetorno(String formula, String expresion, String habilPunto, Double resultado, String signo) {
        
        if (formula != null) {
            retorno.setFormula(formula);
        }
        
        if (expresion != null) {
            retorno.setExpresion(expresion);
        }
        
        if (habilPunto != null) {
            retorno.setHabilitarPunto(Boolean.parseBoolean(habilPunto));
        }
        
        if (resultado != null) {
            retorno.setResultado((resultado.compareTo(-1D) == 0) ? null : resultado);
        }
        
        if (signo != null) {
            retorno.setSigno(signo);
        }
    }
    
    private String tomarUltimoTermino(String valorActual) {
        
        String valorActualCopy = valorActual;
        String ultimo = null;
        valorActualCopy = (valorActualCopy.indexOf("+") == -1) ? valorActualCopy : valorActualCopy.replaceAll("\\+", "@");
        valorActualCopy = (valorActualCopy.indexOf("-") == -1) ? valorActualCopy : valorActualCopy.replaceAll("\\-", "@");
        valorActualCopy = (valorActualCopy.indexOf("*") == -1) ? valorActualCopy : valorActualCopy.replaceAll("\\*", "@");
        valorActualCopy = (valorActualCopy.indexOf("/") == -1) ? valorActualCopy : valorActualCopy.replaceAll("\\/", "@");
        String[] terminos = valorActualCopy.split("@");
        if (terminos.length > 0) {
            int tam = terminos.length;
            ultimo = terminos[tam - 1];
        }
        
        return ultimo;
    }
    
    /**
     *
     * @param valorActual
     * @param teclaDigitada
     */
    private void gestionarMemorias(String valorActual, String teclaDigitada) {
        memoriaRecuperada = false;
        valorActual = valorActual.replace("(", "");
        valorActual = valorActual.replace(")", "");
        valorActual = validarColocarValorInicial(valorActual, "0");
        if ("MC".equals(teclaDigitada)) {
            retorno.setMemoria(null);
            retorno.setFormula(valorActual);
        }
        if ("MR".equals(teclaDigitada)) {
            if (retorno.getMemoria() != null) {
                retorno.setFormula(retorno.getMemoria());
                memoriaRecuperada = true;
            } else {
                retorno.setFormula("0");
            }
        }
        if ("MS".equals(teclaDigitada) || "M+".equals(teclaDigitada)) {
            if (!"0".equals(valorActual) && !INFINITY.equals(valorActual) && !ERROR.equals(valorActual) && !NAN.equals(valorActual)) {
                if (!valorActual.contains("+") && !valorActual.contains("-") && !valorActual.contains("*") && !valorActual.contains("/") && !valorActual.contains(PORCENTAJE)) {
                    retorno.setMemoria(valorActual);
                }
            } else {
                retorno.setFormula(valorActual);
            }
        }
        if ("M-".equals(teclaDigitada)) {
            if (!"0".equals(valorActual) && !INFINITY.equals(valorActual) && !ERROR.equals(valorActual) && !NAN.equals(valorActual)) {
                if (!valorActual.contains("+") && (!valorActual.contains("-") || valorActual.startsWith("-")) && !valorActual.contains("*") && !valorActual.contains("/") && !valorActual.contains("sqrt")) {
                    if (!valorActual.contains(PORCENTAJE)) {
                        Double valor = Double.valueOf(valorActual) * (-1D);
                        String valorMemorizar = validarColocarCero(valor.toString(), retorno);
                        retorno.setMemoria(valorMemorizar);
                    }
                }
                
            } else {
                retorno.setFormula(valorActual);
            }
        }
    }
    
    /**
     *
     * @param formula
     * @param valorMostrar
     * @return
     */
    public static String validarColocarCero(String formula, EstadoValoresVista valorMostrar) {
        
        if (formula.indexOf(".") > -1) {
            String[] numeroReal = formula.split("\\.");
            if (numeroReal.length == 2) {
                String parteDecimal = numeroReal[1];
                
                if (parteDecimal.length() == 1 && "0".equals(parteDecimal)) {
                    formula = numeroReal[0];
                }
            }
        }
        
        return formula;
    }
}
