import java.time.LocalDate;
import java.util.ArrayList;

public class Musica {
    private String titulo;
    private Musico autor;
    private String genero;
    private boolean activa;
    private LocalDate dataLancamento;
    private ArrayList<Preco> historicoPreco;
    private ArrayList<Integer> classificacoes;
    private ArrayList<String> votosUtilizadores;
    double rating;

    public Musica(String titulo, String genero, LocalDate data, Musico autor,double valor) {
        this.titulo = titulo;
        this.genero = genero;
        this.dataLancamento=data;
        this.activa=true;
        this.historicoPreco=new ArrayList<>();
        Preco preco= new Preco(valor);
        this.historicoPreco.add(preco);
        this.classificacoes=new ArrayList<>();
        this.votosUtilizadores=new ArrayList<>();
        this.autor=autor;
        this.rating=rating();
    }
    public void alterarPreco(double preco){
        Preco novopreco= new Preco(preco);
        historicoPreco.add(novopreco);
    }
    public double getPreco(){
        return historicoPreco.getLast().getPreco();
    }
    public double rating(){
        int soma=0;
        for( int i : this.classificacoes){
            soma+=i;

        }
        return soma/this.classificacoes.size();
    }
}
