package GUI;
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class PainelLogin extends JPanel {
    public PainelLogin() {

        setLayout(null);

        JRadioButton chkMostrarCliente = new JRadioButton("Cliente");
        chkMostrarCliente.setBounds(50, 100, 100, 25);
        add(chkMostrarCliente);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(250, 100, 170, 25);
        lblUsername.setVisible(false);  // Inicialmente invisível
        add(lblUsername);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(350, 100, 170, 25);
        txtUsername.setVisible(false);  // Inicialmente invisível
        add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(250, 200, 80, 25);
        lblPassword.setVisible(false);
        add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(350, 200, 170, 25);
        txtPassword.setVisible(false);
        add(txtPassword);

        JCheckBox chkMostrarPass = new JCheckBox("Mostrar Password");
        chkMostrarPass.setBounds(350, 225, 150, 25);
        chkMostrarPass.setVisible(false);
        chkMostrarPass.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtPassword.setEchoChar((char) 0); // Mostrar senha
                } else {
                    txtPassword.setEchoChar('•'); // Ocultar senha
                }
            }
        });
        add(chkMostrarPass);

        chkMostrarCliente.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    lblUsername.setVisible(true);
                    txtUsername.setVisible(true); // Mostrar o campo de senha
                    lblPassword.setVisible(true);
                    txtPassword.setVisible(true);
                    chkMostrarPass.setVisible(true);
                } else {
                    lblUsername.setVisible(false);
                    txtUsername.setVisible(false); // Ocultar o campo de senha
                    lblPassword.setVisible(false);
                    txtPassword.setVisible(false);
                    chkMostrarPass.setVisible(false);
                }
            }
        });



        JRadioButton chkMostrarMusico = new JRadioButton("Músico");
        chkMostrarMusico.setBounds(50, 170, 100, 25);
        add(chkMostrarMusico);


        JLabel lblPin = new JLabel("Pin:");
        lblPin.setBounds(250, 300, 80, 25);
        lblPin.setVisible(false);
        add(lblPin);

        JPasswordField txtPin = new JPasswordField();
        txtPin.setBounds(350, 300, 170, 25);
        txtPin.setVisible(false);
        add(txtPin);

        JCheckBox chkMostrarPin = new JCheckBox("Mostrar Pin");
        chkMostrarPin.setBounds(350, 325, 150, 25);
        chkMostrarPin.setVisible(false);
        chkMostrarPin.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtPin.setEchoChar((char) 0); // Mostrar senha
                } else {
                    txtPin.setEchoChar('•'); // Ocultar senha
                }
            }
        });
        add(chkMostrarPin);

        chkMostrarMusico.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    lblUsername.setVisible(true);
                    txtUsername.setVisible(true); // Mostrar o campo de senha
                    lblPassword.setVisible(true);
                    txtPassword.setVisible(true);
                    chkMostrarPass.setVisible(true);
                    lblPin.setVisible(true);
                    txtPin.setVisible(true);
                    chkMostrarPin.setVisible(true);
                } else {
                    lblUsername.setVisible(false);
                    txtUsername.setVisible(false); // Ocultar o campo de senha
                    lblPassword.setVisible(false);
                    txtPassword.setVisible(false);
                    chkMostrarPass.setVisible(false);
                    lblPin.setVisible(false);
                    txtPin.setVisible(false);
                    chkMostrarPin.setVisible(false);
                }
            }
        });

        JRadioButton chkMostrarAdmin = new JRadioButton("Admin");
        chkMostrarAdmin.setBounds(50, 240, 100, 25);
        add(chkMostrarAdmin);

        chkMostrarAdmin.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    lblUsername.setVisible(true);
                    txtUsername.setVisible(true); // Mostrar o campo de senha
                    lblPassword.setVisible(true);
                    txtPassword.setVisible(true);
                    chkMostrarPass.setVisible(true);
                } else {
                    lblUsername.setVisible(false);
                    txtUsername.setVisible(false); // Ocultar o campo de senha
                    lblPassword.setVisible(false);
                    txtPassword.setVisible(false);
                    chkMostrarPass.setVisible(false);
                }
            }
        });

        ButtonGroup groupo = new ButtonGroup();//Juntar os radiobuttons (cliente, musico, admin) para que não seja possível selecionar mais que um
        groupo.add(chkMostrarCliente);
        groupo.add(chkMostrarMusico);
        groupo.add(chkMostrarAdmin);

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(490, 420, 90, 25);
        add(btnContinuar);
        chkMostrarMusico.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent c) {
                if (c.getStateChange() == ItemEvent.SELECTED) {
                   btnContinuar.addActionListener(e -> exibirPainelMusico());
                }
            }
        });


        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(10, 420, 70, 25);
        btnVoltar.addActionListener(e -> voltarPainelPrincipal());
        add(btnVoltar);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(525, 5, 56, 26);
        btnSair.addActionListener(e -> System.exit(0));
        add(btnSair);
    }

    private void exibirPainelCliente() {
        FramePrincipal framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelCliente());
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }

    private void exibirPainelMusico() {
        FramePrincipal framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelMusico());
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
