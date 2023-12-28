package GUI;

import backend.Cliente;

import javax.swing.*;
import java.awt.*;

public class PainelAddMusica extends JPanel {
    private Cliente cliente;
    public PainelAddMusica(FramePrincipal framePrincipal) {
        this.cliente = cliente;

        setLayout(null);
        setBackground(new Color(70, 90, 120));;
        setPreferredSize(new Dimension(450, 500));


        JLabel lblTitulo = new JLabel("Título");
        JTextField txtTitulo = new JTextField();

        JLabel lblGenero = new JLabel("Género:");
        lblGenero.setBounds(25, 100, 220, 25);
        lblGenero.setForeground(Color.WHITE);
        add(lblGenero);

        JLabel lblData = new JLabel("Data de lançamento:");
        JTextField txtData = new JTextField();

        JLabel lblValor = new JLabel("Valor (€):");
        JTextField txtValor = new JTextField();

        JRadioButton chkPop = new JRadioButton("Pop");
        chkPop.setBounds(25, 125, 85, 25);
        chkPop.setBackground(new Color(70, 90, 120));
        chkPop.setForeground(Color.WHITE);
        add(chkPop);

        JRadioButton chkRock = new JRadioButton("Rock");
        chkRock.setBounds(110, 125, 85, 25);
        chkRock.setBackground(new Color(70, 90, 120));
        chkRock.setForeground(Color.WHITE);
        add(chkRock);

        JRadioButton chkHipHop = new JRadioButton("Hip Hop");
        chkHipHop.setBounds(195, 125, 85, 25);
        chkHipHop.setBackground(new Color(70, 90, 120));
        chkHipHop.setForeground(Color.WHITE);
        add(chkHipHop);

        JRadioButton chkPimba = new JRadioButton("Pimba");
        chkPimba.setBounds(310, 125, 85, 25);
        chkPimba.setBackground(new Color(70, 90, 120));
        chkPimba.setForeground(Color.WHITE);
        add(chkPimba);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(chkPop);
        grupo.add(chkRock);
        grupo.add(chkHipHop);
        grupo.add(chkPimba);


        setVisible(false);

    }

}
