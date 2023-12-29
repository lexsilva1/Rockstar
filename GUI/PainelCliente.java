package GUI;

import backend.Cliente;
import backend.Utilizador;

import javax.swing.*;
import java.awt.*;

public class PainelCliente extends JPanel{
    private Cliente cliente;
    private JButton btnVerPlaylists;
    private JButton btnVerMusicas;
    private JButton btnCriarPlaylist;
    private JButton btnCriarPlaylistGenero;
    private JButton btnOrdenarMusicas;
    private JButton btnLogout;
    private BotaoCarrinho btnCarrinhoCompras;
    private JLabel labelUsername; //Colocar o username visivel
    private JLabel labelSaldo; //Colocar o saldo visível
    private PainelOpcoesCliente painelOpcoesCliente;
    private PainelCriarPlaylist painelCriarPlaylist;
    private PainelCriarPlaylistGenero painelCriarPlaylistGenero;
    private PainelMinhasMusicas painelMinhasMusicas;
    private PainelCarrinhoCompras painelCarrinhoCompras;




    /**
     * Cria um novo painel <code>JPanel</code> 'PainelCliente', para a página inicial de um utlizador do tipo 'Cliente',
     * com um buffer duplo e um flow layout.
     */

    public PainelCliente(FramePrincipal framePrincipal, Cliente cliente) {
        this.cliente = cliente;
        this.btnVerPlaylists = new JButton("As minhas playlists");
        this.btnVerMusicas = new JButton("As minhas músicas");
        this.btnCriarPlaylist = new JButton("Nova playlist");
        JLabel lblPesquisar = new JLabel("Pesquisar");
        JTextField txtPesquisar = new JTextField();
        this.btnCriarPlaylistGenero = new JButton("Nova playlist por género");
        this.btnOrdenarMusicas = new JButton("Ordenar as minhas músicas");
        this.btnLogout = new BotaoLogout("/resources/BotaoLogout.jpg");
        this.btnCarrinhoCompras = new BotaoCarrinho("/resources/carrinho.jpg");
        this.labelUsername = new JLabel("Bem-vindo: " + getCliente().getUsername());
        this.labelSaldo = new JLabel("Saldo: " + String.valueOf(getCliente().getSaldo()));
        this.painelOpcoesCliente= new PainelOpcoesCliente(cliente);
        this.painelCriarPlaylist = new PainelCriarPlaylist(framePrincipal);
        this.painelCriarPlaylistGenero = new PainelCriarPlaylistGenero(framePrincipal,cliente);
        this.painelMinhasMusicas = new PainelMinhasMusicas(framePrincipal);
        this.painelCarrinhoCompras = new PainelCarrinhoCompras(framePrincipal);




        setBackground(new Color(70, 90, 120));
        setLayout(null);

        btnVerPlaylists.setBounds(20,100,200,25);
        btnVerMusicas.setBounds(20,150,200,25);
        btnVerMusicas.addActionListener(e -> abrirPainelMinhasMusicas());
        btnCriarPlaylist.setBounds(20,200,200,25);
        btnCriarPlaylist.addActionListener(e -> abrirPainelCriarPlaylist());
        btnCriarPlaylistGenero.setBounds(20,250,200,25);
        btnCriarPlaylistGenero.addActionListener(e -> abrirPainelCriarPlaylistGenero());
        btnOrdenarMusicas.setBounds(20,300,200,25);
        btnLogout.setBounds(740, 10, 40, 30);
        btnLogout.addActionListener(e -> voltarPainelPrincipal());
        btnCarrinhoCompras.setBounds(20,600,50,30);
        btnCarrinhoCompras.addActionListener(e -> abrirPainelCarrinhoCompras());
        labelUsername.setBounds(20,5,200,25);
        labelUsername.setForeground(Color.WHITE);
        labelSaldo.setBounds(100,600,200,25);
        labelSaldo.setForeground(Color.WHITE);
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


        add(btnVerPlaylists);
        add(btnVerMusicas);
        add(btnCriarPlaylist);
        add(btnCriarPlaylistGenero);
        add(btnOrdenarMusicas);
        add(btnLogout);
        add(btnCarrinhoCompras);
        add(labelUsername);
        add(labelSaldo);
        add(painelOpcoesCliente);



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

    private void abrirPainelMinhasMusicas() {
        // Remover todos os componentes do painelOpcoesCliente
        painelOpcoesCliente.removeAll();
        // Adicionar o painelCriarPlaylist ao painelOpcoesCliente
        painelOpcoesCliente.add(painelMinhasMusicas);
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

    private void abrirPainelCarrinhoCompras() {
        // Remover todos os componentes do painelOpcoesCliente
        painelOpcoesCliente.removeAll();
        // Adicionar o painelCriarPlaylist ao painelOpcoesCliente
        painelOpcoesCliente.add(painelCarrinhoCompras);
        // Atualizar o painelOpcoesCliente
        painelOpcoesCliente.revalidate();
        painelOpcoesCliente.repaint();
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


}


