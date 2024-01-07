package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

public class Compra implements Serializable {
    private LocalDate data;
    private HashMap<String,Double> musicas;
    private Promo promo;

    public Compra(){
        this.data=LocalDate.now();
        this.musicas=new HashMap<>();
        this.promo=null;
    }

    public LocalDate getData() {
        return data;
    }

    public HashMap<String,Double> getMusicas() {
        return musicas;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }
}
