package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoCarrinho extends JButton {

    public BotaoCarrinho(String imagePath) {
        ImageIcon carrinhoIcon = createImageIcon(imagePath);
        setIcon(carrinhoIcon);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirPainelCompras();
            }
        });
    }

    private ImageIcon createImageIcon(String path) {
        try {
            Image imagem = new ImageIcon(getClass().getResource(path)).getImage();

            // Redimensionar a imagem para caber no botão (opcional)
            Image imagemRedimensionada = imagem.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

            // Criar um ImageIcon com a imagem redimensionada
            return new ImageIcon(imagemRedimensionada);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void abrirPainelCompras() {


    }
}