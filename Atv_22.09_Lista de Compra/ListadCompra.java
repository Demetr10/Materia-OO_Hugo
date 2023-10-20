import java.util.ArrayList;
import java.util.List;

public class ListadCompra {
    private String nomeLista;
    private List<Produto> produtos;

    public ListadCompra(String nomeLista) {
        this.nomeLista = nomeLista;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (Produto produto : produtos) {
            valorTotal += produto.getPreco();
        }
        return valorTotal;
    }

    public double calcularPesoTotal() {
        double pesoTotal = 0.0;
        for (Produto produto : produtos) {
            pesoTotal += produto.getPeso();
        }
        return pesoTotal;
    }

    public String getNomeLista() {
        return nomeLista;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

}
/* */