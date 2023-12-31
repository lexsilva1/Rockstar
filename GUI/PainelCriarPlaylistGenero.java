package GUI;

import backend.Utilizador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PainelCriarPlaylistGenero extends JPanel {
    private Utilizador utilizador;
    protected JLabel lblNumero;
    protected JTextField txtNumero;
    protected JLabel lblNome;
    protected JTextField txtNome;
    protected JLabel lblOpcao;
    protected JRadioButton chkPop;
    protected JRadioButton chkRock;
    protected JRadioButton chkHipHop;
    protected JRadioButton chkPimba;
    protected ButtonGroup grupo;
    protected JButton btnCriar;




    public PainelCriarPlaylistGenero(FramePrincipal framePrincipal, Utilizador utilizador) {
        this.utilizador = utilizador;

        setLayout(null);
        setBackground(new Color(70, 90, 120));;
        setPreferredSize(new Dimension(450, 500));


        this.lblNumero = new JLabel("Número de músicas");
        lblNumero.setBounds(25, 175, 150, 25);
        lblNumero.setForeground(Color.WHITE);
        add(lblNumero);

        this.txtNumero = new JTextField();
        txtNumero.setBounds(25, 200, 150, 25);
        add(txtNumero);

        this.lblNome = new JLabel("Nome");
        lblNome.setBounds(200, 175, 150, 25);
        lblNome.setForeground(Color.WHITE);
        add(lblNome);

        this.txtNome = new JTextField();
        txtNome.setBounds(200, 200, 150, 25);
        add(txtNome);

        this.lblOpcao = new JLabel("Género");
        lblOpcao.setBounds(25, 100, 220, 25);
        lblOpcao.setForeground(Color.WHITE);
        add(lblOpcao);

        this.chkPop = new JRadioButton("Pop");
        chkPop.setBounds(25, 125, 85, 25);
        chkPop.setBackground(new Color(70, 90, 120));
        chkPop.setForeground(Color.WHITE);
        add(chkPop);

        this.chkRock = new JRadioButton("Rock");
        chkRock.setBounds(110, 125, 85, 25);
        chkRock.setBackground(new Color(70, 90, 120));
        chkRock.setForeground(Color.WHITE);
        add(chkRock);

        this.chkHipHop = new JRadioButton("Hip Hop");
        chkHipHop.setBounds(195, 125, 85, 25);
        chkHipHop.setBackground(new Color(70, 90, 120));
        chkHipHop.setForeground(Color.WHITE);
        add(chkHipHop);

        this.chkPimba = new JRadioButton("Pimba");
        chkPimba.setBounds(310, 125, 85, 25);
        chkPimba.setBackground(new Color(70, 90, 120));
        chkPimba.setForeground(Color.WHITE);
        add(chkPimba);

        this.grupo = new ButtonGroup();
        grupo.add(chkPop);
        grupo.add(chkRock);
        grupo.add(chkHipHop);
        grupo.add(chkPimba);

        this.btnCriar = new JButton("Criar");
        btnCriar.setBounds(300,350,100,25);
        add(btnCriar);

        txtNumero.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        setVisible(true);

    }

}
