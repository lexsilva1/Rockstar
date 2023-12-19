package backend;

public class Playlist extends GrupoMusicas{
    private boolean publico;

    public Playlist(String owner, String titulo) {
        super(owner, titulo);
        this.publico = true;



    }

}
