package GUI;

import backend.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Iterator;

public class PainelMinhasPlaylists extends JPanel {
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private JScrollPane scrollPane;


    public PainelMinhasPlaylists(FramePrincipal framePrincipal, Cliente cliente, PainelCliente painelCliente) {

        setLayout(new BorderLayout());
        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));


        modeloTabela = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modeloTabela.addColumn("Nome");
        modeloTabela.addColumn("Visibilidade");
        String visibilidade = "";


        for (GrupoMusicas p : framePrincipal.getRockstar().getGrupoMusicas()){
            if(p instanceof Playlist && p.getOwner().equals(cliente.getUsername())){
                if (((Playlist) p).isPublico()) {
                    visibilidade = "Público";
                } else {
                    visibilidade = "Privado";
                }
                modeloTabela.addRow(new Object[]{p.getTitulo(),visibilidade});
                revalidate();
                repaint();
            }
        }

        tabela = new JTable(modeloTabela);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(300);
        tabela.getTableHeader().setReorderingAllowed(false);
        scrollPane = new JScrollPane(tabela);
        scrollPane.setVisible(true);

        JPanel painelSuperior = new JPanel(new BorderLayout());
        JLabel rotuloBarra = new JLabel("As Minhas Playlists");
        rotuloBarra.setHorizontalAlignment(SwingConstants.CENTER);
        painelSuperior.add(rotuloBarra, BorderLayout.CENTER);

        painelSuperior.add(tabela.getTableHeader(), BorderLayout.SOUTH);

        add(scrollPane, BorderLayout.CENTER);
        add(painelSuperior, BorderLayout.NORTH);

        JPopupMenu popupMenu = criarPopupMenuPlaylists(framePrincipal, cliente,painelCliente);
        tabela.setComponentPopupMenu(popupMenu);

        setVisible(true);
    }

    public JPopupMenu criarPopupMenuPlaylists(FramePrincipal framePrincipal, Cliente cliente, PainelCliente painelCliente) {
        JPopupMenu popupMenu = new JPopupMenu();


        JMenuItem abrirPlaylist= new JMenuItem("Abrir");

        abrirPlaylist.addActionListener(e -> {
            int linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada != -1) {
                String nome = (String) tabela.getValueAt(linhaSelecionada, 0);


                DefaultTableModel modeloTabela1 = new DefaultTableModel();
                modeloTabela1.addColumn("Título");
                modeloTabela1.addColumn("Artista");
                modeloTabela1.addColumn("Género");
                modeloTabela1.addColumn("Data Lançamento");
                modeloTabela1.addColumn("Rating");
                modeloTabela1.addColumn("Preço");

                for (GrupoMusicas p : framePrincipal.getRockstar().getGrupoMusicas()){
                    if(p instanceof Playlist && p.getOwner().equals(cliente.getUsername())&& p.getTitulo().equals(nome)){
                        for (Musica m : p.getMusicas()) {
                            modeloTabela1.addRow(new Object[]{m.getTitulo(), m.getAutor(), m.getGenero(), m.getDataLancamento(), m.calculoRating(), m.getPreco()});
                        }
                        revalidate();
                        repaint();
                    }
                }

                JTable tabela1 = new JTable(modeloTabela1);
                JScrollPane scrollPane1 = new JScrollPane(tabela1);
                tabela1.getTableHeader().setReorderingAllowed(false);
                scrollPane1.setVisible(true);

                JPanel painelSuperior = new JPanel(new BorderLayout());
                JLabel rotuloBarra = new JLabel(nome);
                rotuloBarra.setHorizontalAlignment(SwingConstants.CENTER);
                painelSuperior.add(rotuloBarra, BorderLayout.CENTER);

                painelSuperior.add(tabela1.getTableHeader(), BorderLayout.SOUTH);

                this.removeAll();
                this.add(scrollPane1, BorderLayout.CENTER);
                this.add(painelSuperior, BorderLayout.NORTH);




                revalidate();
            }
        });


        JMenuItem apagarPlaylist= new JMenuItem("Apagar");

        apagarPlaylist.addActionListener(e -> {
            int linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada != -1) {
                String nome = (String) tabela.getValueAt(linhaSelecionada, 0);
                Iterator<GrupoMusicas> iterator = framePrincipal.getRockstar().getGrupoMusicas().iterator();
                while (iterator.hasNext()) {
                    GrupoMusicas grupo = iterator.next();
                    if (grupo instanceof Playlist) {
                        Playlist playlist = (Playlist) grupo;
                        if (playlist.getTitulo().equals(nome) && playlist.getOwner().equals(cliente.getUsername())) {
                            iterator.remove();
                        }
                    }
                }
            }
            painelCliente.abrirPainelMinhasPlaylists();

        });

        JMenuItem visibilidadePlaylist= new JMenuItem("Alterar Visibilidade");

        visibilidadePlaylist.addActionListener(e -> {
            int linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada != -1) {
                String nome = (String) tabela.getValueAt(linhaSelecionada, 0);
                String visibilidade = "";
                for (GrupoMusicas c : framePrincipal.getRockstar().getGrupoMusicas()) {
                    if (c instanceof Playlist && c.getTitulo().equals(nome) && c.getOwner().equals(cliente.getUsername())) {
                        ((Playlist) c).setPublico();
                        if (((Playlist) c).isPublico()) {
                            visibilidade = "Público";
                            int modelRow = tabela.convertRowIndexToModel(linhaSelecionada);
                            modeloTabela.setValueAt(visibilidade, modelRow, 1);
                            tabela.repaint();
                        } else {
                            visibilidade = "Privado";
                            int modelRow = tabela.convertRowIndexToModel(linhaSelecionada);
                            modeloTabela.setValueAt(visibilidade, modelRow, 1);
                            tabela.repaint();
                    }
                }
            }
                }
        });

        popupMenu.add(abrirPlaylist);
        popupMenu.add(visibilidadePlaylist);
        popupMenu.add(apagarPlaylist);

        return popupMenu;
    }
}
