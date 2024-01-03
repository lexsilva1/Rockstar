package GUI;

import backend.Musica;
import backend.Musico;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabelaMusicas extends JPanel {
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

        setLayout(new BorderLayout());
        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));

        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Título");
        modeloTabela.addColumn("Género");
        modeloTabela.addColumn("Data Lançamento");
        modeloTabela.addColumn("Rating");
        modeloTabela.addColumn("Preço");
        modeloTabela.addColumn("Activa");

        for (Musica a : framePrincipal.getRockstar().getMusicas()) {
            if (a.getAutor().equals(musico.getUsername())) {
                String estado;
                if (a.getActiva()) {
                    estado = "Sim";
                } else {
                    estado = "Não";
                }
                modeloTabela.addRow(new Object[]{a.getTitulo(), a.getGenero(), a.getDataLancamento(), a.getRating(), a.getPreco(), estado});
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

        altTitulo.addActionListener(e -> {
            int selectedRow = tabela.getSelectedRow();

            if (selectedRow != -1) {
                String titulo = (String) tabela.getValueAt(selectedRow, 0);

                String input = JOptionPane.showInputDialog(framePrincipal, "Título Atual: " + titulo + "\n Novo Título", "Alterar Título", JOptionPane.QUESTION_MESSAGE);

                if (input != null && !input.isEmpty()) {
                    for (Musica a : framePrincipal.getRockstar().getMusicas()) {
                        if (a.getAutor().equals(musico.getUsername()) && a.getTitulo().equals(titulo)) {
                            musico.actualizaTitulo(a, input);
                            JOptionPane.showMessageDialog(framePrincipal, "Título alterado com sucesso", "Alterar Título", JOptionPane.INFORMATION_MESSAGE);
                            int modelRow = tabela.convertRowIndexToModel(selectedRow);
                            modeloTabela.setValueAt(input, modelRow, 0);
                            tabela.repaint();
                        }
                    }
                }
            }
        });

        altPreco.addActionListener(e -> {
            int selectedRow = tabela.getSelectedRow();

            if (selectedRow != -1) {
                double preco = (double) tabela.getValueAt(selectedRow, 4);
                String titulo = (String) tabela.getValueAt(selectedRow, 0);

                String input = JOptionPane.showInputDialog(framePrincipal, "Preço Atual: " + preco + "\n Novo Preço", "Alterar Preço", JOptionPane.QUESTION_MESSAGE);

                if (input != null && !input.isEmpty()) {
                    for (Musica a : framePrincipal.getRockstar().getMusicas()) {
                        if (a.getAutor().equals(musico.getUsername()) && a.getTitulo().equals(titulo)) {
                            musico.actualizaPreco(a, Double.parseDouble(input));
                            JOptionPane.showMessageDialog(framePrincipal, "Preço alterado com sucesso", "Alterar Preço", JOptionPane.INFORMATION_MESSAGE);
                            int modelRow = tabela.convertRowIndexToModel(selectedRow);
                            modeloTabela.setValueAt(a.getPreco(), modelRow, 4);
                            tabela.repaint();
                        }
                    }
                }
            }
        });

        altEstado.addActionListener(e -> {
            int selectedRow = tabela.getSelectedRow();

            if (selectedRow != -1) {
                String estado;
                String titulo = (String) tabela.getValueAt(selectedRow, 0);

                for (Musica a : framePrincipal.getRockstar().getMusicas()) {
                    if (a.getAutor().equals(musico.getUsername()) && a.getTitulo().equals(titulo)) {
                        if (a.getActiva()) {
                            musico.inactivaMusica(a, false);
                        } else {
                            musico.inactivaMusica(a, true);
                        }
                        JOptionPane.showMessageDialog(framePrincipal, "Estado alterado com sucesso", "Alterar Estado", JOptionPane.INFORMATION_MESSAGE);
                        if (a.getActiva()) {
                            estado = "Sim";
                            int modelRow = tabela.convertRowIndexToModel(selectedRow);
                            modeloTabela.setValueAt(estado, modelRow, 5);
                            tabela.repaint();
                        } else {
                            estado = "Não";
                            int modelRow = tabela.convertRowIndexToModel(selectedRow);
                            modeloTabela.setValueAt(estado, modelRow, 5);
                            tabela.repaint();
                        }

                    }
                }
            }
        });

        addAlbum.addActionListener(e -> {
            int selectedRow = tabela.getSelectedRow();

            if (selectedRow != -1) {
                String estado;
                String titulo = (String) tabela.getValueAt(selectedRow, 0);




            }




        });

        popupMenu.add(altTitulo);
        popupMenu.add(altPreco);
        popupMenu.add(altEstado);
        popupMenu.add(addAlbum);

        return popupMenu;
    }

    public DefaultTableModel getModeloTabela() {
        return modeloTabela;
    }

    /**
     * Redifine as linhas da tabela de acordo com os critérios de pesquisa do <code>Musico</code>.
     * @param pesquisa campo de texto onde o <code>Utilizador</code> escreve a <code>String</code> com o que pretende pesquisar
     * @param chkPesquisaNome <code>JRadioButton</code> de seleção do critério de pesquisa
     * @param chkPesquisagenero <code>JRadioButton</code> de seleção do critério de pesquisa
     */
    public void resultadosPesquisa(JTextField pesquisa, JRadioButton chkPesquisaNome, JRadioButton chkPesquisagenero) {
        for (int i = (modeloTabela.getRowCount() - 1); i >= 0 ; i--) {
            if (chkPesquisaNome.isSelected()) {
                String titulo = (String) modeloTabela.getValueAt(i, 0);
                if (!titulo.equalsIgnoreCase(pesquisa.getText())) {
                    modeloTabela.removeRow(i);
                }
            } else {
                String genero = (String) modeloTabela.getValueAt(i, 1);
                if (!genero.equalsIgnoreCase(pesquisa.getText())) {
                    modeloTabela.removeRow(i);
                }
            }
        }
    }
}