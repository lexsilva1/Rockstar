package GUI;

import backend.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static java.lang.Double.parseDouble;

public class PainelAddSaldo extends JPanel {
    Cliente cliente;

    public PainelAddSaldo(FramePrincipal frameprincipal, Cliente cliente,JLabel labelsaldo) {
        this.cliente=cliente;
        setLayout(null);
        setBackground(new Color(70, 90, 120));;
        setPreferredSize(new Dimension(450, 500));

        JLabel lblvalorCarregar = new JLabel("Valor a Carregar");
        lblvalorCarregar.setBounds(20, 200, 120, 25);
        add(lblvalorCarregar);

        JTextField txtsaldo = new JTextField();
        txtsaldo.setBounds(150, 200, 250, 25);
        add(txtsaldo);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(340,450,100,25);
        add(btnAdicionar);
        btnAdicionar.addActionListener ( e -> {
            carregarSaldo(txtsaldo.getText());
            txtsaldo.setText("");
            labelsaldo.setText("Saldo: " + String.valueOf(cliente.getSaldo()));
            labelsaldo.revalidate();
            labelsaldo.repaint();
            setVisible(false);

        });

        setVisible(false);


    }
    public void carregarSaldo(String saldo){
        double valor = Double.parseDouble(saldo);
        cliente.carregaSaldo(valor);

    }

}
