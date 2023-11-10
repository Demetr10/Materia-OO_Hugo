package src;
public class Preguica extends Animal {

    public Preguica(String nome, double idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void emitirSom() {
        System.out.println("BELIGOOOOOOOOO,BELIGOOOOOOOOO");
    }

    @Override
    public void correr() {
        System.out.println("A preguiça está escalando uma árvore");
    }

    public void escalarArvore() {
    }
}
