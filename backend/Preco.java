package backend;

import java.time.LocalDate;

public class Preco {
    private double preco;
    private LocalDate data;

    public Preco(double preco) {
        this.preco = preco;
        this.data=LocalDate.now();
    }

    public double getPreco() {
        return preco;
    }

    public LocalDate getData() {
        return data;
    }
}
