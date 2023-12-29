package GUI;
import backend.*;

import javax.swing.*;

public class PainelCriarAlbum extends PainelCriarPlaylistGenero{
    public PainelCriarAlbum(FramePrincipal framePrincipal, Utilizador utilizador) {
        super(framePrincipal);


        JButton btnAddMusica = new JButton("+");

        setVisible(false);
    }
}
