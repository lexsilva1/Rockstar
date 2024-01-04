package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.time.LocalDate;
import java.util.Arrays;

import backend.Promo;
import backend.Utilizador;
import backend.Admin;

public class PainelCriarCampanha extends JPanel {
    private FramePrincipal framePrincipal;
    private Admin admin;

    public PainelCriarCampanha(FramePrincipal framePrincipal, Admin admin) {
        this.framePrincipal = framePrincipal;
        this.admin = admin;



        setLayout(null);
        setBackground(new Color(70, 90, 120));
        ;
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

        JLabel lblAnoInicio = new JLabel("Ano");
        lblAnoInicio.setBounds(160, 170, 50, 25);
        lblAnoInicio.setForeground(Color.WHITE);
        add(lblAnoInicio);

        JTextField txtMesInicio = new JTextField();
        txtMesInicio.setBounds(200, 150, 50, 25);

        txtMesInicio.setForeground(Color.BLACK);
        add(txtMesInicio);

        JLabel lblMesInicio = new JLabel("Mês");
        lblMesInicio.setBounds(210, 170, 50, 25);
        lblMesInicio.setForeground(Color.WHITE);
        add(lblMesInicio);

        JTextField txtDiaInicio = new JTextField();
        txtDiaInicio.setBounds(250, 150, 50, 25);
        txtDiaInicio.setForeground(Color.BLACK);
        add(txtDiaInicio);

        JLabel lblDiaInicio = new JLabel("Dia");
        lblDiaInicio.setBounds(260, 170, 50, 25);
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

        JLabel lblAnoFim = new JLabel("Ano");
        lblAnoFim.setBounds(160, 220, 50, 25);
        lblAnoFim.setForeground(Color.WHITE);
        add(lblAnoFim);

        JTextField txtMesFim = new JTextField();
        txtMesFim.setBounds(200, 200, 50, 25);
        txtMesFim.setForeground(Color.BLACK);
        add(txtMesFim);

        JLabel lblMesFim = new JLabel("Mês");
        lblMesFim.setBounds(210, 220, 50, 25);
        lblMesFim.setForeground(Color.WHITE);
        add(lblMesFim);

        JTextField txtDiaFim = new JTextField();
        txtDiaFim.setBounds(250, 200, 50, 25);
        txtDiaFim.setForeground(Color.BLACK);
        add(txtDiaFim);

        JLabel lblDiaFim = new JLabel("Dia");
        lblDiaFim.setBounds(260, 220, 50, 25);
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

        btnCriar.addActionListener(e -> {
            if (txtNome.getText().isEmpty() || txtDesconto.getText().isEmpty() || txtNumeroCupoes.getText().isEmpty() || txtAnoFim.getText().isEmpty() || txtMesFim.getText().isEmpty() || txtDiaFim.getText().isEmpty() || txtAnoInicio.getText().isEmpty() || txtMesInicio.getText().isEmpty() || txtMesInicio.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os dados", "Campo vazio", JOptionPane.ERROR_MESSAGE);
            }else {
            for(Promo p : framePrincipal.getRockstar().getPromos()) {
                if (txtNome.getText().equals(p.getNome())) {
                    JOptionPane.showMessageDialog(null, "Campanha já existente", "Campanha já existente", JOptionPane.ERROR_MESSAGE);
                    txtNome.setText("");
                }
            }}
            if (verificarData(txtAnoInicio.getText(), txtMesInicio.getText(), txtDiaInicio.getText())) {
                String txtDataInicio = txtAnoInicio.getText() + "-" + txtMesInicio.getText() + "-" + txtDiaInicio.getText();
                LocalDate dataInicio = LocalDate.parse(txtDataInicio);
                if (verificarData(txtAnoFim.getText(), txtMesFim.getText(), txtDiaFim.getText())) {
                    String txtDataFim = txtAnoFim.getText() + "-" + txtMesFim.getText() + "-" + txtDiaFim.getText();
                    LocalDate dataFim = LocalDate.parse(txtDataFim);
                    String nome = txtNome.getText();
                    int desconto = Integer.parseInt(txtDesconto.getText());
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

                } else {
                    JOptionPane.showMessageDialog(this, "Data Final inválida", "Erro", JOptionPane.ERROR_MESSAGE);
                    txtAnoFim.setText("");
                    txtMesFim.setText("");
                    txtDiaFim.setText("");
                    }
            } else {
                JOptionPane.showMessageDialog(this, "Data Inicial inválida", "Erro", JOptionPane.ERROR_MESSAGE);
                txtAnoInicio.setText("");
                txtMesInicio.setText("");
                txtDiaInicio.setText("");
                }

      });

    }


    public boolean verificarData(String ano, String mes, String dia) {
        int ano1 = Integer.parseInt(ano);
        int mes1 = Integer.parseInt(mes);
        int dia1 = Integer.parseInt(dia);

        if (ano1 < LocalDate.now().getYear() || ano.length() > 4) {
            JOptionPane.showMessageDialog(null, "Ano deve ser posterior a hoje e conter apenas 4 dígitos", "Dados errados", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if ((mes1 < 1 || mes1 > 12) || mes1 < LocalDate.now().getMonthValue()) {
            JOptionPane.showMessageDialog(null, "Mês inválido", "Dados errados", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (mes.length() == 1 || dia.length() == 1) {
            JOptionPane.showMessageDialog(null, "Mês e dia devem ter 2 dígitos", "Dados errados", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (dia1 < 1 || dia1 > LocalDate.of(ano1, mes1, 1).lengthOfMonth() || dia1 < LocalDate.now().getDayOfMonth()) {
            JOptionPane.showMessageDialog(null, "Dia inválido para o mês especificado", "Dados errados", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}



