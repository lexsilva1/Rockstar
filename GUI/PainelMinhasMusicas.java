package GUI;

import backend.Cliente;
import backend.Utilizador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PainelMinhasMusicas extends JPanel {
    private Cliente cliente;
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    public PainelMinhasMusicas(FramePrincipal framePrincipal) {
        this.cliente = cliente;

        setLayout(new BorderLayout());
        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));

        // Criar o modelo da tabela
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Nome da Música");
        modeloTabela.addColumn("Artista");
        modeloTabela.addColumn("Gênero");
        modeloTabela.addColumn("Rating");

        // Adicionar dados de exemplo à tabela
        adicionarMusica("Música 1", "Artista 1", "Pop", 4.5);
        adicionarMusica("Música 2", "Artista 2", "Rock", 3.8);
        adicionarMusica("Música 3", "Artista 3", "Jazz", 5.0);

        // Criar a tabela com o modelo
        tabela = new JTable(modeloTabela);

        // Criar um painel de rolagem para a tabela
        JScrollPane painelRolagem = new JScrollPane(tabela);

        // Adicionar o painel de rolagem ao painel
        add(painelRolagem, BorderLayout.CENTER);
    }

    private void adicionarMusica(String nome, String artista, String genero, double rating) {
        // Adicionar uma nova linha à tabela
        modeloTabela.addRow(new Object[]{nome, artista, genero, rating});
    }
}