package backend;

public class Playlist extends Album{
    private boolean publico;

    public Playlist(String owner, String titulo) {
        super(owner, titulo);
        this.publico = true;

    }

    public Playlist(String owner, String titulo, String genero) {
        super(owner, titulo);
        this.publico = true;
        setGenero(genero);

    }

}
