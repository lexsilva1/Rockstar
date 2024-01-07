package GUI;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PainelPrincipal extends JPanel {
    protected FramePrincipal framePrincipal;
    private JButton btnLogin;
    private JButton btnSignUp;
    private Image backgroundImage;




    public PainelPrincipal(FramePrincipal framePrincipal) {

        this.framePrincipal = framePrincipal;

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/Logo2.png"));
        backgroundImage = imageIcon.getImage();








        //setBackground(new Color(70, 90, 120));

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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenha a imagem de fundo
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
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
