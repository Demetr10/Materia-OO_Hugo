package ifpr.pgua.eic.tads.contatos;

import ifpr.pgua.eic.tads.contatos.controllers.AddControllers;
import ifpr.pgua.eic.tads.contatos.controllers.indexController;
import ifpr.pgua.eic.tads.contatos.model.Agenda;
import ifpr.pgua.eic.tads.contatos.utils.JavalinUtils;
import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        Javalin app = JavalinUtils.makeApp(8080);
        Agenda agenda = new Agenda();
        indexController indexController = new indexController();
        AddControllers addControllers = new AddControllers(agenda);
        app.get("/",indexController.get);
        app.get("/add",addControllers.get);
        app.post("/add",addControllers.post);
    }
    ****
}
