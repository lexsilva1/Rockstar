import java.time.LocalDate;
import java.util.ArrayList;

public class Promo {
    int cupoes;
    String nome;
    double desconto;
    LocalDate dataInicio;
    LocalDate dataFim;
    ArrayList<String> clientes;

    public Promo(int cupoes, String nome, double desconto, LocalDate dataInicio, LocalDate dataFim) {
        this.cupoes = cupoes;
        this.nome = nome;
        this.desconto = desconto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.clientes = new ArrayList<>();
    }

    public void setCupoes() {
        while (this.cupoes > 0) {
            this.cupoes--;
        }
    }
        public int getCupoes () {
            return cupoes;
        }

        public String getNome () {
            return nome;
        }

        public double getDesconto () {
            return desconto;
        }

        public LocalDate getDataInicio () {
            return dataInicio;
        }

        public LocalDate getDataFim () {
            return dataFim;
        }

    public ArrayList<String> getClientes() {
        return clientes;
    }
}

