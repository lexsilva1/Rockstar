package GUI;
import backend.Rockstar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class FramePrincipal extends JFrame {
    private Rockstar rockstar;
    protected PainelPrincipal painelPrincipal;
    private static final String FILE_PATH = "Rockstar.ser";
    public FramePrincipal() {
        super("Rockstar");

        try {
            FileInputStream fileIn = new FileInputStream(FILE_PATH);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            try {
                rockstar = (Rockstar) in.readObject();
                in.close();
                fileIn.close();
                System.out.println("Deserialization successful");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        catch (IOException e){
            System.err.println("não encontro");
        }

        painelPrincipal = new PainelPrincipal(this);

        add(painelPrincipal);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);
        setLocationRelativeTo(null);
        setResizable(false);

        //Cria ícone para quando a app é minimizada
        Image icon = new ImageIcon("resources/icone.jpg").getImage();
        setIconImage(icon);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Serialize the object when the window is closing
                serializeObject(rockstar);
                // Exit the application
                System.exit(0);
            }
        });
    }

    public Rockstar getRockstar() {
        return rockstar;
    }


    public static void serializeObject(Rockstar rockstar) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Rockstar.ser"))) {
            outputStream.writeObject(rockstar);
            System.out.println("Object serialized successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




