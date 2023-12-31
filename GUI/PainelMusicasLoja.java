package GUI;

import backend.Cliente;
import backend.Musica;
import backend.Musico;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelMusicasLoja extends JPanel {
    private Cliente cliente;
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
        this.cliente = cliente;

        setLayout(new BorderLayout());
        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));

        // Criar o modelo da tabela
        modeloTabela = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false; // Torna todas as células não editáveis
            }
        };

        modeloTabela.addColumn("Título");
        modeloTabela.addColumn("Artista");
        modeloTabela.addColumn("Género");
        modeloTabela.addColumn("Data Lançamento");
        modeloTabela.addColumn("Rating");
        modeloTabela.addColumn("Preço");

        for (Musica a : framePrincipal.getRockstar().getMusicas()) {
            modeloTabela.addRow(new Object[]{a.getTitulo(), a.getAutor(), a.getGenero(), a.getDataLancamento(), a.getRating(), a.getPreco(), a.getActiva()});
        }

        tabela = new JTable(modeloTabela);
        tabela.setAutoCreateRowSorter(true);
        scrollPane = new JScrollPane(tabela);
        scrollPane.setVisible(true);
        add(scrollPane, BorderLayout.CENTER);

        JPopupMenu popupMenu = criarPopupMenu(framePrincipal, cliente);
        tabela.setComponentPopupMenu(popupMenu);

        setVisible(true);

    }

    private JPopupMenu criarPopupMenu(FramePrincipal framePrincipal, Cliente cliente) {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem adicionarAoCarrinhoItem = new JMenuItem("Adicionar ao Carrinho");
        adicionarAoCarrinhoItem.addActionListener(e -> {
            int linhaSelecionada = tabela.getSelectedRow();

            if (linhaSelecionada != -1) {
                String titulo = (String) tabela.getValueAt(linhaSelecionada, 0);
                String artista = (String) tabela.getValueAt(linhaSelecionada, 1);


                    for (Musica b : cliente.getMusicas()) {
                        if (b.getTitulo().equals(titulo)&& b.getAutor().equals(artista)) {
                            JOptionPane.showMessageDialog(null, "Musica já adquirida", "ERRO", JOptionPane.ERROR_MESSAGE);
                        } else {
                            for( Musica a : cliente.getCarrinhoCompras()) {
                                if (a.getTitulo().equals(titulo) && a.getAutor().equals(artista)) {
                                    JOptionPane.showMessageDialog(null, "Musica já adicionada ao carrinho", "ERRO", JOptionPane.ERROR_MESSAGE);
                                }else{
                                    cliente.getCarrinhoCompras().add(a);
                                JOptionPane.showMessageDialog(framePrincipal, "Música adicionada ao carrinho", "Adicionar ao Carrinho", JOptionPane.INFORMATION_MESSAGE);
                            }



                        }
                    }
                }
            }
        });

        popupMenu.add(adicionarAoCarrinhoItem);

        return popupMenu;
    }
}
