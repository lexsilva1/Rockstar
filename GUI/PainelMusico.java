package GUI;

import backend.Musico;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class PainelMusico extends JPanel {
    private Musico musico;
    private  JButton btnlimpaPesquisa;


    /**
     * Cria um novo painel <code>JPanel</code> 'PainelMusico', para a página inicial de um utlizador do tipo 'Musico',
     * com um buffer duplo e um flow layout.
     * Apresenta as estatistcas do utilizdor e permite aceder às funcionalidades desta classe de utilizador.
     */
    public PainelMusico(FramePrincipal framePrincipal, Musico musico) {
        this.musico = musico;
        this.btnlimpaPesquisa = new JButton("Limpar");

        JLabel labelUsername = new JLabel("Bem-vindo: " + getMusico().getUsername());
        JButton btnVerAlbuns = new JButton("Os meus álbuns");
        JButton btnVerMusicas = new JButton("As minhas músicas");
        JButton btnCriarAlbum = new JButton("+ Álbum");
        JButton btnAddMusica = new JButton("+ Música");

        JButton btnLogout = new JButton("Logout \u21AA");
        btnLogout.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 10));

        JLabel lblPesquisar = new JLabel("Pesquisar");
        JTextField txtPesquisar = new JTextField();
        PainelOpcoes painelOpcoes = new PainelOpcoes(musico);
        BotaoLupa btnLupa = new BotaoLupa("/resources/lupa.png");



        setBackground(new Color(70, 90, 120));
        setLayout(null);

        btnlimpaPesquisa.setBounds(640,605,85,25);
        btnlimpaPesquisa.setVisible(false);

        labelUsername.setBounds(20,5,180,25);
        labelUsername.setForeground(Color.WHITE);

        lblPesquisar.setBounds(190  , 5, 80, 25);
        lblPesquisar.setForeground(Color.WHITE);
        lblPesquisar.setVisible(true);
        add(lblPesquisar);

        txtPesquisar.setBounds(250, 5, 200, 25);
        txtPesquisar.setVisible(true);
        add(txtPesquisar);

        btnLupa.setBounds(450,7,20,20);

        JRadioButton chkPesquisaNome = new JRadioButton("Título");
        chkPesquisaNome.setBounds(250, 27, 100, 25);
        chkPesquisaNome.setBackground(new Color(70, 90, 120));
        chkPesquisaNome.setForeground(Color.WHITE);
        add(chkPesquisaNome);

        JRadioButton chkPesquisaGenero = new JRadioButton("Género");
        chkPesquisaGenero.setBounds(370, 27, 100, 25);
        chkPesquisaGenero.setBackground(new Color(70, 90, 120));
        chkPesquisaGenero.setForeground(Color.WHITE);
        add(chkPesquisaGenero);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(chkPesquisaNome);
        grupo.add(chkPesquisaGenero);

        btnLogout.setBounds(710, 10, 75, 25);
        btnVerAlbuns.setBounds(22,100,206,25);
        btnVerMusicas.setBounds(22,140,206,25);
        btnCriarAlbum.setBounds(490,10,100,25);
        btnAddMusica.setBounds(590,10,100,25);
        painelOpcoes.setBounds(275,100,450,500);

        Border contorno = BorderFactory.createMatteBorder(5, 5, 0, 5, Color.white);
        Border contorno1 = BorderFactory.createMatteBorder(3, 5, 0, 5, Color.white);
        Border contorno2 = BorderFactory.createMatteBorder(0, 5, 0, 5, Color.white);
        Border contorno3 = BorderFactory.createMatteBorder(0, 5, 5, 5, Color.white);
        String espaco = " ";

        JLabel lblCabecalho = new JLabel(" ESTATÍSTICAS");
        lblCabecalho.setBounds(30,175,190,25);
        lblCabecalho.setBackground(new Color(70, 90, 120));
        lblCabecalho.setForeground(Color.white);
        lblCabecalho.setBorder(contorno);
        Font fonte = new Font(lblCabecalho.getFont().getFontName(), Font.BOLD, lblCabecalho.getFont().getSize());
        lblCabecalho.setFont(fonte);
        lblCabecalho.setOpaque(true);
        lblCabecalho.setVisible(true);

        JLabel lblTotalUsers = new JLabel(" Total Utilizadores");
        lblTotalUsers.setBounds(30,200,190,25);
        lblTotalUsers.setBackground(new Color(70, 90, 120));
        lblTotalUsers.setForeground(Color.white);
        lblTotalUsers.setBorder(contorno);
        lblTotalUsers.setFont(fonte);
        lblTotalUsers.setOpaque(true);
        lblTotalUsers.setVisible(true);

        JLabel totalUsers = new JLabel(espaco.concat(String.valueOf((framePrincipal.getRockstar().getUtilizadores().size()))));
        totalUsers.setBounds(30,220,190,25);
        totalUsers.setOpaque(true);
        totalUsers.setBackground(new Color(70, 90, 120));
        totalUsers.setForeground(Color.white);
        totalUsers.setBorder(contorno2);
        Font fonte2 = new Font(totalUsers.getFont().getFontName(), Font.PLAIN, (totalUsers.getFont().getSize()-2));
        totalUsers.setFont(fonte2);
        totalUsers.setVisible(true);

        JLabel lblTotalMusicas = new JLabel(" Total Músicas");
        lblTotalMusicas.setBounds(30,245,190,25);
        lblTotalMusicas.setBackground(new Color(70, 90, 120));
        lblTotalMusicas.setForeground(Color.white);
        lblTotalMusicas.setBorder(contorno1);
        lblTotalMusicas.setFont(fonte);
        lblTotalMusicas.setOpaque(true);
        lblTotalMusicas.setVisible(true);

        JLabel totalMusicas = new JLabel(espaco.concat(String.valueOf((framePrincipal.getRockstar().getMusicas().size()))));
        totalMusicas.setBounds(30,265,190,25);
        totalMusicas.setOpaque(true);
        totalMusicas.setBackground(new Color(70, 90, 120));
        totalMusicas.setForeground(Color.white);
        totalMusicas.setBorder(contorno2);
        totalMusicas.setFont(fonte2);
        totalMusicas.setVisible(true);

        JLabel lblValorMusicas = new JLabel(" Valor Total Músicas");
        lblValorMusicas.setBounds(30,290,190,25);
        lblValorMusicas.setBackground(new Color(70, 90, 120));
        lblValorMusicas.setForeground(Color.white);
        lblValorMusicas.setBorder(contorno1);
        lblValorMusicas.setFont(fonte);
        lblValorMusicas.setOpaque(true);
        lblValorMusicas.setVisible(true);

        JLabel valorMusicas = new JLabel(espaco.concat(String.format("%1$,.2f€",(framePrincipal.getRockstar().valorMusicas()))));
        valorMusicas.setBounds(30,310,190,25);
        valorMusicas.setOpaque(true);
        valorMusicas.setBackground(new Color(70, 90, 120));
        valorMusicas.setForeground(Color.white);
        valorMusicas.setBorder(contorno2);
        valorMusicas.setFont(fonte2);
        valorMusicas.setVisible(true);

        JLabel lblValorVendas = new JLabel(" Valor Total Vendas");
        lblValorVendas.setBounds(30,335,190,25);
        lblValorVendas.setBackground(new Color(70, 90, 120));
        lblValorVendas.setForeground(Color.white);
        lblValorVendas.setBorder(contorno1);
        lblValorVendas.setFont(fonte);
        lblValorVendas.setOpaque(true);
        lblValorVendas.setVisible(true);

        JLabel valorVendas = new JLabel(espaco.concat(String.format("%1$,.2f€",(framePrincipal.getRockstar().valorVendas()))));
        valorVendas.setBounds(30,355,190,25);
        valorVendas.setOpaque(true);
        valorVendas.setBackground(new Color(70, 90, 120));
        valorVendas.setForeground(Color.white);
        valorVendas.setBorder(contorno2);
        valorVendas.setFont(fonte2);
        valorVendas.setVisible(true);

        JLabel lblTotalRock = new JLabel(" Total Álbuns Rock");
        lblTotalRock.setBounds(30,380,190,25);
        lblTotalRock.setBackground(new Color(70, 90, 120));
        lblTotalRock.setForeground(Color.white);
        lblTotalRock.setBorder(contorno1);
        lblTotalRock.setFont(fonte);
        lblTotalRock.setOpaque(true);
        lblTotalRock.setVisible(true);

        JLabel totalRock = new JLabel(espaco.concat(String.valueOf((framePrincipal.getRockstar().albunsRock()))));
        totalRock.setBounds(30,400,190,25);
        totalRock.setOpaque(true);
        totalRock.setBackground(new Color(70, 90, 120));
        totalRock.setForeground(Color.white);
        totalRock.setBorder(contorno2);
        totalRock.setFont(fonte2);
        totalRock.setVisible(true);

        JLabel lblTotalHipHop = new JLabel(" Total Álbuns Hip Hop");
        lblTotalHipHop.setBounds(30,425,190,27);
        lblTotalHipHop.setBackground(new Color(70, 90, 120));
        lblTotalHipHop.setForeground(Color.white);
        lblTotalHipHop.setBorder(contorno1);
        lblTotalHipHop.setFont(fonte);
        lblTotalHipHop.setOpaque(true);
        lblTotalHipHop.setVisible(true);

        JLabel totalHipHop = new JLabel(espaco.concat(String.valueOf((framePrincipal.getRockstar().albunsHipHop()))));
        totalHipHop.setBounds(30,445,190,25);
        totalHipHop.setOpaque(true);
        totalHipHop.setBackground(new Color(70, 90, 120));
        totalHipHop.setForeground(Color.white);
        totalHipHop.setBorder(contorno2);
        totalHipHop.setFont(fonte2);
        totalHipHop.setVisible(true);

        JLabel lblTotalPimba = new JLabel(" Total Álbuns Pimba");
        lblTotalPimba.setBounds(30,470,190,25);
        lblTotalPimba.setBackground(new Color(70, 90, 120));
        lblTotalPimba.setForeground(Color.white);
        lblTotalPimba.setBorder(contorno1);
        lblTotalPimba.setFont(fonte);
        lblTotalPimba.setOpaque(true);
        lblTotalPimba.setVisible(true);

        JLabel totalPimba = new JLabel(espaco.concat(String.valueOf((framePrincipal.getRockstar().albunsPimba()))));
        totalPimba.setBounds(30,490,190,25);
        totalPimba.setOpaque(true);
        totalPimba.setBackground(new Color(70, 90, 120));
        totalPimba.setForeground(Color.white);
        totalPimba.setBorder(contorno2);
        totalPimba.setFont(fonte2);
        totalPimba.setVisible(true);

        JLabel lblTotalPop = new JLabel(" Total Álbuns Pop");
        lblTotalPop.setBounds(30,515,190,25);
        lblTotalPop.setBackground(new Color(70, 90, 120));
        lblTotalPop.setForeground(Color.white);
        lblTotalPop.setBorder(contorno1);
        lblTotalPop.setFont(fonte);
        lblTotalPop.setOpaque(true);
        lblTotalPop.setVisible(true);

        JLabel totalPop = new JLabel(espaco.concat(String.valueOf((framePrincipal.getRockstar().albunsPop()))));
        totalPop.setBounds(30,535,190,25);
        totalPop.setOpaque(true);
        totalPop.setBackground(new Color(70, 90, 120));
        totalPop.setForeground(Color.white);
        totalPop.setBorder(contorno2);
        totalPop.setFont(fonte2);
        totalPop.setVisible(true);

        JLabel lblMaiorRating = new JLabel(" Música com maior rating");
        lblMaiorRating.setBounds(30,560,190,25);
        lblMaiorRating.setBackground(new Color(70, 90, 120));
        lblMaiorRating.setForeground(Color.white);
        lblMaiorRating.setBorder(contorno1);
        lblMaiorRating.setFont(fonte);
        lblMaiorRating.setOpaque(true);
        lblMaiorRating.setVisible(true);

        JLabel maiorRating = new JLabel(espaco.concat(String.valueOf((framePrincipal.getRockstar().musicaMaiorRating()))));
        maiorRating.setBounds(30,580,190,25);
        maiorRating.setOpaque(true);
        maiorRating.setBackground(new Color(70, 90, 120));
        maiorRating.setForeground(Color.white);
        maiorRating.setBorder(contorno2);
        maiorRating.setFont(fonte2);
        maiorRating.setVisible(true);

        JLabel lblMeusClientes = new JLabel(" Meus clientes");
        lblMeusClientes.setBounds(30,605,190,25);
        lblMeusClientes.setBackground(new Color(70, 90, 120));
        lblMeusClientes.setForeground(Color.white);
        lblMeusClientes.setBorder(contorno1);
        lblMeusClientes.setFont(fonte);
        lblMeusClientes.setOpaque(true);
        lblMeusClientes.setVisible(true);

        JLabel meusClientes = new JLabel(espaco.concat(String.valueOf((framePrincipal.getRockstar().numeroUtilizadoresMusicas(musico)))));
        meusClientes.setBounds(30,625,190,25);
        meusClientes.setOpaque(true);
        meusClientes.setBackground(new Color(70, 90, 120));
        meusClientes.setForeground(Color.white);
        meusClientes.setBorder(contorno3);
        meusClientes.setFont(fonte2);
        meusClientes.setVisible(true);


        btnLogout.addActionListener(e -> voltarPainelPrincipal());

        txtPesquisar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnLupa.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        btnAddMusica.addActionListener(e -> {
            painelOpcoes.removeAll();
            PainelAddMusica painelMusica = new PainelAddMusica(framePrincipal, this.musico, totalMusicas, valorMusicas);
            painelOpcoes.add(painelMusica);
            painelMusica.setVisible(true);
            revalidate();
            repaint();
        });

        btnVerMusicas.addActionListener(e -> {
            painelOpcoes.removeAll();
            PainelTabelaMusicas painelTabelaMusicas = new PainelTabelaMusicas(framePrincipal, musico);
            painelOpcoes.add(painelTabelaMusicas);
            painelTabelaMusicas.setVisible(true);
            revalidate();
            repaint();
        });

        btnCriarAlbum.addActionListener(e -> {
            painelOpcoes.removeAll();
            PainelCriarAlbum painelCriarAlbum = new PainelCriarAlbum(framePrincipal, musico, totalRock, totalHipHop, totalPop, totalPimba);
            painelOpcoes.add(painelCriarAlbum);
            painelCriarAlbum.setVisible(true);
            revalidate();
            repaint();
        });

        btnVerAlbuns.addActionListener(e -> {
            painelOpcoes.removeAll();
            PainelTabelaAlbuns painelTabelaAlbuns = new PainelTabelaAlbuns(framePrincipal, musico);
            painelOpcoes.add(painelTabelaAlbuns);
            painelTabelaAlbuns.setVisible(true);
            revalidate();
            repaint();
        });

        btnLupa.addActionListener((ActionEvent e) ->{
            painelOpcoes.removeAll();
            btnlimpaPesquisa.setVisible(true);

            if (txtPesquisar.getText().isEmpty() || grupo.getSelection() == null ) {
                PainelTabelaMusicas painelTabelaMusicas = new PainelTabelaMusicas(framePrincipal, musico);
                painelTabelaMusicas.setVisible(true);
                painelOpcoes.add(painelTabelaMusicas);
                revalidate();
                repaint();
            } else {
                PainelTabelaMusicas tabelaPesquisa = new PainelTabelaMusicas(framePrincipal, musico);
                tabelaPesquisa.resultadosPesquisa(txtPesquisar, chkPesquisaNome);
                painelOpcoes.add(tabelaPesquisa);
                tabelaPesquisa.setVisible(true);
                revalidate();
                repaint();
            }
            revalidate();
            repaint();
        });

        btnlimpaPesquisa.addActionListener((ActionEvent e) -> {
            painelOpcoes.removeAll();
            btnlimpaPesquisa.setVisible(false);
            revalidate();
            repaint();
        });


        add(labelUsername);
        add(btnLogout);
        add(btnlimpaPesquisa);
        add(btnLupa);
        add(btnVerAlbuns);
        add(btnVerMusicas);
        add(btnCriarAlbum);
        add(btnAddMusica);
        add(painelOpcoes);
        add(lblCabecalho);
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
        add(lblMeusClientes);
        add(meusClientes);

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