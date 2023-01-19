package products;

public class Jogo extends Produto{
    private String distribuidora;
    private String[] generos;
    private String estudio;

    private String categoria = "Jogos";

    public Jogo() {}

    public Jogo(String nome, String id, Double preco, String distribuidora, String[] generos, String estudio) {
        super(nome, id, preco);
        this.distribuidora = distribuidora;
        this.generos = generos;
        this.estudio = estudio;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String[] getGeneros() {
        return generos;
    }

    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getCategoria() {
        return categoria;
    }
}
