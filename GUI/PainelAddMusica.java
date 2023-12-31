package GUI;

import backend.Admin;
import backend.Cliente;
import backend.Musico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Enumeration;

public class PainelAddMusica extends JPanel {
    public PainelAddMusica(FramePrincipal framePrincipal, Musico musico) {

        setLayout(null);
        setBackground(new Color(70, 90, 120));;
        setPreferredSize(new Dimension(450, 500));


        JLabel lblTitulo = new JLabel("Título");
        lblTitulo.setBounds(25, 40, 220, 25);
        lblTitulo.setForeground(Color.WHITE);
        add(lblTitulo);

        JTextField txtTitulo = new JTextField();
        txtTitulo.setBounds(250, 40, 220, 25);
        txtTitulo.setForeground(Color.BLACK);
        add(txtTitulo);

        JLabel lblGenero = new JLabel("Género");
        lblGenero.setBounds(25, 100, 220, 25);
        lblGenero.setForeground(Color.WHITE);
        add(lblGenero);

        JLabel lblData = new JLabel("Data de lançamento");
        lblData.setBounds(25, 190, 220, 25);
        lblData.setForeground(Color.WHITE);
        add(lblData);

        JTextField txtAno = new JTextField();
        txtAno.setBounds(250, 190, 50, 25);
        txtAno.setForeground(Color.BLACK);
        add(txtAno);

        JLabel lblAno = new JLabel("Ano");
        lblAno.setBounds(260, 210, 50, 25);
        lblAno.setForeground(Color.WHITE);
        add(lblAno);

        JTextField txtMes = new JTextField();
        txtMes.setBounds(300, 190, 50, 25);
        txtMes.setForeground(Color.BLACK);
        add(txtMes);

        JLabel lblMes = new JLabel("Mês");
        lblMes.setBounds(310, 210, 50, 25);
        lblMes.setForeground(Color.WHITE);
        add(lblMes);

        JTextField txtDia = new JTextField();
        txtDia.setBounds(350, 190, 50, 25);
        txtDia.setForeground(Color.BLACK);
        add(txtDia);

        JLabel lblDia = new JLabel("Dia");
        lblDia.setBounds(360, 210, 50, 25);
        lblDia.setForeground(Color.WHITE);
        add(lblDia);


        JLabel lblValor = new JLabel("Valor (€)");
        lblValor.setBounds(25, 250, 220, 25);
        lblValor.setForeground(Color.WHITE);
        add(lblValor);

        JTextField txtValor = new JTextField();
        txtValor.setBounds(250, 250, 220, 25);
        txtValor.setForeground(Color.BLACK);
        add(txtValor);


        JRadioButton chkPop = new JRadioButton("Pop");
        chkPop.setBounds(25, 130, 85, 25);
        chkPop.setBackground(new Color(70, 90, 120));
        chkPop.setForeground(Color.WHITE);
        chkPop.setSelected(false);
        add(chkPop);

        JRadioButton chkRock = new JRadioButton("Rock");
        chkRock.setBounds(110, 130, 85, 25);
        chkRock.setBackground(new Color(70, 90, 120));
        chkRock.setForeground(Color.WHITE);
        chkRock.setSelected(false);
        add(chkRock);

        JRadioButton chkHipHop = new JRadioButton("Hip Hop");
        chkHipHop.setBounds(195, 130, 85, 25);
        chkHipHop.setBackground(new Color(70, 90, 120));
        chkHipHop.setForeground(Color.WHITE);
        chkHipHop.setSelected(false);
        add(chkHipHop);

        JRadioButton chkPimba = new JRadioButton("Pimba");
        chkPimba.setBounds(310, 130, 85, 25);
        chkPimba.setBackground(new Color(70, 90, 120));
        chkPimba.setForeground(Color.WHITE);
        chkPimba.setSelected(false);
        add(chkPimba);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(chkPop);
        grupo.add(chkRock);
        grupo.add(chkHipHop);
        grupo.add(chkPimba);

        JButton btnCriar = new JButton("Criar");
        btnCriar.setBounds(380, 310, 75, 25);
        btnCriar.setForeground(Color.BLACK);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(280, 310, 100, 25);
        btnCancelar.setForeground(Color.BLACK);

        btnCriar.addActionListener(e -> {
            if (txtTitulo.getText().isEmpty() || txtAno.getText().isEmpty() || txtMes.getText().isEmpty() || txtDia.getText().isEmpty() || txtValor.getText().isEmpty() || grupo.getSelection() == null) {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os dados", "Campo vazio", JOptionPane.ERROR_MESSAGE);
            } else {
                double valor = Double.parseDouble(txtValor.getText());
                String txtData = txtAno.getText() + "-" + txtMes.getText() + "-" + txtDia.getText();
                LocalDate data = LocalDate.parse(txtData);
                String genero = "Rock";
                if (chkPop.isSelected()) {
                    genero = "Pop";
                } else if (chkPimba.isSelected()) {
                    genero = "Pimba";
                } else if (chkHipHop.isSelected()) {
                    genero = "Hip Hop";
                }
                framePrincipal.getRockstar().addMusica(musico, txtTitulo.getText(), genero, data, valor);
                JOptionPane.showMessageDialog(null, "Música adicionada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTitulo.setText("");
                txtAno.setText("");
                txtMes.setText("");
                txtDia.setText("");
                txtValor.setText("");
                setVisible(false);
            }
        });

        add(btnCriar);
        add(btnCancelar);
        add(lblTitulo);
        add(txtTitulo);
        add(lblGenero);
        add(lblData);
        add(txtAno);
        add(txtMes);
        add(txtDia);
        add(lblValor);
        add(txtValor);


        setVisible(false);

    }

}
