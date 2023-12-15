package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PaginaInicial extends JPanel {
    private JButton entrar;
    private JButton registar;

    /**
     * Cria um novo painel <code>JPanel</code>, para a página inicial da app,
     * com um buffer duplo e um flow layout.
     */
    public PaginaInicial() {
        this.entrar = new JButton("Entrar");
        this.registar = new JButton("Registar");

        setBackground(Color.BLACK);

        // Cria um painel para envolver os botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotoes.setOpaque(false);

        // Adiciona os botões ao painelBotoes
        painelBotoes.add(entrar);
        painelBotoes.add(registar);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        // Adiciona o primeiro painel
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(painelBotoes, gbc);


        //Adiciona ação de mudar do painel (backend.Rockstar) para o painel 2 (a cinzento), com o botão login
        entrar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //Adiciona ação de mudar do painel 2 (a cinzento) para o painel (backend.Rockstar), com o botão Sign Up
        registar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }



}
