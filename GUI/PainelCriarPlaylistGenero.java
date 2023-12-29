package GUI;

import backend.Cliente;
import backend.Utilizador;

import javax.swing.*;
import java.awt.*;

public class PainelCriarPlaylistGenero extends JPanel {
    private Utilizador utilizador;
    private FramePrincipal framePrincipal;
    public PainelCriarPlaylistGenero(FramePrincipal framePrincipal,Utilizador utilizador ) {
        this.utilizador = (Cliente) utilizador;
        this.framePrincipal=framePrincipal;

        setLayout(null);
        setBackground(new Color(70, 90, 120));;
        setPreferredSize(new Dimension(450, 500));

        JLabel lblNumero = new JLabel("Número de músicas:");
        lblNumero.setBounds(25, 175, 150, 25);
        lblNumero.setForeground(Color.WHITE);
        add(lblNumero);

        JTextField txtNumero = new JTextField();
        txtNumero.setBounds(25, 200, 150, 25);
        add(txtNumero);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(200, 175, 150, 25);
        lblNome.setForeground(Color.WHITE);
        add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(200, 200, 150, 25);
        add(txtNome);

        JLabel lblOpcao = new JLabel("Escolha o género:");
        lblOpcao.setBounds(25, 100, 220, 25);
        lblOpcao.setForeground(Color.WHITE);
        add(lblOpcao);

        JRadioButton chkPop = new JRadioButton("Pop");
        chkPop.setBounds(25, 125, 85, 25);
        chkPop.setBackground(new Color(70, 90, 120));
        chkPop.setForeground(Color.WHITE);
        add(chkPop);

        JRadioButton chkRock = new JRadioButton("Rock");
        chkRock.setBounds(110, 125, 85, 25);
        chkRock.setBackground(new Color(70, 90, 120));
        chkRock.setForeground(Color.WHITE);
        add(chkRock);

        JRadioButton chkHipHop = new JRadioButton("Hip Hop");
        chkHipHop.setBounds(195, 125, 85, 25);
        chkHipHop.setBackground(new Color(70, 90, 120));
        chkHipHop.setForeground(Color.WHITE);
        add(chkHipHop);

        JRadioButton chkPimba = new JRadioButton("Pimba");
        chkPimba.setBounds(310, 125, 85, 25);
        chkPimba.setBackground(new Color(70, 90, 120));
        chkPimba.setForeground(Color.WHITE);
        add(chkPimba);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(chkPop);
        grupo.add(chkRock);
        grupo.add(chkHipHop);
        grupo.add(chkPimba);

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(300,350,100,25);
        add(btnContinuar);


        btnContinuar.addActionListener(e ->{
            String genero = "Rock";
            if (chkPop.isSelected()) {
                genero = "Pop";
            } else if (chkPimba.isSelected()) {
                genero = "Pimba";
            } else if (chkHipHop.isSelected()) {
                genero = "Hip Hop";
            }
            criaPlaylistGenero(genero,Integer.parseInt(txtNumero.getText()),txtNome.getText());
            txtNome.setText("");
            txtNumero.setText("");
        });


        setVisible(false);

    }
    public void criaPlaylistGenero(String genero, int num, String titulo){
        framePrincipal.getRockstar().addPlaylistGenero((Cliente) this.utilizador,genero,num,titulo);
    }

}
