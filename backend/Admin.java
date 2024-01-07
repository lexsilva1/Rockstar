package backend;

import java.time.LocalDate;

public class Admin extends Utilizador {
    private static int ultimoidAdmin = 0;
    private int idAdmin;

    public Admin(String username, String password) {
        super(username, password);
        this.idAdmin = ++ultimoidAdmin;
    }

    public Promo criaPromo(int cupoes, String nome, double desconto, LocalDate dataInicio, LocalDate dataFim) {
        return new Promo(cupoes, nome, desconto, dataInicio, dataFim);
    }

    public int getIdAdmin() {
        return idAdmin;
    }
    public boolean promoExiste (Rockstar rockstar, String nome) {
        for(Promo p : rockstar.getPromos()) {
            if (nome.equalsIgnoreCase(p.getNome())) {
                return true;
            }
        }
        return false;
    }
}
