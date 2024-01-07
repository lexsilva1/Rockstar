package GUI;
import backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

public class FramePrincipal extends JFrame {
    private Rockstar rockstar;
    protected PainelPrincipal painelPrincipal;
    private final String FILE_PATH = "Rockstar.ser";
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

            Musico musico15 = new Musico("eminem", "password", "1234");
            rockstar.getUtilizadores().add(musico15);
            Musica eminemSong1 = new Musica("Lose Yourself", "Hip Hop", LocalDate.of(2002, 10, 22), "eminem",  2.3);
            Musica eminemSong2 = new Musica("Stan", "Hip Hop", LocalDate.of(2000, 12, 8), "eminem",  2.0);
            Musica eminemSong3 = new Musica("The Real Slim Shady", "Hip Hop", LocalDate.of(2000, 5, 16), "eminem",  0);
            Musica eminemSong4 = new Musica("Not Afraid", "Hip Hop", LocalDate.of(2010, 4, 25), "eminem",  1.0);
            Musica eminemSong5 = new Musica("Mockingbird", "Hip Hop", LocalDate.of(2005, 4, 25), "eminem",  0.5);
            Musica eminemSong6 = new Musica("Rap God", "Hip Hop", LocalDate.of(2013, 10, 15), "eminem",  1.2);
            Musica eminemSong7 = new Musica("Without Me", "Hip Hop", LocalDate.of(2002, 5, 14), "eminem",  1.4);
            Musica eminemSong8 = new Musica("Love The Way You Lie", "Hip Hop", LocalDate.of(2010, 6, 25), "eminem",  0);
            Musica eminemSong9 = new Musica("Beautiful", "Hip Hop", LocalDate.of(2009, 5, 12), "eminem",  0);
            Musica eminemSong10 = new Musica("Guts Over Fear", "Hip Hop", LocalDate.of(2014, 8, 25), "eminem", 1.0);

            musico15.getMusicas().addAll(Arrays.asList(eminemSong1, eminemSong2, eminemSong3, eminemSong4, eminemSong5, eminemSong6, eminemSong7, eminemSong8, eminemSong9, eminemSong10));
            rockstar.getMusicas().addAll(Arrays.asList(eminemSong1, eminemSong2, eminemSong3, eminemSong4, eminemSong5, eminemSong6, eminemSong7, eminemSong8, eminemSong9, eminemSong10));
            Musico musico14 = new Musico("claudisabel", "password", "1234");
            rockstar.getUtilizadores().add(musico14);


            Musica claudisabelSong1 = new Musica("Festa na Aldeia", "Pimba", LocalDate.of(2022, 2, 11), "claudisabel", 1.0);
            Musica claudisabelSong2 = new Musica("Amor à Portuguesa", "Pimba", LocalDate.of(2020, 7, 8), "claudisabel", 0);
            Musica claudisabelSong3 = new Musica("Vira Virou", "Pimba", LocalDate.of(2019, 5, 15), "claudisabel", 1.3);
            Musica claudisabelSong4 = new Musica("Marcha da Sardinha", "Pimba", LocalDate.of(2018, 9, 23), "claudisabel", 1.7);
            Musica claudisabelSong5 = new Musica("Chupa No Dedo", "Pimba", LocalDate.of(1998, 3, 12), "claudisabel", 0.7);
            Musica claudisabelSong6 = new Musica("Fado do Emigrante", "Pimba", LocalDate.of(2016, 11, 30), "claudisabel", 0.8);
            Musica claudisabelSong7 = new Musica("Piriri Pompom", "Pimba", LocalDate.of(2015, 6, 5), "claudisabel", 0);
            Musica claudisabelSong8 = new Musica("Fado da Cerveja", "Pimba", LocalDate.of(2014, 8, 19), "claudisabel", 1.0);
            Musica claudisabelSong9 = new Musica("Quem Não Sabe Ser Português", "Pimba", LocalDate.of(2013, 10, 2), "claudisabel", 1.0);
            Musica claudisabelSong10 = new Musica("Oh Tia", "Pimba", LocalDate.of(2012, 4, 7), "claudisabel", 0);

            musico14.getMusicas().addAll(Arrays.asList(claudisabelSong1, claudisabelSong2, claudisabelSong3, claudisabelSong4, claudisabelSong5, claudisabelSong6, claudisabelSong7, claudisabelSong8, claudisabelSong9, claudisabelSong10));
            rockstar.getMusicas().addAll(Arrays.asList(claudisabelSong1, claudisabelSong2, claudisabelSong3, claudisabelSong4, claudisabelSong5, claudisabelSong6, claudisabelSong7, claudisabelSong8, claudisabelSong9, claudisabelSong10));
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
            Musica katySong1 = new Musica("Firework", "Pop", LocalDate.of(2010, 8, 24), "katyperry", 1.3);
            Musica katySong2 = new Musica("Dark Horse", "Pop", LocalDate.of(2013, 9, 17), "katyperry", 1.2);
            Musica katySong3 = new Musica("Roar", "Pop", LocalDate.of(2013, 8, 10), "katyperry", 2.0);
            Musica katySong4 =  new Musica("California Gurls", "Pop", LocalDate.of(2010, 5, 7), "katyperry", 0.0);
            Musica katySong5 =new Musica("Teenage Dream", "Pop", LocalDate.of(2010, 7, 23), "katyperry", 0.0);
            Musica katySong6 = new Musica("Last Friday Night (T.G.I.F.)", "Pop", LocalDate.of(2011, 6, 6), "katyperry", 2.7);
            Musica katySong7 = new Musica("Hot N Cold", "Pop", LocalDate.of(2008, 9, 26), "katyperry", 1.6);
            Musica katySong8 = new Musica("E.T.", "Pop", LocalDate.of(2011, 2, 16), "katyperry", 1.7);
            Musica katySong9 = new Musica("Part of Me", "Pop", LocalDate.of(2012, 2, 13), "katyperry", 0.0);
            Musica katySong10 = new Musica("Wide Awake", "Pop", LocalDate.of(2012, 5, 22), "katyperry", 0.7);

            musico8.getMusicas().addAll(Arrays.asList(katySong1, katySong2, katySong3, katySong4, katySong5, katySong6, katySong7, katySong8, katySong9, katySong10));
            rockstar.getMusicas().addAll(Arrays.asList(katySong1, katySong2, katySong3, katySong4, katySong5, katySong6, katySong7, katySong8, katySong9, katySong10));
            Musica justinSong1 = new Musica("Baby", "Pop", LocalDate.of(2010, 1, 18), "justinbieber", 1.55);
            Musica justinSong2 = new Musica("Sorry", "Pop", LocalDate.of(2015, 10, 23), "justinbieber", 1.8);
            Musica justinSong3 = new Musica("What Do You Mean?", "Pop", LocalDate.of(2015, 8, 28), "justinbieber", 1.7);
            Musica justinSong4 = new Musica("Love Yourself", "Pop", LocalDate.of(2015, 11, 9), "justinbieber", 1.5);
            Musica justinSong5 = new Musica("Yummy", "Pop", LocalDate.of(2020, 1, 3), "justinbieber", 1.9);
            Musica justinSong6 = new Musica("Intentions", "Pop", LocalDate.of(2020, 2, 7), "justinbieber", 1.2);
            Musica justinSong7 = new Musica("Beauty and a Beat", "Pop", LocalDate.of(2012, 10, 12), "justinbieber", 0);
            Musica justinSong8 = new Musica("As Long As You Love Me", "Pop", LocalDate.of(2012, 6, 11), "justinbieber", 0.5);
            Musica justinSong9 = new Musica("Company", "Pop", LocalDate.of(2016, 3, 8), "justinbieber", 0);
            Musica justinSong10 = new Musica("Never Say Never", "Pop", LocalDate.of(2010, 5, 25), "justinbieber", 1.4);

            musico6.getMusicas().addAll(Arrays.asList(justinSong1, justinSong2, justinSong3, justinSong4, justinSong5, justinSong6, justinSong7, justinSong8, justinSong9, justinSong10));
            rockstar.getMusicas().addAll(Arrays.asList(justinSong1, justinSong2, justinSong3, justinSong4, justinSong5, justinSong6, justinSong7, justinSong8, justinSong9, justinSong10));


            Musica rihannaSong1 = new Musica("Umbrella", "Pop", LocalDate.of(2007, 5, 1), "rihanna", 0);
            Musica rihannaSong2 = new Musica("Diamonds", "Pop", LocalDate.of(2012, 9, 26), "rihanna", 0);
            Musica rihannaSong3 = new Musica("We Found Love", "Pop", LocalDate.of(2011, 9, 22), "rihanna", 0.7);
            Musica rihannaSong4 = new Musica("Work", "Pop", LocalDate.of(2016, 1, 27), "rihanna", 0.75);
            Musica rihannaSong5 = new Musica("Only Girl (In The World)", "Pop", LocalDate.of(2010, 9, 10), "rihanna", 2.3);
            Musica rihannaSong6 = new Musica("Rude Boy", "Pop", LocalDate.of(2010, 2, 19), "rihanna", 1.8);
            Musica rihannaSong7 = new Musica("S&M", "Pop", LocalDate.of(2011, 1, 21), "rihanna", 2.3);
            Musica rihannaSong8 = new Musica("Don't Stop The Music", "Pop", LocalDate.of(2007, 9, 4), "rihanna", 2);
            Musica rihannaSong9 = new Musica("Where Have You Been", "Pop", LocalDate.of(2011, 4, 17), "rihanna", 2.25);
            Musica rihannaSong10 = new Musica("Stay", "Pop", LocalDate.of(2012, 1, 7), "rihanna", 2.5);

            musico7.getMusicas().addAll(Arrays.asList(rihannaSong1, rihannaSong2, rihannaSong3, rihannaSong4, rihannaSong5, rihannaSong6, rihannaSong7, rihannaSong8, rihannaSong9, rihannaSong10));
            rockstar.getMusicas().addAll(Arrays.asList(rihannaSong1, rihannaSong2, rihannaSong3, rihannaSong4, rihannaSong5, rihannaSong6, rihannaSong7, rihannaSong8, rihannaSong9, rihannaSong10));
            Musica britneySong1 = new Musica("Toxic", "Pop", LocalDate.of(2004, 1, 13), "britneyspears", 1.0);
            Musica britneySong2 = new Musica("Baby One More Time", "Pop", LocalDate.of(1998, 10, 23), "britneyspears", 2);
            Musica britneySong3 =  new Musica("Oops!... I Did It Again", "Pop", LocalDate.of(2000, 3, 27), "britneyspears", 0.7);
            Musica britneySong4 = new Musica("Womanizer", "Pop", LocalDate.of(2008, 10, 3), "britneyspears", 1.6);
            Musica britneySong5 = new Musica("Circus", "Pop", LocalDate.of(2008, 12, 2), "britneyspears", 1.3);
            Musica britneySong6 = new Musica("Gimme More", "Pop", LocalDate.of(2007, 8, 31), "britneyspears", 2.9);
            Musica britneySong7 = new Musica("Stronger", "Pop", LocalDate.of(2000, 11, 13), "britneyspears", 2.2);
            Musica britneySong8 = new Musica("I'm a Slave 4 U", "Pop", LocalDate.of(2001, 9, 24), "britneyspears", 1.1);
            Musica britneySong9 = new Musica("Piece of Me", "Pop", LocalDate.of(2007, 11, 27), "britneyspears", 1.0);
            Musica britneySong10 = new Musica("Everytime", "Pop", LocalDate.of(2003, 5, 17), "britneyspears", 0);

            musico12.getMusicas().addAll(Arrays.asList(britneySong1, britneySong2, britneySong3, britneySong4, britneySong5, britneySong6, britneySong7, britneySong8, britneySong9, britneySong10));
            rockstar.getMusicas().addAll(Arrays.asList(britneySong1, britneySong2, britneySong3, britneySong4, britneySong5, britneySong6, britneySong7, britneySong8, britneySong9, britneySong10));


            Musica shakiraSong1 = new Musica("Hips Don't Lie", "Pop", LocalDate.of(2006, 2, 7), "shakira", 1.7);
            Musica shakiraSong2 = new Musica("Waka Waka (This Time for Africa)", "Pop", LocalDate.of(2010, 5, 7), "shakira", 1.45);
            Musica shakiraSong3 = new Musica("Whenever, Wherever", "Pop", LocalDate.of(2001, 8, 27), "shakira", 1.8);
            Musica shakiraSong4 = new Musica("Underneath Your Clothes", "Pop", LocalDate.of(2002, 2, 13), "shakira", 1.0);
            Musica shakiraSong5 = new Musica("She Wolf", "Pop", LocalDate.of(2009, 7, 10), "shakira", 2);
            Musica shakiraSong6 = new Musica("La Tortura", "Pop", LocalDate.of(2005, 4, 12), "shakira", 2.1);
            Musica shakiraSong7 = new Musica("Dare (La La La)", "Pop", LocalDate.of(2014, 5, 7), "shakira", 0);
            Musica shakiraSong8 = new Musica("Loca", "Pop", LocalDate.of(2010, 9, 10), "shakira", 0);
            Musica shakiraSong9 = new Musica("Don't Bother", "Pop", LocalDate.of(2005, 10, 11), "shakira", 1.0);
            Musica shakiraSong10 = new Musica("Can't Remember to Forget You", "Pop", LocalDate.of(2014, 1, 13), "shakira", 1.0);

            musico13.getMusicas().addAll(Arrays.asList(shakiraSong1, shakiraSong2, shakiraSong3, shakiraSong4, shakiraSong5, shakiraSong6, shakiraSong7, shakiraSong8, shakiraSong9, shakiraSong10));
            rockstar.getMusicas().addAll(Arrays.asList(shakiraSong1, shakiraSong2, shakiraSong3, shakiraSong4, shakiraSong5, shakiraSong6, shakiraSong7, shakiraSong8, shakiraSong9, shakiraSong10));

            Musica drakeSong1 = new Musica("Hotline Bling", "Hip Hop", LocalDate.of(2015, 7, 31), "drake", 1.0);
            Musica drakeSong2 = new Musica("In My Feelings", "Hip Hop", LocalDate.of(2018, 7, 10), "drake", 0);
            Musica drakeSong3 = new Musica("God's Plan", "Hip Hop", LocalDate.of(2018, 1, 19), "drake", 1.2);
            Musica drakeSong4 = new Musica("Started From the Bottom", "Hip Hop", LocalDate.of(2013, 2, 1), "drake", 1.6);
            Musica drakeSong5 = new Musica("Tootsie Slide", "Hip Hop", LocalDate.of(2020, 4, 3), "drake", 1.0);
            Musica drakeSong6 = new Musica("One Dance", "Hip Hop", LocalDate.of(2016, 4, 5), "drake", 0);
            Musica drakeSong7 = new Musica("Nice for What", "Hip Hop", LocalDate.of(2018, 4, 6), "drake", 1.0);
            Musica drakeSong8 = new Musica("Worst Behavior", "Hip Hop", LocalDate.of(2013, 9, 24), "drake", 2.0);
            Musica drakeSong9 = new Musica("Nonstop", "Hip Hop", LocalDate.of(2018, 6, 29), "drake", 2.3);
            Musica drakeSong10 = new Musica("To My Bed", "Hip Hop", LocalDate.of(2018, 6, 29), "drake", 1.0);

            musico4.getMusicas().addAll(Arrays.asList(drakeSong1, drakeSong2, drakeSong3, drakeSong4, drakeSong5, drakeSong6, drakeSong7, drakeSong8, drakeSong9, drakeSong10));
            rockstar.getMusicas().addAll(Arrays.asList(drakeSong1, drakeSong2, drakeSong3, drakeSong4, drakeSong5, drakeSong6, drakeSong7, drakeSong8, drakeSong9, drakeSong10));


            Musica arianaSong1 = new Musica("Thank U, Next", "Pop", LocalDate.of(2018, 11, 3), "arianagrande", 2.2);
            Musica arianaSong2 = new Musica("7 Rings", "Pop", LocalDate.of(2019, 1, 18), "arianagrande", 2);
            Musica arianaSong3 = new Musica("No Tears Left to Cry", "Pop", LocalDate.of(2018, 4, 20), "arianagrande", 1.7);
            Musica arianaSong4 = new Musica("Into You", "Pop", LocalDate.of(2016, 5, 6), "arianagrande", 1.5);
            Musica arianaSong5 = new Musica("Dangerous Woman", "Pop", LocalDate.of(2016, 3, 11), "arianagrande", 1.0);
            Musica arianaSong6 = new Musica("Side to Side", "Pop", LocalDate.of(2016, 8, 30), "arianagrande", 0.0);
            Musica arianaSong7 = new Musica("Break Free", "Pop", LocalDate.of(2014, 7, 2), "arianagrande", 0.0);
            Musica arianaSong8 = new Musica("God is a Woman", "Pop", LocalDate.of(2018, 7, 13), "arianagrande", 1.0);
            Musica arianaSong9 = new Musica("Breathin", "Pop", LocalDate.of(2018, 8, 17), "arianagrande", 0.7);
            Musica arianaSong10 = new Musica("The Way", "Pop", LocalDate.of(2013, 3, 26), "arianagrande", 0.8);

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

            Musico musico16 = new Musico("ironmaiden", "password", "1234");
            rockstar.getUtilizadores().add(musico16);

            Musica ironmaidenSong1 = new Musica("The Trooper", "Rock", LocalDate.of(1983, 5, 20), "ironmaiden", 1.5);
            Musica ironmaidenSong2 = new Musica("Fear of the Dark", "Rock", LocalDate.of(1992, 5, 11), "ironmaiden", 1.8);
            Musica ironmaidenSong3 = new Musica("Run to the Hills", "Rock", LocalDate.of(1982, 2, 12), "ironmaiden", 1.7);
            Musica ironmaidenSong4 = new Musica("Hallowed Be Thy Name", "Rock", LocalDate.of(1982, 3, 20), "ironmaiden", 2.0);
            Musica ironmaidenSong5 = new Musica("Wasted Years", "Rock", LocalDate.of(1986, 9, 6), "ironmaiden", 1.2);
            Musica ironmaidenSong6 = new Musica("Number of the Beast", "Rock", LocalDate.of(1982, 3, 29), "ironmaiden", 1.0);
            Musica ironmaidenSong7 = new Musica("Aces High", "Rock", LocalDate.of(1984, 10, 22), "ironmaiden", 0.9);
            Musica ironmaidenSong8 = new Musica("Phantom of the Opera", "Rock", LocalDate.of(1980, 4, 14), "ironmaiden", 1.3);
            Musica ironmaidenSong9 = new Musica("The Wicker Man", "Rock", LocalDate.of(2000, 5, 8), "ironmaiden", 1.1);
            Musica ironmaidenSong10 = new Musica("2 Minutes to Midnight", "Rock", LocalDate.of(1984, 8, 6), "ironmaiden", 1.4);

            musico16.getMusicas().addAll(Arrays.asList(ironmaidenSong1, ironmaidenSong2, ironmaidenSong3, ironmaidenSong4, ironmaidenSong5, ironmaidenSong6, ironmaidenSong7, ironmaidenSong8, ironmaidenSong9, ironmaidenSong10));
            rockstar.getMusicas().addAll(Arrays.asList(ironmaidenSong1, ironmaidenSong2, ironmaidenSong3, ironmaidenSong4, ironmaidenSong5, ironmaidenSong6, ironmaidenSong7, ironmaidenSong8, ironmaidenSong9, ironmaidenSong10));



            Musica u2Song1 = new Musica("With or Without You", "Rock", LocalDate.of(1987, 3, 16), "u2", 2);
            Musica u2Song2 = new Musica("Beautiful Day", "Rock", LocalDate.of(2000, 10, 9), "u2", 2.2);
            Musica u2Song3 = new Musica("Sunday Bloody Sunday", "Rock", LocalDate.of(1983, 3, 21), "u2", 2.6);
            Musica u2Song4 = new Musica("Where the Streets Have No Name", "Rock", LocalDate.of(1987, 3, 20), "u2", 1.7);
            Musica u2Song5 = new Musica("Vertigo", "Rock", LocalDate.of(2004, 11, 8), "u2", 0);
            Musica u2Song6 = new Musica("I Still Haven't Found What I'm Looking For", "Rock", LocalDate.of(1987, 5, 25), "u2", 1.1);
            Musica u2Song7 = new Musica("New Year's Day", "Rock", LocalDate.of(1983, 1, 10), "u2", 0);
            Musica u2Song8 = new Musica("Pride (In the Name of Love)", "Rock", LocalDate.of(1984, 9, 3), "u2", 1.3);
            Musica u2Song9 = new Musica("One", "Rock", LocalDate.of(1991, 3, 6), "u2", 1.0);
            Musica u2Song10 = new Musica("Where the Streets Have No Name", "Rock", LocalDate.of(1987, 11, 23), "u2", 1.0);


            Musica metallicaSong1 = new Musica("Enter Sandman", "Rock", LocalDate.of(1991, 7, 29), "metallica", 1.7);
            Musica metallicaSong2 = new Musica("Master of Puppets", "Rock", LocalDate.of(1986, 2, 24), "metallica", 1.9);
            Musica metallicaSong3 = new Musica("Nothing Else Matters", "Rock", LocalDate.of(1992, 4, 20), "metallica", 0.75);
            Musica metallicaSong4 = new Musica("The Unforgiven", "Rock", LocalDate.of(1991, 10, 28), "metallica", 0.6);
            Musica metallicaSong5 = new Musica("Sad But True", "Rock", LocalDate.of(1993, 2, 8), "metallica", 0);
            Musica metallicaSong6 = new Musica("For Whom the Bell Tolls", "Rock", LocalDate.of(1984, 8, 31), "metallica", 2.0);
            Musica metallicaSong7 = new Musica("Fade to Black", "Rock", LocalDate.of(1984, 11, 24), "metallica", 2.7);
            Musica metallicaSong8 = new Musica("Whiskey in the Jar", "Rock", LocalDate.of(1999, 11, 8), "metallica", 0);
            Musica metallicaSong9 = new Musica("The Day That Never Comes", "Rock", LocalDate.of(2008, 8, 20), "metallica", 1.0);
            Musica metallicaSong10 = new Musica("Seek & Destroy", "Rock", LocalDate.of(1983, 7, 25), "metallica", 1.0);

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
            Cliente cliente2 = new Cliente("mariasantos", "password");
            rockstar.getUtilizadores().add(cliente2);
            Cliente cliente3 = new Cliente("pedrofonseca", "password");
            rockstar.getUtilizadores().add(cliente3);
            Cliente cliente4 = new Cliente("anapereira", "password");
            rockstar.getUtilizadores().add(cliente4);
            Cliente cliente5 = new Cliente("ricardosousa", "password");
            rockstar.getUtilizadores().add(cliente5);
            Cliente cliente6 = new Cliente("ineslopes", "password");
            rockstar.getUtilizadores().add(cliente6);
            Cliente cliente7 = new Cliente("luisoliveira", "password");
            rockstar.getUtilizadores().add(cliente7);
            Cliente cliente8 = new Cliente("carlamartins", "password");
            rockstar.getUtilizadores().add(cliente8);
            Cliente cliente9 = new Cliente("andrepires", "password");
            rockstar.getUtilizadores().add(cliente9);
            Cliente cliente10 = new Cliente("sofiacarvalho", "password");
            rockstar.getUtilizadores().add(cliente10);
            Cliente cliente11 = new Cliente("joanarodrigues", "password");
            rockstar.getUtilizadores().add(cliente11);
            Cliente cliente12 = new Cliente("tiagomachado", "password");
            rockstar.getUtilizadores().add(cliente12);
            Cliente cliente13 = new Cliente("susanasilva", "password");
            rockstar.getUtilizadores().add(cliente13);
            Cliente cliente14 = new Cliente("pedrosantos", "password");
            rockstar.getUtilizadores().add(cliente14);
            Cliente cliente15 = new Cliente("danielamoreira", "password");
            rockstar.getUtilizadores().add(cliente15);
            Cliente cliente16 = new Cliente("ricardocarvalho", "password");
            rockstar.getUtilizadores().add(cliente16);
            Cliente cliente17 = new Cliente("carlosribeiro", "password");
            rockstar.getUtilizadores().add(cliente17);
            Cliente cliente18 = new Cliente("margaridagomes", "password");
            rockstar.getUtilizadores().add(cliente18);
            Cliente cliente19 = new Cliente("hugomartins", "password");
            rockstar.getUtilizadores().add(cliente19);
            Cliente cliente20 = new Cliente("cristinamendes", "password");
            rockstar.getUtilizadores().add(cliente20);
            rockstar.addPromo(admin,999,"Desconto Boas Vindas",15,LocalDate.of(2023,12,15),LocalDate.of(2024,12,31));
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




