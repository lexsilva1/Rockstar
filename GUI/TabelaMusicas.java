package GUI;

import backend.Musica;
import backend.Musico;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

        for (Musica a : framePrincipal.getRockstar().getMusicas()) {
            if (a.getAutor().equals(musico.getUsername())) {
                modeloTabela.addRow(new Object[]{a.getTitulo(), a.getGenero(), a.getDataLancamento(), a.getRating(), a.getPreco(), a.getActiva()});
            }
        }

        tabela = new JTable(modeloTabela);

        JPopupMenu popupMenu = criarPopupMenu(framePrincipal, musico);
        tabela.setComponentPopupMenu(popupMenu);

        scrollPane = new JScrollPane(tabela);
        scrollPane.setVisible(true);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(false);
    }

    private JPopupMenu criarPopupMenu(FramePrincipal framePrincipal, Musico musico) {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem altTitulo = new JMenuItem("Alterar Título");
        JMenuItem altPreco = new JMenuItem("Alterar Preço");
        JMenuItem altEstado = new JMenuItem("Alterar Estado");
        JMenuItem addAlbum = new JMenuItem("Adicionar a Álbum");

        altTitulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tabela.getSelectedRow();

                if (selectedRow != -1) {
                    String titulo = (String) tabela.getValueAt(selectedRow, 0);

                    String input = JOptionPane.showInputDialog(framePrincipal, "Título Atual: " + titulo + "\n Novo Título", "Alterar Título", JOptionPane.QUESTION_MESSAGE);

                    if (input != null && !input.isEmpty()) {
                        for (Musica a : framePrincipal.getRockstar().getMusicas()) {
                            if (a.getAutor().equals(musico.getUsername()) && a.getTitulo().equals(titulo)) {
                                musico.actualizaTitulo(a,input);
                                JOptionPane.showMessageDialog(framePrincipal, "Título alterado com sucesso", "Alterar Título", JOptionPane.INFORMATION_MESSAGE);
                                int modelRow = tabela.convertRowIndexToModel(selectedRow);
                                modeloTabela.setValueAt(input, modelRow, 0);
                                tabela.repaint();
                            }
                        }
                    }
                }
            }
        });

        altPreco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tabela.getSelectedRow();

                if (selectedRow != -1) {
                    String preco = (String) tabela.getValueAt(selectedRow, 4);

                    String input = JOptionPane.showInputDialog(framePrincipal, "Preço Atual: " + preco + "\n Novo Preço", "Alterar Preço", JOptionPane.QUESTION_MESSAGE);

                    if (input != null && !input.isEmpty()) {
                        for (Musica a : framePrincipal.getRockstar().getMusicas()) {
                            if (a.getAutor().equals(musico.getUsername()) && a.getTitulo().equals(preco)) {
                                musico.actualizaPreco(a, Double.parseDouble(input));
                                JOptionPane.showMessageDialog(framePrincipal, "Preço alterado com sucesso", "Alterar Preço", JOptionPane.INFORMATION_MESSAGE);
                                int modelRow = tabela.convertRowIndexToModel(selectedRow);
                                modeloTabela.setValueAt(input, modelRow, 0);
                                tabela.repaint();
                            }
                        }
                    }
                }
            }
        });

        popupMenu.add(altTitulo);
        popupMenu.add(altPreco);
        popupMenu.add(altEstado);
        popupMenu.add(addAlbum);

        return popupMenu;
    }

}
