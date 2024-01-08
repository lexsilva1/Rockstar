package backend;

public class Playlist extends GrupoMusicas  {
    private boolean publico;

    /**
     * Ao contrário do <code>Album</code> objectos desta classe não possuem atributo género
     * No entanto podem ser públicas ou provadas, consoante a opção do seu criador
     * @param owner
     * @param titulo
     */
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
