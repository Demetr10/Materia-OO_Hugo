package ifpr.pgua.eic.tads.contatos.model.repositories;

import java.util.List;

// import ifpr.pgua.eic.tads.contatos.model.results.Result;
import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.Lanche;
import ifpr.pgua.eic.tads.contatos.model.daos.LancheDAO;

public class LancheRepository {

    private LancheDAO dao;

    public LancheRepository(LancheDAO dao) {
        this.dao = dao;
    }

    public Resultado cadastrar(String nome, Double valor) {
        // int year = LocalDate.now().getYear();
        // if(paginas <= 0 || anoPublicacao > year){
        // return Resultado.erro("Nao");
        // }

        Lanche lanche = new Lanche(nome, valor);
        return dao.criar(lanche);
    }

    public List<Lanche> listar() {
        return dao.listar();
    }

}