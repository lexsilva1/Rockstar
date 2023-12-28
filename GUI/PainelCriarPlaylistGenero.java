package GUI;

import backend.Cliente;
import backend.Utilizador;

import javax.swing.*;
import java.awt.*;

public class PainelCriarPlaylistGenero extends JPanel {
    private Cliente cliente;
    public PainelCriarPlaylistGenero(FramePrincipal framePrincipal) {
        this.cliente = cliente;

        setLayout(null);
        setBackground(new Color(70, 90, 120));;
        setPreferredSize(new Dimension(450, 500));

        JLabel lblNumero = new JLabel("Indique o número de músicas:");
        lblNumero.setBounds(250, 100, 220, 25);
        lblNumero.setForeground(Color.WHITE);
        add(lblNumero);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(250, 125, 150, 25);
        add(txtUsername);

        JLabel lblNome = new JLabel("Indique o nome da playlist:");
        lblNome.setBounds(250, 200, 220, 25);
        lblNome.setForeground(Color.WHITE);
        add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(250, 225, 150, 25);
        add(txtNome);

        JLabel lblOpcao = new JLabel("Escolha o género:");
        lblOpcao.setBounds(25, 100, 220, 25);
        lblOpcao.setForeground(Color.WHITE);
        add(lblOpcao);

        JRadioButton chkPop = new JRadioButton("Pop");
        chkPop.setBounds(25, 150, 100, 25);
        chkPop.setBackground(new Color(70, 90, 120));
        chkPop.setForeground(Color.WHITE);
        add(chkPop);

        JRadioButton chkRock = new JRadioButton("Rock");
        chkRock.setBounds(25, 200, 100, 25);
        chkRock.setBackground(new Color(70, 90, 120));
        chkRock.setForeground(Color.WHITE);
        add(chkRock);

        JRadioButton chkHipHop = new JRadioButton("Hip Hop");
        chkHipHop.setBounds(25, 250, 100, 25);
        chkHipHop.setBackground(new Color(70, 90, 120));
        chkHipHop.setForeground(Color.WHITE);
        add(chkHipHop);

        JRadioButton chkPimba = new JRadioButton("Pimba");
        chkPimba.setBounds(25, 300, 100, 25);
        chkPimba.setBackground(new Color(70, 90, 120));
        chkPimba.setForeground(Color.WHITE);
        add(chkPimba);

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(340,450,100,25);
        add(btnContinuar);


        setVisible(true);

    }

}
