package GUI;

import backend.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class PainelMinhasMusicas extends JPanel {
    private Cliente cliente;
    private JTable tabela;
    private DefaultTableModel modeloTabela;

    public PainelMinhasMusicas(FramePrincipal framePrincipal, Cliente cliente) {
        this.cliente = cliente;

        setLayout(new BorderLayout());
        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));

        // Criar o modelo da tabela
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Título");
        modeloTabela.addColumn("Artista");
        modeloTabela.addColumn("Género");
        modeloTabela.addColumn("Data Lançamento");
        modeloTabela.addColumn("Rating");
        modeloTabela.addColumn("Preço");
        adicionarMusica(cliente);

        // Criar a tabela com o modelo
        tabela = new JTable(modeloTabela);

        // Criar um painel de rolagem para a tabela
        JScrollPane painelRolagem = new JScrollPane(tabela);

        // Adicionar o painel de rolagem ao painel
        add(painelRolagem, BorderLayout.CENTER);

        JPopupMenu popupMenu = adicionarMusicaPlaylist(framePrincipal, cliente);
        tabela.setComponentPopupMenu(popupMenu);
    }

    public void adicionarMusica(Cliente cliente) {
        for (Musica a : cliente.getMusicas()) {
            modeloTabela.addRow(new Object[]{a.getTitulo(), a.getAutor(), a.getGenero(), a.getDataLancamento(), a.getRating(), a.getPreco()});
            revalidate();
            repaint();
        }
    }

    public JPopupMenu adicionarMusicaPlaylist(FramePrincipal framePrincipal, Cliente cliente) {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem adicionarMusicaPlaylist = new JMenuItem("Adicionar à playlist");
        adicionarMusicaPlaylist.addActionListener(e -> {
            int selectedRow = tabela.getSelectedRow();
            String titulo = (String) tabela.getValueAt(selectedRow, 0);

            JDialog addToPlaylist = new JDialog(framePrincipal, "Adicionar Playlist", true);
            addToPlaylist.setSize(400, 150);
            addToPlaylist.setLayout(new BorderLayout());
            addToPlaylist.setResizable(false);

            JPanel painelCentro = new JPanel(null);

            JLabel nomePlaylist = new JLabel();
            nomePlaylist.setText("Escolha a playlist");
            nomePlaylist.setBounds(40, 20, 150, 25);


            JComboBox escolhaPlaylist = new JComboBox<>(verPlaylists(framePrincipal,cliente));
            escolhaPlaylist.setBounds(nomePlaylist.getX() + 160, nomePlaylist.getY(), 150, 25);

            painelCentro.add(escolhaPlaylist);
            painelCentro.add(nomePlaylist);

            JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.CENTER));

            JButton okButton = new JButton();
            okButton.setText("Ok");
            okButton.setFocusable(false);
            okButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GrupoMusicas playlist = (Playlist) escolhaPlaylist.getSelectedItem();
                    for( Musica g : cliente.getMusicas()) {
                        if (g.getTitulo().equals(titulo) && playlist != null) {
                                if (estaAdicionada(g,playlist)) {
                                    JOptionPane.showMessageDialog(null, "A música já foi adicionada à Playlist", "Erro",
                                            JOptionPane.ERROR_MESSAGE);
                                } else {
                                    playlist.addMusica(g);
                                    JOptionPane.showMessageDialog(null, "Musica adicionada com sucesso",
                                            "Musica Adicionada", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        }
                    }
            });

            JButton cancelButton = new JButton();
            cancelButton.setText("Cancelar");
            cancelButton.setFocusable(false);
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addToPlaylist.dispose();  //fechar a janela
                }
            });

            painelSul.add(okButton);
            painelSul.add(cancelButton);

            /////////Painel Principal\\\\\\\\\\\\\

            addToPlaylist.add(painelCentro, BorderLayout.CENTER);
            addToPlaylist.add(painelSul, BorderLayout.SOUTH);

            addToPlaylist.setLocationRelativeTo(framePrincipal);
            addToPlaylist.setVisible(true);

        });

        popupMenu.add(adicionarMusicaPlaylist);
        return popupMenu;
    }


    public GrupoMusicas[] verPlaylists(FramePrincipal framePrincipal, Cliente cliente) {
        ArrayList<GrupoMusicas> coiso = new ArrayList<>();
        for (GrupoMusicas g : framePrincipal.getRockstar().getGrupoMusicas()) {
            if (g.getOwner().equals(cliente.getUsername())) {
                coiso.add(g);
            }
        }
        GrupoMusicas [] minhasplaylists = new Playlist[coiso.size()];
        int i=0;
        for (GrupoMusicas x : coiso){
                minhasplaylists[i]=x;
                i++;

        }
        return minhasplaylists;
    }
    private boolean estaAdicionada(Musica music, GrupoMusicas playlist) {
        return playlist.getMusicas().stream().anyMatch(m -> m.equals(music));
    }

}