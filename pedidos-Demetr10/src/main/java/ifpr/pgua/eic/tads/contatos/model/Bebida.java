package ifpr.pgua.eic.tads.contatos.model;

// package ifpr.pgua.eic.tads.pedidos.model;

public class Bebida {

    private int id;
    private String nome;
    private double valor;

    public Bebida(int id, String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public Bebida(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ID: " + id + "<br> Nome: " + nome + "<br> Valor: " + valor;
    }
}
