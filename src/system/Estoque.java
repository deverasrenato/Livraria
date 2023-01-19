package system;
import products.Produto;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private static List<Produto> estoque = new ArrayList<>();

    public static List<Produto> getEstoque() {
        return estoque;
    }

    public static void adicionarProduto (Produto produto, Integer quantidade){
        if (!Sistema.isProdutoCadastrado(produto)){
            System.out.println("Produto não cadastrado");
        }else if (produto.getQtdeEstoque() == 0){
            estoque.add(produto);
            produto.setQtdeEstoque(produto.getQtdeEstoque() + quantidade);
            System.out.println("Estoque atualizado!");
        } else {
            produto.setQtdeEstoque(produto.getQtdeEstoque() + quantidade);
        }
    }
    public static void removerProduto (Produto produto, Integer quantidade){
        if (!estoque.contains(produto)){
            System.out.println("Produto não encontrado no estoque");
        } else if (produto.getQtdeEstoque() - quantidade < 0){
            System.out.println("Estoque insuficiente");
        } else {
            produto.setQtdeEstoque(produto.getQtdeEstoque() - quantidade);
            System.out.println("Estoque atualizado!");
        }
        if (produto.getQtdeEstoque() - quantidade == 0){
            estoque.remove(produto);
        }
    }
    public static void imprimirEstoque() {
        System.out.println("---------------------");
        System.out.println("Produtos Em estoque:");
        for (int i = 0; i < estoque.size(); i++) {
            System.out.println(estoque.get(i) + " - " + estoque.get(i).getQtdeEstoque());
        }
        System.out.println("---------------------");
    }
    public static void imprimirEstoque(String categoria) {
        System.out.println("---------------------");
        System.out.println(categoria + " em estoque:");
        for (int i = 0; i < estoque.size(); i++) {
            if (estoque.get(i).getCategoria().equals(categoria)){
            System.out.println(estoque.get(i) + " - " + estoque.get(i).getQtdeEstoque());
            }
        }
        System.out.println("---------------------");
    }
}
