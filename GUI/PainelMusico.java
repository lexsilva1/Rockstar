package GUI;

import backend.Musico;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class PainelMusico extends JPanel {
    private Musico musico;

    /**
     * Cria um novo painel <code>JPanel</code> 'PainelMusico', para a página inicial de um utlizador do tipo 'Musico',
     * com um buffer duplo e um flow layout.
     */
    public PainelMusico(FramePrincipal framePrincipal, Musico musico) {
        this.musico = musico;
        JLabel labelUsername = new JLabel("Bem-vindo: " + getMusico().getUsername());
        JButton btnVerAlbuns = new JButton("Os meus álbuns");
        JButton btnVerMusicas = new JButton("As minhas músicas");
        JButton btnCriarAlbum = new JButton("+ Álbum");
        JButton btnAddMusica = new JButton("+ Música");
        JButton btnLogout = new JButton("Logout");
        JLabel lblPesquisar = new JLabel("Pesquisar");
        JTextField txtPesquisar = new JTextField();
        PainelOpcoesCliente painelOpcoes = new PainelOpcoesCliente(musico);
        BotaoLupa btnLupa = new BotaoLupa("/resources/lupa.png");



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

        btnLupa.setBounds(480,5,20,20);

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
        btnCriarAlbum.setBounds(500,10,100,25);
        btnAddMusica.setBounds(600,10,100,25);
        painelOpcoes.setBounds(275,50,450,500);



        JLabel lblTotalUsers = new JLabel("Total Utilizadores");
        lblTotalUsers.setBounds(30,200,180,25);
        lblTotalUsers.setBackground(Color.lightGray);
        lblTotalUsers.setOpaque(true);
        lblTotalUsers.setVisible(true);

        JLabel totalUsers = new JLabel(String.valueOf((framePrincipal.getRockstar().getUtilizadores().size())));
        totalUsers.setBounds(30,220,180,25);
        totalUsers.setOpaque(true);
        totalUsers.setBackground(Color.lightGray);
        totalUsers.setVisible(true);

        JLabel lblTotalMusicas = new JLabel("Total Músicas");
        lblTotalMusicas.setBounds(30,245,200,25);
        lblTotalMusicas.setBackground(Color.lightGray);
        lblTotalMusicas.setOpaque(true);
        lblTotalMusicas.setVisible(true);

        JLabel totalMusicas = new JLabel(String.valueOf((framePrincipal.getRockstar().getMusicas().size())));
        totalMusicas.setBounds(30,265,200,25);
        totalMusicas.setOpaque(true);
        totalMusicas.setBackground(Color.lightGray);
        totalMusicas.setVisible(true);

        JLabel lblValorMusicas = new JLabel("Valor Total Músicas");
        lblValorMusicas.setBounds(30,290,200,25);
        lblValorMusicas.setBackground(Color.lightGray);
        lblValorMusicas.setOpaque(true);
        lblValorMusicas.setVisible(true);

        JLabel valorMusicas = new JLabel(String.format("%1$,.2f€",(framePrincipal.getRockstar().valorMusicas())));
        valorMusicas.setBounds(30,310,200,25);
        valorMusicas.setOpaque(true);
        valorMusicas.setBackground(Color.lightGray);
        valorMusicas.setVisible(true);

        JLabel lblValorVendas = new JLabel("Valor Total Vendas");
        lblValorVendas.setBounds(30,335,200,25);
        lblValorVendas.setBackground(Color.lightGray);
        lblValorVendas.setOpaque(true);
        lblValorVendas.setVisible(true);

        JLabel valorVendas = new JLabel(String.format("%1$,.2f€",(framePrincipal.getRockstar().valorVendas())));
        valorVendas.setBounds(30,355,200,25);
        valorVendas.setOpaque(true);
        valorVendas.setBackground(Color.lightGray);
        valorVendas.setVisible(true);

        JLabel lblTotalRock = new JLabel("Total Álbuns Rock");
        lblTotalRock.setBounds(30,380,200,25);
        lblTotalRock.setBackground(Color.lightGray);
        lblTotalRock.setOpaque(true);
        lblTotalRock.setVisible(true);

        JLabel totalRock = new JLabel(String.valueOf((framePrincipal.getRockstar().albunsRock())));
        totalRock.setBounds(30,400,200,25);
        totalRock.setOpaque(true);
        totalRock.setBackground(Color.lightGray);
        totalRock.setVisible(true);

        JLabel lblTotalHipHop = new JLabel("Total Álbuns Hip Hop");
        lblTotalHipHop.setBounds(30,425,200,25);
        lblTotalHipHop.setBackground(Color.lightGray);
        lblTotalHipHop.setOpaque(true);
        lblTotalHipHop.setVisible(true);

        JLabel totalHipHop = new JLabel(String.valueOf((framePrincipal.getRockstar().albunsHipHop())));
        totalHipHop.setBounds(30,445,200,25);
        totalHipHop.setOpaque(true);
        totalHipHop.setBackground(Color.lightGray);
        totalHipHop.setVisible(true);

        JLabel lblTotalPimba = new JLabel("Total Álbuns Pimba");
        lblTotalPimba.setBounds(30,470,200,25);
        lblTotalPimba.setBackground(Color.lightGray);
        lblTotalPimba.setOpaque(true);
        lblTotalPimba.setVisible(true);

        JLabel totalPimba = new JLabel(String.valueOf((framePrincipal.getRockstar().albunsPimba())));
        totalPimba.setBounds(30,490,200,25);
        totalPimba.setOpaque(true);
        totalPimba.setBackground(Color.lightGray);
        totalPimba.setVisible(true);

        JLabel lblTotalPop = new JLabel("Total Álbuns Pop");
        lblTotalPop.setBounds(30,515,200,25);
        lblTotalPop.setBackground(Color.lightGray);
        lblTotalPop.setOpaque(true);
        lblTotalPop.setVisible(true);

        JLabel totalPop = new JLabel(String.valueOf((framePrincipal.getRockstar().albunsPop())));
        totalPop.setBounds(30,535,200,25);
        totalPop.setOpaque(true);
        totalPop.setBackground(Color.lightGray);
        totalPop.setVisible(true);

        JLabel lblMaiorRating = new JLabel("Música com maior rating");
        lblMaiorRating.setBounds(30,560,200,25);
        lblMaiorRating.setBackground(Color.lightGray);
        lblMaiorRating.setOpaque(true);
        lblMaiorRating.setVisible(true);

        JLabel maiorRating = new JLabel(String.valueOf((framePrincipal.getRockstar().musicaMaiorRating())));
        maiorRating.setBounds(30,580,200,25);
        maiorRating.setOpaque(true);
        maiorRating.setBackground(Color.lightGray);
        maiorRating.setVisible(true);

        JLabel lblMeusUtilizadores = new JLabel("Utilizadores com a minha música");
        lblMeusUtilizadores.setBounds(30,605,200,25);
        lblMeusUtilizadores.setBackground(Color.lightGray);
        lblMeusUtilizadores.setOpaque(true);
        lblMeusUtilizadores.setVisible(true);

        JLabel meusUtilizadores = new JLabel(String.valueOf((framePrincipal.getRockstar().numeroUtilizadoresMusicas(musico))));
        meusUtilizadores.setBounds(30,625,200,25);
        meusUtilizadores.setOpaque(true);
        meusUtilizadores.setBackground(Color.lightGray);
        meusUtilizadores.setVisible(true);


        btnLogout.addActionListener(e -> voltarPainelPrincipal());

        btnAddMusica.addActionListener(e -> {
            painelOpcoes.removeAll();
            PainelAddMusica painelMusica = new PainelAddMusica(framePrincipal, this.musico);
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

        btnVerAlbuns.addActionListener(e -> {
            painelOpcoes.removeAll();
            TabelaAlbuns tabelaAlbuns = new TabelaAlbuns(framePrincipal, musico,painelOpcoes);
            painelOpcoes.add(tabelaAlbuns);
            tabelaAlbuns.setVisible(true);
            revalidate();
            repaint();
        });

        btnLupa.addActionListener((ActionEvent e) ->{
            painelOpcoes.removeAll();
            if (txtPesquisar.getText().isEmpty() || grupo.getSelection() == null ) {
                TabelaMusicas tabelaMusicas = new TabelaMusicas(framePrincipal, musico);
                tabelaMusicas.setVisible(true);
                painelOpcoes.add(tabelaMusicas);
                revalidate();
                repaint();
            } else {
                TabelaMusicas tabelaPesquisa = new TabelaMusicas(framePrincipal, musico);
                tabelaPesquisa.resultadosPesquisa(txtPesquisar, chkPesquisaNome);
                painelOpcoes.add(tabelaPesquisa);
                tabelaPesquisa.setVisible(true);
                revalidate();
                repaint();
            }
            revalidate();
            repaint();
        });


        add(labelUsername);
        add(btnLogout);
        add(btnLupa);
        add(btnVerAlbuns);
        add(btnVerMusicas);
        add(btnCriarAlbum);
        add(btnAddMusica);
        add(painelOpcoes);
        add(lblTotalUsers);
        add(totalUsers);
        add(lblTotalMusicas);
        add(totalMusicas);
        add(lblValorMusicas);
        add(valorMusicas);
        add(lblValorVendas);
        add(valorVendas);
        add(lblTotalRock);
        add(totalRock);
        add(lblTotalHipHop);
        add(totalHipHop);
        add(lblTotalPimba);
        add(totalPimba);
        add(lblTotalPop);
        add(totalPop);
        add(lblMaiorRating);
        add(maiorRating);
        add(lblMeusUtilizadores);
        add(meusUtilizadores);

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