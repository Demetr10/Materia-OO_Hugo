public abstract class Animal {

    private String nome;
    private double idade;
    private double peso;

    public Animal(String nome, double idade, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public abstract void emitirSom();

    public String gerarDetalhes() {
        return "Nome: " + nome + " | Idade: " + idade + " | Peso: " + peso;
    }
}
