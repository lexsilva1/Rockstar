package backend;

import java.io.Serializable;
import java.util.ArrayList;

public class GrupoMusicas implements Serializable {
    private String owner;
    private String titulo;
    private ArrayList<Musica> musicas;

    /**
     * Todos os objectos GrupoMusicas necessitam de uma String owner, que será o username de quem cria o objecto
     * e um titulo que será o nome apresentado do objecto criado. Possuem tb um ArrayList de objectos Musica.
     * @param owner
     * @param titulo
     */
    public GrupoMusicas(String owner, String titulo) {
        this.owner = owner;
        this.titulo = titulo;
        this.musicas=new ArrayList<>();
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

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }
    @Override
    public String toString() {
        return titulo;
    }
}

