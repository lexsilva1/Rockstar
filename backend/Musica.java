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
    private boolean activa;
    private LocalDate dataLancamento;
    private ArrayList<Preco> historicoPreco;
    private HashMap<String,Integer> classificacoes;

    double rating;

    public Musica(String titulo, String genero, LocalDate data, String autor,double valor) {
        this.titulo = titulo;
        this.genero = genero;
        this.dataLancamento=data;
        this.activa=true;
        this.historicoPreco=new ArrayList<>();
        Preco preco= new Preco(valor);
        this.historicoPreco.add(preco);
        this.classificacoes=new HashMap<>();
        this.rating=calculoRating();
        this.autor=autor;
        //this.rating=rating();
    }
    public void alterarPreco(double preco){
        Preco novopreco= new Preco(preco);
        historicoPreco.add(novopreco);
    }
    public double getPreco(){
        return historicoPreco.getLast().getPreco();
    }
    /*public double rating() {
        int soma = 0;
        if (classificacoes.isEmpty()) {
            return 0;
        } else {
            for (int i : this.classificacoes) {
                soma += i;
            }
            return soma / this.classificacoes.size();
        }
    }*/

    public ArrayList<Preco> getHistoricoPreco() {
        return historicoPreco;
    }

    public HashMap<String,Integer> getClassificacoes() {
        return classificacoes;
    }

    public String getGenero() {
        return genero;
    }

    public void inactiva(boolean activo) {

        if (this.activa != activo) {
            this.activa = activo;
        }

    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean getActiva() {
        return activa;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public double getRating() {
        return rating;
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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

