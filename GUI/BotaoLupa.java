package GUI;
import javax.swing.*;
import java.awt.*;

public class BotaoLupa extends JButton {

    public BotaoLupa(String imagePath) {
        ImageIcon iconeLupa = createImageIcon(imagePath);
        setIcon(iconeLupa);
    }

    private ImageIcon createImageIcon(String path) {
        try {
            Image imagem = new ImageIcon(getClass().getResource(path)).getImage();

            // Redimensionar a imagem para caber no botão
            Image imagemRedimensionada = imagem.getScaledInstance(20, 20, Image.SCALE_SMOOTH);

            // Criar um ImageIcon com a imagem redimensionada
            return new ImageIcon(imagemRedimensionada);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}