package GUI;

import backend.Utilizador;

import javax.swing.*;
public class PainelCriarPlaylist extends JPanel {
    private FramePrincipal framePrincipal;
    private Utilizador utilizador;
    private JButton btnLogout;
    private BotaoCarrinho btnCarrinhoCompras;
    private JButton btnVoltar;
    private JButton btnContinuar;

    public PainelCriarPlaylist(FramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;
        this.utilizador = utilizador;
        this.btnLogout = new JButton("Logout");
        this.btnCarrinhoCompras = new BotaoCarrinho("/resources/carrinho.jpg");
        this.btnVoltar = new JButton("Voltar");
        this.btnContinuar = new JButton("Continuar");




        setLayout(null);


        JLabel lblUsername = new JLabel("Nome da Playlist:");
        lblUsername.setBounds(20, 200, 120, 25);
        add(lblUsername);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(150, 200, 250, 25);
        add(txtUsername);

        btnLogout.setBounds(435, 10, 75, 25);
        btnLogout.addActionListener(e -> voltarPainelPrincipal());
        btnCarrinhoCompras.setBounds(525,10,50,30);
        btnVoltar.setBounds(10,425,75,25);
        btnVoltar.addActionListener(e -> voltarPainelCliente());
        btnContinuar.setBounds(470,425,95,25);

        add(btnLogout);
        add(btnCarrinhoCompras);
        add(btnVoltar);
        add(btnContinuar);

        setVisible(true);


    }

    private void voltarPainelPrincipal() {
        FramePrincipal framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelPrincipal(framePrincipal));
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }

    private void voltarPainelCliente() {
        framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelCliente(framePrincipal, utilizador));
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }

}
