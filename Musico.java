import java.util.ArrayList;

public class Musico extends Utilizador{
    private ArrayList<Musica>musicas;
    private String PIN;
    public Musico(String username, String password,String PIN) {
        super(username, password);
        this.PIN=PIN;
        this.musicas=new ArrayList<>();
    }
}
