import java.util.ArrayList;

public class Album {
    private String owner;
    private String titulo;
    private ArrayList<Musica> musicas;
    private String genero;

    public Album(String owner, String titulo) {
        this.owner = owner;
        this.titulo = titulo;
        this.musicas=new ArrayList<>();
        this.genero=null;

    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
