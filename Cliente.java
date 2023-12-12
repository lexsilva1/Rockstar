import java.util.ArrayList;

public class Cliente extends Utilizador {
    private double saldo;
    private ArrayList<Musica> carrinhoCompras;
    private ArrayList<Compra> historicoCompras;

    public Cliente(String username, String password) {
        super(username, password);
        this.saldo = 0;
        this.carrinhoCompras = new ArrayList<>();
        this.historicoCompras = new ArrayList<>();
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void votar(int voto, Musica musica) {
        for (String username : musica.getVotosUtilizadores()) {
            if (this.username.equals(username)) {
                System.out.println("já votou nesta musica");
                break;
            } else {
                musica.getClassificacoes().add(voto);
                musica.getVotosUtilizadores().add(this.username);
            }
        }
    }

    public Playlist criaPlaylistGenero(String genero, int num, String titulo) {
        Playlist playlist = new Playlist(this.username, titulo, genero);
        for (int i = 0; i < num; i++) {
            for (Compra c : historicoCompras) {
                for (Musica m : c.getMusicas()) {
                    if (m.getGenero().equals(genero)) {
                        playlist.addMusica(m);
                    }
                }
            }
        }
        if (playlist.getMusicas().size() < num) {
            System.out.println("Foram adicionadas apenas " + playlist.getMusicas().size() + " músicas.");
        }
        System.out.println("Playlist criada com sucesso");
        return playlist;
    }

    public void compra() {//compra sem promocao
        Compra compra = new Compra();
        compra.getMusicas().addAll(carrinhoCompras);
        double total = 0;
        for (Musica m : compra.getMusicas()) {
            total += m.getPreco();// vai buscar o preço de cada musica e soma todos no total
        }
        if (this.saldo >= total) {//confirmação de saldo
            this.saldo -= total;
            for (Musica m : carrinhoCompras) {
                carrinhoCompras.remove(m);//esvazia o carrinho de compras
            }
            historicoCompras.add(compra);//adiciona a compra ao historico do cliente
            System.out.println("compra efectuada com sucesso");
        } else
            System.out.println("saldo insuficiente");

    }

    public void compraPromo(Promo promo) {
        for (String user : promo.getClientes()) {
            if (user.equals(this.username)) {
                System.out.println("promo já utilizada");//verifica se o cliente já utilizou a promoção

            } else {

                Compra compra = new Compra();
                compra.setPromo(promo);// adiciona a promoção à compra
                compra.getMusicas().addAll(carrinhoCompras);
                double total = 0;
                for (Musica m : compra.getMusicas()) {
                    total += m.getPreco();
                }
                total = total - (total * promo.getDesconto());//efectua o total da compra com o desconto correspondente
                if (this.saldo >= total) {
                    this.saldo -= total;
                    for (Musica m : carrinhoCompras) {
                        carrinhoCompras.remove(m);//esvazia o carrinho de compras
                    }
                    historicoCompras.add(compra);//adiciona a compra ao historico do cliente
                    promo.setCupoes();
                    promo.getClientes().add(this.username);
                    System.out.println("compra efectuada com sucesso");
                } else
                    System.out.println("saldo insuficiente");

            }
        }


    }
}
