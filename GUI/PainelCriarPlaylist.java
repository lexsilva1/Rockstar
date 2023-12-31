package GUI;

import backend.Cliente;
import backend.GrupoMusicas;
import backend.Playlist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PainelCriarPlaylist extends JPanel {
    /**
     * Cria o painel que permite Criar ao <code>Cliente</code> vriar novos objectos <code>Playlist</code> vazios;
     * @param framePrincipal
     * @param cliente
     */
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

        txtNome.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnAdicionar.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

/**
 * Faz as respectivas verificações para garantir as condições de criação de uma <code>Playlist</code>.
 */
        btnAdicionar.addActionListener(e -> {

            if (txtNome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor escreva o nome da playlist", "Campo vazio", JOptionPane.ERROR_MESSAGE);
            } else {
                String nome = txtNome.getText();
                if (playlistExiste(nome,framePrincipal)) {
                    JOptionPane.showMessageDialog(null, "Já existe uma playlist com este nome", "Nome repetido", JOptionPane.ERROR_MESSAGE);
                    txtNome.setText("");
                } else {
                    framePrincipal.getRockstar().addGrupoDeMusicas(cliente.criaPlaylist(nome));
                    txtNome.setText("");
                    JOptionPane.showMessageDialog(null, "Playlist adicionada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    public boolean playlistExiste(String nome, FramePrincipal framePrincipal) {
        for (GrupoMusicas g : framePrincipal.getRockstar().getGrupoMusicas()) {
            if (g instanceof Playlist && nome.equals(g.getTitulo())) {
                return true;
            }
        }
        return false;
    }
}
