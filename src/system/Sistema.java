package system;

import products.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private static List<Produto> sistema = new ArrayList<>();

    public static List<Produto> getSistema() {
        return sistema;
    }

    public static void cadastrarProduto (Produto produto){
        if (produto.getId() == null) {
            System.out.println("Informe um ID! válido!");
        } else if (isProdutoCadastrado(produto)){
            System.out.println("Produto já cadastrado!");
        } else {
            sistema.add(produto);
            System.out.println("produto cadastrado com sucesso!");
        }
    }

    public static void removerProduto (Produto produto){
        if (isProdutoCadastrado(produto)){
            sistema.remove(produto);
            System.out.println("Produto removido do sistema");
        } else {
            System.out.println("Produto não cadastrado!");
        }
    }

    public static void imprimirProdutos(){
        System.out.println("---------------------");
        System.out.println("Produtos cadastrados:");
        for (int i = 0; i < sistema.size(); i++) {
            System.out.println(sistema.get(i));
        }
        System.out.println("---------------------");
    }

    public static void imprimirProdutos(String categoria) {
        System.out.println("---------------------");
        System.out.println(categoria + " cadastrados:");
        for (int i = 0; i < sistema.size(); i++) {
            if (sistema.get(i).getCategoria().equals(categoria)){
                System.out.println(sistema.get(i));
            }
        }
        System.out.println("---------------------");
    }

    public static void realizarVenda(Produto produto, Integer quantidade){
        if (produto.getQtdeEstoque()-quantidade < 0 ){
            System.out.println("Quantidade insuficiente");
        } else {
            Estoque.removerProduto(produto, quantidade);
            Caixa.adicionarDinheiro(produto.getPreco() * quantidade);
        }
    }

    static Boolean isProdutoCadastrado (Produto produto){
        for (int i = 0; i < sistema.size(); i++) {
            if (sistema.get(i).equals(produto)){
                return true;
            }
        }
        return false;
    }

    public static Produto criarLivro(Scanner scanner){
        System.out.print("Informe o nome do Livro: ");
        String nome = scanner.nextLine();

        System.out.print("informe o ID: ");
        String id = scanner.nextLine();

        System.out.print("Informe o preço: $");
        Double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Quantos gêneros o Livro possui? ");
        int num = scanner.nextInt();
        scanner.nextLine();

        String [] generos = new String[num];
        for (int i = 0; i < generos.length; i++) {
            System.out.print("Gênero #" + (i+1) + ": ");
            generos[i] = scanner.nextLine();
        }

        System.out.print("Quantos escritores o Livro possui? ");
        num = scanner.nextInt();
        scanner.nextLine();

        String [] escritores = new String[num];
        for (int i = 0; i < escritores.length; i++) {
            System.out.print("Escritor(a) #" + (i+1) + ": ");
            escritores[i] = scanner.nextLine();
        }

        System.out.print("Informe a editora: ");
        String editora = scanner.nextLine();

        return new Livro(nome, id, preco, generos, escritores, editora);
    }

    public static Produto criarJogo(Scanner scanner){
        System.out.print("Informe o nome do Jogo: ");
        String nome = scanner.nextLine();

        System.out.print("informe o ID: ");
        String id = scanner.nextLine();

        System.out.print("Informe o preço: $");
        Double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Informe a distribuidora: ");
        String distribuidora = scanner.nextLine();

        System.out.print("Quantos gêneros o Jogo possui? ");
        int num = scanner.nextInt();
        scanner.nextLine();

        String [] generos = new String[num];

        for (int i = 0; i < generos.length; i++) {
            System.out.print("Gênero #" + (i+1) + ": ");
            generos[i] = scanner.nextLine();
        }

        System.out.print("Informe o estúdio: ");
        String estudio = scanner.nextLine();

        return new Jogo(nome, id, preco, distribuidora, generos, estudio);

    }

    public static Produto criarFilme(Scanner scanner){
        System.out.print("Informe o nome do Filme: ");
        String nome = scanner.nextLine();

        System.out.print("informe o ID: ");
        String id = scanner.nextLine();

        System.out.print("Informe o preço: $");
        Double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Informe o estúdio: ");
        String estudio = scanner.nextLine();

        System.out.print("Quantos diretores o Filme possui? ");
        int num = scanner.nextInt();
        scanner.nextLine();

        String [] diretores = new String[num];
        for (int i = 0; i < diretores.length; i++) {
            System.out.print("Diretor(a) #" + (i+1) + ": ");
            diretores[i] = scanner.nextLine();
        }

        System.out.print("Quantos gêneros o Filme possui? ");
        num = scanner.nextInt();
        scanner.nextLine();

        String [] generos = new String[num];

        for (int i = 0; i < generos.length; i++) {
            System.out.print("Gênero #" + (i+1) + ": ");
            generos[i] = scanner.nextLine();
        }

        System.out.print("Quantos produtores o Livro possui? ");
        num = scanner.nextInt();
        scanner.nextLine();

        String [] produtores = new String[num];
        for (int i = 0; i < produtores.length; i++) {
            System.out.print("Produtor(a) #" + (i+1) + ": ");
            produtores[i] = scanner.nextLine();
        }

        return new Filme(nome, id, preco, estudio, diretores, generos, produtores);
    }

    public static Produto criarBrinquedo(Scanner scanner){
        System.out.print("Informe o nome do Brinquedo: ");
        String nome = scanner.nextLine();

        System.out.print("informe o ID: ");
        String id = scanner.nextLine();

        System.out.print("Informe o preço: $");
        Double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Informe o tipo: ");
        String tipo = scanner.nextLine();

        return new Brinquedo(nome, id, preco, tipo);

    }

    public static Produto criarAlbumDeMus(Scanner scanner){
        System.out.print("Informe o nome do Álbum: ");
        String nome = scanner.nextLine();

        System.out.print("informe o ID: ");
        String id = scanner.nextLine();

        System.out.print("Informe o preço: $");
        Double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Quantas músicas o Álbum possui? ");
        int num = scanner.nextInt();
        scanner.nextLine();

        String [] musicas = new String[num];
        for (int i = 0; i < musicas.length; i++) {
            System.out.print("Música/Banda #" + (i+1) + ": ");
            musicas[i] = scanner.nextLine();
        }

        System.out.print("Quantos gêneros o Álbum possui? ");
        num = scanner.nextInt();
        scanner.nextLine();

        String [] generos = new String[num];

        for (int i = 0; i < generos.length; i++) {
            System.out.print("Gênero #" + (i+1) + ": ");
            generos[i] = scanner.nextLine();
        }

        System.out.print("Quantos selos o Álbum possui? ");
        num = scanner.nextInt();
        scanner.nextLine();

        String [] selos = new String[num];
        for (int i = 0; i < selos.length; i++) {
            System.out.print("Selo #" + (i+1) + ": ");
            selos[i] = scanner.nextLine();
        }

        return new AlbumDeMusica(nome, id, preco, musicas, generos, selos);
    }
}
