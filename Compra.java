import java.time.LocalDate;
import java.util.ArrayList;

public class Compra {
    private LocalDate data;
    private ArrayList<Musica> musicas;

    public Compra() {
        this.data=LocalDate.now();
        this.musicas=new ArrayList<>();
    }

    public LocalDate getData() {
        return data;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }
}
