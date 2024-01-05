package GUI;

import backend.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Iterator;

public class PainelMinhasPlaylists extends JPanel {
    private Cliente cliente;
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private JScrollPane scrollPane;


    public PainelMinhasPlaylists(FramePrincipal framePrincipal, Cliente cliente, PainelCliente painelCliente) {
        this.cliente = cliente;

        setLayout(new BorderLayout());
        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));

        // Criar o modelo da tabela
        modeloTabela = new DefaultTableModel();
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

        // Criar a tabela com o modelo
        tabela = new JTable(modeloTabela);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(300);
        scrollPane = new JScrollPane(tabela);
        scrollPane.setVisible(true);
        add(scrollPane, BorderLayout.CENTER);

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
                            modeloTabela1.addRow(new Object[]{m.getTitulo(), m.getAutor(), m.getGenero(), m.getDataLancamento(), m.getRating(), m.getPreco()});
                        }
                        revalidate();
                        repaint();
                    }
                }

                // Criar a tabela com o modelo
                this.removeAll();
                JTable tabela1 = new JTable(modeloTabela1);
                JScrollPane scrollPane1 = new JScrollPane(tabela1);
                scrollPane1.setVisible(true);
                this.add(scrollPane1, BorderLayout.CENTER);
                tabela1.setVisible(true);
                this.add(tabela1);
                revalidate();
                repaint();
            }
        });


        JMenuItem apagarPlaylist= new JMenuItem("Apagar");

        apagarPlaylist.addActionListener(e -> {
            int linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada != -1) {
                String nome = (String) tabela.getValueAt(linhaSelecionada, 0);
                Iterator<GrupoMusicas> iterator = framePrincipal.getRockstar().getGrupoMusicas().iterator();
                while (iterator.hasNext()) {
                    Playlist c = (Playlist) iterator.next();
                    if (c.getTitulo().equals(nome) && c.getOwner().equals(cliente.getUsername())) {
                        iterator.remove(); // Use the iterator's remove method

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
