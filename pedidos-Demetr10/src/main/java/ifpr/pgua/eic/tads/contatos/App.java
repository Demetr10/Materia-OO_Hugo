package ifpr.pgua.eic.tads.contatos;

import ifpr.pgua.eic.tads.contatos.controllers.AddBebidaController;
import ifpr.pgua.eic.tads.contatos.controllers.AddPedidoController;
import ifpr.pgua.eic.tads.contatos.controllers.IndexController;
import ifpr.pgua.eic.tads.contatos.model.daos.BebidaDAO;
import ifpr.pgua.eic.tads.contatos.model.daos.JDBCBebidaDAO;
import ifpr.pgua.eic.tads.contatos.model.daos.JDBCLancheDAO;
import ifpr.pgua.eic.tads.contatos.model.daos.JDBCPedidoDAO;
import ifpr.pgua.eic.tads.contatos.model.daos.LancheDAO;
import ifpr.pgua.eic.tads.contatos.model.daos.PedidoDAO;
import ifpr.pgua.eic.tads.contatos.model.entities.FabricaConexoes;
import ifpr.pgua.eic.tads.contatos.model.repositories.BebidaRepository;
import ifpr.pgua.eic.tads.contatos.model.repositories.ImplBebidaRepository;
import ifpr.pgua.eic.tads.contatos.model.repositories.ImplLancheRepository;
import ifpr.pgua.eic.tads.contatos.model.repositories.ImplPedidoRepository;
import ifpr.pgua.eic.tads.contatos.model.repositories.LancheRepository;
import ifpr.pgua.eic.tads.contatos.model.repositories.PedidoRepository;
import ifpr.pgua.eic.tads.contatos.utils.JavalinUtils;
import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Javalin app = JavalinUtils.makeApp(8080);

        BebidaDAO bebidaDAO = new JDBCBebidaDAO(FabricaConexoes.getInstance());
        BebidaRepository bebidaRepository = new ImplBebidaRepository(bebidaDAO);
        AddBebidaController addbebidaController = new AddBebidaController(bebidaRepository);

        IndexController indexController = new IndexController();

        app.get("/", indexController.get);
        app.get("/addBebida.peb", addbebidaController.get);
        app.post("/addBebida.peb", addbebidaController.post);

        LancheDAO lancheDAO = new JDBCLancheDAO(FabricaConexoes.getInstance());
        LancheRepository lancheRepository = new ImplLancheRepository(lancheDAO);

        PedidoDAO pedidoDAO = new JDBCPedidoDAO(FabricaConexoes.getInstance());
        PedidoRepository pedidoRepository = new ImplPedidoRepository(pedidoDAO);
        AddPedidoController addPedidoController = new AddPedidoController(pedidoRepository, bebidaRepository,
                lancheRepository);

        app.get("/Pedido/add", addPedidoController.get);

        // app.post("/add",addController.post);
        // app.get("/list",listController.get);

        // app.get("/addTarefa",addTarefaController.get);
        // app.post("/addTarefa",addTarefaController.post);
        // app.get("/listTarefa",listTarefaController.get);

    }
}
