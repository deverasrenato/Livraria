package products;

import java.util.Scanner;

public class Livro extends Produto{
    private String[] generos;
    private String[] escritores;
    private String editora;

    private String categoria = "Livros";

    public Livro() {}

    public Livro(String nome, String id, Double preco, String[] generos, String[] escritores, String editora) {
        super(nome, id, preco);
        this.generos = generos;
        this.escritores = escritores;
        this.editora = editora;
    }

    public String[] getGeneros() {
        return generos;
    }

    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    public String[] getEscritores() {
        return escritores;
    }

    public void setEscritores(String[] escritores) {
        this.escritores = escritores;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getCategoria() {
        return categoria;
    }

}
