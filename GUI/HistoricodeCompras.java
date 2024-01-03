package GUI;

import backend.Cliente;
import backend.Compra;
import backend.Musica;
import backend.Rockstar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HistoricodeCompras extends JPanel {

    private JTable tabela;
    private DefaultTableModel modeloTabela;

    private JScrollPane scrollPane;

    public HistoricodeCompras(FramePrincipal frameprincipal ,Cliente cliente) {


        setLayout(new BorderLayout());
        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));

        // Criar o modelo da tabela
        modeloTabela = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false; // Torna todas as células não editáveis
            }
        };

        modeloTabela.addColumn("Data");
        modeloTabela.addColumn("Titulo");
        modeloTabela.addColumn("Género");
        modeloTabela.addColumn("Artista");
        modeloTabela.addColumn("Preço");
        for (Compra c : cliente.getHistoricoCompras()){
            for (Musica m : c.getMusicas()) {
                modeloTabela.addRow(new Object[]{c.getData(), m.getTitulo(), m.getGenero(), m.getAutor(), m.getPreco()});
            }
        }
        tabela = new JTable(modeloTabela);
        tabela.setAutoCreateRowSorter(true);
        scrollPane = new JScrollPane(tabela);
        scrollPane.setVisible(true);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
