package GUI;

import backend.Cliente;
import backend.Compra;
import backend.Musica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;

public class HistoricoDeCompras extends JPanel {

    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private JScrollPane scrollPane;

    public HistoricoDeCompras(FramePrincipal frameprincipal , Cliente cliente) {
        setLayout(new BorderLayout());
        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));

        modeloTabela = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modeloTabela.addColumn("Data");
        modeloTabela.addColumn("Titulo");
        modeloTabela.addColumn("Género");
        modeloTabela.addColumn("Artista");
        modeloTabela.addColumn("Preço");
        for (Compra c : cliente.getHistoricoCompras()) {
            for (Musica m : cliente.getMusicas()) {
                for (Map.Entry<Musica, Double> entry : c.getMusicas().entrySet()) {
                    if(m.equals(entry.getKey())) {
                        modeloTabela.addRow(new Object[]{c.getData(), m.getTitulo(), m.getGenero(), m.getAutor(), entry.getValue()});
                    }
                }
            }
        }
        tabela = new JTable(modeloTabela);
        tabela.setAutoCreateRowSorter(true);
        tabela.getTableHeader().setReorderingAllowed(false);
        scrollPane = new JScrollPane(tabela);
        scrollPane.setVisible(true);

        JPanel painelSuperior = new JPanel(new BorderLayout());
        JLabel rotuloBarra = new JLabel("Histórico de Compras");
        rotuloBarra.setHorizontalAlignment(SwingConstants.CENTER);
        painelSuperior.add(rotuloBarra, BorderLayout.CENTER);

        painelSuperior.add(tabela.getTableHeader(), BorderLayout.SOUTH);

        add(scrollPane, BorderLayout.CENTER);
        add(painelSuperior, BorderLayout.NORTH);

        setVisible(true);
    }
}
