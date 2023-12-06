// package ifpr.pgua.eic.tads.contatos.controllers;

// import com.github.hugoperlin.results.Resultado;

// import ifpr.pgua.eic.tads.contatos.model.entities.Bebida;
// import ifpr.pgua.eic.tads.contatos.model.entities.Lanche;
// import ifpr.pgua.eic.tads.contatos.model.repositories.BebidaRepository;
// // import
// ifpr.pgua.eic.tads.contatos.model.repositories.ImplBebidaRepository;
// // import
// ifpr.pgua.eic.tads.contatos.model.repositories.ImplLancheRepository;
// import ifpr.pgua.eic.tads.contatos.model.repositories.LancheRepository;
// import io.javalin.http.Context;
// import io.javalin.http.Handler;

// public class AddController {

// private BebidaRepository bebidaRepository;
// private LancheRepository lancheRepository;

// public AddController(BebidaRepository bebidaRepository, LancheRepository
// lancheRepository) {
// this.bebidaRepository = bebidaRepository;
// this.lancheRepository = lancheRepository;
// }

// public Handler get = (Context ctx) -> {
// ctx.render("templates/add.html");
// };

// public Handler post = (Context ctx) -> {
// String tipo = ctx.formParam("tipo");
// String nome = ctx.formParam("nome");
// double valor = Double.parseDouble(ctx.formParam("valor"));

// // Resultado<Bebida> resultado = repositorio.cadastrar(nome, valor);

// Resultado resultado;
// if ("bebida".equalsIgnoreCase(tipo)) {
// Bebida bebida = new Bebida(nome, valor);
// resultado = bebidaRepository.cadastrar(nome, valor);
// } else if ("lanche".equalsIgnoreCase(tipo)) {
// Lanche lanche = new Lanche(nome, valor);
// resultado = lancheRepository.cadastrar(nome, valor);
// } else {
// resultado = Resultado.erro("Tipo desconhecido");
// }

// ctx.html(resultado.getMsg() + "<br/><a href=\"/\">Voltar</a>");
// };
// }
