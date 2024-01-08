package backend;

import java.io.Serializable;


public abstract class Utilizador implements Serializable {
    protected String username;
    private String password;
    protected boolean activo;

    /**
     * Classe abstracta da qual serão criadas as restantes classes de Utilizadores.
     * @param username
     * @param password
     */
    public Utilizador(String username, String password) {
        this.username = username;
        this.password = password;
        this.activo = true;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setActivo(){
        this.activo= !this.activo;
    }
    public boolean isActivo() {
        return activo;
    }

}
