package GUI;
import backend.Cliente;
import backend.Utilizador;

import javax.swing.*;
import java.awt.*;

public class PainelOpcoesAdmin extends JPanel {
    Utilizador cliente;

    public PainelOpcoesAdmin(Utilizador cliente) {
        this.cliente=cliente;

        setBackground(new Color(70, 90, 120));;
        setPreferredSize(new Dimension(400, 100));
        setVisible(true);


    }

}