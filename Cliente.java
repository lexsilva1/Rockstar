import java.util.ArrayList;

public class Cliente extends Utilizador{
    private double saldo;
    private ArrayList<Musica> carrinhoCompras;
    private ArrayList<Compra> historicoCompras;

    public Cliente(String username, String password, String nome, String NIF, String email, boolean activo, double saldo) {
        super(username, password, nome, NIF, email, activo);
        this.saldo = saldo;
        this.carrinhoCompras = new ArrayList<>();
        this.historicoCompras= new ArrayList<>();
    }
}
