package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoLupa extends JButton {

    public BotaoLupa(String imagePath) {
        ImageIcon logoutIcon = createImageIcon(imagePath);
        setIcon(logoutIcon);


    }

    private ImageIcon createImageIcon(String path) {
        try {
            Image imagem = new ImageIcon(getClass().getResource(path)).getImage();

            // Redimensionar a imagem para caber no botão (opcional)
            Image imagemRedimensionada = imagem.getScaledInstance(20, 20, Image.SCALE_SMOOTH);

            // Criar um ImageIcon com a imagem redimensionada
            return new ImageIcon(imagemRedimensionada);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}