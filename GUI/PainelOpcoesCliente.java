package GUI;
import backend.Utilizador;

import javax.swing.*;
import java.awt.*;

public class PainelOpcoesCliente extends JPanel {
    Utilizador cliente;

    public PainelOpcoesCliente(Utilizador cliente) {
        this.cliente=cliente;

        setBackground(new Color(70, 90, 120));;
        setPreferredSize(new Dimension(400, 100));
        setVisible(true);

        JButton btnlimpaPesquisa = new JButton("Limpar \u007f");
        btnlimpaPesquisa.setBounds(300,300,85,25);
        btnlimpaPesquisa.setVisible(true);

    }

}
