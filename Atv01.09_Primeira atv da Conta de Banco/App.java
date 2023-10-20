import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int escolha;
        boolean continuar = true;

       while(continuar){ 
        System.out.println("\nEscolha entre 01 e 02: ");
        System.out.println("01 - Cadastrar Conta ");
        System.out.println("02 - Cadastrar Pessoa ");
        escolha = ler.nextInt();
        ler.nextLine();

        switch (escolha) {
            case 1:
                System.out.print("\nInforme Nome da Conta: ");
                String nomeConta = ler.nextLine();
                System.out.print("\nInforme o Numero da Conta: ");
                String numeroConta = ler.nextLine();
                System.out.print("\nInforme a Senha da Conta: ");
                String senhaConta = ler.nextLine();
                System.out.print("\nInforme o Saldo da Conta: ");
                double saldoConta = ler.nextDouble();
                ler.nextLine();
                Conta conta = new Conta(nomeConta, numeroConta, saldoConta, senhaConta);
                System.out.println("----\nDados da Conta-----");
                System.out.println(conta.toString());
                break;

            case 2:
                System.out.print("\nInforme seu Nome: ");
                String nome = ler.nextLine();
                System.out.print("\nInforme seu CPF: ");
                String cpf = ler.nextLine();
                System.out.print("\nInforme seu Email: ");
                String email = ler.nextLine();
                System.out.print("\nInforme seu Telefone: ");
                String tell = ler.nextLine();

                Pessoa pessoa = new Pessoa(nome, cpf, email, tell);
                System.out.println("\nDados Pessoais: ");
                System.out.println(pessoa.toString());
                break;

            default:
                System.out.println("OPCAO INVALIDA");
        }
        System.out.print("\nQuer repetir? 1 - sim / 2 - não:\n");
        int resposta = ler.nextInt();
        ler.nextLine();
        if(resposta != 1 ){
            continuar = false;
        }
    }
        ler.close();
    }
}