package GUI;

import backend.Utilizador;

import javax.swing.*;

public class PainelCliente extends JPanel{
    private FramePrincipal framePrincipal;
    private Utilizador utilizador;
    private JButton btnVerPlaylists;
    private JButton btnVerMusicas;
    private JButton btnCriarPlaylist;
    private JButton btnCriarPlaylistGenero;
    private JButton btnOrdenarMusicas;
    private JButton btnPesquisa;
    private JButton btnCarregamento;
    private JButton btnLogout;


    /**
     * Cria um novo painel <code>JPanel</code> 'PainelCliente', para a página inicial de um utlizador do tipo 'Cliente',
     * com um buffer duplo e um flow layout.
     */

    public PainelCliente(FramePrincipal framePrincipal, Utilizador utilizador) {
        this.framePrincipal = framePrincipal;
        this.utilizador = utilizador;
        this.btnVerPlaylists = new JButton("As minhas playlists");
        this.btnVerMusicas = new JButton("As minhas músicas");
        this.btnCriarPlaylist = new JButton("Nova playlist");
        this.btnCriarPlaylistGenero = new JButton("Nova playlist por género");
        this.btnOrdenarMusicas = new JButton("Ordenar as minhas músicas");
        this.btnPesquisa = new JButton("Pesquisar");
        this.btnCarregamento = new JButton("Carregar conta");
        this.btnLogout = new JButton("Logout");

        btnVerPlaylists.setBounds(250,50,170,25);
        btnVerMusicas.setBounds(250,75,170,25);
        btnCriarPlaylist.setBounds(250,100,170,25);
        btnCriarPlaylistGenero.setBounds(250,125,170,25);
        btnOrdenarMusicas.setBounds(250,150,170,25);
        btnPesquisa.setBounds(250,175,170,25);
        btnCarregamento.setBounds(250,200,170,25);
        btnLogout.setBounds(525, 5, 56, 26);

        add(btnVerPlaylists);
        add(btnVerMusicas);
        add(btnCriarPlaylist);
        add(btnCriarPlaylistGenero);
        add(btnOrdenarMusicas);
        add(btnPesquisa);
        add(btnCarregamento);
        add(btnLogout);

        setVisible(true);


    }
}
