package GUI;

import backend.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PainelMinhasMusicas extends JPanel {
    private JTable tabela;
    private DefaultTableModel modeloTabela;

    /**
     * Painel onde é possível ver todas as <code>Musica</code> que o <code>Cliente</code> já adquiriu. É também
     *possível adicionar essas <code>Musica</code> a <code>Playlist</code>, avaliar as mesmas.
     * @param framePrincipal
     * @param cliente
     * @param painelCliente
     */

    public PainelMinhasMusicas(FramePrincipal framePrincipal, Cliente cliente, PainelCliente painelCliente) {

        setLayout(new BorderLayout());
        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));

        modeloTabela = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modeloTabela.addColumn("Título");
        modeloTabela.addColumn("Artista");
        modeloTabela.addColumn("Género");
        modeloTabela.addColumn("Data Lançamento");
        modeloTabela.addColumn("Rating");
        modeloTabela.addColumn("Preço");
        adicionarMusica(cliente);



        tabela = new JTable(modeloTabela);
        tabela.getTableHeader().setReorderingAllowed(false);

        JPanel painelSuperior = new JPanel(new BorderLayout());
        JLabel rotuloBarra = new JLabel("Minhas Músicas");
        rotuloBarra.setHorizontalAlignment(SwingConstants.CENTER);
        painelSuperior.add(rotuloBarra, BorderLayout.CENTER);

        painelSuperior.add(tabela.getTableHeader(), BorderLayout.SOUTH);

        JScrollPane painelRolagem = new JScrollPane(tabela);

        add(painelSuperior, BorderLayout.NORTH);
        add(painelRolagem, BorderLayout.CENTER);


        JPopupMenu popupMenu = adicionarMusicaPlaylist(framePrincipal, cliente,painelCliente);
        tabela.setComponentPopupMenu(popupMenu);
        tabela.setAutoCreateRowSorter(true);

    }

    public void adicionarMusica(Cliente cliente) {
        for (Musica a : cliente.getMusicas()) {
            modeloTabela.addRow(new Object[]{a.getTitulo(), a.getAutor(), a.getGenero(), a.getDataLancamento(), a.calculoRating(), a.getPreco()});
            revalidate();
            repaint();
        }
    }

    public JPopupMenu adicionarMusicaPlaylist(FramePrincipal framePrincipal, Cliente cliente,PainelCliente painelCliente) {
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
/**
 * Este método faz as devidas verificações para garantir que a <code>Musica</code> pode ser adicionada à <code>Playlist</code>
 */
            okButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GrupoMusicas playlist = (Playlist) escolhaPlaylist.getSelectedItem();
                    for( Musica g : cliente.getMusicas()) {
                        if (g.getTitulo().equals(titulo) && playlist != null) {
                            if (!g.getAtiva()) {
                                JOptionPane.showMessageDialog(null, "Música inativada pelo seu autor", "Impossível adicionar música",
                                        JOptionPane.ERROR_MESSAGE);
                            } else {
                                if (estaAdicionada(g, playlist)) {
                                    JOptionPane.showMessageDialog(null, "A música já foi adicionada à Playlist", "Erro",
                                            JOptionPane.ERROR_MESSAGE);
                                    addToPlaylist.setVisible(false);
                                    revalidate();
                                    repaint();
                                } else {
                                    playlist.addMusica(g);
                                    JOptionPane.showMessageDialog(null, "Musica adicionada com sucesso",
                                            "Musica Adicionada", JOptionPane.INFORMATION_MESSAGE);
                                    addToPlaylist.setVisible(false);
                                    revalidate();
                                    repaint();
                                }

                            }
                        }
                    }
                }
            });

            JButton cancelButton = new JButton();
            cancelButton.setText("Cancelar");
            cancelButton.setFocusable(false);
            cancelButton.addActionListener(e12 -> {
                addToPlaylist.dispose();
            });

            painelSul.add(okButton);
            painelSul.add(cancelButton);

            /////////Painel Principal\\\\\\\\\\\\\

            addToPlaylist.add(painelCentro, BorderLayout.CENTER);
            addToPlaylist.add(painelSul, BorderLayout.SOUTH);

            addToPlaylist.setLocationRelativeTo(framePrincipal);
            addToPlaylist.setVisible(true);
        });

        JMenuItem avaliarMusica = new JMenuItem("Avaliar");
        avaliarMusica.addActionListener(e -> {
            int selectedRow = tabela.getSelectedRow();
            String titulo = (String) tabela.getValueAt(selectedRow, 0);

            JDialog addToPlaylist = new JDialog(framePrincipal, "Avaliar", true);
            addToPlaylist.setSize(400, 150);
            addToPlaylist.setLayout(new BorderLayout());
            addToPlaylist.setResizable(false);

            JPanel painelCentro = new JPanel(null);

            JLabel avaliarPlaylist = new JLabel();
            avaliarPlaylist.setText("Avaliar");
            avaliarPlaylist.setBounds(40, 20, 150, 25);

            Integer[] ratings = {0, 1, 2, 3, 4, 5};

            JComboBox<Integer> opcoesAvaliar = new JComboBox<>(ratings);
            opcoesAvaliar.setBounds(avaliarPlaylist.getX() + 160, avaliarPlaylist.getY(), 150, 25);

            painelCentro.add(avaliarPlaylist);
            painelCentro.add(opcoesAvaliar);

            JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.CENTER));

            JButton okButton = new JButton();
            okButton.setText("Ok");
            okButton.setFocusable(false);
            okButton.addActionListener(e1 -> {
                opcoesAvaliar.getSelectedItem();
                for (Musica g : cliente.getMusicas()) {
                    if (g.getTitulo().equals(titulo)) {
                        g.avaliar(cliente, (Integer) opcoesAvaliar.getSelectedItem());
                        JOptionPane.showMessageDialog(null, "Musica avaliada com sucesso",
                                "Musica Avaliada", JOptionPane.INFORMATION_MESSAGE);
                        painelCliente.abrirPainelMinhasMusicas();
                        addToPlaylist.setVisible(false);
                        revalidate();
                        repaint();
                    }
                }
            });

            JButton cancelButton = new JButton();
            cancelButton.setText("Cancelar");
            cancelButton.setFocusable(false);
            cancelButton.addActionListener(e13 -> {
                addToPlaylist.dispose();
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
        popupMenu.add(avaliarMusica);
        return popupMenu;
    }


    public GrupoMusicas[] verPlaylists(FramePrincipal framePrincipal, Cliente cliente) {
        ArrayList<GrupoMusicas> playlists = new ArrayList<>();
        for (GrupoMusicas g : framePrincipal.getRockstar().getGrupoMusicas()) {
            if (g.getOwner().equals(cliente.getUsername())) {
                playlists.add(g);
            }
        }
        GrupoMusicas [] minhasplaylists = new Playlist[playlists.size()];
        int i=0;
        for (GrupoMusicas g : playlists){
            minhasplaylists[i]=g;
            i++;
        }
        return minhasplaylists;
    }

    /**
     * verifica se a <code>Musica</code> está adicionada à <code>Playlist</code>
     * @param music
     * @param playlist
     * @return
     */
    private boolean estaAdicionada(Musica music, GrupoMusicas playlist) {
        return playlist.getMusicas().stream().anyMatch(m -> m.equals(music));
    }

}