package GUI;
import backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.time.LocalDate;

public class FramePrincipal extends JFrame {
    private Rockstar rockstar;
    protected PainelPrincipal painelPrincipal;
    private final String FILE_PATH = "Rockstar.ser"; // estava static mas temos de ver melhor
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
        catch ( FileNotFoundException e){
            System.err.println("não encontro ficheiro");
            Admin admin = new Admin("toy","password");
            Cliente cliente = new Cliente("joaosilva","password");
            Musico musico = new Musico("inesisabel","password","1234");
            Musico musico2 = new Musico("zecabra","password","1234");
            Musico musico3 = new Musico("bossAC","password","1234");
            Musica musica1 = new Musica("Chupa Teresa","Pimba", LocalDate.of(2021,12,3),"inesisabel",1.5);
            Musica musica2 = new Musica("São Lagrimas","Pimba", LocalDate.of(2004,9,13),"zecabra",0.5);
            Musica musica3 = new Musica("Deixei tudo por ela","Pimba", LocalDate.of(2004,11,19),"zecabra",1);
            Musica musica4 = new Musica("Sexta-feira","Hip Hop", LocalDate.of(2013,6,22),"BossAC",1.5);
            Musica musica5 = new Musica("Princesa","Hip Hop", LocalDate.of(2015,4,25),"BossAC",1.5);

            Rockstar rockstar = new Rockstar();
            this.rockstar = rockstar ;
            rockstar.getMusicas().add(musica1);
            rockstar.getMusicas().add(musica2);
            rockstar.getMusicas().add(musica3);
            rockstar.getMusicas().add(musica4);
            rockstar.getMusicas().add(musica5);
            musico.getMusicas().add(musica1);
            musico2.getMusicas().add(musica2);
            musico2.getMusicas().add(musica3);
            musico3.getMusicas().add(musica4);
            musico3.getMusicas().add(musica5);
            rockstar.getUtilizadores().add(admin);
            rockstar.getUtilizadores().add(cliente);
            rockstar.getUtilizadores().add(musico);
            rockstar.getUtilizadores().add(musico2);
            rockstar.getUtilizadores().add(musico3);
        }
        catch (IOException e){
            System.err.println("outro erro");
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




