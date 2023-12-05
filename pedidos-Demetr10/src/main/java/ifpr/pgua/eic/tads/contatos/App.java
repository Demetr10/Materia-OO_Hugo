package ifpr.pgua.eic.tads.contatos;

import ifpr.pgua.eic.tads.contatos.utils.JavalinUtils;
import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Javalin app = JavalinUtils.makeApp(8080);

    }
}
