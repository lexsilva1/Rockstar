package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * É um objeto criado apenas por instâncias do objeto <code>Admin</code>
 * É associado a uma <code>Compra</code> e aplica uma redução percentual ao seu valor
 */
public class Promo implements Serializable {
    private int cupoes;
    private String nome;
    private double desconto;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private ArrayList<String> clientes;

    public Promo(int cupoes, String nome, double desconto, LocalDate dataInicio, LocalDate dataFim) {
        this.cupoes = cupoes;
        this.nome = nome;
        this.desconto = desconto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.clientes = new ArrayList<>();
    }

    public void retiraCupoes() {//setter especifico para quando é usada uma promo deduzir um cupão
            this.cupoes--;

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

