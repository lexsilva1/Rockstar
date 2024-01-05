package GUI;

import backend.Cliente;
import backend.Musica;
import backend.Utilizador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelCliente extends JPanel{
    private Cliente cliente;
    private JButton btnVerPlaylists;
    private JButton btnVerMusicas;
    private JButton btnCriarPlaylist;
    private JButton btnCriarPlaylistGenero;
    private JButton btnHistoricoCompras;
    private JButton btnLogout;
    private BotaoCarrinho btnCarrinhoCompras;
    private BotaoLupa btnLupa;
    private JLabel labelUsername; //Colocar o username visivel
    private JButton btnSaldo; //Colocar o saldo visível
    private JButton btnLoja;
    private PainelOpcoesCliente painelOpcoesCliente;
    private PainelCriarPlaylist painelCriarPlaylist;
    private PainelCriarPlaylistGenero painelCriarPlaylistGenero;
    private PainelMinhasMusicas painelMinhasMusicas;
    private PainelMusicasLoja painelMusicasLoja;
    private FramePrincipal framePrincipal;
    private HistoricodeCompras historicodeCompras;
    private PainelMinhasPlaylists painelMinhasPlaylists;



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
        this.btnLogout = new BotaoLogout("/resources/BotaoLogout.jpg");
        this.btnCarrinhoCompras = new BotaoCarrinho("/resources/carrinho.jpg");
        this.btnLupa = new BotaoLupa("/resources/lupa.png");
        this.labelUsername = new JLabel("Bem-vindo: " + getCliente().getUsername());
        this.btnSaldo = new JButton("Saldo: " + String.valueOf(getCliente().getSaldo()));
        this.btnLoja = new JButton("Loja");
        this.painelOpcoesCliente= new PainelOpcoesCliente(cliente);
        this.painelCriarPlaylist = new PainelCriarPlaylist(framePrincipal,cliente);
        this.painelCriarPlaylistGenero = new PainelCriarPlaylistGenero(framePrincipal, cliente);
        this.painelMusicasLoja = new PainelMusicasLoja(framePrincipal,cliente);






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
        btnLogout.setBounds(740, 10, 40, 30);
        btnLogout.addActionListener(e -> voltarPainelPrincipal());
        btnCarrinhoCompras.setBounds(20,600,50,30);
        btnCarrinhoCompras.addActionListener(e -> abrirPainelCarrinhoCompras());
        labelUsername.setBounds(20,5,200,25);
        labelUsername.setForeground(Color.WHITE);

        btnSaldo.setBounds(100,600,100,25);

        btnSaldo.setForeground(Color.WHITE);
        btnSaldo.setBackground(new Color(70, 90, 120));
        btnSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exibir janela de carregamento de saldo
                exibirJanelaCarregarSaldo();

            }
        });

        btnLoja.setBounds(20,350,200,25);
        btnLoja.addActionListener(e -> abrirPainelMusicasLoja());

        painelOpcoesCliente.setBounds(275,100,450,500);
        painelCriarPlaylist.setBounds(275,100,450,500);
        painelCriarPlaylistGenero.setBounds(275,100,450,500);

        lblPesquisar.setBounds(300  , 5, 100, 25);
        lblPesquisar.setForeground(Color.WHITE);
        lblPesquisar.setVisible(true);
        add(lblPesquisar);

        txtPesquisar.setBounds(370, 5, 200, 25);
        txtPesquisar.setVisible(true);
        add(txtPesquisar);

        btnLupa.setBounds(580,5,20,20);

        JRadioButton chkPesquisaNome = new JRadioButton("Nome");
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
        btnLupa.addActionListener((ActionEvent e) -> {
            painelOpcoesCliente.removeAll();
            if (txtPesquisar.getText().isEmpty() || grupo.getSelection() == null) {
                abrirPainelMusicasLoja();
            } else {
                PainelMusicasLoja painel = new PainelMusicasLoja(framePrincipal, cliente);
                painel.resultadosPesquisa(txtPesquisar, chkPesquisaNome);
                painel.setComponentPopupMenu(painel.criarPopupMenuCliente(framePrincipal,cliente));
                painelOpcoesCliente.add(painel);
                painel.setVisible(true);
                revalidate();
                repaint();
            }
            revalidate();
            repaint();
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
        add(painelOpcoesCliente);
        add(btnLupa);
        add(btnLoja);
        painelOpcoesCliente.add(painelMusicasLoja);



        setVisible(true);
    }


    private void abrirPainelCriarPlaylist() {
        // Remover todos os componentes do painelOpcoesCliente
        painelOpcoesCliente.removeAll();
        // Adicionar o painelCriarPlaylist ao painelOpcoesCliente
        painelOpcoesCliente.add(painelCriarPlaylist);
        // Atualizar o painelOpcoesCliente
        painelOpcoesCliente.revalidate();
        painelOpcoesCliente.repaint();
    }
    /*private void abrirPainelPesquisa(JPanel painel) {
        // Remover todos os componentes do painelOpcoesCliente
        painelOpcoesCliente.removeAll();
        // Adicionar o painelCriarPlaylist ao painelOpcoesCliente
        painelOpcoesCliente.add(painel);
        // Atualizar o painelOpcoesCliente
        painelOpcoesCliente.revalidate();
        painelOpcoesCliente.repaint();
    }*/

    private void abrirPainelMinhasPlaylists() {
        // Remover todos os componentes do painelOpcoesCliente
        painelOpcoesCliente.removeAll();
        // Adicionar o painelCriarPlaylist ao painelOpcoesCliente
        painelOpcoesCliente.add(new PainelMinhasPlaylists(framePrincipal,cliente));
        // Atualizar o painelOpcoesCliente
        painelOpcoesCliente.revalidate();
        painelOpcoesCliente.repaint();
    }


    private void abrirPainelMinhasMusicas() {
        // Remover todos os componentes do painelOpcoesCliente
        painelOpcoesCliente.removeAll();
        // Adicionar o painelCriarPlaylist ao painelOpcoesCliente
        painelOpcoesCliente.add(new PainelMinhasMusicas(framePrincipal,cliente));
        // Atualizar o painelOpcoesCliente
        painelOpcoesCliente.revalidate();
        painelOpcoesCliente.repaint();
    }
    private void abrirHistoricoCompras() { // mudar para variavel local para actualizar
        // Remover todos os componentes do painelOpcoesCliente
        painelOpcoesCliente.removeAll();
        // Adicionar o painelCriarPlaylist ao painelOpcoesCliente
        painelOpcoesCliente.add(new HistoricodeCompras(framePrincipal,cliente));
        // Atualizar o painelOpcoesCliente
        painelOpcoesCliente.revalidate();
        painelOpcoesCliente.repaint();
    }


    private void abrirPainelCriarPlaylistGenero() {
        // Remover todos os componentes do painelOpcoesCliente
        painelOpcoesCliente.removeAll();
        // Adicionar o painelCriarPlaylist ao painelOpcoesCliente
        painelOpcoesCliente.add(painelCriarPlaylistGenero);
        // Atualizar o painelOpcoesCliente
        painelOpcoesCliente.revalidate();
        painelOpcoesCliente.repaint();
    }

    public void abrirPainelCarrinhoCompras() {
        // Remover todos os componentes do painelOpcoesCliente
        painelOpcoesCliente.removeAll();
        // Adicionar o painelCriarPlaylist ao painelOpcoesCliente
        PainelCarrinhoCompras painelCarrinhoCompras = new PainelCarrinhoCompras(framePrincipal, cliente,this);
        painelOpcoesCliente.add(painelCarrinhoCompras);
        // Atualizar o painelOpcoesCliente
        painelOpcoesCliente.revalidate();
        painelOpcoesCliente.repaint();
    }

    private void abrirPainelMusicasLoja() {
        // Remover todos os componentes do painelOpcoesCliente
        painelOpcoesCliente.removeAll();
        // Adicionar o painelCriarPlaylist ao painelOpcoesCliente
        painelOpcoesCliente.add(painelMusicasLoja);
        // Atualizar o painelOpcoesCliente
        painelOpcoesCliente.revalidate();
        painelOpcoesCliente.repaint();
    }

    private void exibirJanelaCarregarSaldo() {
        double saldoAtual = getCliente().getSaldo();

        String input = JOptionPane.showInputDialog(this,
                "Saldo Atual: " + saldoAtual + "\nDigite o montante a carregar:", "Carregar Saldo",
                JOptionPane.QUESTION_MESSAGE);

        if (input != null && !input.isEmpty()) {
                double montanteCarregar = Double.parseDouble(input);

                JOptionPane.showMessageDialog(this, "Saldo carregado com sucesso: " + montanteCarregar,
                        "Carregar Saldo", JOptionPane.INFORMATION_MESSAGE);
                cliente.carregaSaldo(montanteCarregar);
                saldoAtual = cliente.getSaldo();


                btnSaldo.setText("Saldo: " + (saldoAtual));
                revalidate();
                repaint();
            } else{
                JOptionPane.showMessageDialog(this, "Por favor, insira um valor válido.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
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


