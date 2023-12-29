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
    private JLabel labelUsername; //Colocar o username visivel
    private JLabel labelSaldo; //Colocar o saldo visível
    private PainelOpcoesCliente painelOpcoesCliente;
    private PainelCriarPlaylist painelCriarPlaylist;
    private PainelCriarPlaylistGenero painelCriarPlaylistGenero;
    private PainelPesquisar painelPesquisar;
    private PainelAddSaldo painelsaldo;




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
        JLabel lblPesquisar = new JLabel("Pesquisar");
        JTextField txtPesquisar = new JTextField();
        this.btnCriarPlaylistGenero = new JButton("Nova playlist por género");
        this.btnOrdenarMusicas = new JButton("Ordenar as minhas músicas");
        this.btnPesquisa = new JButton("Pesquisar");
        this.btnCarregamento = new JButton("Carregar conta");
        this.btnLogout = new JButton("Logout");
        this.btnCarrinhoCompras = new BotaoCarrinho("/resources/carrinho.jpg");
        this.labelUsername = new JLabel("Bem-vindo: " + getCliente().getUsername());
        this.labelSaldo = new JLabel("Saldo: " + String.valueOf(getCliente().getSaldo()));
        this.painelOpcoesCliente= new PainelOpcoesCliente(cliente);
        this.painelCriarPlaylist = new PainelCriarPlaylist(framePrincipal);
        this.painelCriarPlaylistGenero = new PainelCriarPlaylistGenero(framePrincipal,cliente);
        this.painelPesquisar = new PainelPesquisar(framePrincipal);
        this.painelsaldo = new PainelAddSaldo(framePrincipal,cliente,this.labelSaldo);




        setBackground(new Color(70, 90, 120));
        setLayout(null);

        btnVerPlaylists.setBounds(20,100,200,25);
        btnVerMusicas.setBounds(20,150,200,25);
        btnCriarPlaylist.setBounds(20,200,200,25);
        btnCriarPlaylist.addActionListener(e -> abrirPainelCriarPlaylist());
        btnCriarPlaylistGenero.setBounds(20,250,200,25);
        btnCriarPlaylistGenero.addActionListener(e -> abrirPainelCriarPlaylistGenero());
        btnOrdenarMusicas.setBounds(20,300,200,25);
        btnPesquisa.setBounds(20,350,200,25);
        btnPesquisa.addActionListener(e -> abrirPainelPesquisar());
        btnCarregamento.setBounds(20,400,200,25);
        btnCarregamento.addActionListener(e -> abrirPainelAddSaldo());
        btnLogout.setBounds(635, 10, 75, 25);
        btnLogout.addActionListener(e -> voltarPainelPrincipal());
        btnCarrinhoCompras.setBounds(725,10,50,30);
        labelUsername.setBounds(20,5,200,25);
        labelUsername.setForeground(Color.WHITE);
        labelSaldo.setBounds(200,5,200,25);
        labelSaldo.setForeground(Color.WHITE);
        painelOpcoesCliente.setBounds(275,100,450,500);
        painelCriarPlaylist.setBounds(275,100,450,500);
        painelCriarPlaylistGenero.setBounds(275,100,450,500);
        painelsaldo.setBounds(275,100,450,500);

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
        add(btnPesquisa);
        add(btnCarregamento);
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
        painelCriarPlaylist.setVisible(true);
        painelOpcoesCliente.add(painelCriarPlaylist);
        // Atualizar o painelOpcoesCliente
        painelOpcoesCliente.revalidate();
        painelOpcoesCliente.repaint();
    }

    private void abrirPainelPesquisar() {
        // Remover todos os componentes do painelOpcoesCliente
        painelOpcoesCliente.removeAll();
        // Adicionar o painelCriarPlaylist ao painelOpcoesCliente
        painelOpcoesCliente.add(painelPesquisar);
        // Atualizar o painelOpcoesCliente
        painelOpcoesCliente.revalidate();
        painelOpcoesCliente.repaint();
    }
    private void abrirPainelCriarPlaylistGenero() {
        // Remover todos os componentes do painelOpcoesCliente
        painelOpcoesCliente.removeAll();
        // Adicionar o painelCriarPlaylist ao painelOpcoesCliente
        painelCriarPlaylistGenero.setVisible(true);
        painelOpcoesCliente.add(painelCriarPlaylistGenero);
        // Atualizar o painelOpcoesCliente
        painelOpcoesCliente.revalidate();
        painelOpcoesCliente.repaint();
    }
    private void abrirPainelAddSaldo() {
        // Remover todos os componentes do painelOpcoesCliente
        painelOpcoesCliente.removeAll();
        // Adicionar o painelAddSaldo ao painelOpcoesCliente
        painelsaldo.setVisible(true);
        painelOpcoesCliente.add(painelsaldo);
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


