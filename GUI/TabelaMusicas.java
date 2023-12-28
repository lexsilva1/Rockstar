package GUI;

import backend.Cliente;
import backend.Musica;
import backend.Musico;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TabelaMusicas extends JPanel {
    private Musico musico;
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private JScrollPane scrollPane;

    public TabelaMusicas(FramePrincipal framePrincipal, Musico musico) {
        this.musico = musico;

        setLayout(new BorderLayout());
        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));

        // Criar o modelo da tabela
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Título");
        modeloTabela.addColumn("Género");
        modeloTabela.addColumn("Activa");
        modeloTabela.addColumn("Data Lançamento");
        modeloTabela.addColumn("Rating");

        for (Musica a : framePrincipal.getRockstar().getMusicas()) {
            if (a.getAutor().equals(musico.getUsername())) {
                modeloTabela.addRow(new Object[]{a.getTitulo(), a.getGenero(), a.getActiva(), a.getDataLancamento(), a.getRating()});
            }
        }

        tabela = new JTable(modeloTabela);

        scrollPane = new JScrollPane(tabela);
        scrollPane.setVisible(false);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(false);
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }
}
