import products.*;
import system.Caixa;
import system.Estoque;
import system.Sistema;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Criados produtos, cadastrados no sistema e adicionados ao estoque de forma manual para facilitar o teste do código
        Produto produto1 = new Jogo("League of Legends", "J001", 10.0,"Riot Games", new String[]{"Online, ação, aventura"}, "Riot");
        Produto produto2 = new Brinquedo("Urso", "B001", 50.0, "Pelúcia");
        Produto produto3 = new Brinquedo("Carrinho", "B002", 30.0, "Carros");
        Produto produto4 = new Livro("O alquimista", "L001", 15.0, new String[]{"Romance", "Drama", "Fantasia"}, new String[]{"Paulo Coelho"}, "Paralela");
        Produto produto5 = new Filme("Forrest Gump", "F001", 10.60, "Paramout Pictures", new String[]{"Robert Zemeckis"}, new String[]{"Comédia Dramática"}, new String[]{"Wendy Finerman", "Steve Tisch", "Steve Starkey"});

        Sistema.cadastrarProduto(produto1);
        Sistema.cadastrarProduto(produto2);
        Sistema.cadastrarProduto(produto3);
        Sistema.cadastrarProduto(produto4);
        Sistema.cadastrarProduto(produto5);
        Estoque.adicionarProduto(produto1, 5);
        Estoque.adicionarProduto(produto2, 5);
        Estoque.adicionarProduto(produto3, 5);
        Estoque.adicionarProduto(produto4, 5);
        Estoque.adicionarProduto(produto5, 5);

        // Início do código
        Scanner scanner = new Scanner(System.in);

        imprimirMenu();
        Integer opcao = receberInput(scanner);

        while (opcao != 0){
            switch (opcao){
                case 1:
                    verSistema(scanner);
                    imprimirMenu();
                    opcao = receberInput(scanner);
                    break;

                case 2:
                    Produto produto = criarProduto(scanner);
                    Sistema.cadastrarProduto(produto);

                    imprimirMenu();
                    opcao = receberInput(scanner);
                    break;

                case 3:
                    if (Sistema.getSistema().isEmpty()){
                        System.out.println("Não há produtos a serem removidos!");
                    } else {
                        System.out.println("Informe o ID do produto a ser removido: ");
                        String opcaoRemover = scanner.nextLine();

                        for (int i = 0; i < Sistema.getSistema().size(); i++) {
                            Produto produtoI = Sistema.getSistema().get(i);
                            if (produtoI.getId().equals(opcaoRemover)){
                                Sistema.removerProduto(produtoI);
                            }
                        }
                    }
                    imprimirMenu();
                    opcao = receberInput(scanner);
                    break;

                case 4:
                    if (Sistema.getSistema().isEmpty()){
                        System.out.println("Não há produtos cadastrados a serem vendidos!");
                    } else {
                        System.out.print("Informe o ID do produto a ser vendido: ");
                        String opcaoVender = scanner.nextLine().toUpperCase();

                        System.out.print("Informe a quantidade a ser vendida: ");
                        Integer quantidade = scanner.nextInt();
                        scanner.nextLine();

                        for (int i = 0; i < Sistema.getSistema().size(); i++) {
                            Produto produtoI = Sistema.getSistema().get(i);
                            if (produtoI.getId().equals(opcaoVender)){
                                Sistema.realizarVenda(produtoI, quantidade);
                            }
                        }
                    }
                    imprimirMenu();
                    opcao = receberInput(scanner);
                    break;

                case 5:
                    verEstoque(scanner);
                    imprimirMenu();
                    opcao = receberInput(scanner);
                    break;

                case 6:
                    if (Sistema.getSistema().isEmpty()){
                        System.out.println("Não ha produtos cadastrados a serem adicionados");
                    } else {
                        System.out.print("Informe o ID do produto a ser adicionado ao estoque: ");
                        String opcaoAddEstoque = scanner.nextLine();

                        System.out.print("Informe a quantidade a ser adicionada: ");
                        Integer quantidade = scanner.nextInt();
                        scanner.nextLine();

                        for (int i = 0; i < Sistema.getSistema().size(); i++) {
                            Produto produtoI = Sistema.getSistema().get(i);
                            if (produtoI.getId().equals(opcaoAddEstoque)){
                                Estoque.adicionarProduto(produtoI, quantidade);
                            }
                        }
                    }
                    imprimirMenu();
                    opcao = receberInput(scanner);
                    break;

                case 7:
                    if (Estoque.getEstoque().isEmpty()){
                        System.out.println("Não ha produtos cadastrados a serem removidos");
                    } else {
                        System.out.print("Informe o ID do produto a ser removido do estoque: ");
                        String opcaoRmvEstoque = scanner.nextLine();

                        System.out.print("Informe a quantidade a ser removida: ");
                        Integer quantidade = scanner.nextInt();
                        scanner.nextLine();

                        for (int i = 0; i < Sistema.getSistema().size(); i++) {
                            Produto produtoI = Sistema.getSistema().get(i);
                            if (produtoI.getId().equals(opcaoRmvEstoque)){
                                Estoque.removerProduto(produtoI, quantidade);
                            }
                        }
                    }
                    imprimirMenu();
                    opcao = receberInput(scanner);
                    break;

                case 8:
                    Caixa.mostrarCaixa();
                    imprimirMenu();
                    opcao = receberInput(scanner);
                    break;

                case 9:
                    System.out.print("Informe a quantia a ser adicionada: ");
                    Double quantiaAdd = scanner.nextDouble();
                    scanner.nextLine();

                    Caixa.adicionarDinheiro(quantiaAdd);
                    imprimirMenu();
                    opcao = receberInput(scanner);
                    break;

                case 10:
                    System.out.print("Informe a quantia a ser retirada: ");
                    Double quantiaRmv = scanner.nextDouble();
                    scanner.nextLine();

                    Caixa.retirarDinheiro(quantiaRmv);
                    imprimirMenu();
                    opcao = receberInput(scanner);
                    break;

                case 0:
                    System.out.println("Até logo!");
                    opcao = 0;
                    break;

                default:
                    System.out.println("Tente novamente!");
                    imprimirMenu();
                    opcao = receberInput(scanner);
                    break;
            }
        }
    }

    public static void imprimirMenu(){
        System.out.println("------------------------------------------");
        System.out.println();
        System.out.println("***************LIVRARIA ADA***************");
        System.out.println();
        System.out.println("            O que deseja fazer?           ");
        System.out.println();
        System.out.println(" -----------------SISTEMA-----------------");
        System.out.println("[1] - Ver produstos cadastrados no sistema");
        System.out.println("[2] - Cadastrar novo produto no sistema");
        System.out.println("[3] - Remover produto do sistema");
        System.out.println("[4] - Registrar venda");
        System.out.println(" -----------------ESTOQUE-----------------");
        System.out.println("[5] - Ver estoque");
        System.out.println("[6] - Adicionar produto ao estoque");
        System.out.println("[7] - Remover produto do estoque");
        System.out.println(" ------------------CAIXA------------------");
        System.out.println("[8] - Ver Caixa");
        System.out.println("[9] - Adicionar dinheiro ao caixa");
        System.out.println("[10] - Retirar dinheiro do caixa");
        System.out.println("------------------------------------------");
        System.out.println("[0] - Sair");
        System.out.println("------------------------------------------");
    }

    public static void verSistema(Scanner scanner){
        System.out.println("Aplicar um filtro:");
        System.out.println("[1] - Mostrar Tudo");
        System.out.println("[2] - Apenas Livros");
        System.out.println("[3] - Apenas Jogos");
        System.out.println("[4] - Apenas Filmes");
        System.out.println("[5] - Apenas Brinquedos");
        System.out.println("[6] - Apenas Álbuns de música");

        Integer opcaoFiltro = receberInput(scanner);

        switch (opcaoFiltro){
            case 1:
                Sistema.imprimirProdutos();
                break;
            case 2:
                Sistema.imprimirProdutos("Livros");
                break;
            case 3:
                Sistema.imprimirProdutos("Jogos");
                break;
            case 4:
                Sistema.imprimirProdutos("Filmes");
                break;
            case 5:
                Sistema.imprimirProdutos("Brinquedos");
                break;
            case 6:
                Sistema.imprimirProdutos("Albuns de musica");
            default:
                System.out.println("Tente novamente!");
                break;
        }
    }

    public static void verEstoque(Scanner scanner){
        System.out.println("Aplicar um filtro:");
        System.out.println("[1] - Mostrar Tudo");
        System.out.println("[2] - Apenas Livros");
        System.out.println("[3] - Apenas Jogos");
        System.out.println("[4] - Apenas Filmes");
        System.out.println("[5] - Apenas Brinquedos");
        System.out.println("[6] - Apenas Álbuns de música");

        Integer opcaoFiltro = receberInput(scanner);

        switch (opcaoFiltro){
            case 1:
                Estoque.imprimirEstoque();
                break;
            case 2:
                Estoque.imprimirEstoque("Livros");
                break;
            case 3:
                Estoque.imprimirEstoque("Jogos");
                break;
            case 4:
                Estoque.imprimirEstoque("Filmes");
                break;
            case 5:
                Estoque.imprimirEstoque("Brinquedos");
                break;
            case 6:
                Estoque.imprimirEstoque("Albuns de musica");
            default:
                System.out.println("Tente novamente!");
                break;
        }
    }

    public static Integer receberInput(Scanner scanner){
        int input;
        try {
            input = scanner.nextInt();
            scanner.nextLine();
        }
        catch (InputMismatchException e){
            System.out.println("Digite um número inteiro");
            input = 20;
            scanner.nextLine();
        }
        return input;
    }

    public static Produto criarProduto(Scanner scanner){
        System.out.println("Informe a categoria do produto:");
        System.out.println("[1] - Livro");
        System.out.println("[2] - Jogo");
        System.out.println("[3] - Filme");
        System.out.println("[4] - Brinquedo");
        System.out.println("[5] - Álbum de música");
        Integer opcaoCategoria = receberInput(scanner);


        switch (opcaoCategoria){
            case 1:
                return Sistema.criarLivro(scanner);
            case 2:
                return Sistema.criarJogo(scanner);
            case 3:
                return Sistema.criarFilme(scanner);
            case 4:
                return Sistema.criarBrinquedo(scanner);
            case 5:
                return Sistema.criarAlbumDeMus(scanner);
            default:
                System.out.println("Tente novamente!");
                return new Produto();
        }
    }

}