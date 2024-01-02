package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.Arrays;

import backend.Cliente;
import backend.Musico;
import backend.Utilizador;
import backend.Admin;

public class PainelCriarAdmin extends JPanel {
    private FramePrincipal framePrincipal;

    public PainelCriarAdmin(FramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;


        setLayout(null);
        setBackground(new Color(70, 90, 120));
        ;
        setPreferredSize(new Dimension(450, 500));

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(10, 100, 120, 25);
        lblUsername.setForeground(Color.WHITE);
        add(lblUsername);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(140, 100, 250, 25);
        add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(10, 150, 120, 25);
        lblPassword.setForeground(Color.WHITE);
        add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(140, 150, 250, 25);
        add(txtPassword);

        JLabel lblConfirmarPassword = new JLabel("Confirmar Password:");
        lblConfirmarPassword.setBounds(10, 200, 120, 25);
        lblConfirmarPassword.setForeground(Color.WHITE);
        add(lblConfirmarPassword);

        JPasswordField txtConfirmarPassword = new JPasswordField();
        txtConfirmarPassword.setBounds(140, 200, 250, 25);
        add(txtConfirmarPassword);

        JCheckBox chkConfirmar = new JCheckBox("Confirmo que os dados introduzidos são verdadeiros");
        chkConfirmar.setBounds(10, 350, 350, 25);
        chkConfirmar.setBackground(new Color(70, 90, 120));
        chkConfirmar.setForeground(Color.WHITE);
        add(chkConfirmar);

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(10, 370, 150, 25);
        add(btnContinuar);

        //Ao selecionar a checkbox 'chkConfirmar', verifica se o username já existe, se as passwords coincidem,
        //e se todos os campos estão preenchidos.
        //Quando as verificações são bem sucedidas, adiciona um botão "Continuar", caso contrário retira a seleção da checkbox
        chkConfirmar.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                //Verifica disponibilidade de username
                // ou dá mensagem de erro e apaga o conteúdo da caixa de texto, em caso negativo
                if (!verificarUser(txtUsername.getText())) {
                    JOptionPane.showMessageDialog(null, "Utilizador já existe", "Erro", JOptionPane.ERROR_MESSAGE);
                    txtUsername.setText("");
                }

                //Verifica igualdade de passwords introduzidas
                // ou dá mensagem de erro e apaga o conteúdo da caixa de texto, em caso negativo
                if (!Arrays.equals((txtPassword.getPassword()), txtConfirmarPassword.getPassword())) {
                    JOptionPane.showMessageDialog(null, "Password não coincide", "Erro", JOptionPane.ERROR_MESSAGE);
                    txtConfirmarPassword.setText("");
                }

                //Verifica se os campos 'username' e 'password' estão preenchidos e se as passwords coincidem
                //Verifica se é 'Musico' e, nesse caso, se o 'PIN' está preenchido
                //Add botão 'Continuar'
                //Remove seleção da checkbox e botão 'Continuar', caso verificações não sejam bem sucedidas
                //Remove botão 'Continuar', caso checkbox não esteja selecionada
                if (!txtUsername.getText().isEmpty() && !String.valueOf(txtPassword.getPassword()).isEmpty() && Arrays.equals(txtPassword.getPassword(), txtConfirmarPassword.getPassword()))  {
                        add(btnContinuar);
                    }
                } else {
                    remove(btnContinuar);
                    chkConfirmar.setSelected(false);
                    revalidate();
                    repaint();
                }
            revalidate();
            repaint();
        });
        //Faz todas as verificações antes de permitir avançar para o painel seguinte (PainelLogin)
        //Add nova instância de 'Musico' ou 'Cliente' consoante a seleção do utilizador
        //Mostra mensagens de erro quando alguma verificação não é bem sucedida
        btnContinuar.addActionListener(e -> {
            String username;
            String password;
            if (!txtUsername.getText().isEmpty() && !String.valueOf(txtPassword.getPassword()).isEmpty() && Arrays.equals(txtPassword.getPassword(), txtConfirmarPassword.getPassword())) {
                    username = txtUsername.getText();
                    password = String.valueOf(txtPassword.getPassword());;
                    Utilizador novoUtilizador = new Admin(username, password);
                    framePrincipal.getRockstar().registo(novoUtilizador);
                    JOptionPane.showMessageDialog(null, "Utilizador registado com sucesso", "Registo bem sucedido" , JOptionPane.INFORMATION_MESSAGE);

            } else {
                chkConfirmar.setSelected(false);
                remove(btnContinuar);
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos", "Campo(s) obrigatório(s) vazio(s)" , JOptionPane.ERROR_MESSAGE);
                revalidate();
                repaint();
            }
        });
    }

        public boolean verificarUser (String username) {
            for (Utilizador c : framePrincipal.getRockstar().getUtilizadores()) {
                if (username.equals(c.getUsername())) {
                    return false;
                }
            }
            return true;
        }
}