package products;

public class Brinquedo extends Produto{
    private String tipo;

    private String categoria = "Brinquedos";

    public Brinquedo() {}

    public Brinquedo(String nome, String id, Double preco, String tipo) {
        super(nome, id, preco);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }
}
