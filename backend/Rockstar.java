package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

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

    public double valorMusicas() {
        double total = 0;
        for (Musica m : musicas) {
            total += m.getPreco();
        }
        return total;
    }

    public void registo (Utilizador a) {
        utilizadores.add(a);
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public ArrayList<Promo> getPromos() {
        return promos;
    }

    public ArrayList<GrupoMusicas> getGrupoMusicas() {
        return grupoMusicas;
    }

    public double valorVendas () {
        double total = 0;
        for (Utilizador c : utilizadores) {
            if (c instanceof Cliente) {
                for(Compra k : ((Cliente) c).getHistoricoCompras()) {
                    for (Map.Entry<Musica, Double> entry : k.getMusicas().entrySet()) {
                        total += entry.getValue();
                    }
                }
            }
        }
        return total;
    }

    public int albunsRock () {
        ArrayList<Album> total = new ArrayList<>();
        for (GrupoMusicas g : grupoMusicas) {
            if (g instanceof Album && ((Album) g).getGenero().equalsIgnoreCase("Rock")) {
                total.add((Album) g);
            }
        }
        return total.size();
    }

    public int albunsPimba () {
        ArrayList<Album> total = new ArrayList<>();
        for (GrupoMusicas g : grupoMusicas) {
            if (g instanceof Album && ((Album) g).getGenero().equalsIgnoreCase("Pimba")) {
                total.add((Album) g);
            }
        }
        return total.size();
    }
    public int albunsHipHop () {
        ArrayList<Album> total = new ArrayList<>();
        for (GrupoMusicas g : grupoMusicas) {
            if (g instanceof Album && ((Album) g).getGenero().equalsIgnoreCase("Hip Hop")) {
                total.add((Album) g);
            }
        }
        return total.size();
    }

    public int albunsPop () {
        ArrayList<Album> total = new ArrayList<>();
        for (GrupoMusicas g : grupoMusicas) {
            if (g instanceof Album && ((Album) g).getGenero().equalsIgnoreCase("Pop")) {
                total.add((Album) g);
            }
        }
        return total.size();
    }

    public String musicaMaiorRating () {
        Musica musica = musicas.getFirst();

        for (Musica m : musicas) {
            if (m.calculoRating() > musica.calculoRating()) {
                musica = m;
            }
        }
        return musica.getTitulo()+ " - " + musica.getAutor();
    }
    public int numeroUtilizadoresMusicas(Musico musico){
        boolean stoploop;
        int clientes=0;
        for(Utilizador c : utilizadores){
            stoploop = true;
            if(c instanceof Cliente){
                if (((Cliente) c).getMusicas().isEmpty()) {
                    stoploop = false;
                }
                    while(stoploop) {
                        for (Musica m : ((Cliente) c).getMusicas()) {
                            if (m.getAutor().equals(musico.getUsername())) {
                                clientes++;
                                stoploop = false;
                            }
                            if(m.equals(((Cliente) c).getMusicas().getLast())) {
                                stoploop = false;
                            }
                        }
                    }
                }
            }
        return clientes;
    }
}
