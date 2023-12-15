package ifpr.pgua.eic.tads.contatos.model.repositories;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.daos.BebidaDAO;
import ifpr.pgua.eic.tads.contatos.model.daos.LancheDAO;
import ifpr.pgua.eic.tads.contatos.model.daos.PedidoDAO;
import ifpr.pgua.eic.tads.contatos.model.entities.Bebida;
import ifpr.pgua.eic.tads.contatos.model.entities.Lanche;
import ifpr.pgua.eic.tads.contatos.model.entities.Pedido;

public class ImplPedidoRepository implements PedidoRepository {

    private PedidoDAO dao;
    private BebidaDAO bebidaDao;
    private LancheDAO lancheDao;

    public ImplPedidoRepository(PedidoDAO dao, BebidaDAO bebidaDao, LancheDAO lancheDao) {
        this.dao = dao;
        this.bebidaDao = bebidaDao;
        this.lancheDao = lancheDao;
    }

    @Override
    public Resultado<Pedido> cadastrar(String observacao, int id_lanche, int id_bebida) {

        Pedido Pedido = new Pedido(observacao, id_bebida, id_lanche);

        return dao.criar(Pedido);
    }

    @Override
    public Resultado<List<Pedido>> listar() {
        Resultado<List<Pedido>> resultado = dao.listar();
        if (resultado.foiSucesso()) {
            List<Pedido> lista = resultado.comoSucesso().getObj();
            for (Pedido p : lista) {
                // return dao.listar();

                Resultado<Bebida> b2 = bebidaDao.buscarBebidaPedido(p);
                Resultado<Lanche> l3 = lancheDao.buscarLanchePedido(p);
                if (b2.foiErro()) {
                    return l3.comoErro();
                }
                if (l3.foiErro()) {
                    return l3.comoErro();
                    // } else {
                    // p.setBebida(b2.comoSucesso().getObj());
                    // p.setLanche(.comoSucesso().getObj());
                    // }
                    // }
                }

            }
        }
        return resultado;
    }
}