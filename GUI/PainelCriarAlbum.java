package GUI;
import backend.*;

import javax.swing.*;
import java.awt.*;
/**
 * Constoi um novo PainelCriarAlbum.
 * As JLabel passadas no cosntrutor servem para actualizar as estatisticas se o musico criar novos albuns de um determinado género.
 * A framePrincipal é passada para poder aceder a toda a informação contida na Rockstar.
 */
public class PainelCriarAlbum extends PainelCriarPlaylistGenero{
    public PainelCriarAlbum(FramePrincipal framePrincipal, Musico musico, JLabel totalRock, JLabel totalHipoHop, JLabel totalPop, JLabel totalPimba) {
        super(framePrincipal, musico);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(180,350,100,25);
        btnCancelar.setForeground(Color.BLACK);
        add(btnCancelar);

        btnCancelar.addActionListener(e -> setVisible(false));

        btnCriar.addActionListener(e -> {

            if (txtNome.getText().isEmpty() || txtNumero.getText().isEmpty() || grupo.getSelection() == null) {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os dados", "Campo vazio", JOptionPane.ERROR_MESSAGE);
            } else {
                if (musico.albumExiste(txtNome.getText())) {
                    JOptionPane.showMessageDialog(null, "Já existe um álbum seu com o mesmo nome", "Álbum já existe", JOptionPane.ERROR_MESSAGE);
                    txtNome.setText("");
                } else {
                    if (Integer.parseInt(txtNumero.getText()) > 20) {
                        JOptionPane.showMessageDialog(null, "Apenas pode criar álbuns com até 20 faixas", "Dados errados", JOptionPane.ERROR_MESSAGE);
                    } else {
                        int numeroDeFaixas = Integer.parseInt(txtNumero.getText());

                        String genero = "Rock";
                        if (chkPop.isSelected()) {
                            genero = "Pop";
                        } else if (chkPimba.isSelected()) {
                            genero = "Pimba";
                        } else if (chkHipHop.isSelected()) {
                            genero = "Hip Hop";
                        }
                        musico.criaAlbum(framePrincipal, musico.getUsername(), txtNome.getText(), genero, numeroDeFaixas);
                        JOptionPane.showMessageDialog(null, "Álbum adicionado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);
                    }
                }
            }
            String espaco = " ";
            totalRock.setText(espaco.concat(String.valueOf((framePrincipal.getRockstar().albunsRock()))));
            totalHipoHop.setText(espaco.concat(String.valueOf((framePrincipal.getRockstar().albunsHipHop()))));
            totalPimba.setText(espaco.concat(String.valueOf((framePrincipal.getRockstar().albunsPimba()))));
            totalPop.setText(espaco.concat(String.valueOf((framePrincipal.getRockstar().albunsPop()))));
        });
    }
}
