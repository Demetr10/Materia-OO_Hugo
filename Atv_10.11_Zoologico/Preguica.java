public class Preguica extends Animal {

    public Preguica(String nome, double idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void emitirSom() {
        System.out.println("Uai, uai");
    }

    // @Override
    // public void correr() {
    // System.out.println("A preguiça está escalando uma árvore");
    // }
}
