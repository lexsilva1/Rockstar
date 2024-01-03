package GUI;

import backend.Album;
import backend.Musica;
import backend.Musico;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;

public class PainelAddMusica extends JPanel {
    public PainelAddMusica(FramePrincipal framePrincipal, Musico musico) {

        setLayout(null);
        setBackground(new Color(70, 90, 120));
        ;
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

        JLabel lblAno = new JLabel("Ano");
        lblAno.setBounds(260, 210, 50, 25);
        lblAno.setForeground(Color.WHITE);
        add(lblAno);

        JTextField txtMes = new JTextField();
        txtMes.setBounds(300, 190, 50, 25);
        txtMes.setForeground(Color.BLACK);
        add(txtMes);

        JLabel lblMes = new JLabel("Mês");
        lblMes.setBounds(310, 210, 50, 25);
        lblMes.setForeground(Color.WHITE);
        add(lblMes);

        JTextField txtDia = new JTextField();
        txtDia.setBounds(350, 190, 50, 25);
        txtDia.setForeground(Color.BLACK);
        add(txtDia);

        JLabel lblDia = new JLabel("Dia");
        lblDia.setBounds(360, 210, 50, 25);
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

        JLabel lblAlbum = new JLabel("Nome do Álbum");
        lblAlbum.setBounds(25, 400, 220, 25);
        lblAlbum.setForeground(Color.WHITE);
        lblAlbum.setVisible(false);

        JTextField txtAlbum = new JTextField();
        txtAlbum.setBounds(250, 400, 220, 25);
        txtAlbum.setForeground(Color.BLACK);
        txtAlbum.setVisible(false);

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
                if (!Character.isDigit(input)) {
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
                if (!Character.isDigit(input)) {
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
                if (!Character.isDigit(input)) {
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
                add(lblAlbum);
                add(txtAlbum);
                lblAlbum.setVisible(true);
                txtAlbum.setVisible(true);
                revalidate();
                repaint();
            } else if (chkNao.isSelected()) {
                lblAlbum.setVisible(false);
                txtAlbum.setVisible(false);
                revalidate();
                repaint();
            }
        });

        chkNao.addActionListener(e -> {
            if (chkNao.isSelected()) {
                remove(lblAlbum);
                remove(txtAlbum);
                revalidate();
                repaint();
            }
        });

        btnCriar.addActionListener(e -> {
            if (txtTitulo.getText().isEmpty() || txtAno.getText().isEmpty() || txtMes.getText().isEmpty() || txtDia.getText().isEmpty() || txtValor.getText().isEmpty() || grupo.getSelection() == null ) {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os dados", "Campo vazio", JOptionPane.ERROR_MESSAGE);
            } else {
                if (chkSim.isSelected()) {
                    if (musico.getAlbuns().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não tem álbuns criados", "Sem álbuns", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (txtAlbum.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Por favor preencha o nome do álbum", "Campo vazio", JOptionPane.ERROR_MESSAGE);
                        } else {
                            if (musico.procurarAlbum(txtAlbum.getText()) == null) {
                                JOptionPane.showMessageDialog(null, "Álbum não encontrado", "Dados errados", JOptionPane.ERROR_MESSAGE);
                            } else {
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
                                    if (musico.musicaExiste(txtTitulo.getText())) {
                                        JOptionPane.showMessageDialog(null, "Já existe uma música sua com o mesmo nome", "Música já existe", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        Musica musica = musico.criaMusica(txtTitulo.getText(), genero, data, valor);
                                        Album album = musico.procurarAlbum(txtAlbum.getText());

                                        if (musico.addMusicaAoAlbum(album, musica)) {
                                            framePrincipal.getRockstar().getMusicas().add(musica);
                                            JOptionPane.showMessageDialog(null, "Música criada com sucesso e adicionada ao álbum '" + txtAlbum.getText() + "'!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                                            txtTitulo.setText("");
                                            txtAno.setText("");
                                            txtMes.setText("");
                                            txtDia.setText("");
                                            txtValor.setText("");
                                            txtAlbum.setText("");
                                            grupo.clearSelection();
                                            grupoAlbum.clearSelection();
                                            this.setVisible(false);
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Não foi possível adicionar a música ao álbum selecionado", "Álbum cheio", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                }
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
                        txtAlbum.setText("");
                        grupo.clearSelection();
                        grupoAlbum.clearSelection();
                        this.setVisible(false);
                    }
                }
            }
        });

        btnCancelar.addActionListener(e -> {
            txtTitulo.setText("");
            txtAno.setText("");
            txtMes.setText("");
            txtDia.setText("");
            txtValor.setText("");
            txtAlbum.setText("");
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

        if (ano1 < 1900 || ano.length() > 4) {
            JOptionPane.showMessageDialog(null, "Ano deve ser posterior a 1900 e conter apenas 4 dígitos", "Dados errados", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (mes1 <1 || mes1 > 12) {
            JOptionPane.showMessageDialog(null, "Mês inválido", "Dados errados", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (mes.length() == 1 || dia.length() == 1) {
            JOptionPane.showMessageDialog(null, "Mês e dia devem ter 2 dígitos", "Dados errados", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (dia1 < 1 || dia1 > LocalDate.of(ano1, mes1, 1).lengthOfMonth()) {
                JOptionPane.showMessageDialog(null, "Dia inválido para o mês especificado", "Dados errados", JOptionPane.ERROR_MESSAGE);
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
}
