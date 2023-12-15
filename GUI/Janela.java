package GUI;
import backend.*;

import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame {

    private final static int dimH = 300;
    private final static int dimV = 300;

    public Janela () {
        Rockstar rockstar = new Rockstar();
        setSize(dimH,dimV);
        setTitle("RockStar Inc");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Cria ícone para quando a app é minimizada
        Image icon = new ImageIcon("resources/icone.jpg").getImage();
        setIconImage(icon);

        add(new PaginaInicial());

        setVisible(true);
    }

}
