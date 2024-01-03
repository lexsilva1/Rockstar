package backend;

import GUI.FramePrincipal;

import javax.swing.*;
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
        for (Utilizador n : utilizadores){
            if(n.getUsername().equals(username) && n.getPassword().equals(password)){
                return n;
            }
        }
        return null;
    }

    public Utilizador loginMusico (String username, String password, String pin){
        for (Utilizador n : utilizadores) {
            if (n instanceof Musico) {
                if(n.getUsername().equals(username) && n.getPassword().equals(password) && ((Musico) n).getPin().equals(pin)){
                    return n;
                }
            }
        }
        return null;
    }

    public ArrayList<Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void addGrupoDeMusicas(GrupoMusicas grupoMusicas){
        this.grupoMusicas.add(grupoMusicas);
    }

    public void addPromo (Admin admin, int cupoes, String nome, double desconto, LocalDate dataInicio, LocalDate dataFim){
        Promo promo = admin.criaPromo(cupoes, nome, desconto, dataInicio, dataFim);
        this.promos.add(promo);
    }

    public void registo (Utilizador a) {
        utilizadores.add(a);
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }
}
