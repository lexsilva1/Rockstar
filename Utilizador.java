import java.util.Scanner;

public abstract class Utilizador {
    protected String username;
    private String password;;
    private boolean activo;

    public Utilizador(String username, String password) {
        this.username = username;
        this.password = password;
        this.activo = true;
    }
    public void login(){
        Scanner xpto=new Scanner(System.in);
        String username= xpto.nextLine();
        String password= xpto.nextLine();
        if(this.username.equals(username)&&this.password.equals(password)){
            System.out.println("benvindo");
        }
        System.out.println("username ou password invalido");
    }
    public Musica pesquisaMusica() {
        return null;
    }
    public void addMusica(){
    }
    public void meusAlbuns(){

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
