package co.edu.unbosque.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.unbosque.calculadora.logica.ControlaCalculadora;
import co.edu.unbosque.calculadora.logica.EstadoValoresVista;

/**
 * @author Ana Maria
 *
 */
public class CalculadoraGUI extends JPanel implements KeyListener,
        ActionListener {
    
    private static final long serialVersionUID = 1L;
    private JPanel panelDisplay;
    private JLabel labelNumeros;
    private JLabel labelExpresion;
    private boolean escribible = false;
    private JButton bottonP;
    private JButton bottonPorcentaje;
    private JButton bottonMas;
    private JButton botton1;
    private JButton boton2;
    private JButton botton3;
    private JButton bottonMenos;
    private JButton bottonInver;
    private JButton botton4;
    private JButton botton5;
    private JButton botton6;
    private JButton bottonMul;
    private JButton botton7;
    private JButton botton8;
    private JButton botton9;
    private JButton bottonDividir;
    private JButton bottonRaiz;
    private JButton bottonMC;
    private JButton bottonMR;
    private JButton bottonMS;
    private JButton bottonMemPos;
    private JButton bottonMemNeg;
    private JButton bottonBorrar;
    private JButton bottonCE;
    private JButton bottonC;
    private JButton bottonMM;
    private JButton botton0;
    private JButton bottonIgual;
    private static final int HORIZONTAL = GridBagConstraints.HORIZONTAL;
    private static final int VERTICAL = GridBagConstraints.VERTICAL;
    private static final Color NEGRO = Color.BLACK;
    private static final Color GRIS = new Color(169, 169, 169);
    private static final Color MARRON = new Color(210, 180, 140);
    private static final Color NARANJA = Color.ORANGE;
    private static final Color BLANCO = Color.WHITE;
    private static final Color COLOR_FONDO = new Color(47, 79, 79);
    private static final String RETROCESO = "←";
    private static final char PORCENTAJE = '%';
    ControlaCalculadora controlador = new ControlaCalculadora();
    Map<Integer, String> caractPermitidos = new HashMap<Integer, String>();
    
    public CalculadoraGUI() {
        
        initComponets();
    }
    
    private void initComponets() {
        GridBagLayout gb = new GridBagLayout();
        
        setBackground(COLOR_FONDO);
        gb.maximumLayoutSize(this);
        setLayout(gb);
        
        crearAgregarBoton(bottonP, ".", HORIZONTAL, 2, 8, 0, 0, MARRON, NEGRO);
        crearAgregarBoton(bottonMas, "+", HORIZONTAL, 3, 8, 0, 0, MARRON, NEGRO);
        crearAgregarBoton(botton1, "1", HORIZONTAL, 0, 7, 0, 0, NEGRO, BLANCO);
        crearAgregarBoton(boton2, "2", HORIZONTAL, 1, 7, 0, 0, NEGRO, BLANCO);
        crearAgregarBoton(botton3, "3", HORIZONTAL, 2, 7, 0, 0, NEGRO, BLANCO);
        crearAgregarBoton(bottonMenos, "-", HORIZONTAL, 3, 7, 0, 0, MARRON, NEGRO);
        crearAgregarBoton(bottonInver, "1/x", HORIZONTAL, 4, 6, 0, 0, MARRON, NEGRO);
        crearAgregarBoton(botton4, "4", HORIZONTAL, 0, 6, 0, 0, NEGRO, BLANCO);
        crearAgregarBoton(botton5, "5", HORIZONTAL, 1, 6, 0, 0, NEGRO, BLANCO);
        crearAgregarBoton(botton6, "6", HORIZONTAL, 2, 6, 0, 0, NEGRO, BLANCO);
        crearAgregarBoton(bottonMul, "*", HORIZONTAL, 3, 6, 0, 0, MARRON, NEGRO);
        crearAgregarBoton(bottonPorcentaje, String.valueOf(PORCENTAJE), HORIZONTAL, 4, 4, 0, 0, MARRON, NEGRO);
        crearAgregarBoton(botton7, "7", HORIZONTAL, 0, 5, 0, 0, NEGRO, BLANCO);
        crearAgregarBoton(botton8, "8", HORIZONTAL, 1, 5, 0, 0, NEGRO, BLANCO);
        crearAgregarBoton(botton9, "9", HORIZONTAL, 2, 5, 0, 0, NEGRO, BLANCO);
        crearAgregarBoton(bottonDividir, "/", HORIZONTAL, 3, 5, 0, 0, MARRON, NEGRO);
        crearAgregarBoton(bottonRaiz, "Raiz", HORIZONTAL, 4, 5, 0, 0, MARRON, NEGRO);
        crearAgregarBoton(bottonMC, "MC", HORIZONTAL, 0, 3, 0, 0, GRIS, BLANCO);
        crearAgregarBoton(bottonMR, "MR", HORIZONTAL, 1, 3, 0, 0, GRIS, BLANCO);
        crearAgregarBoton(bottonMS, "MS", HORIZONTAL, 2, 3, 0, 0, GRIS, BLANCO);
        crearAgregarBoton(bottonMemPos, "M+", HORIZONTAL, 3, 3, 0, 0, GRIS, BLANCO);
        crearAgregarBoton(bottonMemNeg, "M-", HORIZONTAL, 4, 3, 0, 0, GRIS, BLANCO);
        crearAgregarBoton(bottonBorrar, RETROCESO, HORIZONTAL, 0, 4, 0, 0, MARRON, NEGRO);
        crearAgregarBoton(bottonCE, ControlaCalculadora.LIMPIAR_FORMULA_LABEL, HORIZONTAL, 1, 4, 0, 0, MARRON, NEGRO);
        crearAgregarBoton(bottonC, ControlaCalculadora.LIMPIAR_TODO_LABEL, HORIZONTAL, 2, 4, 0, 0, MARRON, NEGRO);
        crearAgregarBoton(bottonMM, "±", HORIZONTAL, 3, 4, 0, 0, MARRON, NEGRO);
        crearAgregarBoton(botton0, "0", HORIZONTAL, 0, 8, 2, 0, NEGRO, BLANCO);
        crearAgregarBoton(bottonIgual, "=", VERTICAL, 4, 7, 0, 2, NARANJA, NEGRO);
        
        addDisplayPanel(gb, this);
        addKeyListener(this);
        llenarCaractValidos();
        panelDisplay.setFocusable(true);
        panelDisplay.requestFocus();
        panelDisplay.requestFocusInWindow();
    }
    
    private void llenarCaractValidos() {
        caractPermitidos.put(48, "0");
        caractPermitidos.put(49, "1");
        caractPermitidos.put(50, "2");
        caractPermitidos.put(51, "3");
        caractPermitidos.put(52, "4");
        caractPermitidos.put(53, "5");
        caractPermitidos.put(54, "6");
        caractPermitidos.put(55, "7");
        caractPermitidos.put(56, "8");
        caractPermitidos.put(57, "9");
        caractPermitidos.put(46, ".");
        caractPermitidos.put(47, "/");
        caractPermitidos.put(44, ".");
        caractPermitidos.put(521, "+");
        caractPermitidos.put(8, RETROCESO);
        caractPermitidos.put(45, "-");
        caractPermitidos.put(151, "*");
        caractPermitidos.put(-1, String.valueOf(PORCENTAJE));
    }
    
    private void addDisplayPanel(GridBagLayout gb, KeyListener listener) {
        GridBagConstraints constr = new GridBagConstraints();
        panelDisplay = new JPanel();
        constr.gridx = 0;
        constr.gridy = 1;
        constr.ipady = 17;
        constr.weighty = 1.0;
        constr.ipadx = 330;
        constr.gridwidth = 5;
        panelDisplay.setBackground(COLOR_FONDO);
        constr.anchor = GridBagConstraints.CENTER;
        
        GridBagLayout layout = new GridBagLayout();
        panelDisplay.setLayout(layout);
        GridBagConstraints constrLabels = new GridBagConstraints();
        
        labelNumeros = new JLabel();
        labelNumeros.setText("0");
        labelNumeros.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        labelNumeros.setForeground(BLANCO);
        labelNumeros.setHorizontalAlignment(JLabel.RIGHT);
        
        constrLabels.insets = new Insets(2, 0, 0, 2);
        constrLabels.fill = HORIZONTAL;
        constrLabels.gridx = 0;
        constrLabels.gridy = 1;
        
        layout.setConstraints(labelNumeros, constrLabels);
        panelDisplay.add(labelNumeros);
        
        labelExpresion = new JLabel();
        labelExpresion.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
        labelExpresion.setForeground(BLANCO);
        labelExpresion.setHorizontalAlignment(JLabel.RIGHT);
        
        constrLabels.insets = new Insets(2, 0, 0, 2);
        constrLabels.fill = HORIZONTAL;
        constrLabels.weightx = 0.3;
        constrLabels.gridx = 0;
        constrLabels.gridy = 0;
        constrLabels.anchor = GridBagConstraints.PAGE_END;
        
        layout.setConstraints(labelExpresion, constrLabels);
        panelDisplay.add(labelExpresion);
        panelDisplay.addKeyListener(listener);
        panelDisplay.setFocusable(true);
        panelDisplay.requestFocus();
        panelDisplay.requestFocusInWindow();
        gb.setConstraints(panelDisplay, constr);
        add(panelDisplay);
    }
    
    private void crearAgregarBoton(JButton boton, String labelBoton, int fill, int gridx, int gridy, int gridwidth, int gridheight, Color background, Color foreground) {
        boton = new JButton(labelBoton);
        GridBagConstraints constr = new GridBagConstraints();
        constr.insets = new Insets(4, 4, 4, 4);
        constr.fill = fill;
        constr.weightx = 0.3;
        constr.gridx = gridx;
        constr.gridy = gridy;
        if (gridwidth != 0) {
            constr.gridwidth = gridwidth;
        }
        if (gridheight != 0) {
            
            constr.gridheight = gridheight;
        }
        boton.setBackground(background);
        boton.setForeground(foreground);
        boton.addKeyListener(this);
        add(boton, constr);
        boton.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonTocado = (JButton) e.getSource();
        String etiquetaBotonTocado = botonTocado.getText();
        String valorJText = labelNumeros.getText();
        
        if ("0".equals(valorJText)) {
            valorJText = "";
        }
        
        EstadoValoresVista valorMostrar = controlador.operacionGrafica(etiquetaBotonTocado, valorJText);
        
        if (("-" + ControlaCalculadora.INFINITY).equals(valorMostrar.getFormula())
                || ("-" + ControlaCalculadora.ERROR).equals(valorMostrar.getFormula())
                || ("-" + ControlaCalculadora.NAN).equals(valorMostrar.getFormula())) {
            
            valorMostrar.setFormula(valorMostrar.getFormula().replace("-", ""));
        }
        
        String formula = valorMostrar.getFormula();
        if (valorMostrar.getResultado() != null) {
            valorMostrar.setFormula(ControlaCalculadora.validarColocarCero(formula, valorMostrar));
        }
                
        if (valorMostrar.getFormula().length() < 50) {
            labelNumeros.setText(valorMostrar.getFormula());
            labelExpresion.setText(valorMostrar.getExpresion());
            this.getComponent(0).setEnabled(valorMostrar.isHabilitarPunto());
        }
        
        panelDisplay.requestFocus();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        int codigo = tomarValorCaracter(e);
        escribible = true;
        if (!caractPermitidos.containsKey(codigo)) {
            e.consume();
            escribible = false;
        }
        panelDisplay.requestFocus();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        if (escribible) {
            String valorActual = labelNumeros.getText();
            
            if ("0".equals(valorActual)) {
                valorActual = "";
            }
            
            if (valorActual.length() < 50) {
                int codigo = tomarValorCaracter(e);
                if (!RETROCESO.equals(caractPermitidos.get(codigo))) {
                    String caracter = caractPermitidos.get(codigo);
                    EstadoValoresVista vista = controlador.operacionGrafica(
                            caracter, valorActual);
                    
                    valorActual = vista.getFormula();
                    
                    labelNumeros.setText(vista.getFormula());
                    labelExpresion.setText(vista.getExpresion());
                    this.getComponent(0).setEnabled(vista.isHabilitarPunto());
                } else {
                    
                    if (valorActual.length() > 0) {
                        valorActual = valorActual.substring(0,
                                valorActual.length() - 1);
                        labelNumeros.setText(valorActual);
                    }
                }
                
                if (valorActual.length() == 0) {
                    valorActual = "0";
                    labelNumeros.setText(valorActual);
                }
                
            } else {
                e.consume();
            }
            escribible = false;
        }
        
        panelDisplay.requestFocus();
    }
    
    private int tomarValorCaracter(KeyEvent e) {
        
        char codigoChar = e.getKeyChar();
        int codigoCaracter;
        if (PORCENTAJE == codigoChar) {
            codigoCaracter = -1;
        } else {
            codigoCaracter = KeyEvent.getExtendedKeyCodeForChar(e.getKeyChar());
        }
        return codigoCaracter;
    }
    
}
