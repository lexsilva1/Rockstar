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


        modeloTabela = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

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
                            modeloTabela1.addRow(new Object[]{m.getTitulo(), m.getGenero(), m.getDataLancamento(), m.calculoRating(), m.getPreco(), m.getAtiva()});
                        }
                        revalidate();
                        repaint();
                    }
                }

                JTable tabela1 = new JTable(modeloTabela1);
                JScrollPane scrollPane1 = new JScrollPane(tabela1);
                scrollPane1.setVisible(true);

                JPanel painelSuperior = new JPanel(new BorderLayout());
                JLabel rotuloBarra = new JLabel(nome);
                rotuloBarra.setHorizontalAlignment(SwingConstants.CENTER);
                painelSuperior.add(rotuloBarra, BorderLayout.CENTER);

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
}
