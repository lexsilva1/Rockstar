package backend;

import java.time.LocalDate;

public class Admin extends Utilizador{
    private static int ultimoidAdmin=0;
    private int idAdmin;
    public Admin(String username, String password) {
        super(username, password);
        this.idAdmin=ultimoidAdmin++;
    }
    public Promo criaPromo(int cupoes, String nome, double desconto, LocalDate dataInicio, LocalDate dataFim){
         Promo promo = new Promo(cupoes, nome, desconto, dataInicio, dataFim);
         return promo;
    }
}
