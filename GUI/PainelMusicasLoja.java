package GUI;

import backend.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PainelMusicasLoja extends JPanel {
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private JScrollPane scrollPane;

    /**
     * Cria um <code>JPanel</code> com uma tabela onde são imprimidos os dados relativos às músicas do <code>Musico</code>
     *
     * @param framePrincipal instância de <code>JFrame</code> que é a frame de toda a aplicação
     * @param cliente        instância de <code>Musico</code>, que é o utilizador que tem o login efetuado,
     *                       e sobre o qual queremos obter informações
     */
    public PainelMusicasLoja(FramePrincipal framePrincipal, Cliente cliente) {

        setLayout(new BorderLayout());
        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));

        modeloTabela = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modeloTabela.addColumn("Título");
        modeloTabela.addColumn("Artista");
        modeloTabela.addColumn("Género");
        modeloTabela.addColumn("Data Lançamento");
        modeloTabela.addColumn("Rating");
        modeloTabela.addColumn("Preço");

        for (Musica a : framePrincipal.getRockstar().getMusicas()) {
            modeloTabela.addRow(new Object[]{a.getTitulo(), a.getAutor(), a.getGenero(), a.getDataLancamento(), a.calculoRating(), a.getPreco(), a.getAtiva()});
        }

        tabela = new JTable(modeloTabela);
        tabela.setAutoCreateRowSorter(true);
        tabela.getTableHeader().setReorderingAllowed(false);
        scrollPane = new JScrollPane(tabela);
        scrollPane.setVisible(true);

        JPanel painelSuperior = new JPanel(new BorderLayout());
        JLabel rotuloBarra = new JLabel("Loja");
        rotuloBarra.setHorizontalAlignment(SwingConstants.CENTER);
        painelSuperior.add(rotuloBarra, BorderLayout.CENTER);

        painelSuperior.add(tabela.getTableHeader(), BorderLayout.SOUTH);

        add(scrollPane, BorderLayout.CENTER);

        add(painelSuperior, BorderLayout.NORTH);

        JPopupMenu popupMenu = criarPopupMenuCliente(framePrincipal, cliente);
        tabela.setComponentPopupMenu(popupMenu);

        setVisible(true);
    }

    public JPopupMenu criarPopupMenuCliente(FramePrincipal framePrincipal, Cliente cliente) {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem adicionarAoCarrinhoItem = new JMenuItem("Adicionar ao Carrinho");
        adicionarAoCarrinhoItem.addActionListener(e -> {
            int linhaSelecionada = tabela.getSelectedRow();

            if (linhaSelecionada != -1) {
                String titulo = (String) tabela.getValueAt(linhaSelecionada, 0);
                String artista = (String) tabela.getValueAt(linhaSelecionada, 1);


                for (Musica c : framePrincipal.getRockstar().getMusicas()) {
                    if (c.getTitulo().equals(titulo) && c.getAutor().equals(artista)) {
                        boolean alreadyPurchased = isAlreadyPurchased(c, cliente);
                        boolean alreadyInCart = !alreadyPurchased && isAlreadyInCart(c, cliente);

                        if (!alreadyPurchased) {
                            if (!alreadyInCart) {
                                cliente.getCarrinhoCompras().add(c);
                                JOptionPane.showMessageDialog(framePrincipal, "Música adicionada ao carrinho", "Adicionar ao Carrinho", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Musica já adicionada ao carrinho", "ERRO", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Musica já adquirida", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        JMenuItem verHistoricoPreco = new JMenuItem("Histórico de preços");

        verHistoricoPreco.addActionListener(e -> {
            int linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada != -1) {
                String nome = (String) tabela.getValueAt(linhaSelecionada, 0);


                DefaultTableModel modeloTabela1 = new DefaultTableModel();
                modeloTabela1.addColumn("Data");
                modeloTabela1.addColumn("Preço");


                for (Musica p : framePrincipal.getRockstar().getMusicas()){
                    if(p.getTitulo().equals(nome)){
                        for (Preco m : p.getHistoricoPreco()) {
                            modeloTabela1.addRow(new Object[]{m.getData(), m.getPreco() + " €"});
                        }
                        revalidate();
                        repaint();
                    }
                }

                JTable tabela1 = new JTable(modeloTabela1);
                JScrollPane scrollPane1 = new JScrollPane(tabela1);
                scrollPane1.setVisible(true);

                this.removeAll();

                JPanel painelSuperior = new JPanel(new BorderLayout());
                JLabel rotuloBarra = new JLabel(nome);
                rotuloBarra.setHorizontalAlignment(SwingConstants.CENTER);
                painelSuperior.add(rotuloBarra, BorderLayout.CENTER);

                painelSuperior.add(tabela1.getTableHeader(), BorderLayout.SOUTH);

                this.add(scrollPane1, BorderLayout.CENTER);
                this.add(painelSuperior, BorderLayout.NORTH);

                revalidate();
            }
        });

        popupMenu.add(adicionarAoCarrinhoItem);
        popupMenu.add(verHistoricoPreco);

        return popupMenu;
    }


    private boolean isAlreadyPurchased(Musica music, Cliente cliente) {
            return cliente.getMusicas().stream().anyMatch(m -> m.equals(music));
        }

        private boolean isAlreadyInCart(Musica music, Cliente cliente) {
            return cliente.getCarrinhoCompras().stream().anyMatch(m -> m.equals(music));
        }
    public void resultadosPesquisa(JTextField pesquisa, JRadioButton chkPesquisaNome) {
        for (int i = (modeloTabela.getRowCount() - 1); i >= 0 ; i--) {
            if (chkPesquisaNome.isSelected()) {
                String titulo = (String) modeloTabela.getValueAt(i, 0);
                titulo = titulo.toLowerCase();
                if (!titulo.contains(pesquisa.getText())) {
                    modeloTabela.removeRow(i);
                }
            } else {
                String genero = (String) modeloTabela.getValueAt(i, 2);
                genero = genero.toLowerCase();
                if (!genero.contains(pesquisa.getText())) {
                    modeloTabela.removeRow(i);
                }
            }
        }
    }
}
