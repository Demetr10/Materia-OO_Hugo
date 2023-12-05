
package ifpr.pgua.eic.tads.contatos.model.daos;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.repositories.PedidoRepository;

public interface PedidoDAO {
    Resultado<PedidoRepository> criar(PedidoDAO pedido);

    Resultado<List<PedidoRepository>> listar();
}
