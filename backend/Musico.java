package backend;

import java.util.ArrayList;

public class Musico extends Utilizador{
    private ArrayList<Musica>musicas;
    private String PIN;
    public Musico(String username, String password,String PIN) {
        super(username, password);
        this.PIN=PIN;
        this.musicas=new ArrayList<>();
    }
    public void inactivaMusica(Musica musica){
        for ( Musica m : musicas){
            if (m.equals(musica) && this.equals(musica.getAutor())){
                musica.inactiva();
                System.out.println("musica inactivada");
            } else
                System.out.println("a musica não pode ser inactivada por si");
        }
    }
    public void actualizaTitulo(Musica musica, String titulo){
        for ( Musica m : musicas){
            if (m.equals(musica) && this.equals(musica.getAutor())){
                musica.setTitulo(titulo);
                System.out.println("Titulo alterado");
            } else
                System.out.println("a musica não pode ser alterada por si");
        }
    }
}
}
