package GUI;

import backend.Album;
import backend.GrupoMusicas;
import backend.Musica;
import backend.Musico;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class PainelAddMusica extends JPanel {
    public PainelAddMusica(FramePrincipal framePrincipal, Musico musico, JLabel totalMusicas, JLabel valorMusicas) {

        setLayout(null);
        setBackground(new Color(70, 90, 120));
        setPreferredSize(new Dimension(450, 500));


        JLabel lblTitulo = new JLabel("Título");
        lblTitulo.setBounds(25, 40, 220, 25);
        lblTitulo.setForeground(Color.WHITE);
        add(lblTitulo);

        JTextField txtTitulo = new JTextField();
        txtTitulo.setBounds(250, 40, 220, 25);
        txtTitulo.setForeground(Color.BLACK);
        add(txtTitulo);

        JLabel lblGenero = new JLabel("Género");
        lblGenero.setBounds(25, 100, 220, 25);
        lblGenero.setForeground(Color.WHITE);
        add(lblGenero);

        JLabel lblData = new JLabel("Data de lançamento");
        lblData.setBounds(25, 190, 220, 25);
        lblData.setForeground(Color.WHITE);
        add(lblData);

        JTextField txtAno = new JTextField();
        txtAno.setBounds(250, 190, 50, 25);
        txtAno.setForeground(Color.BLACK);
        add(txtAno);

        JLabel lblAno = new JLabel("AAAA");
        lblAno.setBounds(255, 210, 50, 25);
        lblAno.setForeground(Color.WHITE);
        add(lblAno);

        JTextField txtMes = new JTextField();
        txtMes.setBounds(300, 190, 50, 25);
        txtMes.setForeground(Color.BLACK);
        add(txtMes);

        JLabel lblMes = new JLabel("MM");
        lblMes.setBounds(307, 210, 50, 25);
        lblMes.setForeground(Color.WHITE);
        add(lblMes);

        JTextField txtDia = new JTextField();
        txtDia.setBounds(350, 190, 50, 25);
        txtDia.setForeground(Color.BLACK);
        add(txtDia);

        JLabel lblDia = new JLabel("DD");
        lblDia.setBounds(357, 210, 50, 25);
        lblDia.setForeground(Color.WHITE);
        add(lblDia);


        JLabel lblValor = new JLabel("Valor (€)");
        lblValor.setBounds(25, 250, 220, 25);
        lblValor.setForeground(Color.WHITE);
        add(lblValor);

        JTextField txtValor = new JTextField();
        txtValor.setBounds(250, 250, 220, 25);
        txtValor.setForeground(Color.BLACK);
        add(txtValor);


        JRadioButton chkPop = new JRadioButton("Pop");
        chkPop.setBounds(25, 130, 85, 25);
        chkPop.setBackground(new Color(70, 90, 120));
        chkPop.setForeground(Color.WHITE);
        chkPop.setSelected(false);
        add(chkPop);

        JRadioButton chkRock = new JRadioButton("Rock");
        chkRock.setBounds(110, 130, 85, 25);
        chkRock.setBackground(new Color(70, 90, 120));
        chkRock.setForeground(Color.WHITE);
        chkRock.setSelected(false);
        add(chkRock);

        JRadioButton chkHipHop = new JRadioButton("Hip Hop");
        chkHipHop.setBounds(195, 130, 85, 25);
        chkHipHop.setBackground(new Color(70, 90, 120));
        chkHipHop.setForeground(Color.WHITE);
        chkHipHop.setSelected(false);
        add(chkHipHop);

        JRadioButton chkPimba = new JRadioButton("Pimba");
        chkPimba.setBounds(310, 130, 85, 25);
        chkPimba.setBackground(new Color(70, 90, 120));
        chkPimba.setForeground(Color.WHITE);
        chkPimba.setSelected(false);
        add(chkPimba);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(chkPop);
        grupo.add(chkRock);
        grupo.add(chkHipHop);
        grupo.add(chkPimba);

        JLabel lblAddAlbum = new JLabel("Adicionar a música a um album?");
        lblAddAlbum.setBounds(25, 310, 220, 25);
        lblAddAlbum.setForeground(Color.WHITE);
        lblAddAlbum.setVisible(true);
        add(lblAddAlbum);

        JRadioButton chkSim = new JRadioButton("Sim");
        chkSim.setBounds(25, 340, 85, 25);
        chkSim.setBackground(new Color(70, 90, 120));
        chkSim.setForeground(Color.WHITE);
        chkSim.setSelected(false);
        add(chkSim);

        JRadioButton chkNao = new JRadioButton("Não");
        chkNao.setBounds(110, 340, 85, 25);
        chkNao.setBackground(new Color(70, 90, 120));
        chkNao.setForeground(Color.WHITE);
        chkNao.setSelected(false);
        add(chkNao);

        ButtonGroup grupoAlbum = new ButtonGroup();
        grupoAlbum.add(chkSim);
        grupoAlbum.add(chkNao);

        JLabel nomeAlbum = new JLabel();
        nomeAlbum.setText("Escolha o Álbum");
        nomeAlbum.setBounds(130, 380, 150, 25);
        nomeAlbum.setForeground(Color.WHITE);
        nomeAlbum.setVisible(false);

        JComboBox escolhaAlbum = new JComboBox<>(verAlbuns(framePrincipal,musico));
        escolhaAlbum.setBounds(nomeAlbum.getX() + 160, nomeAlbum.getY(), 150, 25);
        escolhaAlbum.setVisible(false);

        JButton btnCriar = new JButton("Criar");
        btnCriar.setBounds(380, 460, 75, 25);
        btnCriar.setForeground(Color.BLACK);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(280, 460, 100, 25);
        btnCancelar.setForeground(Color.BLACK);

        txtValor.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!Character.isDigit(input) && input != '.') {
                    e.consume();
                } else if (input == '.' && txtValor.getText().contains(".")) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        txtAno.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!Character.isDigit(input) || txtAno.getText().length() == 4) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        txtMes.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!Character.isDigit(input) || txtMes.getText().length() == 2) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        txtDia.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!Character.isDigit(input) || txtDia.getText().length() == 2) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        chkSim.addActionListener(e -> {
            if (chkSim.isSelected()) {
                add(nomeAlbum);
                add(escolhaAlbum);
                nomeAlbum.setVisible(true);
                escolhaAlbum.setVisible(true);
                revalidate();
                repaint();
            } else if (chkNao.isSelected()) {
                nomeAlbum.setVisible(false);
                escolhaAlbum.setVisible(false);
                revalidate();
                repaint();
            }
        });

        chkNao.addActionListener(e -> {
            if (chkNao.isSelected()) {
                remove(nomeAlbum);
                remove(escolhaAlbum);
                revalidate();
                repaint();
            }
        });

        btnCriar.addActionListener(e -> {
            if (txtTitulo.getText().isEmpty() || txtAno.getText().isEmpty() || txtMes.getText().isEmpty() || txtDia.getText().isEmpty() || txtValor.getText().isEmpty() || grupo.getSelection() == null ) {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os dados", "Campo vazio", JOptionPane.ERROR_MESSAGE);
            } else {
                if (musico.musicaExiste(txtTitulo.getText())) {
                    JOptionPane.showMessageDialog(null, "Já existe uma música sua com o mesmo nome", "Música já existe", JOptionPane.ERROR_MESSAGE);
                    txtTitulo.setText("");
                } else {
                    if (chkSim.isSelected()) {
                        if (verificarData(txtAno.getText(), txtMes.getText(), txtDia.getText())) {
                            String txtData = txtAno.getText() + "-" + txtMes.getText() + "-" + txtDia.getText();
                            LocalDate data = LocalDate.parse(txtData);
                            double valor = Double.parseDouble(txtValor.getText());
                            String genero = "Rock";
                            if (chkPop.isSelected()) {
                                genero = "Pop";
                            } else if (chkPimba.isSelected()) {
                                genero = "Pimba";
                            } else if (chkHipHop.isSelected()) {
                                genero = "Hip Hop";
                            }


                            if (escolhaAlbum.getSelectedItem() != null) {

                                Musica musica = musico.criaMusica(txtTitulo.getText(), genero, data, valor);

                                Album album = (Album) escolhaAlbum.getSelectedItem();

                                if (musico.addMusicaAoAlbum(album, musica)) {
                                    framePrincipal.getRockstar().getMusicas().add(musica);
                                    JOptionPane.showMessageDialog(null, "Música criada com sucesso e adicionada ao álbum '" + album.getTitulo() + "'!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                                    txtTitulo.setText("");
                                    txtAno.setText("");
                                    txtMes.setText("");
                                    txtDia.setText("");
                                    txtValor.setText("");
                                    grupo.clearSelection();
                                    grupoAlbum.clearSelection();
                                    this.setVisible(false);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Não foi possível adicionar a música ao álbum selecionado", "Álbum cheio", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }


                    } else {
                        if (verificarData(txtAno.getText(), txtMes.getText(), txtDia.getText())) {

                            double valor = Double.parseDouble(txtValor.getText());
                            String txtData = txtAno.getText() + "-" + txtMes.getText() + "-" + txtDia.getText();
                            LocalDate data = LocalDate.parse(txtData);
                            String genero = "Rock";
                            if (chkPop.isSelected()) {
                                genero = "Pop";
                            } else if (chkPimba.isSelected()) {
                                genero = "Pimba";
                            } else if (chkHipHop.isSelected()) {
                                genero = "Hip Hop";
                            }

                            Musica musica = musico.criaMusica(txtTitulo.getText(), genero, data, valor);
                            framePrincipal.getRockstar().getMusicas().add(musica);
                            JOptionPane.showMessageDialog(null, "Música criada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                            txtTitulo.setText("");
                            txtAno.setText("");
                            txtMes.setText("");
                            txtDia.setText("");
                            txtValor.setText("");
                            grupo.clearSelection();
                            grupoAlbum.clearSelection();
                            this.setVisible(false);
                        }
                    }
                }
            }
            String espaco = " ";
            totalMusicas.setText(espaco.concat(String.valueOf((framePrincipal.getRockstar().getMusicas().size()))));
            valorMusicas.setText(espaco.concat(String.format("%1$,.2f€",(framePrincipal.getRockstar().valorMusicas()))));
        });

        btnCancelar.addActionListener(e -> {
            txtTitulo.setText("");
            txtAno.setText("");
            txtMes.setText("");
            txtDia.setText("");
            txtValor.setText("");
            grupo.clearSelection();
            grupoAlbum.clearSelection();
            setVisible(false);
        });

        add(btnCriar);
        add(btnCancelar);
        add(lblTitulo);
        add(txtTitulo);
        add(lblGenero);
        add(lblData);
        add(txtAno);
        add(txtMes);
        add(txtDia);
        add(lblValor);
        add(txtValor);
        add(lblAddAlbum);

        setVisible(false);
    }

    /**
     * Verifica se os dados introduzidos nos campos relativos à data são válidos para criar uma data do tipo <code>LocalDate</code>.
     * Data introduzida não deve ser posterior à data atual (variável criada através do método <code>LocalDate.now()</code>,
     * verificado através da sua comparação através do método <code>.isAfter</code>.
     * @param ano String que será convertida em int e representa o year no <code>LocalDate</code>; deve ser composta por 4 caracteres
     *           e o valor não deve ser inferior a 1900;
     * @param mes String que será convertida em int e representa o month no <code>LocalDate</code>; deve ser composta por 2 caracteres
     *      *           e o valor não deve ser <1 ou >12;
     * @param dia String que será convertida em int e representa o dayOfMonth no <code>LocalDate</code>; deve ser composta por 2 caracteres
     *      *      *           e o valor deve ser válido para o mês em questão (verificado através do método <code>.lengthOfMonth()</code>
     *            com os dados do ano e mês fornecidos e o valor '1' para o dayOfMonth;
     * @return true se a data satisfizer todas as condições; false em caso contrário, demonstrando quais os dados incorretos através de mensagens
     * que surgem através de <code>JOptionPane</code>.
     */
    public boolean verificarData(String ano, String mes, String dia) {
        int ano1 = Integer.parseInt(ano);
        int mes1 = Integer.parseInt(mes);
        int dia1 = Integer.parseInt(dia);

        if (ano1 < 1900 || ano.length() < 4) {
            JOptionPane.showMessageDialog(null, "Ano deve ser posterior a 1900 e conter 4 dígitos", "Dados errados", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (mes1 <1 || mes1 > 12 || mes.length() < 2) {
            JOptionPane.showMessageDialog(null, "Mês inválido.\nMês deve conter 2 dígitos", "Dados errados", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (dia1 < 1 || dia1 > LocalDate.of(ano1, mes1, 1).lengthOfMonth() || dia.length() < 2) {
                JOptionPane.showMessageDialog(null, "Dia inválido para o mês especificado.\nDia deve conter 2 dígitos.", "Dados errados", JOptionPane.ERROR_MESSAGE);
                return false;
        } else {
            LocalDate data = LocalDate.of(ano1, mes1, dia1);
            LocalDate hoje = LocalDate.now();
            if (data.isAfter(hoje)) {
                JOptionPane.showMessageDialog(null, "Data não deve ser posterior à data atual", "Dados errados", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    public GrupoMusicas[] verAlbuns(FramePrincipal framePrincipal, Musico musico) {
        ArrayList<GrupoMusicas> albuns = new ArrayList<>();
        for (GrupoMusicas g : framePrincipal.getRockstar().getGrupoMusicas()) {
            if (g.getOwner().equals(musico.getUsername())) {
                albuns.add(g);
            }
        }
        GrupoMusicas [] meusAlbuns = new Album [albuns.size()];
        int i=0;
        for (GrupoMusicas g : albuns){
            meusAlbuns[i]=g;
            i++;
        }
        return meusAlbuns;
    }
}
