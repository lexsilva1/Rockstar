package GUI;

import backend.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class PainelCarrinhoCompras extends JPanel {
    private Cliente cliente;
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private DefaultTableModel modelotabelapromo;
    private JTable tabelapromo;
    private PainelCliente painelCliente;
    private Promo promo;

    public PainelCarrinhoCompras(FramePrincipal framePrincipal, Cliente cliente, PainelCliente painelCliente) {
        this.cliente = cliente;
        this.painelCliente = painelCliente;
        this.promo=null;

        setLayout(null); // Layout nulo

        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));

        // Criar o modelo da tabela das músicas que foram adicionadas ao carrinho
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Título");
        modeloTabela.addColumn("Artista");
        modeloTabela.addColumn("Género");
        modeloTabela.addColumn("Data Lançamento");
        modeloTabela.addColumn("Rating");
        modeloTabela.addColumn("Preço");


        // Adicionar dados de exemplo à tabela
        for (Musica a : cliente.getCarrinhoCompras()) {
            modeloTabela.addRow(new Object[]{a.getTitulo(), a.getAutor(), a.getGenero(), a.getDataLancamento(), a.getRating(), a.getPreco(), a.getActiva()});
        }


        // Criar a tabela com o modelo
        tabela = new JTable(modeloTabela);
        tabela.setPreferredScrollableViewportSize(new Dimension(400, 100));

        // Adicionar a tabela a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(10, 30, 400, 150); // Definir posição e tamanho manualmente

        // Adicionar o JScrollPane ao painel
        add(scrollPane);

        // mostrar o custo total
        JLabel labelCustoTotal = new JLabel("Custo Total: " + String.valueOf(calcularCustoTotal()) + " €");
        labelCustoTotal.setForeground(Color.WHITE);
        labelCustoTotal.setBounds(10, 190, 200, 25); // Definir posição e tamanho manualmente
        add(labelCustoTotal);

        JLabel labelCarrinho = new JLabel("Carrinho de Compras");
        labelCarrinho.setForeground(Color.WHITE);
        labelCarrinho.setBounds(10, 0, 200, 25); // Definir posição e tamanho manualmente
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
        modelotabelapromo = new DefaultTableModel();
        modelotabelapromo.addColumn("Nome");
        modelotabelapromo.addColumn("Desconto");
        modelotabelapromo.addColumn("Data de início");
        modelotabelapromo.addColumn("Data de fim");
        modelotabelapromo.addColumn("Cupões disponíveis");

        // Adicionar dados de exemplo à tabela
        for (Promo a : framePrincipal.getRockstar().getPromos()) {
            modelotabelapromo.addRow(new Object[]{a.getNome(), a.getDesconto(), a.getDataInicio(), a.getDataFim(), a.getCupoes()});
        }


        // Criar a tabela com o modelo
        tabelapromo = new JTable(modelotabelapromo);
        tabelapromo.setPreferredScrollableViewportSize(new Dimension(400, 100));
        JPopupMenu popupMenu = criarPopupMenuPromo(framePrincipal, cliente);
        tabelapromo.setComponentPopupMenu(popupMenu);


        // Adicionar a tabela a um JScrollPane
        JScrollPane scrollPane1 = new JScrollPane(tabelapromo);
        scrollPane1.setBounds(10, 305, 400, 150); // Definir posição e tamanho manualmente

        // Adicionar o JScrollPane ao painel
        add(scrollPane1);


    }


    private double calcularCustoTotal() {
            double custoTotal = 0.0;
            int rowCount = modeloTabela.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                double preco = (double) modeloTabela.getValueAt(i, 5); // 5 é o índice da coluna de preço
                custoTotal += preco;
            }
            return (custoTotal);
        }


    private double calcularCustoTotalPromo(Promo promo) {
                double custoTotal = 0.0;
                int rowCount = modeloTabela.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    double preco = (double) modeloTabela.getValueAt(i, 5) -((double) modeloTabela.getValueAt(i,5)*(promo.getDesconto()/100)); // 5 é o índice da coluna de preço
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
                painelCliente.botaosaldo().setText(("Saldo: " + String.valueOf(cliente.getSaldo())));
            } else
                cliente.compraPromo(promo);
            limparCarrinhoCompras(cliente, painelCliente);
                painelCliente.botaosaldo().setText(("Saldo: " + String.valueOf(cliente.getSaldo())));
        }
    }

    /*public void comprarMusicasPromo(Cliente cliente, PainelCliente painelCliente,Promo promo) {
        if (cliente.getSaldo() < calcularCustoTotal()) {
            JOptionPane.showMessageDialog(this, "Saldo insuficiente.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            cliente.compraPromo(promo);
            limparCarrinhoCompras(cliente, painelCliente);
            painelCliente.botaosaldo().setText(("Saldo: " + String.valueOf(cliente.getSaldo())));
        }
    }*/

    public JPopupMenu criarPopupMenuPromo(FramePrincipal framePrincipal, Cliente cliente) {
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

