package backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Cliente extends Utilizador {
    private double saldo;
    private ArrayList<Musica> carrinhoCompras;
    private ArrayList<Compra> historicoCompras;
    private ArrayList<Musica> musicas;

    /**
     * Classe que herda da classe <code>Utilizador</code>
     * Possui a particularidade de criar objectos <code>Playlist</code>,<code>Compra</code> e é o único utilizador com saldo
     * @param username
     * @param password
     */

    public Cliente(String username, String password) {
        super(username, password);
        this.musicas=new ArrayList<>();
        this.saldo = 0;
        this.carrinhoCompras = new ArrayList<>();
        this.historicoCompras = new ArrayList<>();
    }

    public void carregaSaldo(double saldo) {
        this.saldo += saldo;
    }

    /**
     * Cria uma Playlist a partir do ArrayList criado com todas as músicas do género selcionado, utiliza o método Shuffle da classe Collections
     * para randomizar a ordem, e usa o iterator para ir retirando músicas desse ArrayList depois de os colocar na Playlist criada.
     * @param num
     * @param titulo
     * @param musicasGenero
     * @return
     */
    public Playlist criaPlaylistGenero(int num, String titulo, ArrayList<Musica> musicasGenero) {
        Playlist playlist = new Playlist(this.username, titulo);
        Collections.shuffle(musicasGenero);

        Iterator<Musica> iterator = musicasGenero.iterator();
        int i = 0;
        while (i < num && iterator.hasNext()) {
            Musica m = iterator.next();
            playlist.getMusicas().add(m);
            iterator.remove(); // Remove o elemento atual da lista
            i++;
        }

        return playlist;
    }

    public Playlist criaPlaylist(String nome){
        return new Playlist(this.username,nome);
    }

    /**
     * Efectua a compra das músicas presentes no carrinhoCompras, verificando o saldo, e adiciona o objecto <code>Compra</code>
     * ao historicoCompras do cliente.
     */
    public void compra() {
        Compra compra = new Compra();
        double total = 0;
        for (Musica m : carrinhoCompras) {
            compra.getMusicas().put(m,m.getPreco());
            total += m.getPreco();
        }
        if (this.saldo >= total) {
            this.saldo -= total;
            musicas.addAll(carrinhoCompras);
            historicoCompras.add(compra);
        }
    }
    /**
     * Efectua a compra das músicas presentes no carrinhoCompras, verificando o saldo
     * aplicando o desconto respectivo à <code>Promo</code> utilizada e adiciona o objecto <code>Compra</code> ao historicoCompras do cliente.
     */
    public void compraPromo(Promo promo) {

                Compra compra = new Compra();
                compra.setPromo(promo);// adiciona a promoção à compra
                double total = 0;
                for (Musica m : carrinhoCompras) {
                    compra.getMusicas().put(m,(m.getPreco()-m.getPreco()*(promo.getDesconto()/100))); //guarda o titulo da musica e o preço com desconto
                    total += (m.getPreco()-m.getPreco()*(promo.getDesconto()/100));//efectua o total da compra com o desconto correspondente
                }
                    musicas.addAll(carrinhoCompras);
                    this.saldo -= total;
                    historicoCompras.add(compra);
                    promo.retiraCupoes();
                    promo.getClientes().add(this.username);
            }



    public double getSaldo() {
        return saldo;
    }

    public ArrayList<Musica> getCarrinhoCompras() {
        return carrinhoCompras;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public ArrayList<Compra> getHistoricoCompras() {
        return historicoCompras;
    }
}
