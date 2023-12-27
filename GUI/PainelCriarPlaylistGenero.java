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
        setPreferredSize(new Dimension(450, 500));

        JLabel lblNumero = new JLabel("Indique o número de músicas:");
        lblNumero.setBounds(250, 100, 220, 25);
        add(lblNumero);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(250, 150, 150, 25);
        add(txtUsername);

        JLabel lblNome = new JLabel("Indique o nome da playlist:");
        lblNome.setBounds(250, 200, 220, 25);
        add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(250, 250, 150, 25);
        add(txtNome);

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(340,450,100,25);
        add(btnContinuar);


        setVisible(true);

    }

}
