package GUI;

import backend.Utilizador;

import javax.swing.*;

public class PainelMusico extends JPanel {

    private Utilizador utilizador;
    private JButton verAlbuns;
    private JButton verMusicas;
    private JButton criarAlbum;
    private JButton addMusica;
    private JButton pesquisa;
    private JButton ordenarMusicas;
    private JButton estatisticas;


    /**
     * Cria um novo painel <code>JPanel</code> 'PainelMusico', para a página inicial de um utlizador do tipo 'Musico',
     * com um buffer duplo e um flow layout.
     */
    public PainelMusico(Utilizador utilizador) {
        this.utilizador = utilizador;
        this.verAlbuns = new JButton("Os meus álbuns");
        this.verMusicas = new JButton("As minhas músicas");
        this.criarAlbum = new JButton("Novo álbum");
        this.addMusica = new JButton("Adicionar música");
        this.pesquisa = new JButton("Pesquisar música");
        this.ordenarMusicas = new JButton("Ordenar as minhas músicas");
        this.estatisticas = new JButton("Ver estatísticas");

        verAlbuns.setBounds(250,50,170,25);
        verMusicas.setBounds(250,75,170,25);
        criarAlbum.setBounds(250,100,170,25);
        addMusica.setBounds(250,125,170,25);
        pesquisa.setBounds(250,175,170,25);
        ordenarMusicas.setBounds(250,150,170,25);
        estatisticas.setBounds(250,200,170,25);

        add(verAlbuns);
        add(verMusicas);
        add(criarAlbum);
        add(addMusica);
        add(pesquisa);
        add(ordenarMusicas);
        add(estatisticas);
        
        setVisible(true);


    }
}
