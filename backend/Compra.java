package backend;

import java.time.LocalDate;
import java.util.ArrayList;

public class Compra {
    private LocalDate data;
    private ArrayList<Musica> musicas;
    private Promo promo;

    public Compra() {
        this.data=LocalDate.now();
        this.musicas=new ArrayList<>();
        this.promo=null;
    }

    public LocalDate getData() {
        return data;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }
}
