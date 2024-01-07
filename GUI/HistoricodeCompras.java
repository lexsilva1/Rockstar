package GUI;

import backend.Cliente;
import backend.Compra;
import backend.Musica;
import backend.Rockstar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;

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
        scrollPane = new JScrollPane(tabela);
        scrollPane.setVisible(true);
        // Adicionar a barra extra com o rótulo "Minhas Músicas"
        JPanel painelSuperior = new JPanel(new BorderLayout());
        JLabel rotuloBarra = new JLabel("Histórico de Compras");
        rotuloBarra.setHorizontalAlignment(SwingConstants.CENTER);
        painelSuperior.add(rotuloBarra, BorderLayout.CENTER);

        // Adicionar a tabela ao painel superior
        painelSuperior.add(tabela.getTableHeader(), BorderLayout.SOUTH);

        add(scrollPane, BorderLayout.CENTER);
        add(painelSuperior, BorderLayout.NORTH);

        setVisible(true);
    }
}
