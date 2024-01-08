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

    /**
     * Objecto Musica, criado pelo <code>Musico</code> .
     * Possui um HashMap para as Classificações, para que os Utilizadores possam votar mais do que uma vez,
     * mas substituindo o voto anterior.
     * @param titulo
     * @param genero
     * @param data
     * @param autor
     * @param valor
     */

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

    /**
     * Cria um novo objecto <code>Preco</code> e armazena no historico de preços da musica.
     * @param preco valor numerico do <code>Preco</code> criado.
     */
    public void alterarPreco(double preco){
        Preco novopreco= new Preco(preco);
        historicoPreco.add(novopreco);
    }


    /**
     * permite ativar/inativar a <code>Musica</code>
     * @param activo
     */
    public void inativa(boolean activo) {

        if (this.ativa != activo) {
            this.ativa = activo;
        }

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

    /**
     * calcula o rating da música.
     * @return Dvolve um double que é a média de todas as avaliações feitas por clientes que adquiriram esta musica.
     */
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

    /**
     * adiciona ao HashMap de classificações o rating atribuido pelo cliente
     * @param cliente cliente que avalia.
     * @param nota valor da avaliação.
     */
    public void avaliar(Cliente cliente, int nota){
        classificacoes.put(cliente.getUsername(),nota);

    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

