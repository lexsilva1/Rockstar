package GUI;

import javax.swing.*;
import java.awt.*;

public class ImagemDeFundo extends JPanel {
    private Image imagemDeFundo;

    public ImagemDeFundo(Image imagemDeFundo) {
        this.imagemDeFundo = imagemDeFundo;
    }

    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        // Desenha a imagem de fundo
        g.drawImage(imagemDeFundo, 0, 0, getWidth(), getHeight(), this);

    }
}
