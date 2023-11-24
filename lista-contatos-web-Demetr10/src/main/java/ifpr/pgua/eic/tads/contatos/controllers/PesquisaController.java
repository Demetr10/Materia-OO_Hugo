// package ifpr.pgua.eic.tads.contatos.controllers;

// import ifpr.pgua.eic.tads.contatos.model.Agenda;
// import ifpr.pgua.eic.tads.contatos.model.Contato;
// import io.javalin.http.Context;
// import io.javalin.http.Handler;

// public class PesquisaController {

// private Agenda agenda;

// public PesquisaController(Agenda agenda) {
// this.agenda = agenda;
// }

// public Handler get = (Context ctx) -> {
// ctx.render("templates/pesquisar.html");
// };

// public Handler post = (Context ctx) -> {
// String nome = ctx.formParam("nome");
// Contato resultado = agenda.buscar(nome);

// if (resultado != null) {
// ctx.html("Resultado da pesquisa: " + resultado + "<br/><a
// href=\"/\">Voltar</a>");
// } else {
// ctx.html("Contato não encontrado!<br/><a href=\"/\">Voltar</a>");
// }
// };

// // Adicionando uma rota para limpar os contatos cadastrados
// public Handler limpar = (Context ctx) -> {
// agenda.limpar();
// ctx.html("Contatos limpos!<br/><a href=\"/\">Voltar</a>");
// };

// }
