import java.util.ArrayList;

public class Album {
    private String owner;
    private String titulo;
    private ArrayList<Musica> musicas;

    public Album(String owner, String titulo) {
        this.owner = owner;
        this.titulo = titulo;
        this.musicas=new ArrayList<>();

    }
}
