package GUI;

import javax.swing.*;

public class PainelCliente extends JPanel {

    private JButton verPlaylists;
    private JButton verMusicas;
    private JButton criarPlaylist;
    private JButton criarPlaylistGenero;
    private JButton ordenarMusicas;
    private JButton pesquisa;
    private JButton carregamento;


    /**
     * Cria um novo painel <code>JPanel</code> 'PainelCliente', para a página inicial de um utlizador do tipo 'Cliente',
     * com um buffer duplo e um flow layout.
     */
    public PainelCliente() {
        this.verPlaylists = new JButton("As minhas playlists");
        this.verMusicas = new JButton("As minhas músicas");
        this.criarPlaylist = new JButton("Nova playlist");
        this.criarPlaylistGenero = new JButton("Nova playlist por género");
        this.ordenarMusicas = new JButton("Ordenar as minhas músicas");
        this.pesquisa = new JButton("Pesquisar");
        this.carregamento = new JButton("Carregar conta");

        verPlaylists.setBounds(250,50,170,25);
        verMusicas.setBounds(250,75,170,25);
        criarPlaylist.setBounds(250,100,170,25);
        criarPlaylistGenero.setBounds(250,125,170,25);
        ordenarMusicas.setBounds(250,150,170,25);
        pesquisa.setBounds(250,175,170,25);
        carregamento.setBounds(250,200,170,25);

        add(verPlaylists);
        add(verMusicas);
        add(criarPlaylist);
        add(criarPlaylistGenero);
        add(ordenarMusicas);
        add(pesquisa);
        add(carregamento);

        setVisible(true);


    }
}
