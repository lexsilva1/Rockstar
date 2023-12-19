package GUI;

import javax.swing.*;
import java.awt.*;

public class FramePrincipal extends JFrame {

    public FramePrincipal() {
        super("Rockstar Inc");

        PainelPrincipal painelPrincipal = new PainelPrincipal();

        add(painelPrincipal);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        //Cria ícone para quando a app é minimizada
        Image icon = new ImageIcon("resources/icone.jpg").getImage();
        setIconImage(icon);
    }
}

