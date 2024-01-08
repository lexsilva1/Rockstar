package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Musica implements Serializable {
    private String titulo;
    private String autor;
    private String genero;
    private boolean ativa;
    private LocalDate dataLancamento;
    private ArrayList<Preco> historicoPreco;
    private HashMap<String,Integer> classificacoes;
    private double rating;

    public Musica(String titulo, String genero, LocalDate data, String autor,double valor) {
        this.titulo = titulo;
        this.genero = genero;
        this.dataLancamento = data;
        this.ativa =true;
        this.historicoPreco = new ArrayList<>();
        Preco preco = new Preco(valor);
        this.historicoPreco.add(preco);
        this.classificacoes = new HashMap<>();
        this.rating = calculoRating();
        this.autor=autor;
    }
    public void alterarPreco(double preco){
        Preco novopreco= new Preco(preco);
        historicoPreco.add(novopreco);
    }


    public void inativa(boolean activo) {

        if (this.ativa != activo) {
            this.ativa = activo;
        }

    }

    public double calculoRating(){
        double total = 0;
        if(classificacoes.isEmpty()) {
          return 0;
        }else {
            for (Map.Entry<String, Integer> entry : this.getClassificacoes().entrySet()) {
                total += entry.getValue();
            }
        }
        return total/classificacoes.size();
    }
    public void avaliar(Cliente cliente, int nota){
        classificacoes.put(cliente.getUsername(),nota);

    }
    public ArrayList<Preco> getHistoricoPreco() {
        return historicoPreco;
    }

    public HashMap<String,Integer> getClassificacoes() {
        return classificacoes;
    }
    public double getPreco(){
        return historicoPreco.getLast().getPreco();
    }

    public String getGenero() {
        return genero;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean getAtiva() {
        return ativa;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public double getRating() {
        return rating;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

