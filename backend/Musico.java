package backend;

import GUI.FramePrincipal;

import java.time.LocalDate;
import java.util.ArrayList;

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


    public void inactivaMusica(Musica musica, boolean activo) {
        for (Musica m : musicas) {
            if (m.equals(musica) && this.username.equals(musica.getAutor())) {
                musica.inactiva(activo);
            }
        }
    }

    public void actualizaTitulo(Musica musica, String titulo) {
        for (Musica m : musicas) {
            if (m.equals(musica) && this.username.equals(musica.getAutor())) {
                musica.setTitulo(titulo);
                System.out.println("Titulo alterado");
            }
        }
    }


    public void actualizaPreco(Musica musica, Double preco) {
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

    public void criaAlbum(String owner, String titulo, String genero, int numFaixas) {
        Album album = new Album(owner, titulo, genero, numFaixas);
        this.albuns.add(album);
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

    public Album procurarAlbum (String titulo) {
        for (Album a : albuns) {
            if (a.getTitulo().equalsIgnoreCase(titulo)) {
                return a;
            }
        }
        return null;
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

    public boolean musicaExiste (String titulo) {
        for (Musica m : musicas) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }
}

