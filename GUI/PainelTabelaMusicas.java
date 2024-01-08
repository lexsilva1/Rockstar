package GUI;

import backend.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class PainelTabelaMusicas extends JPanel {
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
    public PainelTabelaMusicas(FramePrincipal framePrincipal, Musico musico) {

        setLayout(new BorderLayout());
        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));


        modeloTabela = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modeloTabela.addColumn("Título");
        modeloTabela.addColumn("Género");
        modeloTabela.addColumn("Data Lançamento");
        modeloTabela.addColumn("Rating");
        modeloTabela.addColumn("Preço");
        modeloTabela.addColumn("Activa");

        for (Musica a : framePrincipal.getRockstar().getMusicas()) {
            if (a.getAutor().equals(musico.getUsername())) {
                String estado;
                if (a.getAtiva()) {
                    estado = "Sim";
                } else {
                    estado = "Não";
                }
                modeloTabela.addRow(new Object[]{a.getTitulo(), a.getGenero(), a.getDataLancamento(), a.getRating(), a.getPreco(), estado});
            }
        }

        tabela = new JTable(modeloTabela);
        tabela.setAutoCreateRowSorter(true);
        tabela.getTableHeader().setReorderingAllowed(false);

        JPanel painelSuperior = new JPanel(new BorderLayout());
        JLabel rotuloBarra = new JLabel("As minhas Músicas");
        rotuloBarra.setHorizontalAlignment(SwingConstants.CENTER);
        painelSuperior.add(rotuloBarra, BorderLayout.CENTER);

        painelSuperior.add(tabela.getTableHeader(), BorderLayout.SOUTH);

        JPopupMenu popupMenu = criarPopupMenu(framePrincipal, musico);
        tabela.setComponentPopupMenu(popupMenu);

        scrollPane = new JScrollPane(tabela);
        scrollPane.setVisible(true);
        add(scrollPane, BorderLayout.CENTER);
        add(painelSuperior, BorderLayout.NORTH);
        setVisible(false);
    }

    private JPopupMenu criarPopupMenu(FramePrincipal framePrincipal, Musico musico) {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem altTitulo = new JMenuItem("Alterar Título");
        JMenuItem altPreco = new JMenuItem("Alterar Preço");
        JMenuItem altEstado = new JMenuItem("Alterar Estado");
        JMenuItem addAlbum = new JMenuItem("Adicionar a Álbum");
        /**
         * Permite a alteração do título de uma <code>Musica</code>
         */
        altTitulo.addActionListener(e -> {
            int selectedRow = tabela.getSelectedRow();

            if (selectedRow != -1) {
                String titulo = (String) tabela.getValueAt(selectedRow, 0);

                String input = JOptionPane.showInputDialog(framePrincipal, "Título Atual: " + titulo + "\n Novo Título", "Alterar Título", JOptionPane.QUESTION_MESSAGE);

                if (input != null && !input.isEmpty()) {
                    for (Musica a : framePrincipal.getRockstar().getMusicas()) {
                        if (a.getAutor().equals(musico.getUsername()) && a.getTitulo().equals(titulo)) {
                            musico.atualizaTitulo(a, input);
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

                String input;

                input = JOptionPane.showInputDialog(framePrincipal, "Preço Atual: " + preco + "\n Novo Preço (Formato: €.€€)", "Alterar Preço", JOptionPane.QUESTION_MESSAGE);
                if (input != null) {
                    do {
                        input = JOptionPane.showInputDialog(framePrincipal, "Preço Atual: " + preco + "\n Novo Preço (Formato: €.€€)", "Alterar Preço", JOptionPane.QUESTION_MESSAGE);
                    } while (input != null && !input.matches("\\d+(\\.\\d{1,2})?"));

                    if (input != null && !input.isEmpty()) {
                        for (Musica a : framePrincipal.getRockstar().getMusicas()) {
                            if (a.getAutor().equals(musico.getUsername()) && a.getTitulo().equals(titulo)) {
                                musico.atualizaPreco(a, Double.parseDouble(input));
                                JOptionPane.showMessageDialog(framePrincipal, "Preço alterado com sucesso", "Alterar Preço", JOptionPane.INFORMATION_MESSAGE);
                                int modelRow = tabela.convertRowIndexToModel(selectedRow);
                                modeloTabela.setValueAt(a.getPreco(), modelRow, 4);
                                tabela.repaint();
                            }
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
                        if (a.getAtiva()) {
                            musico.inativaMusica(a, false);
                        } else {
                            musico.inativaMusica(a, true);
                        }
                        JOptionPane.showMessageDialog(framePrincipal, "Estado alterado com sucesso", "Alterar Estado", JOptionPane.INFORMATION_MESSAGE);
                        if (a.getAtiva()) {
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
            String titulo = (String) tabela.getValueAt(selectedRow, 0);

            JDialog addToAlbum = new JDialog(framePrincipal, "Adicionar a Album", true);
            addToAlbum.setSize(400, 150);
            addToAlbum.setLayout(new BorderLayout());
            addToAlbum.setResizable(false);

            JPanel painelCentro = new JPanel(null);

            JLabel nomeAlbum = new JLabel();
            nomeAlbum.setText("Escolha o Álbum");
            nomeAlbum.setBounds(40, 20, 150, 25);


            JComboBox escolhaAlbum = new JComboBox<>(verAlbuns(framePrincipal,musico));
            escolhaAlbum.setBounds(nomeAlbum.getX() + 160, nomeAlbum.getY(), 150, 25);

            painelCentro.add(escolhaAlbum);
            painelCentro.add(nomeAlbum);

            JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.CENTER));

            JButton okButton = new JButton();
            okButton.setText("Ok");
            okButton.setFocusable(false);

            okButton.addActionListener(e1 -> {
                GrupoMusicas albuns = (Album) escolhaAlbum.getSelectedItem();
                for( Musica g : musico.getMusicas()) {
                    if (g.getTitulo().equals(titulo) && albuns != null) {
                        if (estaAdicionada(g,albuns)) {
                            JOptionPane.showMessageDialog(null, "A música já foi adicionada ao Álbum", "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                            addToAlbum.setVisible(false);
                            revalidate();
                            repaint();
                        } else {
                            albuns.addMusica(g);
                            JOptionPane.showMessageDialog(null, "Musica adicionada com sucesso",
                                    "Musica Adicionada", JOptionPane.INFORMATION_MESSAGE);
                            addToAlbum.setVisible(false);
                            revalidate();
                            repaint();
                        }

                    }
                }
            });
            JButton cancelButton = new JButton();
            cancelButton.setText("Cancelar");
            cancelButton.setFocusable(false);
            cancelButton.addActionListener(e12 -> {
                addToAlbum.dispose();
            });

            painelSul.add(okButton);
            painelSul.add(cancelButton);

            addToAlbum.add(painelCentro, BorderLayout.CENTER);
            addToAlbum.add(painelSul, BorderLayout.SOUTH);

            addToAlbum.setLocationRelativeTo(framePrincipal);
            addToAlbum.setVisible(true);
        });

        popupMenu.add(altTitulo);
        popupMenu.add(altPreco);
        popupMenu.add(altEstado);
        popupMenu.add(addAlbum);

        return popupMenu;
    }

    public GrupoMusicas[] verAlbuns(FramePrincipal framePrincipal, Musico musico) {
        ArrayList<GrupoMusicas> albuns = new ArrayList<>();
        for (GrupoMusicas g : framePrincipal.getRockstar().getGrupoMusicas()) {
            if (g.getOwner().equals(musico.getUsername())) {
                albuns.add(g);
            }
        }
        GrupoMusicas [] meusAlbuns = new Album [albuns.size()];
        int i=0;
        for (GrupoMusicas g : albuns){
            meusAlbuns[i]=g;
            i++;
        }
        return meusAlbuns;
    }

    private boolean estaAdicionada(Musica music, GrupoMusicas albuns) {
        return albuns.getMusicas().stream().anyMatch(m -> m.equals(music));
    }

    /**
     * Redifine as linhas da tabela de acordo com os critérios de pesquisa do <code>Musico</code>.
     * @param pesquisa campo de texto onde o <code>Utilizador</code> escreve a <code>String</code> com o que pretende pesquisar
     * @param chkPesquisaNome <code>JRadioButton</code> de seleção do critério de pesquisa
     */
    public void resultadosPesquisa(JTextField pesquisa, JRadioButton chkPesquisaNome) {
        for (int i = (modeloTabela.getRowCount() - 1); i >= 0 ; i--) {
            if (chkPesquisaNome.isSelected()) {
                String titulo = (String) modeloTabela.getValueAt(i, 0);
                titulo = titulo.toLowerCase();
                if (!titulo.contains(pesquisa.getText())) {
                    modeloTabela.removeRow(i);
                }
            } else {
                String genero = (String) modeloTabela.getValueAt(i, 1);
                genero = genero.toLowerCase();
                if (!genero.contains(pesquisa.getText())) {
                    modeloTabela.removeRow(i);
                }
            }
        }
    }
}