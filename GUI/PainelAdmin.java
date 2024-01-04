package GUI;


import backend.Admin;
import backend.Musica;
import backend.Promo;
import backend.Utilizador;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicInteger;

public class PainelAdmin extends JPanel {
    private Admin admin;
    private JButton btnVerCampanhas;
    private JButton btnCriarCampanha;
    private JButton btnCriarAdministrador;
    private JLabel labelUsername; //Colocar o username visivel
    private JButton btnLogout;
    private BotaoLupa btnLupa;
    private PainelOpcoesAdmin painelOpcoesAdmin;
    private PainelPesquisarUtilizador painelPesquisarUtilizador;
    private PainelCriarAdmin painelCriarAdmin;
    private PainelCriarCampanha painelCriarCampanha;




    /**
     * Cria um novo painel <code>JPanel</code> 'PainelAdmin', para a página inicial de um utlizador do tipo 'Administrador',
     * com um buffer duplo e um flow layout.
     */
    public PainelAdmin(FramePrincipal framePrincipal, Admin admin) {
        this.admin = admin;
        this.btnVerCampanhas = new JButton("Ver Campanhas");
        this.btnCriarCampanha = new JButton("Criar Campanha");
        this.btnCriarAdministrador = new JButton("Criar Administrador");
        this.labelUsername = new JLabel("Bem-vindo: " + admin.getUsername());
        JLabel lblPesquisar = new JLabel("Pesquisar");
        JTextField txtPesquisar = new JTextField();
        this.btnLupa = new BotaoLupa("/resources/lupa.png");
        this.btnLogout = new BotaoLogout("/resources/BotaoLogout.jpg");
        this.painelOpcoesAdmin= new PainelOpcoesAdmin(admin);
        this.painelPesquisarUtilizador = new PainelPesquisarUtilizador(framePrincipal);
        this.painelCriarAdmin = new PainelCriarAdmin(framePrincipal);
        this.painelCriarCampanha = new PainelCriarCampanha(framePrincipal, admin);


        setBackground(new Color(70, 90, 120));
        setLayout(null);

        btnVerCampanhas.setBounds(20,150,200,25);
        btnCriarCampanha.setBounds(20,200,200,25);
        btnCriarCampanha.addActionListener(e -> abrirPainelCriarCampanha());
        btnCriarAdministrador.setBounds(20,250,200,25);
        btnCriarAdministrador.addActionListener(e -> abrirPainelCriarAdmin());
        btnLogout.setBounds(740, 10, 40, 30);
        btnLogout.addActionListener(e -> voltarPainelPrincipal());
        labelUsername.setBounds(20,5,200,25);
        labelUsername.setForeground(Color.WHITE);
        painelOpcoesAdmin.setBounds(275,100,450,500);

        lblPesquisar.setBounds(300  , 5, 100, 25);
        lblPesquisar.setForeground(Color.WHITE);
        lblPesquisar.setVisible(true);
        add(lblPesquisar);

        txtPesquisar.setBounds(370, 5, 200, 25);
        txtPesquisar.setVisible(true);
        add(txtPesquisar);

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
        btnLupa.addActionListener((ActionEvent e) ->{
            if (txtPesquisar.getText().isEmpty() || grupo.getSelection() == null ) {
                JOptionPane.showMessageDialog(null, "Por favor escreva algo e selecione o parametro para pesquisar", "Campo vazio", JOptionPane.ERROR_MESSAGE);
        } else if( chkPesquisaMusica.isSelected()) {
            JPanel painel =new JPanel();
            painel.setLayout(new BorderLayout());
            painel.setBackground(new Color(70, 90, 120));
            painel.setPreferredSize(new Dimension(450, 500));
            DefaultTableModel modeloTabela = new DefaultTableModel();
            modeloTabela.addColumn("Título");
            modeloTabela.addColumn("Artista");
            modeloTabela.addColumn("Género");
            modeloTabela.addColumn("Data Lançamento");
            modeloTabela.addColumn("Rating");
            modeloTabela.addColumn("Preço");
            modeloTabela.addColumn("Ações");


            for (Musica a : framePrincipal.getRockstar().getMusicas() ){
                    if(a.getTitulo().contains(txtPesquisar.getText())){
                        modeloTabela.addRow(new Object[]{a.getTitulo(), a.getAutor(), a.getGenero(), a.getDataLancamento(), a.getRating(), a.getPreco(), a.getActiva()});
                    }
                }

                JTable tabela = new JTable(modeloTabela);
                tabela.setAutoCreateRowSorter(true);
                JScrollPane scrollPane = new JScrollPane(tabela);
                scrollPane.setVisible(true);
                painel.add(scrollPane, BorderLayout.CENTER);
                painel.setVisible(true);
                abrirPainelPesquisa(painel);
                JPopupMenu popupMenu = criarPopupMenuMusica(framePrincipal,tabela);
                tabela.setComponentPopupMenu(popupMenu);

            } else if (chkPesquisaUtilizador.isSelected()) {
                JPanel painel =new JPanel();
                painel.setLayout(new BorderLayout());
                painel.setBackground(new Color(70, 90, 120));
                painel.setPreferredSize(new Dimension(450, 500));
                DefaultTableModel modeloTabela = new DefaultTableModel();
                modeloTabela.addColumn("Username");
                modeloTabela.addColumn("Tipo de Utilizador");
                modeloTabela.addColumn("Ativo");
                modeloTabela.addColumn("password");
                for (Utilizador a : framePrincipal.getRockstar().getUtilizadores()){
                    if(a.getUsername().contains(txtPesquisar.getText())){
                        modeloTabela.addRow(new Object[]{a.getUsername(), a.getClass().getSimpleName(), a.isActivo(),a.getPassword()});
                    }
                }
                JTable tabela = new JTable(modeloTabela);
                tabela.setAutoCreateRowSorter(true);
                JScrollPane scrollPane = new JScrollPane(tabela);
                scrollPane.setVisible(true);
                painel.add(scrollPane, BorderLayout.CENTER);
                painel.setVisible(true);
                abrirPainelPesquisa(painel);
                JPopupMenu popupMenu = criarPopupMenuUtilizador(framePrincipal,tabela);
                tabela.setComponentPopupMenu(popupMenu);
            }
        });
        btnVerCampanhas.addActionListener(e -> {
            JPanel painel =new JPanel();
            painel.setLayout(new BorderLayout());
            painel.setBackground(new Color(70, 90, 120));
            painel.setPreferredSize(new Dimension(450, 500));
            DefaultTableModel modeloTabela = new DefaultTableModel();
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
            JScrollPane scrollPane = new JScrollPane(tabela);
            scrollPane.setVisible(true);
            painel.add(scrollPane, BorderLayout.CENTER);
            painel.setVisible(true);
            abrirPainelPesquisa(painel);
        });


        add(btnVerCampanhas);
        add(btnCriarCampanha);
        add(btnCriarAdministrador);
        add(btnLupa);
        add(btnLogout);
        add(painelOpcoesAdmin);
        setVisible(true);

    }

    private void abrirPainelPesquisa(JPanel painel) {
        // Remover todos os componentes do painelOpcoesCliente
        painelOpcoesAdmin.removeAll();
        // Adicionar o painelCriarPlaylist ao painelOpcoesCliente
        painelOpcoesAdmin.add(painel);
        // Atualizar o painelOpcoesCliente
        painelOpcoesAdmin.revalidate();
        painelOpcoesAdmin.repaint();
    }

    private void abrirPainelCriarCampanha() {
        // Remover todos os componentes do painelOpcoesCliente
        painelOpcoesAdmin.removeAll();
        // Adicionar o painelCriarPlaylist ao painelOpcoesCliente
        painelOpcoesAdmin.add(painelCriarCampanha);
        // Atualizar o painelOpcoesCliente
        painelOpcoesAdmin.revalidate();
        painelOpcoesAdmin.repaint();
    }

    private void abrirPainelCriarAdmin() {
        // Remover todos os componentes do painelOpcoesCliente
        painelOpcoesAdmin.removeAll();
        // Adicionar o painelCriarPlaylist ao painelOpcoesCliente
        painelOpcoesAdmin.add(painelCriarAdmin);
        // Atualizar o painelOpcoesCliente
        painelOpcoesAdmin.revalidate();
        painelOpcoesAdmin.repaint();
    }
    public JPopupMenu criarPopupMenuMusica(FramePrincipal framePrincipal, JTable tabela) {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem adicionarAoCarrinhoItem = new JMenuItem("Remover Musica");
        adicionarAoCarrinhoItem.addActionListener(e -> {
            int linhaSelecionada = tabela.getSelectedRow();

            if (linhaSelecionada != -1) {
                String titulo = (String) tabela.getValueAt(linhaSelecionada, 0);
                String artista = (String) tabela.getValueAt(linhaSelecionada, 1);


                for (Musica c : framePrincipal.getRockstar().getMusicas()) {
                    if (c.getTitulo().equals(titulo) && c.getAutor().equals(artista)) {
                        framePrincipal.getRockstar().getMusicas().remove(c);
                    }
                }
                for (Utilizador a : framePrincipal.getRockstar().getUtilizadores()){
                    if( a instanceof Cliente){
                        for(Musica c :  ((Cliente) a).getMusicas()){
                            if (c.getTitulo().equals(titulo) && c.getAutor().equals(artista)) {
                                ((Cliente) a).getMusicas().remove(c);
                            }
                        }
                    }else if (a instanceof Musico){
                        for (Musica c : ((Musico) a).getMusicas()){
                            if (c.getTitulo().equals(titulo) && c.getAutor().equals(artista)) {
                                ((Musico) a).getMusicas().remove(c);
                            }
                        }
                    }
                }
            }
        });

        popupMenu.add(adicionarAoCarrinhoItem);

        return popupMenu;
    }
    public JPopupMenu criarPopupMenuUtilizador(FramePrincipal framePrincipal, JTable tabela) {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem adicionarAoCarrinhoItem = new JMenuItem("Bloquear Utilizador");
        adicionarAoCarrinhoItem.addActionListener(e -> {
            int linhaSelecionada = tabela.getSelectedRow();

            if (linhaSelecionada != -1) {
                String username = (String) tabela.getValueAt(linhaSelecionada, 0);

                for (Utilizador a : framePrincipal.getRockstar().getUtilizadores()){
                    if( a instanceof Admin && ((Admin) a).getIdAdmin()==1 && a.getUsername().equals(username)){
                        JOptionPane.showMessageDialog(null, "Não foi possível inactivar este utilizador", "Admin primário", JOptionPane.ERROR_MESSAGE);
                    }else if (a.getUsername().equals(username))
                        a.setActivo();
                    JOptionPane.showMessageDialog(framePrincipal, "Utilizador Bloqueado", "Bloquear utilizador", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });

        popupMenu.add(adicionarAoCarrinhoItem);

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
