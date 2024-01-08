package backend;

import java.io.Serializable;
import java.time.LocalDate;

public class Preco implements Serializable {
    private double preco;
    private LocalDate data;

    /**
     * Cria um objecto <code>Preco</code> que corresponde a um valor numerico na data da criação
     * @param preco é o valor numerico da Musica
     */
    public Preco(double preco) {
        this.preco = preco;
        this.data = LocalDate.now();
    }

    public double getPreco() {
        return preco;
    }

    public LocalDate getData() {
        return data;
    }
}
