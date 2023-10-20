import java.util.ArrayList;
import java.util.List;

public class Gerenciador {

    private ArrayList<ListadCompra> listasdCompras;
    private ArrayList<Produto> produtos; // Adicione esta linha

    public Gerenciador() {
        listasdCompras = new ArrayList<>();
        produtos = new ArrayList<>(); // Inicialize a lista de produtos
    }

    public ListadCompra buscarListaCompra(String nomeLista) {
        for (ListadCompra lista : listasdCompras) {
            if (lista != null && lista.getNomeLista().equals(nomeLista)) {
                return lista;
            }
        }
        return null;
    }

    public boolean cadastrarListaCompra(String nomeLista) {
        ListadCompra listaexiste = buscarListaCompra(nomeLista);
        if (listaexiste == null) {
            ListadCompra novaLista = new ListadCompra(nomeLista);
            return listasdCompras.add(novaLista);
        }
        return false;
    }

    // Adicione os métodos para cadastrar e listar produtos
    public boolean cadastrarProduto(Produto produto) {
        return produtos.add(produto);
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

}
