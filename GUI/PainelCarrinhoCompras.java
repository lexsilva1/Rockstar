package GUI;

import backend.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;

public class PainelCarrinhoCompras extends JPanel {
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private DefaultTableModel modelotabelapromo;
    private JTable tabelapromo;
    private Promo promo;

    public PainelCarrinhoCompras(FramePrincipal framePrincipal, Cliente cliente, PainelCliente painelCliente) {
        this.promo=null;

        setLayout(null);

        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));


        modeloTabela = new DefaultTableModel();
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


        for (Musica a : cliente.getCarrinhoCompras()) {
            modeloTabela.addRow(new Object[]{a.getTitulo(), a.getAutor(), a.getGenero(), a.getDataLancamento(), a.getRating(), a.getPreco(), a.getAtiva()});
        }

        tabela = new JTable(modeloTabela);
        tabela.setPreferredScrollableViewportSize(new Dimension(400, 100));
        tabela.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(10, 30, 400, 150); // Definir posição e tamanho manualmente

        add(scrollPane);

        JLabel labelCustoTotal = new JLabel("Custo Total: " + String.format("%1$,.2f€",calcularCustoTotal()) + " €");
        labelCustoTotal.setForeground(Color.WHITE);
        labelCustoTotal.setBounds(10, 190, 200, 25);
        add(labelCustoTotal);

        JLabel labelCarrinho = new JLabel("Carrinho de Compras");
        labelCarrinho.setForeground(Color.WHITE);
        labelCarrinho.setBounds(10, 0, 200, 25);
        add(labelCarrinho);

        JButton btnReset = new JButton("Limpar Carrinho");
        btnReset.setBounds(280, 190, 130, 25);
        btnReset.addActionListener(e -> limparCarrinhoCompras(cliente, painelCliente));
        add(btnReset);

        JLabel lblContinuar = new JLabel("Campanhas");
        lblContinuar.setForeground(Color.WHITE);
        lblContinuar.setBounds(10, 280, 100, 25);
        add(lblContinuar);

        JButton btnFinalizarCompra = new JButton("Finalizar Compra");
        btnFinalizarCompra.setBounds(280, 230, 130, 25);
        btnFinalizarCompra.addActionListener(e -> comprarMusicas(cliente, painelCliente));
        add(btnFinalizarCompra);


        // Criar o modelo da tabela das campanhas
        modelotabelapromo = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false; // Torna todas as células não editáveis
            }
        };

        modelotabelapromo.addColumn("Nome");
        modelotabelapromo.addColumn("Desconto");
        modelotabelapromo.addColumn("Data de início");
        modelotabelapromo.addColumn("Data de fim");
        modelotabelapromo.addColumn("Cupões disponíveis");

        for (Promo a : framePrincipal.getRockstar().getPromos()) {
            if (a.getDataFim().isAfter(LocalDate.now()) && a.getCupoes() > 0) {
                modelotabelapromo.addRow(new Object[]{a.getNome(), a.getDesconto(), a.getDataInicio(), a.getDataFim(), a.getCupoes()});
            }
        }

        tabelapromo = new JTable(modelotabelapromo);
        tabelapromo.setPreferredScrollableViewportSize(new Dimension(400, 100));
        tabelapromo.getTableHeader().setReorderingAllowed(false);
        JPopupMenu popupMenu = criarPopupMenuPromo(framePrincipal, cliente,labelCustoTotal);
        tabelapromo.setComponentPopupMenu(popupMenu);

        JScrollPane scrollPane1 = new JScrollPane(tabelapromo);
        scrollPane1.setBounds(10, 305, 400, 150);

        add(scrollPane1);
    }


    private double calcularCustoTotal() {
            double custoTotal = 0.0;
            int rowCount = modeloTabela.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                double preco = (double) modeloTabela.getValueAt(i, 5);
                custoTotal += preco;
            }
            return (custoTotal);
        }

    private double calcularCustoTotalPromo(Promo promo) {
                double custoTotal = 0.0;
                int rowCount = modeloTabela.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    double preco = (double) modeloTabela.getValueAt(i, 5) -((double) modeloTabela.getValueAt(i,5)*(promo.getDesconto()/100));
                    custoTotal += preco;
                }
                return (custoTotal);
            }

    public void limparCarrinhoCompras(Cliente cliente, PainelCliente painelCliente) {
        cliente.getCarrinhoCompras().removeAll(cliente.getCarrinhoCompras());
        painelCliente.abrirPainelCarrinhoCompras();
    }

    public void comprarMusicas(Cliente cliente, PainelCliente painelCliente) {
        if (cliente.getSaldo() < calcularCustoTotal()) {
            JOptionPane.showMessageDialog(this, "Saldo insuficiente.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            if (this.promo == null) {
                cliente.compra();
                limparCarrinhoCompras(cliente, painelCliente);
                JOptionPane.showMessageDialog(null, "compra efectuada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                painelCliente.botaosaldo().setText(("Saldo: " + String.format("%1$,.2f€",cliente.getSaldo())));
            } else {
                cliente.compraPromo(promo);
                limparCarrinhoCompras(cliente, painelCliente);
                JOptionPane.showMessageDialog(null, "compra efectuada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                painelCliente.botaosaldo().setText(("Saldo: " + String.format("%1$,.2f€",cliente.getSaldo())));
            }
        }
    }

    public JPopupMenu criarPopupMenuPromo(FramePrincipal framePrincipal, Cliente cliente,JLabel labelCustoTotal) {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem adicionarCampanha = new JMenuItem("Adicionar Campanha");
        adicionarCampanha.addActionListener(e -> {
            int linhaSelecionada = tabelapromo.getSelectedRow();

            if (linhaSelecionada != -1) {
                String nomePromo = (String) tabelapromo.getValueAt(linhaSelecionada, 0);

                for (Promo promo : framePrincipal.getRockstar().getPromos()) {
                    if (promo.getNome().equals(nomePromo)) {

                        if (!isAlreadyUsed(promo, cliente)) {
                            this.setPromo(promo);
                            JOptionPane.showMessageDialog(framePrincipal, "Promoção adicionada ao carrinho", "Adicionar ao Carrinho", JOptionPane.INFORMATION_MESSAGE);
                            labelCustoTotal.setText("Custo Total: " + String.format("%1$,.2f€",calcularCustoTotalPromo(promo)));
                            labelCustoTotal.setForeground(Color.WHITE);
                            labelCustoTotal.setBounds(10, 190, 200, 25);
                            add(labelCustoTotal);
                        } else {
                            JOptionPane.showMessageDialog(null, "Promoção já utilizada", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        popupMenu.add(adicionarCampanha);

        return popupMenu;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }

    private boolean isAlreadyUsed(Promo promo, Cliente cliente) {
        return promo.getClientes().contains(cliente.getUsername());
    }

}

