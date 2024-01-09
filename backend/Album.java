package backend;

public class Album extends GrupoMusicas{
    private String genero;
    private int numFaixas;

    /**
     * Os objectos da classe Album, possuem um número de faixas e um género de entre os quatro definidos no programa.
     * @param owner
     * @param titulo
     * @param genero
     * @param numFaixas
     */
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


