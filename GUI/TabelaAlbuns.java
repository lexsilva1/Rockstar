package GUI;

import backend.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TabelaAlbuns extends TabelaMusicas {
    private JTable tabela;
    private JPanel painelSuperior;
    private JLabel rotuloBarra;
    private DefaultTableModel modeloTabela;
    private JScrollPane scrollPane;
    private PainelOpcoesCliente painelMusico;

    /**
     * Cria um <code>JPanel</code> com uma tabela onde são imprimidos os dados relativos às instâncias
     * de <code>GrupoMusicas</code> do <code>Utilizador</code>
     *
     * @param framePrincipal instância de <code>JFrame</code> que é a frame de toda a aplicação
     * @param musico     instância de <code>Musico</code>, que será quem tem o login efetuado,
     *                   e sobre o qual queremos obter informações
     */
    public TabelaAlbuns(FramePrincipal framePrincipal, Musico musico, PainelOpcoesCliente painelMusico) {
        super(framePrincipal,musico);
        this.painelMusico = painelMusico;


        setLayout(new BorderLayout());
        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));

        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Título");
        modeloTabela.addColumn("Género");
        modeloTabela.addColumn("N.º Faixas");
        modeloTabela.addColumn("Máx Faixas");


        for (Album a : musico.getAlbuns()) {
            int numMusicas = 0;
            for (int i = 0; i < a.getMusicas().size(); i++) {
                numMusicas++;
            }
            modeloTabela.addRow(new Object[]{a.getTitulo(), a.getGenero(), numMusicas, a.getNumFaixas() });
        }

        tabela = new JTable(modeloTabela);


        painelSuperior = new JPanel(new BorderLayout());
        rotuloBarra = new JLabel("Os meus Álbuns");
        rotuloBarra.setHorizontalAlignment(SwingConstants.CENTER);
        painelSuperior.add(rotuloBarra, BorderLayout.CENTER);

        // Adicionar a tabela ao painel superior
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

        JMenuItem verMusicas = new JMenuItem("Ver Músicas");

        verMusicas.addActionListener(e -> {
            int linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada != -1) {
                String nome = (String) tabela.getValueAt(linhaSelecionada, 0);


                DefaultTableModel modeloTabela1 = new DefaultTableModel();
                modeloTabela1.addColumn("Título");
                modeloTabela1.addColumn("Género");
                modeloTabela1.addColumn("Data Lançamento");
                modeloTabela1.addColumn("Rating");
                modeloTabela1.addColumn("Preço");
                modeloTabela1.addColumn("Activa");

                for (GrupoMusicas p : framePrincipal.getRockstar().getGrupoMusicas()){
                    if(p instanceof Album && p.getOwner().equals(musico.getUsername())&& p.getTitulo().equals(nome)){
                        for (Musica m : p.getMusicas()) {
                            modeloTabela1.addRow(new Object[]{m.getTitulo(), m.getGenero(), m.getDataLancamento(), m.calculoRating(), m.getPreco(), m.getActiva()});
                        }
                        revalidate();
                        repaint();
                    }
                }

                // Criar a tabela com o modelo
                JTable tabela1 = new JTable(modeloTabela1);
                JScrollPane scrollPane1 = new JScrollPane(tabela1);
                scrollPane1.setVisible(true);

                JPanel painelSuperior = new JPanel(new BorderLayout());
                JLabel rotuloBarra = new JLabel(nome);
                rotuloBarra.setHorizontalAlignment(SwingConstants.CENTER);
                painelSuperior.add(rotuloBarra, BorderLayout.CENTER);

                // Adicionar a tabela ao painel superior
                painelSuperior.add(tabela1.getTableHeader(), BorderLayout.SOUTH);

                this.removeAll();
                this.add(scrollPane1, BorderLayout.CENTER);
                this.add(painelSuperior, BorderLayout.NORTH);
                revalidate();
            }
        });

        popupMenu.add(verMusicas);
        return popupMenu;
    }

    /**
     * Percorre o <code>ArrayList<<Album>Album</Album>></code> de um <code>Musico</code>,
     * comparando o seu título com o título do <code>Album</code> seleccionado na <code>TabelaAlbuns</code>.
     * Fixa cada linha da tabela, iniciando um contador <code>int</code> a '0', que autoincrementa quando
     * o título da <code>Musica</code> iterada é igual ao título contido na coluna '0' da <code>TabelaMusicas</code>.
     * No final de todas as iterações para cada <code>Musica</code>, se o contador for '0', significa que a <code>Musica</code>
     * da linha atual da tabela não existe no <code>Album</code>, removendo essa linha. Assim, no final, a <code>TabelaMusicas</code>
     * terá apenas as instâncias de <code>Musica</code> que estão no <code>Album</code> selecionado.
     * @param tabelaMusicas tabela a apresentar com todas as <code>Musica</code> que estão adicionadas ao <code>Album</code> selecionado
     *                      na <code>TabelaAlbuns</code>
     * @param musico instância de <code>Musico</code>, que é o utilizador que tem o login efetuado,
     *               e sobre o qual queremos obter informações
     * @param titulo atributo 'titulo', de um <code>Album</code>, que o <code>Utilizador</code> selecionou na <code>TabelaAlbuns</code>
     * @return <code>TabelaMusicas</code>
     */
    public TabelaMusicas musicasAlbum (TabelaMusicas tabelaMusicas, Musico musico, String titulo) {

        for (Album a : musico.getAlbuns()) {
            if (a.getTitulo().equals(titulo)) {
                if (a.getMusicas().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O álbum selecionado não tem músicas adicionadas", "Álbum Vazio", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    for (int i = 0; i < tabelaMusicas.getModeloTabela().getRowCount(); i++) {
                        int contador = 0;
                        for (Musica m : a.getMusicas()) {
                            if (m.getTitulo() == tabelaMusicas.getModeloTabela().getValueAt(i, 0)) {
                                contador++;
                            }
                        }
                        if (contador == 0) {
                            tabelaMusicas.getModeloTabela().removeRow(i);
                        }
                    }
                }
            }
        }
        return tabelaMusicas;
    }
}
