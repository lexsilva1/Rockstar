package backend;

import java.time.LocalDate;

public class Admin extends Utilizador {
    /**
     * Classe que herda da classe <code>Utilizador</code>
     * Possui a particularidade de criar objectos <code>Promo</code>
     * @param username
     * @param password
     */
    public Admin(String username, String password) {
        super(username, password);
    }

    public Promo criaPromo(int cupoes, String nome, double desconto, LocalDate dataInicio, LocalDate dataFim) {
        return new Promo(cupoes, nome, desconto, dataInicio, dataFim);
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
