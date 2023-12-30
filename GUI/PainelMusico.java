package GUI;

import backend.Musico;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelMusico extends JPanel {
    private FramePrincipal framePrincipal;
    private Musico musico;


    /**
     * Cria um novo painel <code>JPanel</code> 'PainelMusico', para a página inicial de um utlizador do tipo 'Musico',
     * com um buffer duplo e um flow layout.
     */
    public PainelMusico(FramePrincipal framePrincipal, Musico musico) {
        this.framePrincipal = framePrincipal;
        this.musico = musico;
        JLabel labelUsername = new JLabel("Bem-vindo: " + getMusico().getUsername());
        JButton btnVerAlbuns = new JButton("Os meus álbuns");
        JButton btnVerMusicas = new JButton("As minhas músicas");
        JButton btnCriarAlbum = new JButton("+ Álbum");
        JButton btnAddMusica = new JButton("+ Música");
        JButton btnOrdenarMusicas = new JButton("Ordenar as minhas músicas");
        JButton btnEstatisticas = new JButton("Ver estatísticas");
        JButton btnLogout = new JButton("Logout");
        JLabel lblPesquisar = new JLabel("Pesquisar");
        JTextField txtPesquisar = new JTextField();
        PainelOpcoesCliente painelOpcoes = new PainelOpcoesCliente(musico);
        PainelAddMusica painelMusica = new PainelAddMusica(framePrincipal, this.musico);


        setBackground(new Color(70, 90, 120));
        setLayout(null);

        labelUsername.setBounds(20,5,200,25);
        labelUsername.setForeground(Color.WHITE);

        lblPesquisar.setBounds(200  , 5, 100, 25);
        lblPesquisar.setForeground(Color.WHITE);
        lblPesquisar.setVisible(true);
        add(lblPesquisar);

        txtPesquisar.setBounds(270, 5, 200, 25);
        txtPesquisar.setVisible(true);
        add(txtPesquisar);

        JRadioButton chkPesquisaNome = new JRadioButton("Nome");
        chkPesquisaNome.setBounds(270, 25, 100, 25);
        chkPesquisaNome.setBackground(new Color(70, 90, 120));
        chkPesquisaNome.setForeground(Color.WHITE);
        add(chkPesquisaNome);

        JRadioButton chkPesquisaGenero = new JRadioButton("Género");
        chkPesquisaGenero.setBounds(390, 25, 100, 25);
        chkPesquisaGenero.setBackground(new Color(70, 90, 120));
        chkPesquisaGenero.setForeground(Color.WHITE);
        add(chkPesquisaGenero);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(chkPesquisaNome);
        grupo.add(chkPesquisaGenero);

        btnLogout.setBounds(725, 10, 75, 25);
        btnVerAlbuns.setBounds(20,100,200,25);
        btnVerMusicas.setBounds(20,150,200,25);
        btnOrdenarMusicas.setBounds(20,250,200,25);
        btnEstatisticas.setBounds(20,200,200,25);
        btnCriarAlbum.setBounds(500,10,100,25);
        btnAddMusica.setBounds(600,10,100,25);
        painelOpcoes.setBounds(275,50,450,500);
        painelMusica.setBounds(275,0,450,100);

        btnLogout.addActionListener(e -> voltarPainelPrincipal());

        btnAddMusica.addActionListener(e -> {
            painelOpcoes.removeAll();
            painelOpcoes.add(painelMusica);
            painelMusica.setVisible(true);
            revalidate();
            repaint();
        });

        btnVerMusicas.addActionListener(e -> {
            painelOpcoes.removeAll();
            TabelaMusicas tabelaMusicas = new TabelaMusicas(framePrincipal, musico);
            painelOpcoes.add(tabelaMusicas);
            tabelaMusicas.setVisible(true);
            revalidate();
            repaint();
        });

        btnCriarAlbum.addActionListener(e -> {
            painelOpcoes.removeAll();
            PainelCriarAlbum painelCriarAlbum = new PainelCriarAlbum(framePrincipal, musico);
            painelOpcoes.add(painelCriarAlbum);
            painelCriarAlbum.setVisible(true);
            revalidate();
            repaint();
        });


        add(labelUsername);
        add(btnLogout);
        add(btnVerAlbuns);
        add(btnVerMusicas);
        add(btnCriarAlbum);
        add(btnAddMusica);
        add(btnOrdenarMusicas);
        add(btnEstatisticas);
        add(painelOpcoes);

        setVisible(true);

    }

    public Musico getMusico() {
        return musico;
    }

    private void voltarPainelPrincipal() {
        FramePrincipal framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelPrincipal(framePrincipal));
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }
}