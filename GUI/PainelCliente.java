package GUI;

import backend.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PainelCliente extends JPanel{
    private Cliente cliente;
    private JButton btnVerPlaylists;
    private JButton btnVerMusicas;
    private JButton btnCriarPlaylist;
    private JButton btnCriarPlaylistGenero;
    private JButton btnHistoricoCompras;
    private JButton btnLogout;
    private JButton btnCarrinhoCompras;
    private BotaoLupa btnLupa;
    private JLabel labelUsername;
    private JButton btnSaldo;
    private JButton btnLoja;
    private PainelOpcoes painelOpcoes;
    private PainelCriarPlaylist painelCriarPlaylist;
    private PainelCriarPlaylistGenero painelCriarPlaylistGenero;
    private PainelMusicasLoja painelMusicasLoja;
    private FramePrincipal framePrincipal;
    private  JButton btnlimpaPesquisa;


    /**
     * Cria um novo painel <code>JPanel</code> 'PainelCliente', para a página inicial de um utlizador do tipo 'Cliente',
     * com um buffer duplo e um flow layout.
     */

    public PainelCliente(FramePrincipal framePrincipal, Cliente cliente) {
        this.cliente = cliente;
        this.framePrincipal = framePrincipal;
        this.btnVerPlaylists = new JButton("As minhas playlists");
        this.btnVerMusicas = new JButton("As minhas músicas");
        this.btnCriarPlaylist = new JButton("Nova playlist");
        JLabel lblPesquisar = new JLabel("Pesquisar");
        JTextField txtPesquisar = new JTextField();
        this.btnCriarPlaylistGenero = new JButton("Nova playlist por género");
        this.btnHistoricoCompras = new JButton("Historico de Compras");
        this.btnLogout = new JButton("Logout \u21AA"); // Unicode para LEFTWARDS ARROW WITH HOOK (U+21AA)
        btnLogout.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 10));
        this.btnCarrinhoCompras = new JButton ("\uD83D\uDED2 Carrinho"); // Unicode para carrinho de compras
        this.btnLupa = new BotaoLupa("/resources/lupa.png");
        this.labelUsername = new JLabel("Bem-vindo: " + getCliente().getUsername());
        this.btnSaldo = new JButton("Saldo: " + String.format("%1$,.2f€",getCliente().getSaldo()));
        this.btnLoja = new JButton("Loja");
        this.painelOpcoes = new PainelOpcoes(cliente);
        this.painelMusicasLoja = new PainelMusicasLoja(framePrincipal,cliente);
        this.btnlimpaPesquisa = new JButton("Limpar");

        setBackground(new Color(70, 90, 120));
        setLayout(null);

        btnVerPlaylists.setBounds(20,100,200,25);
        btnVerPlaylists.addActionListener(e -> abrirPainelMinhasPlaylists());
        btnVerMusicas.setBounds(20,150,200,25);
        btnVerMusicas.addActionListener(e -> abrirPainelMinhasMusicas());
        btnCriarPlaylist.setBounds(20,200,200,25);
        btnCriarPlaylist.addActionListener(e -> abrirPainelCriarPlaylist());
        btnCriarPlaylistGenero.setBounds(20,250,200,25);
        btnCriarPlaylistGenero.addActionListener(e -> abrirPainelCriarPlaylistGenero());
        btnHistoricoCompras.setBounds(20,300,200,25);
        btnHistoricoCompras.addActionListener(e -> abrirHistoricoCompras());
        btnLogout.setBounds(700, 10, 80, 30);
        btnLogout.addActionListener(e -> voltarPainelPrincipal());
        btnCarrinhoCompras.setBounds(20,600,100,30);
        btnCarrinhoCompras.addActionListener(e -> abrirPainelCarrinhoCompras());
        labelUsername.setBounds(20,5,200,25);
        labelUsername.setForeground(Color.WHITE);

        btnSaldo.setBounds(140,602,120,25);

        btnSaldo.setForeground(Color.BLACK);
        btnSaldo.setBackground(new Color(70, 90, 120));

        btnSaldo.addActionListener(e -> {
            exibirJanelaCarregarSaldo();
        });

        btnLoja.setBounds(20,350,200,25);
        btnLoja.addActionListener(e -> abrirPainelMusicasLoja());

        painelOpcoes.setBounds(275,100,450,500);

        lblPesquisar.setBounds(300  , 5, 100, 25);
        lblPesquisar.setForeground(Color.WHITE);
        lblPesquisar.setVisible(true);
        add(lblPesquisar);

        txtPesquisar.setBounds(370, 5, 200, 25);
        txtPesquisar.setVisible(true);
        add(txtPesquisar);

        btnLupa.setBounds(580,5,20,20);

        btnlimpaPesquisa.setBounds(640,605,85,25);
        btnlimpaPesquisa.setVisible(false);

        JRadioButton chkPesquisaNome = new JRadioButton("Título");
        chkPesquisaNome.setBounds(370, 30, 100, 25);
        chkPesquisaNome.setBackground(new Color(70, 90, 120));
        chkPesquisaNome.setForeground(Color.WHITE);
        add(chkPesquisaNome);

        JRadioButton chkPesquisaGenero = new JRadioButton("Género");
        chkPesquisaGenero.setBounds(490, 30, 100, 25);
        chkPesquisaGenero.setBackground(new Color(70, 90, 120));
        chkPesquisaGenero.setForeground(Color.WHITE);
        add(chkPesquisaGenero);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(chkPesquisaNome);
        grupo.add(chkPesquisaGenero);

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

        btnLupa.addActionListener((ActionEvent e) -> {
            painelOpcoes.removeAll();
            btnlimpaPesquisa.setVisible(true);

            if (txtPesquisar.getText().isEmpty() || grupo.getSelection() == null) {
                abrirPainelMusicasLoja();
            } else {
                PainelMusicasLoja painel = new PainelMusicasLoja(framePrincipal, cliente);
                painel.resultadosPesquisa(txtPesquisar, chkPesquisaNome);
                painel.setComponentPopupMenu(painel.criarPopupMenuCliente(framePrincipal,cliente));
                painelOpcoes.add(painel);
                painel.setVisible(true);
                revalidate();
                repaint();
            }
            revalidate();
            repaint();
        });

        btnlimpaPesquisa.addActionListener((ActionEvent e) -> {
            painelOpcoes.removeAll();
            btnlimpaPesquisa.setVisible(false);
            abrirPainelMusicasLoja();
        });

        add(btnVerPlaylists);
        add(btnVerMusicas);
        add(btnCriarPlaylist);
        add(btnCriarPlaylistGenero);
        add(btnHistoricoCompras);
        add(btnLogout);
        add(btnCarrinhoCompras);
        add(labelUsername);
        add(btnSaldo);
        add(painelOpcoes);
        add(btnLupa);
        add(btnLoja);
        painelOpcoes.add(painelMusicasLoja);
        add(btnlimpaPesquisa);

        setVisible(true);
    }


    private void abrirPainelCriarPlaylist() {
        painelOpcoes.removeAll();
        this.painelCriarPlaylist = new PainelCriarPlaylist(framePrincipal,cliente);
        painelCriarPlaylist.setBounds(275,100,450,500);
        painelOpcoes.add(painelCriarPlaylist);
        btnlimpaPesquisa.setVisible(false);
        painelOpcoes.revalidate();
        painelOpcoes.repaint();
    }

    public void abrirPainelMinhasPlaylists() {
        painelOpcoes.removeAll();
        painelOpcoes.add(new PainelMinhasPlaylists(framePrincipal,cliente,this));
        btnlimpaPesquisa.setVisible(false);
        painelOpcoes.revalidate();
        painelOpcoes.repaint();
    }

    public void abrirPainelMinhasMusicas() {
        painelOpcoes.removeAll();
        painelOpcoes.add(new PainelMinhasMusicas(framePrincipal,cliente,this));
        btnlimpaPesquisa.setVisible(false);
        painelOpcoes.revalidate();
        painelOpcoes.repaint();
    }
    private void abrirHistoricoCompras() {
        painelOpcoes.removeAll();
        painelOpcoes.add(new HistoricoDeCompras(cliente));
        btnlimpaPesquisa.setVisible(false);
        painelOpcoes.revalidate();
        painelOpcoes.repaint();
    }

    private void abrirPainelCriarPlaylistGenero() {
        painelOpcoes.removeAll();
        this.painelCriarPlaylistGenero = new PainelCriarPlaylistGenero(framePrincipal, cliente);
        painelCriarPlaylistGenero.setBounds(275,100,450,500);
        painelOpcoes.add(painelCriarPlaylistGenero);
        btnlimpaPesquisa.setVisible(false);
        painelOpcoes.revalidate();
        painelOpcoes.repaint();
    }

    public void abrirPainelCarrinhoCompras() {
        painelOpcoes.removeAll();
        PainelCarrinhoCompras painelCarrinhoCompras = new PainelCarrinhoCompras(framePrincipal, cliente,this);
        painelOpcoes.add(painelCarrinhoCompras);
        btnlimpaPesquisa.setVisible(false);
        painelOpcoes.revalidate();
        painelOpcoes.repaint();
    }

    private void abrirPainelMusicasLoja() {
        painelOpcoes.removeAll();
        painelOpcoes.add(new PainelMusicasLoja(framePrincipal,cliente));
        btnlimpaPesquisa.setVisible(false);
        painelOpcoes.revalidate();
        painelOpcoes.repaint();
    }

    private void exibirJanelaCarregarSaldo() {
        double saldoAtual = getCliente().getSaldo();

        String input = JOptionPane.showInputDialog(this,


              "Saldo Atual: " + String.format("%1$,.2f€", saldoAtual) + "\nDigite o montante a carregar:", "Carregar Saldo",JOptionPane.QUESTION_MESSAGE);


        if (input != null && !input.isEmpty()) {
            try {
                double montanteCarregar = Double.parseDouble(input);

                JOptionPane.showMessageDialog(this, "Saldo carregado com sucesso: " + montanteCarregar,
                        "Carregar Saldo", JOptionPane.INFORMATION_MESSAGE);
                cliente.carregaSaldo(montanteCarregar);
                saldoAtual = cliente.getSaldo();

                btnSaldo.setText("Saldo: " + String.format("%1$,.2f€",saldoAtual));
                revalidate();
                repaint();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Apenas valores numéricos","Valor Inválido", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void voltarPainelPrincipal() {
        FramePrincipal framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelPrincipal(framePrincipal));
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }

    public Cliente getCliente() {
        return cliente;
    }
    public JButton botaosaldo(){
        return btnSaldo;
    }

}


