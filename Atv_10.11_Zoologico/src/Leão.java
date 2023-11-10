package src;
public class Leão extends Animal {

    public Leão(String nome, double idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void emitirSom() {
        System.out.println("Rrrrrrr");
    }

    @Override
    public void correr() {
        System.out.println("O cavalo está correndo");
    }
}
