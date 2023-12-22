package GUI;

import backend.Cliente;
import backend.Musico;
import backend.Utilizador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class PainelSignUp extends JPanel {
private FramePrincipal framePrincipal;
    public PainelSignUp () {

        setLayout(null);

        framePrincipal = new FramePrincipal();

        JLabel lblNome = new JLabel("Nome completo:");
        lblNome.setBounds(10, 50, 120, 25);
        add(lblNome);


        JTextField txtNome = new JTextField();
        txtNome.setBounds(140, 50, 250, 25);
        add(txtNome);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(10, 100, 120, 25);
        add(lblUsername);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(140, 100, 250, 25);
        add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(10, 150, 120, 25);
        add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(140, 150, 250, 25);
        add(txtPassword);

        JLabel lblConfirmarPassword = new JLabel("Confirmar Password:");
        lblConfirmarPassword.setBounds(10, 200, 120, 25);
        add(lblConfirmarPassword);

        JPasswordField txtConfirmarPassword = new JPasswordField();
        txtConfirmarPassword.setBounds(140, 200, 250, 25);
        add(txtConfirmarPassword);

        JCheckBox chkMusico = new JCheckBox("Sou Músico");
        chkMusico.setBounds(140, 250, 150, 25);
        add(chkMusico);

        JCheckBox chkConfirmar = new JCheckBox("Confirmo que os dados introduzidos são verdadeiros");
        chkConfirmar.setBounds(10, 350, 500, 25);
        add(chkConfirmar);

        JLabel lblPin = new JLabel("Pin:");
        lblPin.setBounds(10, 300, 120, 25);
        lblPin.setVisible(false);  // Inicialmente invisível
        add(lblPin);

        JTextField txtPinMusico = new JTextField();
        txtPinMusico.setBounds(140, 300, 150, 25);
        txtPinMusico.setVisible(false);  // Inicialmente invisível
        add(txtPinMusico);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(10, 420, 70, 25);
        btnVoltar.addActionListener(e -> voltarPainelPrincipal());
        add(btnVoltar);

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(490, 420, 90, 25);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(525, 5, 56, 26);
        btnSair.addActionListener(e -> System.exit(0));
        add(btnSair);


        //Mostrar campos para introdução de atributos de um utilizador do tipo 'Musico'
        chkMusico.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                lblPin.setVisible(true);
                txtPinMusico.setVisible(true); // Mostrar o campo de senha
            } else {
                lblPin.setVisible(false);
                txtPinMusico.setVisible(false); // Ocultar o campo de senha
            }
        });

        //Ao selecionar a checkbox 'chkConfirmar', verifica se o username já existe, se as passwords coincidem,
        //e se todos os campos estão preenchidos.
        //Quando as verificações são bem sucedidas, adiciona um botão "Continuar", caso contrário retira a seleção da checkbox
       chkConfirmar.addItemListener(e -> {
           if (e.getStateChange() == ItemEvent.SELECTED) {
               //Verifica disponibilidade de username
               // ou dá mensagem de erro e apaga o conteúdo da caixa de texto, em caso negativo
               if (!verificarUser(txtUsername.getText(), framePrincipal)) {
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
                   if (chkMusico.isSelected()) {
                       if(!txtPinMusico.getText().isEmpty()) {
                           add(btnContinuar);
                       } else {
                           remove(btnContinuar);
                           chkConfirmar.setSelected(false);
                           revalidate();
                           repaint();
                       }
                   } else {
                       add(btnContinuar);
                   }
               } else {
                   remove(btnContinuar);
                   chkConfirmar.setSelected(false);
                   revalidate();
                   repaint();
               }

           } else {
               remove(btnContinuar);
           }
           revalidate();
           repaint();
       });


        //Faz todas as verificações antes de permitir avançar para o painel seguinte (PinelLogin)
        //Add nova instância de 'Musico' ou 'Cliente' consoante a seleção do utilizador
        //Mostra mensagens de erro quando alguma verificação não é bem sucedida
        btnContinuar.addActionListener(e -> {
            framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor((Component) e.getSource()); //vai buscar o componente (botão) que é acionado
            String username = "";
            String password = "";
            if (!txtUsername.getText().isEmpty() && !String.valueOf(txtPassword.getPassword()).isEmpty() && Arrays.equals(txtPassword.getPassword(), txtConfirmarPassword.getPassword())) {
                if (chkMusico.isSelected()) {
                    if (txtPinMusico.getText().isEmpty()) {
                        chkConfirmar.setSelected(false);
                        remove(btnContinuar);
                        JOptionPane.showMessageDialog(null, "Por favor preencha o PIN", "Campo 'PIN' vazio" , JOptionPane.ERROR_MESSAGE);
                        revalidate();
                        repaint();
                    } else {
                        String pin = txtPinMusico.getText();
                        Utilizador novoUtilizador = new Musico(username, password, pin);
                        framePrincipal.getRockstar().registo(novoUtilizador);
                        framePrincipal.getContentPane().removeAll();
                        framePrincipal.getContentPane().add(new PainelLogin());
                        framePrincipal.revalidate();
                        framePrincipal.repaint();
                    }
                } else {
                    username = txtUsername.getText();
                    password = Arrays.toString(txtPassword.getPassword());
                    Utilizador novoUtilizador = new Cliente(username, password);
                    framePrincipal.getRockstar().registo(novoUtilizador);
                    framePrincipal.getContentPane().removeAll();
                    framePrincipal.getContentPane().add(new PainelLogin());
                    framePrincipal.revalidate();
                    framePrincipal.repaint();
                }
            } else {
                chkConfirmar.setSelected(false);
                remove(btnContinuar);
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos", "Campo(s) obrigatório(s) vazio(s)" , JOptionPane.ERROR_MESSAGE);
                revalidate();
                repaint();
            }
        });

    }

    /**
     * Adiciona ação ao botão voltar.
     * Reconhece o botão que é ativado, remove tudo o que está no painel e cria um novo 'PainelPrincipal'.
     * Atualiza a interface gráfica.
     */
    private void voltarPainelPrincipal() {
        FramePrincipal framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelPrincipal());
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }


    /**
     * Verifica se o nome de utilizador introduzido, ao tentar registar um novo utilizador, já existe.
     * Return 'true' se o username não estiver a ser utilizado;
     * Return 'false' se o username já estiver a ser utilizado;
     */
    public boolean verificarUser (String username, FramePrincipal framePrincipal) {
        for (Utilizador c : framePrincipal.getRockstar().getUtilizadores()) {
            if (username.equals(c.getUsername())) {
                return false;
            }
        }
        return true;
    }
}


