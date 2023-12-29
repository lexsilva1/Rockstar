package GUI;

import backend.Musica;
import backend.Musico;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabelaMusicas extends JPanel {
    private Musico musico;
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private JScrollPane scrollPane;

    /**
     * Cria um <code>JPanel</code> com uma tabela onde são imprimidos os dados relativos às músicas do <code>Musico</code>
     *
     * @param framePrincipal instância de <code>JFrame</code> que é a frame de toda a aplicação
     * @param musico         instância de <code>Musico</code>, que é o utilizador que tem o login efetuado,
     *                       e sobre o qual queremos obter informações
     */
    public TabelaMusicas(FramePrincipal framePrincipal, Musico musico) {
        this.musico = musico;

        setLayout(new BorderLayout());
        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));

        // Criar o modelo da tabela
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Título");
        modeloTabela.addColumn("Género");
        modeloTabela.addColumn("Data Lançamento");
        modeloTabela.addColumn("Rating");
        modeloTabela.addColumn("Preço");
        modeloTabela.addColumn("Activa");
        modeloTabela.addColumn("Ações");

        for (Musica a : framePrincipal.getRockstar().getMusicas()) {
            if (a.getAutor().equals(musico.getUsername())) {
                modeloTabela.addRow(new Object[]{a.getTitulo(), a.getGenero(), a.getDataLancamento(), a.getRating(), a.getPreco(), a.getActiva()});
            }
        }

        tabela = new JTable(modeloTabela);

        scrollPane = new JScrollPane(tabela);
        scrollPane.setVisible(true);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(false);
    }

}
