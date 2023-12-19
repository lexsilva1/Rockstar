package GUI;

import javax.swing.*;

public class PainelPrincipal extends JPanel {

    public PainelPrincipal() {
        setLayout(null);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(160, 320, 80, 25);
        btnLogin.addActionListener(e -> exibirPainelLogin());
        add(btnLogin);

        JButton btnSignUp = new JButton("Sign up");
        btnSignUp.setBounds(360, 320, 80, 25);
        btnSignUp.addActionListener(e -> exibirPainelSignUp());
        add(btnSignUp);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(525, 5, 56, 26);
        btnSair.addActionListener(e -> System.exit(0));
        add(btnSair);
    }

    private void exibirPainelLogin() {
        FramePrincipal framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelLogin());
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }
    private void exibirPainelSignUp() {
        FramePrincipal framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelSignUp());
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }

}
