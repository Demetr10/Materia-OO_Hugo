package ifpr.pgua.eic.tads.contatos.model.repositories;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.daos.PedidoDAO;
import ifpr.pgua.eic.tads.contatos.model.entities.Pedido;

public class ImplPedidoRepository implements PedidoRepository {

    private PedidoDAO dao;

    public ImplPedidoRepository(PedidoDAO dao) {
        this.dao = dao;
    }

    @Override
    public Resultado<Pedido> cadastrar(String observacao, int id_lanche, int id_bebida) {
        // if (nome.isBlank() || nome.isEmpty()) {
        // return Resultado.erro("Nome inválido");
        // }

        // if (valor.isNaN() || valor <= 0) {
        // return Resultado.erro("Valor inválido");
        // }

        Pedido Pedido = new Pedido(observacao, id_bebida, id_lanche);

        return dao.criar(Pedido);
    }

    @Override
    public Resultado<List<Pedido>> listar() {
        return dao.listar();
    }

}