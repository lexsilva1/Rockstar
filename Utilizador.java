public abstract class Utilizador {
    private String username;
    private String password;
    private String nome;
    private String NIF;
    private String email;
    private boolean activo;

    public Utilizador(String username, String password, String nome, String NIF, String email) {
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.NIF = NIF;
        this.email = email;
        this.activo = true;
    }

}
