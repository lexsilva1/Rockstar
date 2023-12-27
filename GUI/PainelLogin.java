package GUI;
import backend.Admin;
import backend.Cliente;
import backend.Musico;
import backend.Utilizador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PainelLogin extends JPanel {
    private FramePrincipal framePrincipal;
    private Image imagemDeFundo;

    public PainelLogin(FramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;
        this.imagemDeFundo = new ImageIcon(getClass().getResource("/resources/ockstar.png")).getImage();


        setLayout(null);

        JRadioButton chkMostrarCliente = new JRadioButton("Cliente");
        chkMostrarCliente.setBounds(50, 100, 100, 25);
        chkMostrarCliente.setBackground(Color.BLACK);
        chkMostrarCliente.setForeground(Color.WHITE);
        add(chkMostrarCliente);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(500, 200, 170, 25);
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setVisible(false);  // Inicialmente invisível
        add(lblUsername);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(600, 200, 170, 25);
        txtUsername.setVisible(false);  // Inicialmente invisível
        add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(500, 300, 80, 25);
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setVisible(false);
        add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(600, 300, 170, 25);
        txtPassword.setVisible(false);
        add(txtPassword);

        JCheckBox chkMostrarPass = new JCheckBox("Mostrar Password");
        chkMostrarPass.setBounds(600, 325, 150, 25);
        chkMostrarPass.setBackground(Color.BLACK);
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
        chkMostrarMusico.setBackground(Color.BLACK);
        chkMostrarMusico.setForeground(Color.WHITE);
        add(chkMostrarMusico);


        JLabel lblPin = new JLabel("Pin:");
        lblPin.setBounds(500, 400, 80, 25);
        lblPin.setForeground(Color.WHITE);
        lblPin.setVisible(false);
        add(lblPin);

        JPasswordField txtPin = new JPasswordField();
        txtPin.setBounds(600, 400, 170, 25);
        txtPin.setVisible(false);
        add(txtPin);

        JCheckBox chkMostrarPin = new JCheckBox("Mostrar Pin");
        chkMostrarPin.setBounds(600, 425, 150, 25);
        chkMostrarPin.setBackground(Color.BLACK);
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
        chkMostrarAdmin.setBackground(Color.BLACK);
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

        //Juntar os radiobuttons (cliente, musico, admin) para que não seja possível selecionar mais do que um
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
                    } else {
                        exibirPainelMusico((Musico) framePrincipal.getRockstar().login(txtUsername.getText(), String.valueOf(txtPassword.getPassword())));
                    }
                }

                if (chkMostrarCliente.isSelected()) {
                    if (((framePrincipal.getRockstar().login(txtUsername.getText(), String.valueOf(txtPassword.getPassword()))) == null)) {
                        JOptionPane.showMessageDialog(null, "Username ou Password incorretos", "Dados Incorretos", JOptionPane.ERROR_MESSAGE);
                    } else {
                        exibirPainelCliente((Cliente) framePrincipal.getRockstar().login(txtUsername.getText(), String.valueOf(txtPassword.getPassword())));
                    }
                }

                if (chkMostrarAdmin.isSelected()) {
                    if (((framePrincipal.getRockstar().login(txtUsername.getText(), String.valueOf(txtPassword.getPassword()))) == null)) {
                        JOptionPane.showMessageDialog(null, "Username ou Password incorretos", "Dados Incorretos", JOptionPane.ERROR_MESSAGE);
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Desenha a imagem de fundo
        g.drawImage(imagemDeFundo, 0, 0, getWidth(), getHeight(), this);
    }
}

