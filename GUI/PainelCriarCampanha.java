package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;

import backend.Admin;

public class PainelCriarCampanha extends JPanel {

    /**
     * Classe responsável por gerir o <code>ArrayList</code> carrinhoDeCompras do <code>Cliente</code>
     * @param framePrincipal
     * @param admin
     */
    public PainelCriarCampanha(FramePrincipal framePrincipal, Admin admin) {

        setLayout(null);
        setBackground(new Color(70, 90, 120));

        setPreferredSize(new Dimension(450, 500));

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 50, 120, 25);
        lblNome.setForeground(Color.WHITE);
        add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(150, 50, 250, 25);
        add(txtNome);

        JLabel lblDesconto = new JLabel("Desconto:");
        lblDesconto.setBounds(10, 100, 120, 25);
        lblDesconto.setForeground(Color.WHITE);
        add(lblDesconto);

        JTextField txtDesconto = new JTextField();
        txtDesconto.setBounds(150, 100, 70, 25);
        add(txtDesconto);

        JLabel lblPercentagem = new JLabel("%");
        lblPercentagem.setBounds(220, 100, 70, 25);
        lblPercentagem.setForeground(Color.WHITE);
        add(lblPercentagem);

        JLabel lblDataInicio = new JLabel("Data de início:");
        lblDataInicio.setBounds(10, 150, 120, 25);
        lblDataInicio.setForeground(Color.WHITE);
        add(lblDataInicio);

        JTextField txtAnoInicio = new JTextField();
        txtAnoInicio.setBounds(150, 150, 50, 25);
        txtAnoInicio.setForeground(Color.BLACK);
        add(txtAnoInicio);

        JLabel lblAnoInicio = new JLabel("AAAA");
        lblAnoInicio.setBounds(155, 170, 50, 25);
        lblAnoInicio.setForeground(Color.WHITE);
        add(lblAnoInicio);

        JTextField txtMesInicio = new JTextField();
        txtMesInicio.setBounds(200, 150, 50, 25);

        txtMesInicio.setForeground(Color.BLACK);
        add(txtMesInicio);

        JLabel lblMesInicio = new JLabel("MM");
        lblMesInicio.setBounds(205, 170, 50, 25);
        lblMesInicio.setForeground(Color.WHITE);
        add(lblMesInicio);

        JTextField txtDiaInicio = new JTextField();
        txtDiaInicio.setBounds(250, 150, 50, 25);
        txtDiaInicio.setForeground(Color.BLACK);
        add(txtDiaInicio);

        JLabel lblDiaInicio = new JLabel("DD");
        lblDiaInicio.setBounds(255, 170, 50, 25);
        lblDiaInicio.setForeground(Color.WHITE);
        add(lblDiaInicio);

        JLabel lblDataFim = new JLabel("Data de fim:");
        lblDataFim.setBounds(10, 200, 120, 25);
        lblDataFim.setForeground(Color.WHITE);
        add(lblDataFim);

        JTextField txtAnoFim = new JTextField();
        txtAnoFim.setBounds(150, 200, 50, 25);
        txtAnoFim.setForeground(Color.BLACK);
        add(txtAnoFim);

        JLabel lblAnoFim = new JLabel("AAAA");
        lblAnoFim.setBounds(155, 220, 50, 25);
        lblAnoFim.setForeground(Color.WHITE);
        add(lblAnoFim);

        JTextField txtMesFim = new JTextField();
        txtMesFim.setBounds(200, 200, 50, 25);
        txtMesFim.setForeground(Color.BLACK);
        add(txtMesFim);

        JLabel lblMesFim = new JLabel("MM");
        lblMesFim.setBounds(205, 220, 50, 25);
        lblMesFim.setForeground(Color.WHITE);
        add(lblMesFim);

        JTextField txtDiaFim = new JTextField();
        txtDiaFim.setBounds(250, 200, 50, 25);
        txtDiaFim.setForeground(Color.BLACK);
        add(txtDiaFim);

        JLabel lblDiaFim = new JLabel("DD");
        lblDiaFim.setBounds(255, 220, 50, 25);
        lblDiaFim.setForeground(Color.WHITE);
        add(lblDiaFim);

        JLabel lblNumeroCupoes = new JLabel("Nº de cupões:");
        lblNumeroCupoes.setBounds(10, 250, 120, 25);
        lblNumeroCupoes.setForeground(Color.WHITE);
        add(lblNumeroCupoes);

        JTextField txtNumeroCupoes = new JTextField();
        txtNumeroCupoes.setBounds(150, 250, 70, 25);
        add(txtNumeroCupoes);


        JButton btnCriar = new JButton("Criar");
        btnCriar.setBounds(290, 360, 75, 25);
        btnCriar.setForeground(Color.BLACK);
        add(btnCriar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(180, 360, 100, 25);
        btnCancelar.setForeground(Color.BLACK);
        add(btnCancelar);

        txtNome.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnCriar.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        txtAnoInicio.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!Character.isDigit(input) || txtAnoInicio.getText().length() == 4) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnCriar.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnCriar.doClick();
                }
            }
        });

        txtMesInicio.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!Character.isDigit(input) || txtMesInicio.getText().length() == 2) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnCriar.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        txtDiaInicio.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!Character.isDigit(input) || txtDiaInicio.getText().length() == 2) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnCriar.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        txtAnoFim.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!Character.isDigit(input) || txtAnoFim.getText().length() == 4) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnCriar.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        txtMesFim.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!Character.isDigit(input) || txtMesFim.getText().length() == 2) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnCriar.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        txtDiaFim.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!Character.isDigit(input) || txtDiaFim.getText().length() == 2) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnCriar.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        txtNumeroCupoes.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (txtNumeroCupoes.getText().length() == 3) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnCriar.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        txtDesconto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnCriar.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

/**
 * O ActionListener cria a Promo, verifica se existe uma promo com o mesmo nome, e a data de inicio da campanha.
 * Não permite a criação da promo na eventualidade de já existir uma com o mesmo nome, ou de a data de inicio ser inferior à data atual.
 */
        btnCriar.addActionListener(e -> {
            if (txtNome.getText().isEmpty() || txtDesconto.getText().isEmpty() || txtNumeroCupoes.getText().isEmpty() || txtAnoFim.getText().isEmpty() || txtMesFim.getText().isEmpty() || txtDiaFim.getText().isEmpty() || txtAnoInicio.getText().isEmpty() || txtMesInicio.getText().isEmpty() || txtMesInicio.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os dados", "Campo vazio", JOptionPane.ERROR_MESSAGE);

            } else {
                if (admin.promoExiste(framePrincipal.getRockstar(), txtNome.getText())) {
                    JOptionPane.showMessageDialog(null, "Já existe campanha com o mesmo nome", "Campanha já existe", JOptionPane.ERROR_MESSAGE);

                    txtNome.setText("");
                } else {
                    if (Integer.parseInt(txtDesconto.getText()) > 50) {
                        JOptionPane.showMessageDialog(null, "Desconto máximo permitido: 50%", "Desconto inválido", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (verificarDataInicio(txtAnoInicio.getText(), txtMesInicio.getText(), txtDiaInicio.getText())) {
                            String txtDataInicio = txtAnoInicio.getText() + "-" + txtMesInicio.getText() + "-" + txtDiaInicio.getText();
                            LocalDate dataInicio = LocalDate.parse(txtDataInicio);
                            if (verificarDataFim(txtAnoFim.getText(), txtMesFim.getText(), txtDiaFim.getText(), dataInicio)) {
                                String txtDataFim = txtAnoFim.getText() + "-" + txtMesFim.getText() + "-" + txtDiaFim.getText();
                                LocalDate dataFim = LocalDate.parse(txtDataFim);
                                if (dataFim.isBefore(dataInicio)) {
                                    txtAnoFim.setText("");
                                    txtMesFim.setText("");
                                    txtDiaFim.setText("");
                                } else {
                                    String nome = txtNome.getText();
                                    double desconto = Double.parseDouble(txtDesconto.getText());
                                    int numeroCupoes = Integer.parseInt(txtNumeroCupoes.getText());
                                    framePrincipal.getRockstar().addPromo(admin, numeroCupoes, nome, desconto, dataInicio, dataFim);
                                    JOptionPane.showMessageDialog(null, "Campanha criada com sucesso");
                                    txtNome.setText("");
                                    txtDesconto.setText("");
                                    txtNumeroCupoes.setText("");
                                    txtAnoInicio.setText("");
                                    txtMesInicio.setText("");
                                    txtDiaInicio.setText("");
                                    txtAnoFim.setText("");
                                    txtMesFim.setText("");
                                    txtDiaFim.setText("");
                                    setVisible(false);
                                }

                            } else {
                                txtAnoFim.setText("");
                                txtMesFim.setText("");
                                txtDiaFim.setText("");
                            }
                        } else {
                            txtAnoInicio.setText("");
                            txtMesInicio.setText("");
                            txtDiaInicio.setText("");
                        }
                    }
                }
            }
      });
    }

    /**
     * Metodo utilizado na criação de <code>Promo</code> para assegurar a correcta inserção de dados,
     * e que a data de início da <code>Promo</code> é igyal ou superior à data atual;
     * @param anoInicio
     * @param mesInicio
     * @param diaInicio
     * @return
     */
    public boolean verificarDataInicio(String anoInicio, String mesInicio, String diaInicio) {
        int ano1 = Integer.parseInt(anoInicio);
        int mes1 = Integer.parseInt(mesInicio);
        int dia1 = Integer.parseInt(diaInicio);

        if (ano1 < LocalDate.now().getYear()) {
            JOptionPane.showMessageDialog(null, "Ano não deve ser anterior ao ano atual", "Dados errados", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (mes1 < 1 || mes1 > 12 || mes1 < LocalDate.now().getMonthValue()) {
            JOptionPane.showMessageDialog(null, "Mês inválido", "Dados errados", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (dia1 < 1 || dia1 > 31) {
            JOptionPane.showMessageDialog(null, "Dia inválido", "Dados errados", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (dia1 > LocalDate.of(ano1, mes1, 1).lengthOfMonth()) {
            JOptionPane.showMessageDialog(null, "Dia inválido para o mês especificado", "Dados errados", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            LocalDate dataInicio = LocalDate.of(ano1, mes1, dia1);
            LocalDate hoje = LocalDate.now();
            if (dataInicio.isBefore(hoje)) {
                JOptionPane.showMessageDialog(null, "Data não deve ser anterior à data atual", "Dados errados", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        }
    }

    /**
     * Assegura que os dados para a criação da data foram introduzidos correctamente.
     * @param anoFim
     * @param mesFim
     * @param diaFim
     * @param dataInicio
     * @return
     */
    public boolean verificarDataFim(String anoFim, String mesFim, String diaFim, LocalDate dataInicio) {

        int anoFim1 = Integer.parseInt(anoFim);
        int mesFim1 = Integer.parseInt(mesFim);
        int diaFim1 = Integer.parseInt(diaFim);

        if (anoFim.length() < 4) {
            JOptionPane.showMessageDialog(null, "Ano deve conter 4 dígitos", "Dados errados", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (mesFim1 < 1 || mesFim1 > 12) {
            JOptionPane.showMessageDialog(null, "Mês inválido", "Dados errados", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (diaFim1 < 1 || diaFim1 > 31) {
            JOptionPane.showMessageDialog(null, "Dia inválido", "Dados errados", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (diaFim1 > LocalDate.of(anoFim1, mesFim1, 1).lengthOfMonth()) {
            JOptionPane.showMessageDialog(null, "Dia inválido para o mês especificado", "Dados errados", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            LocalDate dataFim = LocalDate.of(anoFim1, mesFim1, diaFim1);
            if (dataFim.isBefore(dataInicio)) {
                JOptionPane.showMessageDialog(null, "Data Fim não deve ser anterior à Data Início", "Dados errados", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        }
    }
}



