
package ifpr.pgua.eic.tads.contatos.model.daos;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.Lanche;

public interface LancheDAO {
    Resultado<Lanche> criar(Lanche lanche);

    List<Lanche> listar();
}
