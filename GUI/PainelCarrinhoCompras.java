package GUI;

import backend.Cliente;
import backend.Musica;
import backend.Utilizador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class PainelCarrinhoCompras extends JPanel {
    private Cliente cliente;
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private JLabel labelCustoTotal;
    private PainelCliente painelCliente;
    public PainelCarrinhoCompras(FramePrincipal framePrincipal, Cliente cliente, PainelCliente painelCliente) {
        this.cliente = cliente;
        this.painelCliente=painelCliente;

        setLayout(null); // Layout nulo

        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));

        // Criar o modelo da tabela
        modeloTabela=new DefaultTableModel();
        modeloTabela.addColumn("Título");
        modeloTabela.addColumn("Artista");
        modeloTabela.addColumn("Género");
        modeloTabela.addColumn("Data Lançamento");
        modeloTabela.addColumn("Rating");
        modeloTabela.addColumn("Preço");


        // Adicionar dados de exemplo à tabela
        for (Musica a : cliente.getCarrinhoCompras() ){
               modeloTabela.addRow(new Object[]{a.getTitulo(), a.getAutor(), a.getGenero(), a.getDataLancamento(), a.getRating(), a.getPreco(), a.getActiva()});
        }



        // Criar a tabela com o modelo
        tabela = new JTable(modeloTabela);
        tabela.setPreferredScrollableViewportSize(new Dimension(400, 100));

        // Adicionar a tabela a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(10, 10, 400, 100); // Definir posição e tamanho manualmente

        // Adicionar o JScrollPane ao painel
        add(scrollPane);

        // mostrar o custo total
        labelCustoTotal = new JLabel("Custo Total: " + calcularCustoTotal() + " €");
        labelCustoTotal.setForeground(Color.WHITE);
        labelCustoTotal.setBounds(10, 120, 200, 25); // Definir posição e tamanho manualmente
        add(labelCustoTotal);

        JButton btnReset= new JButton("Limpar Carrinho");
        btnReset.setBounds(290,130,130,25);
        btnReset.addActionListener(e -> limparCarrinhoCompras(cliente,painelCliente));
        add(btnReset);

        JButton btnContinuar = new JButton("Campanhas");
        btnContinuar.setBounds(10,200,100,25);
        add(btnContinuar);

        JButton btnFinalizarCompra= new JButton("Finalizar Compra");
        btnFinalizarCompra.setBounds(290,200,130,25);
        btnFinalizarCompra.addActionListener(e -> comprarMusicas(cliente,painelCliente));
        add(btnFinalizarCompra);

    }


    private String calcularCustoTotal() {
        double custoTotal = 0.0;
        int rowCount = modeloTabela.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            double preco = (double) modeloTabela.getValueAt(i, 5); // 5 é o índice da coluna de preço
            custoTotal += preco;
        }
        // Formatando o custo total para exibir duas casas decimais
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(custoTotal);
    }

    public void limparCarrinhoCompras (Cliente cliente,PainelCliente painelCliente){
        cliente.getCarrinhoCompras().removeAll(cliente.getCarrinhoCompras());
        painelCliente.abrirPainelCarrinhoCompras();
    }

    public void comprarMusicas ( Cliente cliente, PainelCliente painelCliente) {
        cliente.compra();
        limparCarrinhoCompras(cliente,painelCliente);
        painelCliente.botaosaldo().setText(("Saldo: " + String.valueOf(cliente.getSaldo())));

        }
    }

