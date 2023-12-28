package GUI;

import javax.swing.*;

public class PainelCriarAlbum extends PainelCriarPlaylistGenero{
    public PainelCriarAlbum(FramePrincipal framePrincipal) {
        super(framePrincipal);

        JButton btnAddMusica = new JButton("+");

        setVisible(false);
    }
}
