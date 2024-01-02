package GUI;

import backend.Cliente;
import backend.Utilizador;

import javax.swing.*;
import java.awt.*;

public class PainelPesquisarUtilizador extends JPanel {
    private Cliente cliente;
    public PainelPesquisarUtilizador(FramePrincipal framePrincipal) {
        this.cliente = cliente;

        setLayout(null);
        setBackground(new Color(70, 90, 120));;
        setPreferredSize(new Dimension(450, 500));

        JLabel lblUsername = new JLabel("Indique o username:");
        lblUsername.setBounds(20, 50, 120, 25);
        lblUsername.setForeground(Color.WHITE);
        add(lblUsername);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(150, 50, 250, 25);
        add(txtUsername);

        JButton btnAdicionar = new JButton("Pesquisar");
        btnAdicionar.setBounds(300,100,100,25);
        add(btnAdicionar);


        setVisible(true);


    }

}