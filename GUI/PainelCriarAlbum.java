package GUI;
import backend.*;

import javax.swing.*;
import java.awt.*;

public class PainelCriarAlbum extends PainelCriarPlaylistGenero{
    public PainelCriarAlbum(FramePrincipal framePrincipal, Musico musico) {
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
                int numeroDeFaixas = Integer.parseInt(txtNumero.getText());

                String genero = "Rock";
                if (chkPop.isSelected()) {
                    genero = "Pop";
                } else if (chkPimba.isSelected()) {
                    genero = "Pimba";
                } else if (chkHipHop.isSelected()) {
                    genero = "Hip Hop";
                }
                //musico.criaAlbum(musico.getUsername(), txtNome.getText(), genero, numeroDeFaixas);
                JOptionPane.showMessageDialog(null, "Álbum adicionado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
            }
        });
    }
}
