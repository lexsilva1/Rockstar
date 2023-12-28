package GUI;
import javax.swing.*;
import java.awt.*;

public class PainelPrincipal extends JPanel {
    protected FramePrincipal framePrincipal;
    private JButton btnLogin;
    private JButton btnSignUp;


    public PainelPrincipal(FramePrincipal framePrincipal) {

        this.framePrincipal = framePrincipal;
        setBackground(new Color(70, 90, 120));

        setLayout(null);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(260, 520, 80, 25);
        btnLogin.addActionListener(e -> exibirPainelLogin());
        add(btnLogin);

        btnSignUp = new JButton("Sign up");
        btnSignUp.setBounds(460, 520, 80, 25);
        btnSignUp.addActionListener(e -> exibirPainelSignUp());
        add(btnSignUp);

    }

    private void exibirPainelLogin() {
        framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelLogin(framePrincipal));
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }
    private void exibirPainelSignUp() {
        framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelSignUp(framePrincipal));
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JButton getBtnSignUp() {
        return btnSignUp;
    }

}
