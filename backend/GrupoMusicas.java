package backend;

import java.io.Serializable;
import java.util.ArrayList;

public class GrupoMusicas implements Serializable {
    private String owner;
    private String titulo;
    private ArrayList<Musica> musicas;

    public GrupoMusicas(String owner, String titulo) {
        this.owner = owner;
        this.titulo = titulo;
        this.musicas=new ArrayList<>();
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }
    public void addMusica(Musica musica){
        musicas.add(musica);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getOwner() {
        return owner;
    }
}

