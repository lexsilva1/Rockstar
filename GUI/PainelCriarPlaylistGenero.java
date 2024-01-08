package GUI;

import backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Classe responsável por gerar as <code>Playlist</code> a partir das músicas adquiridas pelo <code>Cliente</code>
 */
public class PainelCriarPlaylistGenero extends JPanel {
    protected Utilizador cliente;
    protected JLabel lblNumero;
    protected JTextField txtNumero;
    protected JLabel lblNome;
    protected JTextField txtNome;
    protected JLabel lblOpcao;
    protected JRadioButton chkPop;
    protected JRadioButton chkRock;
    protected JRadioButton chkHipHop;
    protected JRadioButton chkPimba;
    protected ButtonGroup grupo;
    protected JButton btnCriar;

    public PainelCriarPlaylistGenero(FramePrincipal framePrincipal, Utilizador utilazador) {
        this.cliente= utilazador;
        setLayout(null);
        setBackground(new Color(70, 90, 120));;
        setPreferredSize(new Dimension(450, 500));

        this.lblNumero = new JLabel("Número de músicas");
        lblNumero.setBounds(25, 175, 150, 25);
        lblNumero.setForeground(Color.WHITE);
        add(lblNumero);

        this.txtNumero = new JTextField();
        txtNumero.setBounds(25, 200, 150, 25);
        add(txtNumero);

        this.lblNome = new JLabel("Nome");
        lblNome.setBounds(200, 175, 150, 25);
        lblNome.setForeground(Color.WHITE);
        add(lblNome);

        this.txtNome = new JTextField();
        txtNome.setBounds(200, 200, 150, 25);
        add(txtNome);

        this.lblOpcao = new JLabel("Género");
        lblOpcao.setBounds(25, 100, 220, 25);
        lblOpcao.setForeground(Color.WHITE);
        add(lblOpcao);

        this.chkPop = new JRadioButton("Pop");
        chkPop.setBounds(25, 125, 85, 25);
        chkPop.setBackground(new Color(70, 90, 120));
        chkPop.setForeground(Color.WHITE);
        add(chkPop);

        this.chkRock = new JRadioButton("Rock");
        chkRock.setBounds(110, 125, 85, 25);
        chkRock.setBackground(new Color(70, 90, 120));
        chkRock.setForeground(Color.WHITE);
        add(chkRock);

        this.chkHipHop = new JRadioButton("Hip Hop");
        chkHipHop.setBounds(195, 125, 85, 25);
        chkHipHop.setBackground(new Color(70, 90, 120));
        chkHipHop.setForeground(Color.WHITE);
        add(chkHipHop);

        this.chkPimba = new JRadioButton("Pimba");
        chkPimba.setBounds(310, 125, 85, 25);
        chkPimba.setBackground(new Color(70, 90, 120));
        chkPimba.setForeground(Color.WHITE);
        add(chkPimba);

        this.grupo = new ButtonGroup();
        grupo.add(chkPop);
        grupo.add(chkRock);
        grupo.add(chkHipHop);
        grupo.add(chkPimba);

        this.btnCriar = new JButton("Criar");
        btnCriar.setBounds(300,350,100,25);
        add(btnCriar);


        btnCriar.addActionListener(e -> {
            if (txtNome.getText().isEmpty() || txtNumero.getText().isEmpty() || grupo.getSelection() == null) {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os dados", "Campo vazio", JOptionPane.ERROR_MESSAGE);
            } else {
                if (playlistExiste(txtNome.getText(), framePrincipal)) {
                    JOptionPane.showMessageDialog(null, "Já existe uma playlist com este nome", "Nome repetido", JOptionPane.ERROR_MESSAGE);
                    txtNome.setText("");
                } else {
                    if (Integer.parseInt(txtNumero.getText()) > framePrincipal.getRockstar().getMusicas().size()) {
                        JOptionPane.showMessageDialog(null, "Apenas pode criar playlists com até "+ framePrincipal.getRockstar().getMusicas().size() +" faixas", "Dados errados", JOptionPane.ERROR_MESSAGE);
                    } else {

                        String genero = "Rock";
                        if (chkPop.isSelected()) {
                            genero = "Pop";
                        } else if (chkPimba.isSelected()) {
                            genero = "Pimba";
                        } else if (chkHipHop.isSelected()) {
                            genero = "Hip Hop";
                        }
                        if (cliente instanceof Cliente) {
                            ArrayList<Musica> todasDesteGenero = criaArrayGernero((Cliente) cliente, genero);
                            Playlist playlist = ((Cliente) cliente).criaPlaylistGenero(Integer.parseInt(txtNumero.getText()), txtNome.getText(), todasDesteGenero);
                            if (playlist.getMusicas().size() < Integer.parseInt(txtNumero.getText()) && !playlist.getMusicas().isEmpty()) {
                                framePrincipal.getRockstar().addGrupoDeMusicas(playlist);
                                JOptionPane.showMessageDialog(null, "Playlist adicionada com sucesso, apenas com as " + playlist.getMusicas().size() + " musicas que adquiriu", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                            } else if (playlist.getMusicas().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Playlist não criada por falta de musicas do género solicitado. Por favor visite a nossa Loja", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                framePrincipal.getRockstar().addGrupoDeMusicas(playlist);
                                JOptionPane.showMessageDialog(null, "Playlist adicionada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                            }
                        }
                    }
                }
            }
        });

        txtNumero.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        setVisible(true);

    }

    /**
     * Cria um ArrayList com todas as musicas que o cliente já adquiriu que correspondem ao genero selecionado.
     * Este método é usado no action listner para criar aplaylist com musicas aleatorias.
     * @param cliente
     * @param genero
     * @return
     */
    public ArrayList<Musica> criaArrayGernero( Cliente cliente, String genero){
        ArrayList<Musica> listagenero =new ArrayList<>();
        for(Musica m :  cliente.getMusicas()){
            if(m.getGenero().equals(genero) && m.getAtiva()){
                listagenero.add(m);
            }
        }
        return listagenero;
    }

    public boolean playlistExiste(String nome, FramePrincipal framePrincipal) {
        for (GrupoMusicas g : framePrincipal.getRockstar().getGrupoMusicas()) {
            if (g instanceof Playlist && nome.equals(g.getTitulo())) {
                return true;
            }
        }
        return false;
    }

}