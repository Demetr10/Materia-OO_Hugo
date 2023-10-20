package OO_;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ContaBanks conta;

        conta = new ContaBanks();

        System.out.println("Registro de Conta Bancária");

        System.out.print("Número da Conta: ");
        conta.numeroConta = scanner.nextInt();

        System.out.print("Agência: ");
        conta.agencia = scanner.nextInt();

        System.out.print("Senha: ");
        scanner.nextLine(); // Limpar o buffer
        conta.senha = scanner.nextLine();

        System.out.print("Saldo: ");
        conta.saldo = scanner.nextDouble();

        System.out.print("CPF: ");
        scanner.nextLine(); // Limpar o buffer
        conta.cpf = scanner.nextLine();

        System.out.println("Conta registrada com sucesso:");

        System.out.println("Número da Conta: " + conta.numeroConta);
        System.out.println("Agência: " + conta.agencia);
        System.out.println("Senha: " + conta.senha);
        System.out.println("Saldo: " + conta.saldo);
        System.out.println("CPF: " + conta.cpf);

        scanner.close();
    }
}
// variaveis