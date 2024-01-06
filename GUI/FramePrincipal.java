package GUI;
import backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;

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
            Rockstar rockstar = new Rockstar();
            this.rockstar = rockstar ;
            Admin admin = new Admin("toy","password");
            Cliente cliente = new Cliente("joaosilva","password");
            Musico musico = new Musico("inesisabel","password","1234");
            Musico musico2 = new Musico("zecabra","password","1234");
            Musico musico3 = new Musico("bossAC","password","1234");
            Musica musica1 = new Musica("Chupa Teresa","Pimba", LocalDate.of(2021,12,3),"inesisabel",1.5);
            Musica musica2 = new Musica("São Lagrimas","Pimba", LocalDate.of(2004,9,13),"zecabra",0.5);
            Musica musica3 = new Musica("Deixei tudo por ela","Pimba", LocalDate.of(2004,11,19),"zecabra",1);
            Musica musica4 = new Musica("Sexta-feira","Hip Hop", LocalDate.of(2013,6,22),"bossAC",1.5);
            Musica musica5 = new Musica("Princesa","Hip Hop", LocalDate.of(2015,4,25),"bossAC",1.5);
            // Create 10 new Musicos with celebrity usernames starting from musico4
            Musico musico4 = new Musico("drake", "password", "1234");
            Musico musico5 = new Musico("arianagrande", "password", "1234");
            Musico musico6 = new Musico("justinbieber", "password", "1234");
            Musico musico7 = new Musico("rihanna", "password", "1234");
            Musico musico8 = new Musico("katyperry", "password", "1234");
            Musico musico9 = new Musico("u2", "password", "1234");
            Musico musico10 = new Musico("imaginedragons", "password", "1234");
            Musico musico11 = new Musico("metallica", "password", "1234");
            Musico musico12 = new Musico("britneyspears", "password", "1234");
            Musico musico13 = new Musico("shakira", "password", "1234");
            Musica katySong1 = new Musica("Firework", "Pop", LocalDate.of(2022, 5, 11), "katyperry", 1.0);
            Musica katySong2 = new Musica("Dark Horse", "Pop", LocalDate.of(2022, 5, 12), "katyperry", 1.0);
            Musica katySong3 = new Musica("Roar", "Pop", LocalDate.of(2022, 5, 13), "katyperry", 1.0);
            Musica katySong4 = new Musica("California Gurls", "Pop", LocalDate.of(2022, 5, 14), "katyperry", 1.0);
            Musica katySong5 = new Musica("Teenage Dream", "Pop", LocalDate.of(2022, 5, 15), "katyperry", 1.0);
            Musica katySong6 = new Musica("Last Friday Night (T.G.I.F.)", "Pop", LocalDate.of(2022, 5, 16), "katyperry", 1.0);
            Musica katySong7 = new Musica("Hot N Cold", "Pop", LocalDate.of(2022, 5, 17), "katyperry", 1.0);
            Musica katySong8 = new Musica("E.T.", "Pop", LocalDate.of(2022, 5, 18), "katyperry", 1.0);
            Musica katySong9 = new Musica("Part of Me", "Pop", LocalDate.of(2022, 5, 19), "katyperry", 1.0);
            Musica katySong10 = new Musica("Wide Awake", "Pop", LocalDate.of(2022, 5, 20), "katyperry", 1.0);

            musico8.getMusicas().addAll(Arrays.asList(katySong1, katySong2, katySong3, katySong4, katySong5, katySong6, katySong7, katySong8, katySong9, katySong10));
            rockstar.getMusicas().addAll(Arrays.asList(katySong1, katySong2, katySong3, katySong4, katySong5, katySong6, katySong7, katySong8, katySong9, katySong10));
            Musica justinSong1 = new Musica("Baby", "Pop", LocalDate.of(2022, 4, 21), "justinbieber", 1.0);
            Musica justinSong2 = new Musica("Sorry", "Pop", LocalDate.of(2022, 4, 22), "justinbieber", 1.0);
            Musica justinSong3 = new Musica("What Do You Mean?", "Pop", LocalDate.of(2022, 4, 23), "justinbieber", 1.0);
            Musica justinSong4 = new Musica("Love Yourself", "Pop", LocalDate.of(2022, 4, 24), "justinbieber", 1.0);
            Musica justinSong5 = new Musica("Yummy", "Pop", LocalDate.of(2022, 4, 25), "justinbieber", 1.0);
            Musica justinSong6 = new Musica("Intentions", "Pop", LocalDate.of(2022, 4, 26), "justinbieber", 1.0);
            Musica justinSong7 = new Musica("Beauty and a Beat", "Pop", LocalDate.of(2022, 4, 27), "justinbieber", 1.0);
            Musica justinSong8 = new Musica("As Long As You Love Me", "Pop", LocalDate.of(2022, 4, 28), "justinbieber", 1.0);
            Musica justinSong9 = new Musica("Company", "Pop", LocalDate.of(2022, 4, 29), "justinbieber", 1.0);
            Musica justinSong10 = new Musica("Never Say Never", "Pop", LocalDate.of(2022, 4, 30), "justinbieber", 1.0);

            musico6.getMusicas().addAll(Arrays.asList(justinSong1, justinSong2, justinSong3, justinSong4, justinSong5, justinSong6, justinSong7, justinSong8, justinSong9, justinSong10));
            rockstar.getMusicas().addAll(Arrays.asList(justinSong1, justinSong2, justinSong3, justinSong4, justinSong5, justinSong6, justinSong7, justinSong8, justinSong9, justinSong10));

// Add Musicas for Rihanna
            Musica rihannaSong1 = new Musica("Umbrella", "Pop", LocalDate.of(2022, 5, 1), "rihanna", 1.0);
            Musica rihannaSong2 = new Musica("Diamonds", "Pop", LocalDate.of(2022, 5, 2), "rihanna", 1.0);
            Musica rihannaSong3 = new Musica("We Found Love", "Pop", LocalDate.of(2022, 5, 3), "rihanna", 1.0);
            Musica rihannaSong4 = new Musica("Work", "Pop", LocalDate.of(2022, 5, 4), "rihanna", 1.0);
            Musica rihannaSong5 = new Musica("Only Girl (In The World)", "Pop", LocalDate.of(2022, 5, 5), "rihanna", 1.0);
            Musica rihannaSong6 = new Musica("Rude Boy", "Pop", LocalDate.of(2022, 5, 6), "rihanna", 1.0);
            Musica rihannaSong7 = new Musica("S&M", "Pop", LocalDate.of(2022, 5, 7), "rihanna", 1.0);
            Musica rihannaSong8 = new Musica("Don't Stop The Music", "Pop", LocalDate.of(2022, 5, 8), "rihanna", 1.0);
            Musica rihannaSong9 = new Musica("Where Have You Been", "Pop", LocalDate.of(2022, 5, 9), "rihanna", 1.0);
            Musica rihannaSong10 = new Musica("Stay", "Pop", LocalDate.of(2022, 5, 10), "rihanna", 1.0);

            musico7.getMusicas().addAll(Arrays.asList(rihannaSong1, rihannaSong2, rihannaSong3, rihannaSong4, rihannaSong5, rihannaSong6, rihannaSong7, rihannaSong8, rihannaSong9, rihannaSong10));
            rockstar.getMusicas().addAll(Arrays.asList(rihannaSong1, rihannaSong2, rihannaSong3, rihannaSong4, rihannaSong5, rihannaSong6, rihannaSong7, rihannaSong8, rihannaSong9, rihannaSong10));
            Musica britneySong1 = new Musica("Toxic", "Pop", LocalDate.of(2022, 3, 1), "britneyspears", 1.0);
            Musica britneySong2 = new Musica("Baby One More Time", "Pop", LocalDate.of(2022, 3, 2), "britneyspears", 1.0);
            Musica britneySong3 = new Musica("Oops!... I Did It Again", "Pop", LocalDate.of(2022, 3, 3), "britneyspears", 1.0);
            Musica britneySong4 = new Musica("Womanizer", "Pop", LocalDate.of(2022, 3, 4), "britneyspears", 1.0);
            Musica britneySong5 = new Musica("Circus", "Pop", LocalDate.of(2022, 3, 5), "britneyspears", 1.0);
            Musica britneySong6 = new Musica("Gimme More", "Pop", LocalDate.of(2022, 3, 6), "britneyspears", 1.0);
            Musica britneySong7 = new Musica("Stronger", "Pop", LocalDate.of(2022, 3, 7), "britneyspears", 1.0);
            Musica britneySong8 = new Musica("I'm a Slave 4 U", "Pop", LocalDate.of(2022, 3, 8), "britneyspears", 1.0);
            Musica britneySong9 = new Musica("Piece of Me", "Pop", LocalDate.of(2022, 3, 9), "britneyspears", 1.0);
            Musica britneySong10 = new Musica("Everytime", "Pop", LocalDate.of(2022, 3, 10), "britneyspears", 1.0);

            musico12.getMusicas().addAll(Arrays.asList(britneySong1, britneySong2, britneySong3, britneySong4, britneySong5, britneySong6, britneySong7, britneySong8, britneySong9, britneySong10));
            rockstar.getMusicas().addAll(Arrays.asList(britneySong1, britneySong2, britneySong3, britneySong4, britneySong5, britneySong6, britneySong7, britneySong8, britneySong9, britneySong10));

            
            Musica shakiraSong1 = new Musica("Hips Don't Lie", "Pop", LocalDate.of(2022, 3, 11), "shakira", 1.0);
            Musica shakiraSong2 = new Musica("Waka Waka (This Time for Africa)", "Pop", LocalDate.of(2022, 3, 12), "shakira", 1.0);
            Musica shakiraSong3 = new Musica("Whenever, Wherever", "Pop", LocalDate.of(2022, 3, 13), "shakira", 1.0);
            Musica shakiraSong4 = new Musica("Underneath Your Clothes", "Pop", LocalDate.of(2022, 3, 14), "shakira", 1.0);
            Musica shakiraSong5 = new Musica("She Wolf", "Pop", LocalDate.of(2022, 3, 15), "shakira", 1.0);
            Musica shakiraSong6 = new Musica("La Tortura", "Pop", LocalDate.of(2022, 3, 16), "shakira", 1.0);
            Musica shakiraSong7 = new Musica("Dare (La La La)", "Pop", LocalDate.of(2022, 3, 17), "shakira", 1.0);
            Musica shakiraSong8 = new Musica("Loca", "Pop", LocalDate.of(2022, 3, 18), "shakira", 1.0);
            Musica shakiraSong9 = new Musica("Don't Bother", "Pop", LocalDate.of(2022, 3, 19), "shakira", 1.0);
            Musica shakiraSong10 = new Musica("Can't Remember to Forget You", "Pop", LocalDate.of(2022, 3, 20), "shakira", 1.0);

            musico13.getMusicas().addAll(Arrays.asList(shakiraSong1, shakiraSong2, shakiraSong3, shakiraSong4, shakiraSong5, shakiraSong6, shakiraSong7, shakiraSong8, shakiraSong9, shakiraSong10));
            rockstar.getMusicas().addAll(Arrays.asList(shakiraSong1, shakiraSong2, shakiraSong3, shakiraSong4, shakiraSong5, shakiraSong6, shakiraSong7, shakiraSong8, shakiraSong9, shakiraSong10));

            Musica drakeSong1 = new Musica("Hotline Bling", "Hip Hop", LocalDate.of(2022, 4, 1), "drake", 1.0);
            Musica drakeSong2 = new Musica("In My Feelings", "Hip Hop", LocalDate.of(2022, 4, 2), "drake", 1.0);
            Musica drakeSong3 = new Musica("God's Plan", "Hip Hop", LocalDate.of(2022, 4, 3), "drake", 1.0);
            Musica drakeSong4 = new Musica("Started From the Bottom", "Hip Hop", LocalDate.of(2022, 4, 4), "drake", 1.0);
            Musica drakeSong5 = new Musica("Tootsie Slide", "Hip Hop", LocalDate.of(2022, 4, 5), "drake", 1.0);
            Musica drakeSong6 = new Musica("One Dance", "Hip Hop", LocalDate.of(2022, 4, 6), "drake", 1.0);
            Musica drakeSong7 = new Musica("Nice for What", "Hip Hop", LocalDate.of(2022, 4, 7), "drake", 1.0);
            Musica drakeSong8 = new Musica("Worst Behavior", "Hip Hop", LocalDate.of(2022, 4, 8), "drake", 1.0);
            Musica drakeSong9 = new Musica("Nonstop", "Hip Hop", LocalDate.of(2022, 4, 9), "drake", 1.0);
            Musica drakeSong10 = new Musica("To My Bed", "Hip Hop", LocalDate.of(2022, 4, 10), "drake", 1.0);

            musico4.getMusicas().addAll(Arrays.asList(drakeSong1, drakeSong2, drakeSong3, drakeSong4, drakeSong5, drakeSong6, drakeSong7, drakeSong8, drakeSong9, drakeSong10));
            rockstar.getMusicas().addAll(Arrays.asList(drakeSong1, drakeSong2, drakeSong3, drakeSong4, drakeSong5, drakeSong6, drakeSong7, drakeSong8, drakeSong9, drakeSong10));

// Add Musicas for Ariana Grande
            Musica arianaSong1 = new Musica("Thank U, Next", "Pop", LocalDate.of(2022, 4, 11), "arianagrande", 1.0);
            Musica arianaSong2 = new Musica("7 Rings", "Pop", LocalDate.of(2022, 4, 12), "arianagrande", 1.0);
            Musica arianaSong3 = new Musica("No Tears Left to Cry", "Pop", LocalDate.of(2022, 4, 13), "arianagrande", 1.0);
            Musica arianaSong4 = new Musica("Into You", "Pop", LocalDate.of(2022, 4, 14), "arianagrande", 1.0);
            Musica arianaSong5 = new Musica("Dangerous Woman", "Pop", LocalDate.of(2022, 4, 15), "arianagrande", 1.0);
            Musica arianaSong6 = new Musica("Side to Side", "Pop", LocalDate.of(2022, 4, 16), "arianagrande", 1.0);
            Musica arianaSong7 = new Musica("Break Free", "Pop", LocalDate.of(2022, 4, 17), "arianagrande", 1.0);
            Musica arianaSong8 = new Musica("God is a Woman", "Pop", LocalDate.of(2022, 4, 18), "arianagrande", 1.0);
            Musica arianaSong9 = new Musica("Breathin", "Pop", LocalDate.of(2022, 4, 19), "arianagrande", 1.0);
            Musica arianaSong10 = new Musica("The Way", "Pop", LocalDate.of(2022, 4, 20), "arianagrande", 1.0);

            musico5.getMusicas().addAll(Arrays.asList(arianaSong1, arianaSong2, arianaSong3, arianaSong4, arianaSong5, arianaSong6, arianaSong7, arianaSong8, arianaSong9, arianaSong10));
            rockstar.getMusicas().addAll(Arrays.asList(arianaSong1, arianaSong2, arianaSong3, arianaSong4, arianaSong5, arianaSong6, arianaSong7, arianaSong8, arianaSong9, arianaSong10));
            rockstar.getUtilizadores().add(musico4);
            rockstar.getUtilizadores().add(musico5);
            rockstar.getUtilizadores().add(musico6);
            rockstar.getUtilizadores().add(musico7);
            rockstar.getUtilizadores().add(musico8);
            rockstar.getUtilizadores().add(musico9);
            rockstar.getUtilizadores().add(musico10);
            rockstar.getUtilizadores().add(musico11);
            rockstar.getUtilizadores().add(musico12);
            rockstar.getUtilizadores().add(musico13);



            // U2 Songs
            Musica u2Song1 = new Musica("With or Without You", "Rock", LocalDate.of(2022, 1, 11), "u2", 1.0);
            Musica u2Song2 = new Musica("Beautiful Day", "Rock", LocalDate.of(2022, 1, 12), "u2", 1.0);
            Musica u2Song3 = new Musica("Sunday Bloody Sunday", "Rock", LocalDate.of(2022, 1, 13), "u2", 1.0);
            Musica u2Song4 = new Musica("Where the Streets Have No Name", "Rock", LocalDate.of(2022, 1, 14), "u2", 1.0);
            Musica u2Song5 = new Musica("Vertigo", "Rock", LocalDate.of(2022, 1, 15), "u2", 1.0);
            Musica u2Song6 = new Musica("I Still Haven't Found What I'm Looking For", "Rock", LocalDate.of(2022, 1, 16), "u2", 1.0);
            Musica u2Song7 = new Musica("New Year's Day", "Rock", LocalDate.of(2022, 1, 17), "u2", 1.0);
            Musica u2Song8 = new Musica("Pride (In the Name of Love)", "Rock", LocalDate.of(2022, 1, 18), "u2", 1.0);
            Musica u2Song9 = new Musica("One", "Rock", LocalDate.of(2022, 1, 19), "u2", 1.0);
            Musica u2Song10 = new Musica("Where the Streets Have No Name", "Rock", LocalDate.of(2022, 1, 20), "u2", 1.0);

// Metallica Songs
            Musica metallicaSong1 = new Musica("Enter Sandman", "Rock", LocalDate.of(2022, 1, 31), "metallica", 1.0);
            Musica metallicaSong2 = new Musica("Master of Puppets", "Rock", LocalDate.of(2022, 2, 1), "metallica", 1.0);
            Musica metallicaSong3 = new Musica("Nothing Else Matters", "Rock", LocalDate.of(2022, 2, 2), "metallica", 1.0);
            Musica metallicaSong4 = new Musica("The Unforgiven", "Rock", LocalDate.of(2022, 2, 3), "metallica", 1.0);
            Musica metallicaSong5 = new Musica("Sad But True", "Rock", LocalDate.of(2022, 2, 4), "metallica", 1.0);
            Musica metallicaSong6 = new Musica("For Whom the Bell Tolls", "Rock", LocalDate.of(2022, 2, 5), "metallica", 1.0);
            Musica metallicaSong7 = new Musica("Fade to Black", "Rock", LocalDate.of(2022, 2, 6), "metallica", 1.0);
            Musica metallicaSong8 = new Musica("Whiskey in the Jar", "Rock", LocalDate.of(2022, 2, 7), "metallica", 1.0);
            Musica metallicaSong9 = new Musica("The Day That Never Comes", "Rock", LocalDate.of(2022, 2, 8), "metallica", 1.0);
            Musica metallicaSong10 = new Musica("Seek & Destroy", "Rock", LocalDate.of(2022, 2, 9), "metallica", 1.0);

// Add U2 songs to musico9's array of musicas and rockstar's array of musicas
            musico9.getMusicas().addAll(Arrays.asList(u2Song1, u2Song2, u2Song3, u2Song4, u2Song5, u2Song6, u2Song7, u2Song8, u2Song9, u2Song10));
            rockstar.getMusicas().addAll(Arrays.asList(u2Song1, u2Song2, u2Song3, u2Song4, u2Song5, u2Song6, u2Song7, u2Song8, u2Song9, u2Song10));

            musico11.getMusicas().addAll(Arrays.asList(metallicaSong1, metallicaSong2, metallicaSong3, metallicaSong4, metallicaSong5, metallicaSong6, metallicaSong7, metallicaSong8, metallicaSong9, metallicaSong10));
            rockstar.getMusicas().addAll(Arrays.asList(metallicaSong1, metallicaSong2, metallicaSong3, metallicaSong4, metallicaSong5, metallicaSong6, metallicaSong7, metallicaSong8, metallicaSong9, metallicaSong10));



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




