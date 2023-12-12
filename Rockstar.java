import java.util.ArrayList;

public class Rockstar {
    private ArrayList<Utilizador> utilizadores;
    private ArrayList<Album> albuns;
    private ArrayList<Musica> musicas;

    public Rockstar() {
        this.utilizadores=new ArrayList<>();
        this.albuns=new ArrayList<>();
        this.musicas=new ArrayList<>();
    }
    public Utilizador login(String username, String password){
        boolean login = false;
        for (Utilizador n : getUtilizadores()){
            if(n.getUsername().equals(username) && n.getPassword().equals(password)){
                login = true;
                return n;
            }
        }
        return null;
    }

    public ArrayList<Utilizador> getUtilizadores() {
        return utilizadores;
    }
    public void adPlaylistGenero(Cliente cliente,String genero,int num, String titulo){
        Playlist nova =cliente.criaPlaylistGenero(genero,num,titulo);
        this.albuns.add(nova);

    }
}
