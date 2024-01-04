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

    public PainelMinhasPlaylists(FramePrincipal framePrincipal, Cliente cliente) {
        this.cliente = cliente;

        setLayout(new BorderLayout());
        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));

        // Criar o modelo da tabela
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Nome");
        modeloTabela.addColumn("Visibilidade");
        for (GrupoMusicas p : framePrincipal.getRockstar().getGrupoMusicas()){
            if(p instanceof Playlist && p.getOwner().equals(cliente.getUsername())){
                modeloTabela.addRow(new Object[]{p.getTitulo(),((Playlist) p).isPublico()});
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

        JPopupMenu popupMenu = criarPopupMenuPlaylists(framePrincipal, cliente);
        tabela.setComponentPopupMenu(popupMenu);

        setVisible(true);
    }

    public JPopupMenu criarPopupMenuPlaylists(FramePrincipal framePrincipal, Cliente cliente) {
        JPopupMenu popupMenu = new JPopupMenu();

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
        });
        popupMenu.add(apagarPlaylist);

        return popupMenu;
    }
}
