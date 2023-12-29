package GUI;
import backend.*;

import javax.swing.*;

public class PainelCriarAlbum extends PainelCriarPlaylistGenero{
    public PainelCriarAlbum(FramePrincipal framePrincipal, Utilizador utilizador) {
        super(framePrincipal,(Musico) utilizador);


        JButton btnAddMusica = new JButton("+");

        setVisible(false);
    }
}
