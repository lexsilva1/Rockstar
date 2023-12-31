package GUI;

import backend.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Map;

public class PainelAdmin extends JPanel {
    private JButton btnVerCampanhas;
    private JButton btnCriarCampanha;
    private JButton btnCriarAdministrador;
    private JLabel labelUsername;
    private JLabel lblPesquisar;
    private JTextField txtPesquisar;
    private JButton btnLogout;
    private BotaoLupa btnLupa;
    private  JButton btnlimpaPesquisa;

    private PainelOpcoes painelOpcoes;
    private PainelCriarAdmin painelCriarAdmin;
    private PainelCriarCampanha painelCriarCampanha;




    /**
     * Cria um novo painel <code>JPanel</code> 'PainelAdmin', para a página inicial de um utlizador do tipo 'Administrador',
     * com um buffer duplo e um flow layout.
     */
    public PainelAdmin(FramePrincipal framePrincipal, Admin admin) {
        this.btnVerCampanhas = new JButton("Ver Campanhas");
        this.btnCriarCampanha = new JButton("Criar Campanha");
        this.btnCriarAdministrador = new JButton("Criar Administrador");
        this.labelUsername = new JLabel("Bem-vindo: " + admin.getUsername());
        this.lblPesquisar = new JLabel("Pesquisar");
        this.txtPesquisar = new JTextField();
        this.btnLupa = new BotaoLupa("/resources/lupa.png");
        this.btnLogout = new JButton("Logout \u21AA");
        this.btnLogout.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 10));
        this.painelOpcoes = new PainelOpcoes(admin);
        this.painelCriarAdmin = new PainelCriarAdmin(framePrincipal);
        this.painelCriarCampanha = new PainelCriarCampanha(framePrincipal, admin);
        this.btnlimpaPesquisa = new JButton("Limpar");

        setBackground(new Color(70, 90, 120));
        setLayout(null);

        btnVerCampanhas.setBounds(20,150,200,25);
        btnCriarCampanha.setBounds(20,200,200,25);
        btnCriarCampanha.addActionListener(e -> abrirPainelCriarCampanha());
        btnCriarAdministrador.setBounds(20,250,200,25);
        btnCriarAdministrador.addActionListener(e -> abrirPainelCriarAdmin());
        btnLogout.setBounds(700, 10, 80, 30);
        btnLogout.addActionListener(e -> voltarPainelPrincipal());
        labelUsername.setBounds(20,5,200,25);
        labelUsername.setForeground(Color.WHITE);
        painelOpcoes.setBounds(275,100,450,500);

        lblPesquisar.setBounds(300  , 5, 100, 25);
        lblPesquisar.setForeground(Color.WHITE);
        lblPesquisar.setVisible(true);
        add(lblPesquisar);

        txtPesquisar.setBounds(370, 5, 200, 25);
        txtPesquisar.setVisible(true);
        add(txtPesquisar);

        btnlimpaPesquisa.setBounds(640,605,85,25);
        btnlimpaPesquisa.setVisible(false);


        btnLupa.setBounds(580,5,20,20);

        JRadioButton chkPesquisaMusica = new JRadioButton("Música");
        chkPesquisaMusica.setBounds(370, 30, 100, 25);
        chkPesquisaMusica.setBackground(new Color(70, 90, 120));
        chkPesquisaMusica.setForeground(Color.WHITE);
        add(chkPesquisaMusica);

        JRadioButton chkPesquisaUtilizador = new JRadioButton("Utilizador");
        chkPesquisaUtilizador.setBounds(490, 30, 100, 25);
        chkPesquisaUtilizador.setBackground(new Color(70, 90, 120));
        chkPesquisaUtilizador.setForeground(Color.WHITE);
        add(chkPesquisaUtilizador);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(chkPesquisaMusica);
        grupo.add(chkPesquisaUtilizador);
        /**
         * Este listener gera uma de duas JTable consoante a escolha de pesquisa do utilizador (Utilizadores ou Musicas)
         */
        btnLupa.addActionListener((ActionEvent e) ->{
            painelOpcoes.removeAll();
            btnlimpaPesquisa.setVisible(true);

            if (txtPesquisar.getText().isEmpty() || grupo.getSelection() == null ) {
                JOptionPane.showMessageDialog(null, "Por favor escreva algo e selecione o parâmetro para pesquisar", "Campo vazio", JOptionPane.ERROR_MESSAGE);
            } else if( chkPesquisaMusica.isSelected()) {
                JPanel painel =new JPanel();
                painel.setLayout(new BorderLayout());
                painel.setBackground(new Color(70, 90, 120));
                painel.setPreferredSize(new Dimension(450, 500));
                DefaultTableModel modeloTabela = new DefaultTableModel();
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


                for (Musica a : framePrincipal.getRockstar().getMusicas() ){
                    if(a.getTitulo().toLowerCase().contains(txtPesquisar.getText().toLowerCase())){
                        modeloTabela.addRow(new Object[]{a.getTitulo(), a.getAutor(), a.getGenero(), a.getDataLancamento(), a.getRating(), a.getPreco()});
                    }
                }

                JTable tabela = new JTable(modeloTabela);
                tabela.setAutoCreateRowSorter(true);
                JScrollPane scrollPane = new JScrollPane(tabela);
                scrollPane.setVisible(true);
                painel.add(scrollPane, BorderLayout.CENTER);
                painel.setVisible(true);
                abrirPainelPesquisa(painel);
                JPopupMenu popupMenu = criarPopupMenuMusica(framePrincipal,tabela,modeloTabela);
                tabela.setComponentPopupMenu(popupMenu);

            } else if (chkPesquisaUtilizador.isSelected()) {
                JPanel painel =new JPanel();
                painel.setLayout(new BorderLayout());
                painel.setBackground(new Color(70, 90, 120));
                painel.setPreferredSize(new Dimension(450, 500));
                DefaultTableModel modeloTabela = new DefaultTableModel();

                modeloTabela = new DefaultTableModel() {
                    public boolean isCellEditable(int row, int column) {
                        return false; // Torna todas as células não editáveis
                    }
                };

                modeloTabela.addColumn("Username");
                modeloTabela.addColumn("Tipo de Utilizador");
                modeloTabela.addColumn("Ativo");
                modeloTabela.addColumn("Password");

                for (Utilizador a : framePrincipal.getRockstar().getUtilizadores()){
                    if (a.getUsername().toLowerCase().contains(txtPesquisar.getText().toLowerCase())){
                        String estado;
                        if (a.isActivo()) {
                            estado = "Ativo";
                        } else {
                            estado = "Inativo";
                        }
                        modeloTabela.addRow(new Object[]{a.getUsername(), a.getClass().getSimpleName(), estado,a.getPassword()});
                    }
                }

                JTable tabela = new JTable(modeloTabela);
                tabela.setAutoCreateRowSorter(true);
                tabela.getTableHeader().setReorderingAllowed(false);
                JScrollPane scrollPane = new JScrollPane(tabela);
                scrollPane.setVisible(true);
                painel.add(scrollPane, BorderLayout.CENTER);
                painel.setVisible(true);
                abrirPainelPesquisa(painel);
                JPopupMenu popupMenu = criarPopupMenuUtilizador(framePrincipal,tabela, modeloTabela);
                tabela.setComponentPopupMenu(popupMenu);
            }
        });

        btnVerCampanhas.addActionListener(e -> {
            JPanel painel =new JPanel();
            painel.setLayout(new BorderLayout());
            painel.setBackground(new Color(70, 90, 120));
            painel.setPreferredSize(new Dimension(450, 500));

            DefaultTableModel modeloTabela = new DefaultTableModel();

            modeloTabela = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false; // Torna todas as células não editáveis
                }
            };
            modeloTabela.addColumn("Nome");
            modeloTabela.addColumn("Desconto");
            modeloTabela.addColumn("Data Inicio");
            modeloTabela.addColumn("Data Fim");
            modeloTabela.addColumn("Cupoes");
            for (Promo a : framePrincipal.getRockstar().getPromos()){
                    modeloTabela.addRow(new Object[]{a.getNome(), a.getDesconto(),a.getDataInicio(), a.getDataFim(),a.getCupoes()});
                }

            JTable tabela = new JTable(modeloTabela);
            tabela.setAutoCreateRowSorter(true);
            tabela.getTableHeader().setReorderingAllowed(false);
            JScrollPane scrollPane = new JScrollPane(tabela);
            scrollPane.setVisible(true);

            JPanel painelSuperior = new JPanel(new BorderLayout());
            JLabel rotuloBarra = new JLabel("Campanhas");
            rotuloBarra.setHorizontalAlignment(SwingConstants.CENTER);
            painelSuperior.add(rotuloBarra, BorderLayout.CENTER);
            painelSuperior.add(tabela.getTableHeader(), BorderLayout.SOUTH);

            painel.add(scrollPane, BorderLayout.CENTER);
            painel.add(painelSuperior, BorderLayout.NORTH);
            painel.setVisible(true);
            abrirPainelPesquisa(painel);
        });

        txtPesquisar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnLupa.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        btnlimpaPesquisa.addActionListener((ActionEvent e) -> {
            painelOpcoes.removeAll();
            btnlimpaPesquisa.setVisible(false);
            revalidate();
            repaint();
        });

        add(labelUsername);
        add(btnVerCampanhas);
        add(btnCriarCampanha);
        add(btnCriarAdministrador);
        add(btnLupa);
        add(btnLogout);
        add(painelOpcoes);
        add(btnlimpaPesquisa);
        setVisible(true);

    }

    private void abrirPainelPesquisa(JPanel painel) {
        painelOpcoes.removeAll();
        painelOpcoes.add(painel);
        painelOpcoes.revalidate();
        painelOpcoes.repaint();
    }

    private void abrirPainelCriarCampanha() {
        painelOpcoes.removeAll();
        painelOpcoes.add(painelCriarCampanha);
        btnlimpaPesquisa.setVisible(false);
        painelOpcoes.revalidate();
        painelOpcoes.repaint();
    }

    private void abrirPainelCriarAdmin() {
        painelOpcoes.removeAll();
        painelOpcoes.add(painelCriarAdmin);
        btnlimpaPesquisa.setVisible(false);
        painelCriarAdmin.setVisible(true);
        painelOpcoes.revalidate();
        painelOpcoes.repaint();
    }

    /**
     * Neste método o <code>Admin<code> remove todas as instâncias do objecto <code>Musica</code> que seleciona. No caso dos clientes, são reembolsados
     * do valor que pagaram pela música na altura da aquisição, e não pelo preço da musica que vigorava na altura da sua remoção.
     * @param framePrincipal
     * @param tabela
     * @param modeloTabela
     * @return
     */
    public JPopupMenu criarPopupMenuMusica(FramePrincipal framePrincipal, JTable tabela, DefaultTableModel modeloTabela) {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem removerMusica = new JMenuItem("Remover Musica");
        removerMusica.addActionListener(e -> {
            int linhaSelecionada = tabela.getSelectedRow();

            if (linhaSelecionada != -1) {
                String titulo = (String) tabela.getValueAt(linhaSelecionada, 0);
                String artista = (String) tabela.getValueAt(linhaSelecionada, 1);

                Iterator<Musica> iterator = framePrincipal.getRockstar().getMusicas().iterator();
                while (iterator.hasNext()) {
                    Musica c = iterator.next();
                    if (c.getTitulo().equals(titulo) && c.getAutor().equals(artista)) {
                        iterator.remove(); // Use the iterator's remove method
                    }
                }

                for (Utilizador a : framePrincipal.getRockstar().getUtilizadores()){
                    if( a instanceof Cliente){
                        Iterator<Musica> iteratorcliente = ((Cliente) a).getMusicas().iterator();
                        while (iteratorcliente.hasNext()) {
                            Musica m = iteratorcliente.next();
                            if (m.getTitulo().equals(titulo) && m.getAutor().equals(artista)) {
                                double totalValueToRefund = 0.0;
                                // Calculate the total value of the removed song from the purchase
                                for (Compra k : ((Cliente) a).getHistoricoCompras()) {
                                    for (Map.Entry<Musica, Double> entry : k.getMusicas().entrySet()) {
                                        if (entry.getKey().equals(m)) {
                                            totalValueToRefund = entry.getValue();


                                        }
                                    }
                                }

                                // Remove the song from the user's music list
                                iteratorcliente.remove();

                                // Add the refunded value back to the user's balance
                                ((Cliente) a).carregaSaldo(totalValueToRefund);
                            }
                        }
                        for(GrupoMusicas g : framePrincipal.getRockstar().getGrupoMusicas())
                            if ( g.getOwner().equals(a.getUsername())) {
                                iteratorcliente = g.getMusicas().iterator();
                                while(iteratorcliente.hasNext()){
                                    Musica m = iteratorcliente.next();
                                    if (m.getTitulo().equals(titulo) && m.getAutor().equals(artista)) {
                                        iteratorcliente.remove();
                                    }
                                }
                            }

                    }else if (a instanceof Musico){
                        Iterator<Musica> iteratormusico = ((Musico) a).getMusicas().iterator();
                        while (iteratormusico.hasNext()){
                            Musica m = iteratormusico.next();
                            if (m.getTitulo().equals(titulo) && m.getAutor().equals(artista)) {
                                iteratormusico.remove();
                            }
                        }
                        for (Album b :((Musico) a).getAlbuns()){
                            iteratormusico=b.getMusicas().iterator();
                            while(iteratormusico.hasNext()){
                                Musica c = iteratormusico.next();
                                if(c.getTitulo().equals(titulo) && c.getAutor().equals(artista)){
                                    iteratormusico.remove();
                                }
                            }
                        }
                    }
                }
            }
            modeloTabela.removeRow(linhaSelecionada);
            revalidate();
            repaint();
        });

        popupMenu.add(removerMusica);

        return popupMenu;
    }

    /**
     * Neste método, o Admin pode inativar/ativar utilizadores de acordo com as restrições impostas no enunciado. Para evitar
     * o uso de break, utilizamos variaveis boolean para parar os ciclos quando necessário.
     * @param framePrincipal
     * @param tabela
     * @param modeloTabela
     * @return
     */
    public JPopupMenu criarPopupMenuUtilizador(FramePrincipal framePrincipal, JTable tabela, DefaultTableModel modeloTabela) {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem ativarInativar = new JMenuItem("Inativar/Reativar Utilizador");
        ativarInativar.addActionListener(e -> {
            int linhaSelecionada = tabela.getSelectedRow();

            if (linhaSelecionada != -1) {
                String username = (String) tabela.getValueAt(linhaSelecionada, 0);
                String estado;
                boolean stopIf = false;
                boolean stopElse = false;

                for (Utilizador a : framePrincipal.getRockstar().getUtilizadores()) {
                    if (!stopIf && a instanceof Admin && a.getUsername().equalsIgnoreCase (username) &&  a.getUsername().equals("toy")) {
                        JOptionPane.showMessageDialog(null, "Não foi possível inativar este utilizador", "Admin primário", JOptionPane.ERROR_MESSAGE);
                        stopIf = true;
                        stopElse = true;
                    } else {
                        if (!stopElse && a.getUsername().equals(username)) {
                            a.setActivo();
                            if (a.isActivo()) {
                                JOptionPane.showMessageDialog(framePrincipal, "Utilizador Reativado", "Estado Utilizador", JOptionPane.INFORMATION_MESSAGE);
                                estado = "Ativo";
                                int modelRow = tabela.convertRowIndexToModel(linhaSelecionada);
                                modeloTabela.setValueAt(estado, modelRow, 2);
                                tabela.repaint();
                            } else {
                                JOptionPane.showMessageDialog(framePrincipal, "Utilizador Inativado", "Estado utilizador", JOptionPane.INFORMATION_MESSAGE);
                                estado = "Inativo";
                                int modelRow = tabela.convertRowIndexToModel(linhaSelecionada);
                                modeloTabela.setValueAt(estado, modelRow, 2);
                                tabela.repaint();
                            }
                            stopIf = true;
                            stopElse = true;
                        }
                    }
                }
            }
        });

        popupMenu.add(ativarInativar);

        return popupMenu;
    }


    private void voltarPainelPrincipal () {
        FramePrincipal framePrincipal = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
        framePrincipal.getContentPane().removeAll();
        framePrincipal.getContentPane().add(new PainelPrincipal(framePrincipal));
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }
}
