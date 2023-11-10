package ifpr.pgua.eic.tads.contatos.controllers;

import ifpr.pgua.eic.tads.contatos.model.Agenda;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class AddControllers {
    
    private Agenda agenda;

    public AddControllers (Agenda agenda){
        this.agenda = agenda;
    }

    // Adicionar um contato na lista de contatos
    
    public Handler get = (Context ctx)->{
        ctx.render("templates/add.html");
    };

    public Handler post = (Context ctx)->{
        String nome = ctx.formParam("nome");
        String email = ctx.formParam("email");
        String telefone = ctx.formParam("telefone");

        // ctx.html("Nome:"+nome+ "Email:"+email+ "telefone"+telefone);
        String resultado = agenda.cadastrar(nome, email, telefone);
        System.out.println(agenda.listar());
        ctx.html(resultado+"<a href=\"/\">Voltar</a>");
    };
}
