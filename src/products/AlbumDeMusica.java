package products;

public class AlbumDeMusica extends Produto{
    private String[] musicas;
    private String[] generos;
    private String[] selos;

    private String categoria = "Albuns de musica";

    public AlbumDeMusica() {
    }

    public AlbumDeMusica(String nome, String id, Double preco, String[] musicas, String[] generos, String[] selos) {
        super(nome, id, preco);
        this.musicas = musicas;
        this.generos = generos;
        this.selos = selos;
    }

    public String[] getMusicas() {
        return musicas;
    }

    public void setMusicas(String[] musicas) {
        this.musicas = musicas;
    }

    public String[] getGeneros() {
        return generos;
    }

    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    public String[] getSelos() {
        return selos;
    }

    public void setSelos(String[] selos) {
        this.selos = selos;
    }

    public String getCategoria() {
        return categoria;
    }
}
