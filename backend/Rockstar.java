package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Rockstar implements Serializable {
    private ArrayList<Utilizador> utilizadores;
    private ArrayList<GrupoMusicas> grupoMusicas;
    private ArrayList<Musica> musicas;
    private ArrayList<Promo> promos;

    public Rockstar() {
        this.utilizadores=new ArrayList<>();
        this.grupoMusicas =new ArrayList<>();
        this.musicas=new ArrayList<>();
        this.promos= new ArrayList<>();
    }
    public Utilizador login(String username, String password){
        for (Utilizador n : getUtilizadores()){
            if(n.getUsername().equals(username) && n.getPassword().equals(password)){
                return n;
            }
        }
        return null;
    }

    public ArrayList<Utilizador> getUtilizadores() {
        return utilizadores;
    }
    public void addPlaylistGenero(Cliente cliente,String genero,int num, String titulo){
        Playlist nova =cliente.criaPlaylistGenero(genero,num,titulo);
        this.grupoMusicas.add(nova);

    }
    public void addPromo (Admin admin, int cupoes, String nome, double desconto, LocalDate dataInicio, LocalDate dataFim){
        Promo promo = admin.criaPromo(cupoes, nome, desconto, dataInicio, dataFim);
        this.promos.add(promo);

    }

    public void registo (Utilizador a) {
        utilizadores.add(a);
    }
}
