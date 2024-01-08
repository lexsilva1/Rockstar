package GUI;

import backend.Cliente;
import backend.Musico;
import backend.Utilizador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class PainelSignUp extends JPanel {
    protected final FramePrincipal [] armazenaFrame;
    private FramePrincipal framePrincipal;

    /**
     * Cria o Painel onde permite registar novos utilizadores.
     * @param framePrincipal
     */

    public PainelSignUp(FramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;
        this.armazenaFrame = new FramePrincipal[] {framePrincipal};

        setBackground(new Color(70, 90, 120));
        setLayout(null);

        JLabel lblNome = new JLabel("Nome completo:");
        lblNome.setBounds(10, 50, 120, 25);
        lblNome.setForeground(Color.WHITE);
        add(lblNome);


        JTextField txtNome = new JTextField();
        txtNome.setBounds(170, 50, 250, 25);
        add(txtNome);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(10, 100, 120, 25);
        lblUsername.setForeground(Color.WHITE);
        add(lblUsername);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(170, 100, 250, 25);
        add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(10, 150, 120, 25);
        lblPassword.setForeground(Color.WHITE);
        add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(170, 150, 250, 25);
        add(txtPassword);

        JLabel lblConfirmarPassword = new JLabel("Confirmar Password:");
        lblConfirmarPassword.setBounds(10, 200, 150, 25);
        lblConfirmarPassword.setForeground(Color.WHITE);
        add(lblConfirmarPassword);

        JPasswordField txtConfirmarPassword = new JPasswordField();
        txtConfirmarPassword.setBounds(170, 200, 250, 25);
        add(txtConfirmarPassword);

        JCheckBox chkMusico = new JCheckBox("Sou Músico");
        chkMusico.setBounds(170, 250, 150, 25);
        chkMusico.setBackground(new Color(70, 90, 120));
        chkMusico.setForeground(Color.WHITE);
        add(chkMusico);

        JCheckBox chkConfirmar = new JCheckBox("Confirmo que os dados introduzidos são verdadeiros");
        chkConfirmar.setBounds(10, 350, 450, 25);
        chkConfirmar.setBackground(new Color(70, 90, 120));
        chkConfirmar.setForeground(Color.WHITE);
        add(chkConfirmar);

        JLabel lblPin = new JLabel("Pin:");
        lblPin.setBounds(10, 300, 120, 25);
        lblPin.setForeground(Color.WHITE);
        lblPin.setVisible(false);
        add(lblPin);

        JTextField txtPinMusico = new JTextField();
        txtPinMusico.setBounds(170, 300, 150, 25);
        txtPinMusico.setVisible(false);
        add(txtPinMusico);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(10, 620, 70, 25);
        btnVoltar.addActionListener(e -> voltarPainelPrincipal());
        add(btnVoltar);

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(690, 620, 90, 25);


        chkMusico.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                lblPin.setVisible(true);
                txtPinMusico.setVisible(true); // Mostrar o campo de senha
            } else {
                lblPin.setVisible(false);
                txtPinMusico.setVisible(false); // Ocultar o campo de senha
            }
        });
        /**
         *Ao selecionar a checkbox 'chkConfirmar', verifica se o username já existe, se as passwords coincidem,
         *e se todos os campos estão preenchidos.
         *Quando as verificações são bem sucedidas, adiciona um botão "Continuar", caso contrário retira a seleção da checkbox
         */

        chkConfirmar.addItemListener(e -> {
           if (e.getStateChange() == ItemEvent.SELECTED) {
               /**
                *Verifica disponibilidade de username
                *ou dá mensagem de erro e apaga o conteúdo da caixa de texto, em caso negativo
                */
               if (!verificarUser(txtUsername.getText())) {
                   JOptionPane.showMessageDialog(null, "Utilizador já existe", "Erro", JOptionPane.ERROR_MESSAGE);
                   txtUsername.setText("");
               }
                /**
                *Verifica igualdade de passwords introduzidas
                *ou dá mensagem de erro e apaga o conteúdo da caixa de texto, em caso negativo
                */

               if (!Arrays.equals((txtPassword.getPassword()), txtConfirmarPassword.getPassword())) {
                   JOptionPane.showMessageDialog(null, "Password não coincide", "Erro", JOptionPane.ERROR_MESSAGE);
                   txtConfirmarPassword.setText("");
               }

               /**
                *Verifica se os campos 'username' e 'password' estão preenchidos e se as passwords coincidem
                *Verifica se é 'Musico' e, nesse caso, se o 'PIN' está preenchido
                *Add botão 'Continuar'
                *Remove seleção da checkbox e botão 'Continuar', caso verificações não sejam bem sucedidas
                *Remove botão 'Continuar', caso checkbox não esteja selecionada
                */
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
/**
 *  //Faz todas as verificações antes de permitir avançar para o painel seguinte (PainelLogin)
 *         //Add nova instância de 'Musico' ou 'Cliente' consoante a seleção do utilizador
 *         //Mostra mensagens de erro quando alguma verificação não é bem sucedida
 */

        btnContinuar.addActionListener(e -> {
            armazenaFrame[0] = (FramePrincipal) SwingUtilities.getWindowAncestor((Component) e.getSource()); //vai buscar o componente (botão) que é acionado
            String username = txtUsername.getText();
            String password = String.valueOf(txtPassword.getPassword());
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
                        JOptionPane.showMessageDialog(null, "Utilizador registado com sucesso", "Registo bem sucedido" , JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("Musico add");
                        framePrincipal.getContentPane().removeAll();
                        framePrincipal.getContentPane().add(new PainelLogin(framePrincipal));
                        framePrincipal.revalidate();
                        framePrincipal.repaint();
                    }
                } else {
                    Utilizador novoUtilizador = new Cliente(username, password);
                    framePrincipal.getRockstar().registo(novoUtilizador);
                    JOptionPane.showMessageDialog(null, "Utilizador registado com sucesso", "Registo bem sucedido" , JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Cliente add");
                    framePrincipal.getContentPane().removeAll();
                    framePrincipal.getContentPane().add(new PainelLogin(framePrincipal));
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

    private void voltarPainelPrincipal() {
        FramePrincipal framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelPrincipal(framePrincipal));
        framePrincipal.revalidate();
        framePrincipal.repaint();
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


