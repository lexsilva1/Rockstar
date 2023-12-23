package backend;

import java.util.ArrayList;

public class Album extends GrupoMusicas{
    private String genero;

    public Album(String owner, String titulo, String genero) {
        super(owner, titulo);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }
}

