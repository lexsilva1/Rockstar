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
        lblUsername.setBounds(20, 200, 120, 25);
        add(lblUsername);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(150, 200, 250, 25);
        add(txtUsername);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(340,450,100,25);
        add(btnAdicionar);


        setVisible(true);

    }

}
