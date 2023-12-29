package GUI;

import backend.Cliente;
import backend.Utilizador;

import javax.swing.*;
import java.awt.*;

public class PainelCriarPlaylist extends JPanel {
    private Cliente cliente;
    public PainelCriarPlaylist(FramePrincipal framePrincipal) {
        this.cliente = cliente;

        setLayout(null);
        setBackground(new Color(70, 90, 120));;
        setPreferredSize(new Dimension(450, 500));

        JLabel lblUsername = new JLabel("Nome da Playlist:");
        lblUsername.setBounds(20, 100, 120, 25);
        lblUsername.setForeground(Color.WHITE);
        add(lblUsername);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(150, 100, 250, 25);
        add(txtUsername);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(300,250,100,25);
        add(btnAdicionar);


        setVisible(false);


    }

}
