package backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Cliente extends Utilizador {
    private double saldo;
    private ArrayList<Musica> carrinhoCompras;
    private ArrayList<Compra> historicoCompras;
    private ArrayList<Musica> musicas;

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

    public void compra() {//compra sem promocao
        Compra compra = new Compra();
        double total = 0;
        for (Musica m : carrinhoCompras) {
            compra.getMusicas().put(m,m.getPreco());
            total += m.getPreco();// vai buscar o preço de cada musica e soma todos no total
        }
        if (this.saldo >= total) {//confirmação de saldo
            this.saldo -= total;
            musicas.addAll(carrinhoCompras);
            historicoCompras.add(compra);//adiciona a compra ao historico do cliente
        }
    }

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
                    historicoCompras.add(compra);//adiciona a compra ao historico do cliente
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
