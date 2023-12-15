
package ifpr.pgua.eic.tads.contatos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.entities.Bebida;
import ifpr.pgua.eic.tads.contatos.model.entities.Lanche;
import ifpr.pgua.eic.tads.contatos.model.entities.Pedido;
import ifpr.pgua.eic.tads.contatos.model.repositories.BebidaRepository;
import ifpr.pgua.eic.tads.contatos.model.repositories.LancheRepository;
import ifpr.pgua.eic.tads.contatos.model.repositories.PedidoRepository;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class AddPedidoController {

    private PedidoRepository repositorio;
    private LancheRepository lancherepositorio;
    private BebidaRepository bebidarepositorio;

    public AddPedidoController(PedidoRepository repositorio, BebidaRepository bebidaRepository,
            LancheRepository lancheRepository) {
        this.repositorio = repositorio;
        this.bebidarepositorio = bebidaRepository;
        this.lancherepositorio = lancheRepository;
    }

    public Handler get = (Context ctx) -> {

        Resultado<List<Bebida>> resultadobebida = bebidarepositorio.listar();

        Resultado<List<Lanche>> resultadolanche = lancherepositorio.listar();

        Map<String, Object> model = new HashMap<>();

        model.put("bebidas", resultadobebida.comoSucesso().getObj());
        model.put("lanches", resultadolanche.comoSucesso().getObj());
        // model.put("resultadobebida", resultadobebida);
        // model.put("resultadolanche", resultadolanche);
        // if (resultadobebida.foiSucesso() && resultadolanche.foiSucesso()) {
        // model.put("listabebida", resultadobebida.comoSucesso().getObj());
        // model.put("listalanche", resultadolanche.comoSucesso().getObj());
        // }

        ctx.render("templates/addPedido.peb", model);
    };
    private int id_bebida;
    private int id_lanche;

    public Handler post = (Context ctx) -> {
        String idbebida = ctx.formParam("bebida");
        String idlanche = ctx.formParam("lanche");
        String observacao = ctx.formParam("observacao");

        // int id_bebida = Integer.parseInt(ctx.formParam("id_bebida"));
        // int id_lanche = Integer.parseInt(ctx.formParam("id_lanche"));

        Resultado<Bebida> resultadobebida = bebidarepositorio.getById(Integer.valueOf(idbebida));
        Resultado<Lanche> resultadolanche = lancherepositorio.getById(Integer.valueOf(idlanche));

        Bebida bebida = resultadobebida.comoSucesso().getObj();
        Lanche lanche = resultadolanche.comoSucesso().getObj();

        Resultado<Pedido> resultado = repositorio.cadastrar(observacao, id_bebida, id_lanche);

        Map<String, Object> model = new HashMap<>();
        model.put("resultado", resultado);
        if (resultado.foiErro()) {
            model.put("observacao", observacao);

            model.put("idbebida", Integer.valueOf(idbebida));
            Resultado<List<Bebida>> b2 = bebidarepositorio.listar();
            model.put("bebidas", b2.comoSucesso().getObj());

            model.put("idlanche", Integer.valueOf(idlanche));
            Resultado<List<Lanche>> l2 = lancherepositorio.listar();
            model.put("lanches", l2.comoSucesso().getObj());
        }

        ctx.render("templates/addPedido.peb", model);

    };
};