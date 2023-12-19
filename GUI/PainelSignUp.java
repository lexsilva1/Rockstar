package GUI;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PainelSignUp extends JPanel {

    public PainelSignUp () {

    setLayout(null);

    JLabel lblNome = new JLabel("Nome completo:");
    lblNome.setBounds(10, 30, 120, 25);
    add(lblNome);

    JTextField txtNome = new JTextField();
    txtNome.setBounds(140, 30, 250, 25);
    add(txtNome);

    JLabel lblEmail = new JLabel("Email:");
    lblEmail.setBounds(10, 80, 120, 25);
    add(lblEmail);

    JTextField txtEmail = new JTextField();
    txtEmail.setBounds(140, 80, 250, 25);
    add(txtEmail);

    JLabel lblNIF = new JLabel("NIF:");
    lblNIF.setBounds(10, 130, 120, 25);
    add(lblNIF);

    JTextField txtNIF = new JTextField();
    txtNIF.setBounds(140, 130, 250, 25);
    add(txtNIF);

    JLabel lblUsername = new JLabel("Username:");
    lblUsername.setBounds(10, 180, 120, 25);
    add(lblUsername);

    JTextField txtUsername = new JTextField();
    txtUsername.setBounds(140, 180, 250, 25);
    add(txtUsername);

    JLabel lblPassword = new JLabel("Password:");
    lblPassword.setBounds(10, 230, 120, 25);
    add(lblPassword);

    JPasswordField txtPassword = new JPasswordField();
    txtPassword.setBounds(140, 230, 250, 25);
    add(txtPassword);

    JLabel lblConfirmarPassword = new JLabel("Confirmar Password:");
    lblConfirmarPassword.setBounds(10, 280, 120, 25);
    add(lblConfirmarPassword);

    JPasswordField txtConfirmarPassword = new JPasswordField();
    txtConfirmarPassword.setBounds(140, 280, 250, 25);
    add(txtConfirmarPassword);



    JCheckBox chkMostrarSenha = new JCheckBox("Sou Músico");
    chkMostrarSenha.setBounds(140, 330, 150, 25);
    add(chkMostrarSenha);

    JLabel lblPin = new JLabel("Pin:");
    lblPin.setBounds(10, 370, 120, 25);
    lblPin.setVisible(false);  // Inicialmente invisível
    add(lblPin);

    JTextField txtPinMusico = new JTextField();
        txtPinMusico.setBounds(140, 370, 150, 25);
        txtPinMusico.setVisible(false);  // Inicialmente invisível
        add(txtPinMusico);

        chkMostrarSenha.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    lblPin.setVisible(true);
                    txtPinMusico.setVisible(true); // Mostrar o campo de senha
                } else {
                    lblPin.setVisible(false);
                    txtPinMusico.setVisible(false); // Ocultar o campo de senha
                }
            }
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(10, 420, 70, 25);
        btnVoltar.addActionListener(e -> voltarPainelPrincipal());
        add(btnVoltar);

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(490, 420, 90, 25);
        btnContinuar.addActionListener(e -> voltarPainelLogin());
        add(btnContinuar);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(525, 5, 56, 26);
        btnSair.addActionListener(e -> System.exit(0));
        add(btnSair);
    }



    private void voltarPainelLogin() {
        FramePrincipal framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelLogin());
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }

    private void voltarPainelPrincipal() {
        FramePrincipal framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelPrincipal());
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }


}
