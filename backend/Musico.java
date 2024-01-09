package backend;

import GUI.FramePrincipal;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe que herda da classe <code>Utilizador</code>
 * Possui a particularidade de criar objectos <code>Album</code>,<code>Musica</code> e é o único <code>Utilizador</code>
 * que pode alterar parâmetros de <code>Musica</code>
 */
public class Musico extends Utilizador {
    private ArrayList<Musica> musicas;
    private ArrayList<Album> albuns;
    private String pin;

    public Musico(String username, String password, String pin) {
        super(username, password);
        this.pin = pin;
        this.musicas = new ArrayList<>();
        this.albuns = new ArrayList<>();
    }

    public void inativaMusica(Musica musica, boolean activo) {
        for (Musica m : musicas) {
            if (m.equals(musica) && this.username.equals(musica.getAutor())) {
                musica.inativa(activo);
            }
        }
    }

    public void atualizaTitulo(Musica musica, String titulo) {
        for (Musica m : musicas) {
            if (m.equals(musica) && this.username.equals(musica.getAutor())) {
                musica.setTitulo(titulo);
                System.out.println("Titulo alterado");
            }
        }
    }

    public void atualizaPreco(Musica musica, Double preco) {
        for (Musica m : musicas) {
            if (m.equals(musica) && this.username.equals(musica.getAutor())) {
                musica.alterarPreco(preco);
            }
        }
    }

    public Musica criaMusica(String titulo, String genero, LocalDate data, double valor) {
        Musica musica = new Musica(titulo, genero, data, this.username, valor);
        this.musicas.add(musica);
        return musica;
    }

    public void criaAlbum(FramePrincipal framePrincipal, String owner, String titulo, String genero, int numFaixas) {
        Album album = new Album(owner, titulo, genero, numFaixas);
        this.albuns.add(album);
        framePrincipal.getRockstar().addGrupoDeMusicas(album);
    }

    public boolean addMusicaAoAlbum(Album album, Musica musica) {
        int faixasNoAlbum = 0;

        for (Musica m : album.getMusicas()) {
            faixasNoAlbum++;
        }

        if (faixasNoAlbum < album.getNumFaixas()) {
            album.addMusica(musica);
            return true;
        }
        return false;
    }

    public boolean musicaExiste (String titulo) {
        for (Musica m : musicas) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }

    public boolean albumExiste (String titulo) {
        for (Album a : albuns) {
            if (a.getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }

    public String getPin() {
        return pin;
    }

    public ArrayList<Album> getAlbuns() {
        return albuns;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }
}

