package GUI;

import backend.Musico;
import backend.Utilizador;

import javax.swing.*;

public class PainelMusico extends JPanel {
    private FramePrincipal framePrincipal;
    private Musico musico;
    private JButton btnVerAlbuns;
    private JButton btnVerMusicas;
    private JButton btnCriarAlbum;
    private JButton btnAddMusica;
    private JButton btnPesquisa;
    private JButton btnOrdenarMusicas;
    private JButton btnEstatisticas;
    private JButton btnLogout;



    /**
     * Cria um novo painel <code>JPanel</code> 'PainelMusico', para a página inicial de um utlizador do tipo 'Musico',
     * com um buffer duplo e um flow layout.
     */
    public PainelMusico(FramePrincipal framePrincipal, Musico musico) {
        this.framePrincipal = framePrincipal;
        this.musico = musico;
        this.btnVerAlbuns = new JButton("Os meus álbuns");
        this.btnVerMusicas = new JButton("As minhas músicas");
        this.btnCriarAlbum = new JButton("Novo álbum");
        this.btnAddMusica = new JButton("Adicionar música");
        this.btnPesquisa = new JButton("Pesquisar música");
        this.btnOrdenarMusicas = new JButton("Ordenar as minhas músicas");
        this.btnEstatisticas = new JButton("Ver estatísticas");
        this.btnLogout = new JButton("Logout");
        btnLogout.setBounds(525, 5, 56, 26);


        btnVerAlbuns.setBounds(250,50,170,25);
        btnVerMusicas.setBounds(250,75,170,25);
        btnCriarAlbum.setBounds(250,100,170,25);
        btnAddMusica.setBounds(250,125,170,25);
        btnPesquisa.setBounds(250,175,170,25);
        btnOrdenarMusicas.setBounds(250,150,170,25);
        btnEstatisticas.setBounds(250,200,170,25);
        add(btnLogout);

        add(btnVerAlbuns);
        add(btnVerMusicas);
        add(btnCriarAlbum);
        add(btnAddMusica);
        add(btnPesquisa);
        add(btnOrdenarMusicas);
        add(btnEstatisticas);
        
        setVisible(true);


    }
}
