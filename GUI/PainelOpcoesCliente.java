package GUI;
import backend.Cliente;
import javax.swing.*;
import java.awt.*;

public class PainelOpcoesCliente extends JPanel {
    Cliente cliente;

    public PainelOpcoesCliente(Cliente cliente) {
        this.cliente=cliente;

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(400, 250));
        setVisible(true);



    }

}
