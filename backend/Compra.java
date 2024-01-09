package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

public class Compra implements Serializable {
    private LocalDate data;
    private HashMap<Musica,Double> musicas;
    private Promo promo;

    /**
     * Esta classe representa a compra efectuada pelo cliente. A cada compra está associada uma data.
     * Guarda também os dados da música comprada, com o preço efectivamente pago pelo cliente por cada música.
     */
    public Compra(){
        this.data=LocalDate.now();
        this.musicas=new HashMap<>();
        this.promo=null;
    }

    public LocalDate getData() {
        return data;
    }

    /**
     *Devolve um mapa das músicas e do valor pago por cada uma na compra.
     *
     * @return <code>HashMap</code> que contém todas as músicas e os seus preços correspondentes.
     */
    public HashMap<Musica,Double> getMusicas() {
        return musicas;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }
}
