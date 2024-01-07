package GUI;
import backend.Admin;
import backend.Cliente;
import backend.Musico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PainelLogin extends JPanel {
    private FramePrincipal framePrincipal;

    public PainelLogin(FramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;
        setBackground(new Color(70, 90, 120));

        setLayout(null);

        JRadioButton chkMostrarCliente = new JRadioButton("Cliente");
        chkMostrarCliente.setBounds(50, 100, 100, 25);
        chkMostrarCliente.setBackground(new Color(70, 90, 120));
        chkMostrarCliente.setForeground(Color.WHITE);
        add(chkMostrarCliente);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(400, 200, 170, 25);
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setVisible(false);
        add(lblUsername);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(500, 200, 170, 25);
        txtUsername.setVisible(false);
        add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(400, 300, 80, 25);
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setVisible(false);
        add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(500, 300, 170, 25);
        txtPassword.setVisible(false);
        add(txtPassword);

        JCheckBox chkMostrarPass = new JCheckBox("Mostrar Password");
        chkMostrarPass.setBounds(500, 325, 150, 25);
        chkMostrarPass.setBackground(new Color(70, 90, 120));
        chkMostrarPass.setForeground(Color.WHITE);
        chkMostrarPass.setVisible(false);
        chkMostrarPass.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                txtPassword.setEchoChar((char) 0); // Mostrar senha
            } else {
                txtPassword.setEchoChar('•'); // Ocultar senha
            }
        });
        add(chkMostrarPass);

        chkMostrarCliente.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                lblUsername.setVisible(true);
                txtUsername.setVisible(true);
                lblPassword.setVisible(true);
                txtPassword.setVisible(true);
                chkMostrarPass.setVisible(true);
            } else {
                lblUsername.setVisible(false);
                txtUsername.setVisible(false);
                lblPassword.setVisible(false);
                txtPassword.setVisible(false);
                chkMostrarPass.setVisible(false);
            }
        });


        JRadioButton chkMostrarMusico = new JRadioButton("Músico");
        chkMostrarMusico.setBounds(50, 250, 100, 25);
        chkMostrarMusico.setBackground(new Color(70, 90, 120));
        chkMostrarMusico.setForeground(Color.WHITE);
        add(chkMostrarMusico);

        JLabel lblPin = new JLabel("Pin:");
        lblPin.setBounds(400, 400, 80, 25);
        lblPin.setForeground(Color.WHITE);
        lblPin.setVisible(false);
        add(lblPin);

        JPasswordField txtPin = new JPasswordField();
        txtPin.setBounds(500, 400, 170, 25);
        txtPin.setVisible(false);
        add(txtPin);

        JCheckBox chkMostrarPin = new JCheckBox("Mostrar Pin");
        chkMostrarPin.setBounds(500, 425, 150, 25);
        chkMostrarPin.setBackground(new Color(70, 90, 120));
        chkMostrarPin.setForeground(Color.WHITE);
        chkMostrarPin.setVisible(false);
        chkMostrarPin.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                txtPin.setEchoChar((char) 0); // Mostrar PIN
            } else {
                txtPin.setEchoChar('•'); // Ocultar PIN
            }
        });
        add(chkMostrarPin);

        chkMostrarMusico.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                lblUsername.setVisible(true);
                txtUsername.setVisible(true);
                lblPassword.setVisible(true);
                txtPassword.setVisible(true);
                chkMostrarPass.setVisible(true);
                lblPin.setVisible(true);
                txtPin.setVisible(true);
                chkMostrarPin.setVisible(true);
            } else {
                lblUsername.setVisible(false);
                txtUsername.setVisible(false);
                lblPassword.setVisible(false);
                txtPassword.setVisible(false);
                chkMostrarPass.setVisible(false);
                lblPin.setVisible(false);
                txtPin.setVisible(false);
                chkMostrarPin.setVisible(false);
            }
        });

        JRadioButton chkMostrarAdmin = new JRadioButton("Admin");
        chkMostrarAdmin.setBounds(50, 400, 100, 25);
        chkMostrarAdmin.setBackground(new Color(70, 90, 120));
        chkMostrarAdmin.setForeground(Color.WHITE);
        add(chkMostrarAdmin);

        chkMostrarAdmin.addItemListener(e -> {
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
        });

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(chkMostrarCliente);
        grupo.add(chkMostrarMusico);
        grupo.add(chkMostrarAdmin);

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(690, 620, 90, 25);
        add(btnContinuar);

        //Verifica se todos os campos estão preenchidos, o tipo de utilizador selecionado e se os dados estão corretos
        //Mostra o painel correspondente ao tipo de 'Utilizador'
        btnContinuar.addActionListener(e -> {
            if (txtUsername.getText().isEmpty() || String.valueOf(txtPassword.getPassword()).isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os dados", "Campo vazio", JOptionPane.ERROR_MESSAGE);
            } else {
                if (chkMostrarMusico.isSelected()) {
                    if (String.valueOf(txtPin.getPassword()).isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor introduza o PIN", "Campo vazio", JOptionPane.ERROR_MESSAGE);
                    } else if ((framePrincipal.getRockstar().loginMusico(txtUsername.getText(), String.valueOf(txtPassword.getPassword()), String.valueOf(txtPin.getPassword())) == null)) {
                        JOptionPane.showMessageDialog(null, "Username, Password ou PIN incorretos", "Dados Incorretos", JOptionPane.ERROR_MESSAGE);
                    }else if (!(framePrincipal.getRockstar().loginMusico(txtUsername.getText(), String.valueOf(txtPassword.getPassword()), String.valueOf(txtPin.getPassword())).isActivo())) {
                            JOptionPane.showMessageDialog(null, "Por favor contacte Administrador", "Utilizador Bloqueado", JOptionPane.ERROR_MESSAGE);
                    } else {
                        exibirPainelMusico((Musico) framePrincipal.getRockstar().login(txtUsername.getText(), String.valueOf(txtPassword.getPassword())));
                    }
                }

                if (chkMostrarCliente.isSelected()) {
                    if (((framePrincipal.getRockstar().login(txtUsername.getText(), String.valueOf(txtPassword.getPassword()))) == null)) {
                        JOptionPane.showMessageDialog(null, "Username ou Password incorretos", "Dados Incorretos", JOptionPane.ERROR_MESSAGE);
                    } else if (!((framePrincipal.getRockstar().login(txtUsername.getText(), String.valueOf(txtPassword.getPassword())) instanceof Cliente))) {
                        JOptionPane.showMessageDialog(null, "Dados introduzidos não correspondem a 'Cliente'", "Dados Incorretos", JOptionPane.ERROR_MESSAGE);
                    } else if (!((framePrincipal.getRockstar().login(txtUsername.getText(), String.valueOf(txtPassword.getPassword())).isActivo()))) {
                        JOptionPane.showMessageDialog(null, "Por favor contacte Administrador", "Utilizador Bloqueado", JOptionPane.ERROR_MESSAGE);
                    } else {
                        exibirPainelCliente((Cliente) framePrincipal.getRockstar().login(txtUsername.getText(), String.valueOf(txtPassword.getPassword())));
                    }
                }


                if (chkMostrarAdmin.isSelected()) {
                    if (((framePrincipal.getRockstar().login(txtUsername.getText(), String.valueOf(txtPassword.getPassword()))) == null)) {
                        JOptionPane.showMessageDialog(null, "Username ou Password incorretos", "Dados Incorretos", JOptionPane.ERROR_MESSAGE);
                    } else if (!((framePrincipal.getRockstar().login(txtUsername.getText(), String.valueOf(txtPassword.getPassword())) instanceof Admin))) {
                        JOptionPane.showMessageDialog(null, "Dados introduzidos não correspondem a 'Administrador'", "Dados Incorretos", JOptionPane.ERROR_MESSAGE);
                    } else if (!((framePrincipal.getRockstar().login(txtUsername.getText(), String.valueOf(txtPassword.getPassword())).isActivo()))) {
                        JOptionPane.showMessageDialog(null, "por favor contacte Administrador", "Utilizador Bloqueado", JOptionPane.ERROR_MESSAGE);
                    } else {
                        exibirPainelAdmin((Admin) framePrincipal.getRockstar().login(txtUsername.getText(), String.valueOf(txtPassword.getPassword())));
                    }
                }
            }
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(10, 620, 70, 25);
        btnVoltar.addActionListener(e -> voltarPainelPrincipal());
        add(btnVoltar);

    }

    /**
     * Método para limpar painel atual e gerar um novo 'PainelCliente'
     * @param cliente: instância de 'Utilizador' para que seja guardado no novo painel
     */
    private void exibirPainelCliente(Cliente cliente) {
        framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelCliente(framePrincipal, cliente));
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }

    /**
     * Método para limpar painel atual e gerar um novo 'PainelMusico'
     * @param musico: instância de 'Utilizador' para que seja guardado no novo painel
     */
    private void exibirPainelMusico(Musico musico) {
        framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelMusico(framePrincipal, musico));
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }

    /**
     * Método para limpar painel atual e gerar um novo 'PainelAdmin'
     * @param admin: instância de 'Utilizador' para que seja guardado no novo painel
     */
    private void exibirPainelAdmin(Admin admin) {
        framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelAdmin(framePrincipal, admin));
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }

    /**
     * Método para limpar painel atual e gerar um novo 'PainelPrincipal'
     */
    private void voltarPainelPrincipal() {
        framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelPrincipal(framePrincipal));
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }
}

