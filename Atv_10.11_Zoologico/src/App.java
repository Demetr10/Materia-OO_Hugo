package src;
import java.util.Scanner;

public class App {
    private static Scanner ler;
    private static Zoo zoológico;

    private static String menu() {
        String str = "";
        System.out.println("Menu:");
        System.out.println("1. Cadastrar animal");
        System.out.println("2. Listar animais");
        System.out.println("3. Contar animais por tipo");
        System.out.println("4. Fazer todos os animais emitirem som");
        System.out.println("5. Fazer os cavalos e os leões correrem");
        System.out.println("9. Sair");
        return str;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // public App() {
        ler = new Scanner(System.in);
        zoológico = new Zoo();
        int opcao = 0;

        // this.zoológico = new Zoo();

        // public void executar() {

            // int tipo;
        do {

            System.out.println(menu());
            opcao = ler.nextInt();
            // ler.nextLine();

            switch (opcao) {
                case 1:
                ler.nextLine();
                    System.out.println("Informe o nome do animal:");
                    String nome = System.console().readLine();
                    System.out.println("Informe a idade do animal:");
                    double idade = Double.parseDouble(System.console().readLine());
                    System.out.println("Informe o peso do animal:");
                    double peso = Double.parseDouble(System.console().readLine());

                    System.out.println("Escolha o tipo do animal:");
                    System.out.println("1. Cavalo");
                    System.out.println("2. Leão");
                    System.out.println("3. Preguiça");

                    int tipo = ler.nextInt();
                    // Integer.parseInt(System.console().readLine());
                    // opcao = ler.nextInt();
                do{
                    switch (tipo) {
                        case 1:
                            zoológico.cadastrar(new Cavalo(nome, idade, peso));
                            break;
                        case 2:
                            zoológico.cadastrar(new Leão(nome, idade, peso));
                            break;
                        case 3:
                            zoológico.cadastrar(new Preguica(nome, idade, peso));
                            break;
                            default:   System.out.println("opção inválida!");
                            break;
                    }
                }    while (tipo < 1 || tipo > 3);
                break;
                    // break;
                case 2:
                    System.out.println(zoológico.listarAnimais());
                    break;
                case 3:
                    System.out.println(zoológico.contarAnimais("Cavalo"));
                    System.out.println(zoológico.contarAnimais("Leão"));
                    System.out.println(zoológico.contarAnimais("Preguiça"));
                    break;
                case 4:
                    zoológico.invocarEmitirSom();
                    break;
                case 5:
                    // System.out.println("Informe o nome do animal:");
                    // String nomeAnimal = ler.nextLine();
                    zoológico.invocarCorrer();
                    break;
                case 0:
                    System.out.println("Até a próxima!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);

    }

}

// Cavalo cavalo = new Cavalo("Fala-Fala", 5, 300);
// zoológico.cadastrar(cavalo);

// zoológico.invocarCorrer();
// public static void main(String[] args) {
// App app = new App();
// app.executar();
// }
