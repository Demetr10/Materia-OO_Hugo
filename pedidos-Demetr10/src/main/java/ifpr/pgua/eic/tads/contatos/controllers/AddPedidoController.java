// package ifpr.pgua.eic.tads.contatos.controllers;

// import java.util.HashMap;
// import java.util.Map;

// import com.github.hugoperlin.results.Resultado;

// import ifpr.pgua.eic.tads.contatos.model.entities.Pedido;
// import ifpr.pgua.eic.tads.contatos.model.repositories.PedidoRepository;
// import io.javalin.http.Context;
// import io.javalin.http.Handler;

// public class AddPedidoController {

// private PedidoRepository repositorio;

// public AddPedidoController(PedidoRepository repositorio) {
// this.repositorio = repositorio;
// }

// public Handler get = (Context ctx) -> {

// ctx.render("templates/addPedido.peb");
// };

// public Handler post = (Context ctx) -> {
// String nome = ctx.formParam("nome");
// Double valor = Double.parseDouble(ctx.formParam("valor"));

// Resultado<Pedido> resultado = repositorio.cadastrar(nome, valor);

// Map<String, Object> model = new HashMap<>();
// model.put("resultado", resultado);
// if (resultado.foiErro()) {
// model.put("nome", nome);
// model.put("valor", valor);

// }

// ctx.render("templates/addPedido.peb", model);
// };
// };

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

        Resultado<List<Bebida>> resultadobebida = this.bebidarepositorio.listar();

        Resultado<List<Lanche>> resultadolanche = this.lancherepositorio.listar();

        Map<String, Object> model = new HashMap<>();

        model.put("resultadobebida", resultadobebida);
        model.put("resultadolanche", resultadolanche);
        if (resultadobebida.foiSucesso() && resultadolanche.foiSucesso()) {
            model.put("listabebida", resultadobebida.comoSucesso().getObj());
            model.put("listalanche", resultadolanche.comoSucesso().getObj());
        }

        ctx.render("templates/addPedido.peb", model);
    };

    public Handler post = (Context ctx) -> {
        String observacao = ctx.formParam("observacao");

        int id_bebida = Integer.parseInt(ctx.formParam("id_bebida"));
        int id_lanche = Integer.parseInt(ctx.formParam("id_lanche"));

        Resultado<Pedido> resultado = repositorio.cadastrar(observacao, id_bebida, id_lanche);

        Map<String, Object> model = new HashMap<>();
        model.put("resultado", resultado);
        if (resultado.foiErro()) {
            model.put("observacao", observacao);
            model.put("id_lanche", id_lanche);
            model.put("id_lanche", id_bebida);
        }

        ctx.render("templates/addPedido.html", model);

    };
};