package src;
public class Cavalo extends Animal {

    public Cavalo(String nome, double idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void emitirSom() {
        System.out.println("Hiná, híná");
    }

    @Override
    public void correr() {
        System.out.println("O cavalo está correndo");
    }
}
