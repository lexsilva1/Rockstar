package backend;

import java.util.ArrayList;

public class Album extends GrupoMusicas{
    private String genero;
    private int numFaixas;

    public Album(String owner, String titulo, String genero, int numFaixas) {
        super(owner, titulo);
        this.genero = genero;
        this.numFaixas = numFaixas;
    }

    public String getGenero() {
        return genero;
    }

    public int getNumFaixas() {
        return numFaixas;
    }
}


