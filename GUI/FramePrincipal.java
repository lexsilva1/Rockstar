package GUI;

import backend.Rockstar;

import javax.swing.*;
import java.awt.*;

public class FramePrincipal extends JFrame {
    private Rockstar rockstar;
    public FramePrincipal() {
        super("Rockstar");

        rockstar = new Rockstar();

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

    public Rockstar getRockstar() {
        return rockstar;
    }
}

