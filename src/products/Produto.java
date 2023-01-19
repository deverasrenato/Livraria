package products;

import java.util.Objects;

public class Produto {
    private String nome;
    private String id;
    private Double preco;
    private Integer qtdeEstoque;

    private String categoria;

    public Produto() {
    }

    public Produto(String nome, String id, Double preco) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
        this.qtdeEstoque = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(Integer qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public String toString() {
        return this.nome + " (" + id + ")";
    }
}
