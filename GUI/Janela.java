package GUI;

import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame {

    private final static int dimH = 300;
    private final static int dimV = 300;

    public Janela () {
        setSize(dimH,dimV);
        setTitle("RockStar Inc");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel paginaInicial = new JPanel();
        paginaInicial.setBackground(Color.BLACK);

        //Cria ícone para quando a app é minimizada
        Image icon = new ImageIcon("resources/icone.jpg").getImage();
        setIconImage(icon);

        //Cria painel com logotipo
        Image logotipo = new ImageIcon("resources/icone.jpg").getImage();
        ImagemDeFundo topoPagina = new ImagemDeFundo(logotipo);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(topoPagina, gbc);
        gbc.weighty = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(paginaInicial, gbc);

        JButton login = new JButton("Login");
        JButton signUp = new JButton("Sign Up");
        JButton exit = new JButton("Exit");
        paginaInicial.add(login, BorderLayout.CENTER);
        paginaInicial.add(signUp, BorderLayout.CENTER);
        paginaInicial.add(exit, BorderLayout.SOUTH);

        setVisible(true);
    }

}
