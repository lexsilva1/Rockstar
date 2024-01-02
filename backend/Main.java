package backend;

import GUI.FramePrincipal;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        FramePrincipal frame = new FramePrincipal();
        frame.setVisible(true);

/*       Admin admin = new Admin("toy","password");
        Cliente cliente = new Cliente("joaosilva","password");
        Musico musico = new Musico("inesisabel","password","1234");

       Rockstar rockstar = new Rockstar();

        rockstar.getUtilizadores().add(admin);
        rockstar.getUtilizadores().add(cliente);
        rockstar.getUtilizadores().add(musico);

     Rockstar rockstar = null;

        try {
            FileInputStream fileIn = new FileInputStream("Rockstar.ser");
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


        for (Utilizador i : rockstar.getUtilizadores()) {
            System.out.println(i.getUsername());

        }

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Rockstar.ser"))) {
            outputStream.writeObject(rockstar);
            System.out.println("Object serialized successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
