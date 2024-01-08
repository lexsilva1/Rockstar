package GUI;
import backend.Utilizador;

import javax.swing.*;
import java.awt.*;

/**
 * O <code>PainelOpcoes</code> é um painel auxiliar que aparece nos Paineis principais de todos os utilizadores.
 * Sempre que o utilizador carrega num dos botões presentes no seu painel, é aqui que são gerados os paineis que lhe
 * mostram a informação pretendida.
 */
public class PainelOpcoes extends JPanel {
    Utilizador cliente;

    public PainelOpcoes(Utilizador cliente) {
        this.cliente=cliente;

        setBackground(new Color(70, 90, 120));;
        setPreferredSize(new Dimension(400, 100));
        setVisible(true);

        JButton btnlimpaPesquisa = new JButton("Limpar \u007f");
        btnlimpaPesquisa.setBounds(300,300,85,25);
        btnlimpaPesquisa.setVisible(true);

    }

}
