import java.util.ArrayList;

public class Musico extends Utilizador{
    private ArrayList<Musica>musicas;
    private String PIN;
    public Musico(String username, String password, String nome, String NIF, String email,String PIN) {
        super(username, password, nome, NIF, email);
        this.PIN=PIN;
        this.musicas=new ArrayList<>();
    }
}
