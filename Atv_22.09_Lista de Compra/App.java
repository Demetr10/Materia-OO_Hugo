import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner scan;
    private static Gerenciador gerenciador;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        gerenciador = new Gerenciador();

        int opcao;

        do {
            System.out.println(menu());
            opcao = scan.nextInt();
            scan.nextLine(); // Limpar a quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    criarListadCompra();
                    break;
                case 3:
                    addprodutoLista();
                    break;
                case 4:
                    removerProdutoDaLista();
                    break;
                case 5:
                    calcularValorTotalLista();
                    break;
                case 6:
                    calcularPesoTotalLista();
                    break;
                case 7:
                    listarProdutos(); // Adicionado para listar produtos cadastrados
                    break;
                case 8:
                    verSuaLista();
                    break;
                case 0:
                    System.out.println("Saiu!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 0);
    }

    private static String menu() {
        String str = "";
        str += "1 - Cadastrar Produto\n";
        str += "2 - Criar Lista de Compras\n";
        str += "3 - Adicionar Produto à Lista\n";
        str += "4 - Remover Produto da Lista\n";
        str += "5 - Calcular Valor Total da Lista\n";
        str += "6 - Calcular Peso Total da Lista\n";
        str += "7 - Ver sua lista\n"; // Adicionado para ver a lista de compras
        str += "8 - Listar Produtos\n"; // Adicionado para listar produtos cadastrados
        str += "0 - Sair\n";
        str += "Escolha uma opção: ";

        return str;
    }

    private static void cadastrarProduto() {
        System.out.println("### Cadastro de Produto ###");
        System.out.println("Digite o nome do produto:");
        String nomeProduto = scan.nextLine();
        System.out.println("Digite o preco do produto R$:");
        double precoProduto = scan.nextDouble();
        System.out.println("Digite o peso do produto KG:");
        double pesoProduto = scan.nextDouble();
        scan.nextLine(); // Limpar a quebra de linha

        Produto produto = new Produto(nomeProduto, precoProduto, pesoProduto);

        if (gerenciador.cadastrarProduto(produto)) {
            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar o produto. Produto já existe.");
        }
        System.out.println("\n");

    }

    private static void criarListadCompra() {
        System.out.println("### Criação de Lista de Compras ###");
        System.out.println("Digite o nome da lista:");
        String nomeLista = scan.nextLine();
        gerenciador.cadastrarListaCompra(nomeLista);
        System.out.println("Lista de Compras criada com sucesso!");

        System.out.println("\n");

    }

    private static void addprodutoLista() {
        System.out.println("### Adicionar Produto à Lista ###");
        System.out.println("Digite o nome da lista:");
        String nomeLista = scan.nextLine();
        ListadCompra lista = gerenciador.buscarListaCompra(nomeLista);
        if (lista != null) {
            System.out.println("Escolha um produto para adicionar à lista:");
            listarProdutos();
            int escolhaProduto = scan.nextInt();
            scan.nextLine(); // Limpar a quebra de linha
            if (escolhaProduto >= 0 && escolhaProduto < gerenciador.listarProdutos().size()) {
                Produto produtoSelecionado = gerenciador.listarProdutos().get(escolhaProduto);
                lista.adicionarProduto(produtoSelecionado);
                System.out.println("Produto adicionado à lista com sucesso!");
            } else {
                System.out.println("Produto não encontrado!");
            }
        } else {
            System.out.println("Lista de Compras não encontrada!");
        }
    }

    private static void listarProdutos() {
        System.out.println("### Lista de Produtos Cadastrados ###");
        for (int i = 0; i < gerenciador.listarProdutos().size(); i++) {
            Produto produto = gerenciador.listarProdutos().get(i);
            System.out.println(i + " - " + produto.toString());
        }
        System.out.println("\n");

    }

    private static void removerProdutoDaLista() {
        System.out.println("### Remover Produto da Lista ###");
        System.out.println("Digite o nome da lista:");
        String nomeLista = scan.nextLine();
        ListadCompra lista = gerenciador.buscarListaCompra(nomeLista);
        if (lista != null) {
            System.out.println("Digite o nome do produto a ser removido:");
            String nomeProduto = scan.nextLine();
            Produto produto = new Produto(nomeProduto, 0.0, 0.0);
            lista.removerProduto(produto);
            System.out.println("Produto removido da lista com sucesso!");
        } else {
            System.out.println("Lista de Compras não encontrada!");
        }
        System.out.println("\n");

    }

    private static void calcularValorTotalLista() {
        System.out.println("### Calcular Valor Total da Lista ###");
        System.out.println("Digite o nome da lista:");
        String nomeLista = scan.nextLine();
        ListadCompra lista = gerenciador.buscarListaCompra(nomeLista);
        if (lista != null) {
            double valorTotal = lista.calcularValorTotal();
            System.out.println("Valor Total da Lista: R$" + valorTotal);
        } else {
            System.out.println("Lista de Compras não encontrada!");
        }
        System.out.println("\n");

    }

    private static void calcularPesoTotalLista() {
        System.out.println("### Calcular Peso Total da Lista ###");
        System.out.println("Digite o nome da lista:");
        String nomeLista = scan.nextLine();
        ListadCompra lista = gerenciador.buscarListaCompra(nomeLista);
        if (lista != null) {
            double pesoTotal = lista.calcularPesoTotal();
            System.out.println("Peso Total da Lista: " + pesoTotal + " kg");
        } else {
            System.out.println("Lista de Compras não encontrada!");
        }
        System.out.println("\n");
    }

    private static void verSuaLista() {
        System.out.println("### Lista de Compras ###");
        System.out.println("Digite o nome da lista:");
        String nomeLista = scan.nextLine();
        ListadCompra lista = gerenciador.buscarListaCompra(nomeLista);
        if (lista != null) {
            List<Produto> produtosNaLista = lista.getProdutos();

            if (!produtosNaLista.isEmpty()) {
                System.out.println("Produtos na Lista:");
                for (int i = 0; i < produtosNaLista.size(); i++) {
                    Produto produto = produtosNaLista.get(i);
                    System.out.println(i + " - " + produto.toString());
                }
            } else {
                System.out.println("A lista está vazia.");
            }
        } else {
            System.out.println("Lista de Compras não encontrada!");
        }
    }

}
