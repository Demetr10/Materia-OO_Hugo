package ifpr.pgua.eic.tads.contatos.model.repositories;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.daos.LancheDAO;
import ifpr.pgua.eic.tads.contatos.model.entities.Lanche;

public class ImplLancheRepository implements LancheRepository {

    private LancheDAO dao;

    public ImplLancheRepository(LancheDAO dao) {
        this.dao = dao;
    }

    @Override
    public Resultado<Lanche> cadastrar(String nome, Double valor) {
        if (nome.isBlank() || nome.isEmpty()) {
            return Resultado.erro("Nome inválido");
        }

        if (valor.isNaN() || valor <= 0) {
            return Resultado.erro("Valor inválido");
        }

        Lanche Lanche = new Lanche(nome, valor);

        return dao.criar(Lanche);
    }

    @Override
    public Resultado<List<Lanche>> listar() {
        return dao.listar();
    }

}