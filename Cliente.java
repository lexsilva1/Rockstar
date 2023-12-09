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

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void votar (int voto, Musica musica){
        for (String username : musica.getVotosUtilizadores()){
                if (this.username.equals(username)){
                    System.out.println("já votou nesta musica");
                    break;
                }else {
                    musica.getClassificacoes().add(voto);
                    musica.getVotosUtilizadores().add(this.username);
                }
        }
    }
    public Playlist criaPlaylistGenero(String genero,int num, String titulo){
        Playlist playlist = new Playlist(this.username, titulo, genero );
        for(int i=0; i<num;i++){
            for(Compra c : historicoCompras){
                for( Musica m : c.getMusicas()){
                    if (m.getGenero().equals(genero)){
                        playlist.addMusica(m);
                    }
                }
            }
        }
        if(playlist.getMusicas().size()<num){
            System.out.println("Foram adicionadas apenas "+playlist.getMusicas().size()+" músicas.");
        }
        System.out.println("Playlist criada com sucesso");
        return playlist;
    }

    }
