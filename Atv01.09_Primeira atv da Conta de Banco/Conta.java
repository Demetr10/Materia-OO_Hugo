public class Conta {
    private String nomeConta;
    private String numeroConta;
    private double saldoConta;
    private String senhaConta;

    public Conta(String nomeConta, String numeroConta, double saldoConta, String senhaConta) {
        this.nomeConta = nomeConta;
        this.numeroConta = numeroConta;
        this.saldoConta = saldoConta;
        this.senhaConta = senhaConta;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public String getSenhaConta() {
        return senhaConta;
    }

    public void setSenhaConta(String senhaConta) {
        this.senhaConta = senhaConta;
    }

    public String toString() {
        return "\nNome da Conta: " + nomeConta +
                "\nNumero da Conta: " + numeroConta +
                "\nSenha da Conta: " + senhaConta +
                "\nSaldo da Conta: " + saldoConta;
    }
}