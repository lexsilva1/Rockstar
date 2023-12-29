package backend;

import java.time.LocalDate;
import java.util.ArrayList;

public class Musico extends Utilizador{
    private ArrayList<Musica>musicas;
    private String pin;
    public Musico(String username, String password,String pin) {
        super(username, password);
        this.pin = pin;
        this.musicas=new ArrayList<>();
    }
    public void inactivaMusica(Musica musica){
        for ( Musica m : musicas){
            if (m.equals(musica) && this.equals(musica.getAutor())){
                musica.inactiva();
                System.out.println("musica inactivada");
            } else
                System.out.println("a musica não pode ser inactivada por si");
        }
    }
    public void actualizaTitulo(Musica musica, String titulo){
        for ( Musica m : musicas){
            if (m.equals(musica) && this.equals(musica.getAutor())){
                musica.setTitulo(titulo);
            }
        }
    }

    public void actualizaPreco(Musica musica, Double preco){
        for ( Musica m : musicas){
            if (m.equals(musica) && this.equals(musica.getAutor())){
                musica.alterarPreco(preco);
            }
        }
    }

    public String getPin() {
        return pin;
    }
    public Musica criaMusica(String titulo, String genero, LocalDate data, double valor){
        Musica musica = new Musica(titulo,genero,data,this.username,valor);
        this.musicas.add(musica);
        return musica;
    }
}

