package GUI;

import backend.Utilizador;

import javax.swing.*;

public class PainelAdmin extends JPanel {
    private FramePrincipal framePrincipal;
    private Utilizador utilizador;
    private JButton btnPesquisarMusica;
    private JButton btnPesquisarUtilizador;
    private JButton btnVerCampanhas;
    private JButton btnCriarCampanha;
    private JButton btnLogout;




    /**
     * Cria um novo painel <code>JPanel</code> 'PainelAdmin', para a página inicial de um utlizador do tipo 'Administrador',
     * com um buffer duplo e um flow layout.
     */
    public PainelAdmin(FramePrincipal framePrincipal, Utilizador utilizador) {
        this.framePrincipal = framePrincipal;
        this.utilizador = utilizador;
        this.btnPesquisarMusica = new JButton("Pesquisar Música");
        this.btnPesquisarUtilizador = new JButton("ªPesquisar Utilizador");
        this.btnVerCampanhas = new JButton("Ver Campanhas");
        this.btnCriarCampanha = new JButton("Criar Campanha");
        this.btnLogout = new JButton("Logout");
        btnLogout.setBounds(525, 5, 56, 26);

        btnPesquisarMusica.setBounds(250,50,170,25);
        btnPesquisarUtilizador.setBounds(250,75,170,25);
        btnVerCampanhas.setBounds(250,100,170,25);
        btnCriarCampanha.setBounds(250,125,170,25);
        add(btnLogout);

        add(btnPesquisarMusica);
        add(btnPesquisarUtilizador);
        add(btnVerCampanhas);
        add(btnCriarCampanha);

        setVisible(true);


    }
}
