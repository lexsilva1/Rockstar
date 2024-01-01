package GUI;

import backend.Cliente;
import backend.Musica;
import backend.Utilizador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PainelMinhasMusicas extends JPanel {
    private Cliente cliente;
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    public PainelMinhasMusicas(FramePrincipal framePrincipal, Cliente cliente) {
        this.cliente = cliente;

        setLayout(new BorderLayout());
        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));

        // Criar o modelo da tabela
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Título");
        modeloTabela.addColumn("Artista");
        modeloTabela.addColumn("Género");
        modeloTabela.addColumn("Data Lançamento");
        modeloTabela.addColumn("Rating");
        modeloTabela.addColumn("Preço");
        adicionarMusica(cliente);

        // Criar a tabela com o modelo
        tabela = new JTable(modeloTabela);

        // Criar um painel de rolagem para a tabela
        JScrollPane painelRolagem = new JScrollPane(tabela);

        // Adicionar o painel de rolagem ao painel
        add(painelRolagem, BorderLayout.CENTER);
    }

    public void adicionarMusica(Cliente cliente) {
        for (Musica a : cliente.getMusicas()) {
            modeloTabela.addRow(new Object[]{a.getTitulo(), a.getAutor(), a.getGenero(), a.getDataLancamento(), a.getRating(), a.getPreco()});
            revalidate();
            repaint();
        }
    }

}