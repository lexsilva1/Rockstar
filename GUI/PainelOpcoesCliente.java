package GUI;
import backend.Cliente;
import javax.swing.*;
import java.awt.*;

public class PainelOpcoesCliente extends JPanel {
    Cliente cliente;

    public PainelOpcoesCliente(Cliente cliente) {
        this.cliente=cliente;

        setBackground(new Color(70, 90, 120));;
        setPreferredSize(new Dimension(400, 250));
        setVisible(true);



    }

}
