package GUI;

import backend.Cliente;
import backend.Utilizador;

import javax.swing.*;
import java.awt.*;

public class PainelPesquisar extends JPanel {
    private Cliente cliente;
    public PainelPesquisar(FramePrincipal framePrincipal) {
        this.cliente = cliente;

        setLayout(null);
        setBackground(new Color(70, 90, 120));;
        setPreferredSize(new Dimension(450, 500));


        JLabel lblOpcao = new JLabel("Escolha por que pretende pesquisar:");
        lblOpcao.setBounds(25, 50, 220, 25);
        add(lblOpcao);

        JRadioButton chkGenero = new JRadioButton("Género");
        chkGenero.setBounds(25, 100, 100, 25);
        add(chkGenero);

        JRadioButton chkArtista = new JRadioButton("Artista");
        chkArtista.setBounds(25, 150, 100, 25);
        add(chkArtista);

        JLabel lblOpcaoGenero = new JLabel("Escolha o género:");
        lblOpcaoGenero.setBounds(25, 100, 220, 25);
        add(lblOpcaoGenero);

        JRadioButton chkPop = new JRadioButton("Pop");
        chkPop.setBounds(25, 150, 100, 25);
        add(chkPop);

        JRadioButton chkRock = new JRadioButton("Rock");
        chkRock.setBounds(25, 200, 100, 25);
        add(chkRock);

        JRadioButton chkHipHop = new JRadioButton("Hip Hop");
        chkHipHop.setBounds(25, 250, 100, 25);
        add(chkHipHop);

        JRadioButton chkPimba = new JRadioButton("Pimba");
        chkPimba.setBounds(25, 300, 100, 25);
        add(chkPimba);


        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(340,450,100,25);
        add(btnContinuar);


        setVisible(true);

    }

}