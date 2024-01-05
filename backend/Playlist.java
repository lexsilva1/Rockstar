package backend;

import java.util.Iterator;

public class Playlist extends GrupoMusicas  {
    private boolean publico;

    public Playlist(String owner, String titulo) {
        super(owner, titulo);
        this.publico = true;



    }

    public boolean isPublico() {
        return publico;
    }

    public void setPublico() {
        this.publico = !this.publico;
    }
}
