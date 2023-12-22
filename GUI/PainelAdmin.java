package GUI;

import backend.Utilizador;

import javax.swing.*;

public class PainelAdmin extends JPanel {

    private Utilizador utilizador;
    private JButton pesquisarMusica;
    private JButton pesquisarUtilizador;
    private JButton verCampanhas;
    private JButton criarCampanha;



    /**
     * Cria um novo painel <code>JPanel</code> 'PainelAdmin', para a página inicial de um utlizador do tipo 'Administrador',
     * com um buffer duplo e um flow layout.
     */
    public PainelAdmin(Utilizador utilizador) {
        this.utilizador = utilizador;
        this.pesquisarMusica = new JButton("Pesquisar Música");
        this.pesquisarUtilizador = new JButton("ªPesquisar Utilizador");
        this.verCampanhas = new JButton("Ver Campanhas");
        this.criarCampanha = new JButton("Criar Campanha");


        pesquisarMusica.setBounds(250,50,170,25);
        pesquisarUtilizador.setBounds(250,75,170,25);
        verCampanhas.setBounds(250,100,170,25);
        criarCampanha.setBounds(250,125,170,25);

        add(pesquisarMusica);
        add(pesquisarUtilizador);
        add(verCampanhas);
        add(criarCampanha);

        setVisible(true);


    }
}
