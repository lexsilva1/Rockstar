package GUI;

import backend.Cliente;
import backend.Utilizador;

import javax.swing.*;
import java.awt.*;

public class PainelCliente extends JPanel{
    private FramePrincipal framePrincipal;
    private Cliente cliente;
    private JButton btnVerPlaylists;
    private JButton btnVerMusicas;
    private JButton btnCriarPlaylist;
    private JButton btnCriarPlaylistGenero;
    private JButton btnOrdenarMusicas;
    private JButton btnPesquisa;
    private JButton btnCarregamento;
    private JButton btnLogout;
    private BotaoCarrinho btnCarrinhoCompras;
    private JButton btnVoltar;
    private JLabel labelUsername; //Colocar o username visivel
    private JLabel labelSaldo; //Colocar o saldo visível
    private PainelOpcoesCliente painelOpcoesCliente;
    private PainelCriarPlaylist painelCriarPlaylist;
    private PainelCriarPlaylistGenero painelCriarPlaylistGenero;
    private Image imagemDeFundo;




    /**
     * Cria um novo painel <code>JPanel</code> 'PainelCliente', para a página inicial de um utlizador do tipo 'Cliente',
     * com um buffer duplo e um flow layout.
     */

    public PainelCliente(FramePrincipal framePrincipal, Cliente cliente) {
        this.framePrincipal = framePrincipal;
        this.cliente = cliente;
        this.btnVerPlaylists = new JButton("As minhas playlists");
        this.btnVerMusicas = new JButton("As minhas músicas");
        this.btnCriarPlaylist = new JButton("Nova playlist");
        this.btnCriarPlaylistGenero = new JButton("Nova playlist por género");
        this.btnOrdenarMusicas = new JButton("Ordenar as minhas músicas");
        this.btnPesquisa = new JButton("Pesquisar");
        this.btnCarregamento = new JButton("Carregar conta");
        this.btnLogout = new JButton("Logout");
        this.btnCarrinhoCompras = new BotaoCarrinho("/resources/carrinho.jpg");
        this.btnVoltar = new JButton("Voltar");
        this.labelUsername = new JLabel("Bem-vindo: " + getCliente().getUsername());
        this.labelSaldo = new JLabel("Saldo: " + String.valueOf(getCliente().getSaldo()));
        this.painelOpcoesCliente= new PainelOpcoesCliente(cliente);
        this.painelCriarPlaylist = new PainelCriarPlaylist(framePrincipal);
        this.painelCriarPlaylistGenero = new PainelCriarPlaylistGenero(framePrincipal);
        this.imagemDeFundo = new ImageIcon(getClass().getResource("/resources/ockstar.png")).getImage();




        setLayout(null);

        btnVerPlaylists.setBounds(20,100,200,25);
        btnVerMusicas.setBounds(20,150,200,25);
        btnCriarPlaylist.setBounds(20,200,200,25);
        btnCriarPlaylist.addActionListener(e -> abrirPainelCriarPlaylist());
        btnCriarPlaylistGenero.setBounds(20,250,200,25);
        btnCriarPlaylistGenero.addActionListener(e -> abrirPainelCriarPlaylistGenero());
        btnOrdenarMusicas.setBounds(20,300,200,25);
        btnPesquisa.setBounds(20,350,200,25);
        btnCarregamento.setBounds(20,400,200,25);
        btnLogout.setBounds(635, 10, 75, 25);
        btnLogout.addActionListener(e -> voltarPainelPrincipal());
        btnVoltar.setBounds(10,625,75,25);
        btnVoltar.addActionListener(e -> voltarPainelLogin());
        btnCarrinhoCompras.setBounds(725,10,50,30);
        labelUsername.setBounds(20,5,200,25);
        labelUsername.setForeground(Color.WHITE);
        labelSaldo.setBounds(300,5,200,25);
        labelSaldo.setForeground(Color.WHITE);
        painelOpcoesCliente.setBounds(275,100,450,500);
        painelCriarPlaylist.setBounds(275,100,450,500);
        painelCriarPlaylistGenero.setBounds(275,100,450,500);




        add(btnVerPlaylists);
        add(btnVerMusicas);
        add(btnCriarPlaylist);
        add(btnCriarPlaylistGenero);
        add(btnOrdenarMusicas);
        add(btnPesquisa);
        add(btnCarregamento);
        add(btnLogout);
        add(btnCarrinhoCompras);
        add(btnVoltar);
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
    private void abrirPainelCriarPlaylistGenero() {
        // Remover todos os componentes do painelOpcoesCliente
        painelOpcoesCliente.removeAll();
        // Adicionar o painelCriarPlaylist ao painelOpcoesCliente
        painelOpcoesCliente.add(painelCriarPlaylistGenero);
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

    private void voltarPainelLogin() {
        FramePrincipal framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelLogin(framePrincipal));
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Desenha a imagem de fundo
        g.drawImage(imagemDeFundo, 0, 0, getWidth(), getHeight(), this);
    }
}


