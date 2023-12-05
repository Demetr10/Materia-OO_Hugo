package ifpr.pgua.eic.tads.contatos.model.repositories;

import java.util.List;

// import ifpr.pgua.eic.tads.contatos.model.results.Result;
import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.Bebida;
import ifpr.pgua.eic.tads.contatos.model.daos.BebidaDAO;

public class BebidaRepository {

    private BebidaDAO dao;

    public BebidaRepository(BebidaDAO dao) {
        this.dao = dao;
    }

    public Resultado cadastrar(String nome, Double valor) {
        // int year = LocalDate.now().getYear();
        // if(paginas <= 0 || anoPublicacao > year){
        // return Resultado.erro("Nao");
        // }

        Bebida bebida = new Bebida(nome, valor);
        return dao.criar(bebida);
    }

    public List<Bebida> listar() {
        return dao.listar();
    }

}