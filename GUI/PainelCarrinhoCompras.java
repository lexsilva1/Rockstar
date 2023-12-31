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
    private ArrayList<Musica> musicas;
    public PainelCarrinhoCompras(FramePrincipal framePrincipal) {
        this.cliente = cliente;
        this.musicas=new ArrayList<>();
        setLayout(null); // Layout nulo

        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));

        // Criar o modelo da tabela
        modeloTabela=new DefaultTableModel();
        modeloTabela.addColumn("Título");
        modeloTabela.addColumn("Artista");
        modeloTabela.addColumn("Género");
       // modeloTabela.addColumn("Data Lançamento");
        modeloTabela.addColumn("Rating");
        modeloTabela.addColumn("Preço");
       // modeloTabela.addColumn("Ações");


        // Adicionar dados de exemplo à tabela
       // for (Musica a : this.musicas ){
              // modeloTabela.addRow(new Object[]{a.getTitulo(), a.getAutor(), a.getGenero(), a.getDataLancamento(), a.getRating(), a.getPreco(), a.getActiva()});
          // }

        adicionarMusica("Música 1", "Artista 1", "Pop", 4.5, 2.99);
        adicionarMusica("Música 2", "Artista 2", "Rock", 3.8, 1.99);
        adicionarMusica("Música 3", "Artista 3", "Jazz", 5.0, 3.49);

        // Criar a tabela com o modelo
        tabela = new JTable(modeloTabela);
        tabela.setPreferredScrollableViewportSize(new Dimension(400, 100));

        // Adicionar a tabela a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(10, 10, 400, 100); // Definir posição e tamanho manualmente

        // Adicionar o JScrollPane ao painel
        add(scrollPane);

        // mostrar o custo total
        labelCustoTotal = new JLabel("Custo Total: " + calcularCustoTotal());
        labelCustoTotal.setForeground(Color.WHITE);
        labelCustoTotal.setBounds(10, 120, 200, 25); // Definir posição e tamanho manualmente
        add(labelCustoTotal);

        JButton btnContinuar = new JButton("Campanhas");
        btnContinuar.setBounds(10,200,100,25);
        add(btnContinuar);

        JButton btnFinalizarCompra= new JButton("Finalizar Compra");
        btnFinalizarCompra.setBounds(290,200,130,25);
        add(btnFinalizarCompra);
    }

    private void adicionarMusica(String nome, String artista, String genero, double rating, double preco) {
        // Adicionar uma nova linha à tabela
        modeloTabela.addRow(new Object[]{nome, artista, genero, rating, preco});
    }

    private String calcularCustoTotal() {
        double custoTotal = 0.0;
        int rowCount = modeloTabela.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            double preco = (double) modeloTabela.getValueAt(i, 4); // 4 é o índice da coluna de preço
            custoTotal += preco;
        }

        // Formatando o custo total para exibir duas casas decimais
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(custoTotal);
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }
}