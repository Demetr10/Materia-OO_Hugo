import java.util.ArrayList;

public class Zoo {

    private ArrayList<Animal> animais;

    public Zoo() {
        this.animais = new ArrayList<>();
    }

    public void cadastrar(Animal animal) {
        this.animais.add(animal);
    }

    public String listarAnimais() {
        String animaisListados = "";
        for (Animal animal : this.animais) {
            animaisListados += animal.gerarDetalhes() + "\n";
        }
        return animaisListados;
    }

    public String contarAnimais(String tipo) {
        int contador = 0;
        for (Animal animal : this.animais) {
            if (animal.getClass().getSimpleName().equals(tipo)) {
                contador++;
            }
        }
        return "Quantidade de animais do tipo " + tipo + ": " + contador;
    }

    /**
     * 
     */
    public void invocarEmitirSom() {
        for (Animal animal : this.animais) {
            animal.emitirSom();
        }
    }

    public void invocarCorrer(String nome) {
        for (Animal animal : animais) {
            if (animal.getNome().equals(nome)) {
                if (animal instanceof Cavalo) {
                    Cavalo cavalo = (Cavalo) animal;
                    cavalo.correr();

                } else {
                    if (animal instanceof Leão) {
                        Leão Leão = (Leão) animal;
                        Leão.correr();
                    } else {
                        if (animal instanceof Preguica) {
                            Preguica preguica = (Preguica) animal;
                            preguica.escalarArvore();
                        }

                    }

                }

            }
        }

    }
    // public void invocarCorrer() {
    // for (Animal animal : this.animais) {
    // if (animal instanceof Cavalo || animal instanceof Leão) {
    // animal.correr();
    // }
    // }
}