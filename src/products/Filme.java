package products;

public class Filme extends Produto {
    private String estudio;
    private String[] diretores;
    private String[] generos;
    private String[] produtores;
    private String categoria = "Filmes";

    public Filme() {
    }

    public Filme(String nome, String id, Double preco, String estudio, String[] diretores, String[] generos, String[] produtores) {
        super(nome, id, preco);
        this.estudio = estudio;
        this.diretores = diretores;
        this.generos = generos;
        this.produtores = produtores;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String[] getDiretores() {
        return diretores;
    }

    public void setDiretores(String[] diretores) {
        this.diretores = diretores;
    }

    public String[] getGeneros() {
        return generos;
    }

    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    public String[] getProdutores() {
        return produtores;
    }

    public void setProdutores(String[] produtores) {
        this.produtores = produtores;
    }

    public String getCategoria() {
        return categoria;
    }
}
