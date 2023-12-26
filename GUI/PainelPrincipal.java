package GUI;
import javax.swing.*;

public class PainelPrincipal extends JPanel {
    protected FramePrincipal framePrincipal;
    private JButton btnLogin;
    private JButton btnSignUp;

    public PainelPrincipal(FramePrincipal framePrincipal) {

        this.framePrincipal = framePrincipal;

        setLayout(null);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(160, 320, 80, 25);
        btnLogin.addActionListener(e -> exibirPainelLogin());
        add(btnLogin);

        btnSignUp = new JButton("Sign up");
        btnSignUp.setBounds(360, 320, 80, 25);
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
