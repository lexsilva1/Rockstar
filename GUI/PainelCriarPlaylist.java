package GUI;

import backend.Cliente;
import backend.Utilizador;

import javax.swing.*;
import java.awt.*;

public class PainelCriarPlaylist extends JPanel {
    private Cliente cliente;
    public PainelCriarPlaylist(FramePrincipal framePrincipal, Cliente cliente) {


        setLayout(null);
        setBackground(new Color(70, 90, 120));;
        setPreferredSize(new Dimension(450, 500));

        JLabel lblNome = new JLabel("Nome da Playlist:");
        lblNome.setBounds(20, 100, 120, 25);
        lblNome.setForeground(Color.WHITE);
        add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(150, 100, 250, 25);
        add(txtNome);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(300,250,100,25);
        add(btnAdicionar);

        btnAdicionar.addActionListener(e -> {

            if (txtNome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor escreva o nome da playlist", "Campo vazio", JOptionPane.ERROR_MESSAGE);
                } else {
                String nome = txtNome.getText();
                framePrincipal.getRockstar().addGrupoDeMusicas(cliente.criaPlaylist(nome));
                JOptionPane.showMessageDialog(null, "Playlist adicionada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }

        });



        setVisible(true);




    }

}
