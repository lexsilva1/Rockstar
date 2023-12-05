import java.util.ArrayList;

public class Cliente extends Utilizador{
    private double saldo;
    private ArrayList<Musica> carrinhoCompras;
    private ArrayList<Compra> historicoCompras;

    public Cliente(String username, String password, String nome, String NIF, String email) {
        super(username, password, nome, NIF, email);
        this.saldo = 0;
        this.carrinhoCompras = new ArrayList<>();
        this.historicoCompras= new ArrayList<>();
    }
}
