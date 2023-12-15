package ifpr.pgua.eic.tads.contatos;

import ifpr.pgua.eic.tads.contatos.controllers.AddBebidaController;
import ifpr.pgua.eic.tads.contatos.controllers.AddLancheController;
import ifpr.pgua.eic.tads.contatos.controllers.AddPedidoController;
import ifpr.pgua.eic.tads.contatos.controllers.IndexController;
import ifpr.pgua.eic.tads.contatos.controllers.ListBebidasController;
import ifpr.pgua.eic.tads.contatos.controllers.ListLancheController;
import ifpr.pgua.eic.tads.contatos.controllers.ListPedidoController;
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
        ListBebidasController listBebidaController = new ListBebidasController(bebidaRepository);

        IndexController indexController = new IndexController();

        app.get("/", indexController.get);
        app.get("/addBebida.peb", addbebidaController.get);
        app.post("/addBebida.peb", addbebidaController.post);
        app.get("/listBebidas.peb", listBebidaController.get);

        LancheDAO lancheDAO = new JDBCLancheDAO(FabricaConexoes.getInstance());
        LancheRepository lancheRepository = new ImplLancheRepository(lancheDAO);
        AddLancheController addlancheController = new AddLancheController(lancheRepository);
        ListLancheController listLancheController = new ListLancheController(lancheRepository);

        app.get("/addLanche.peb", addlancheController.get);
        app.post("/addLanche.peb", addlancheController.post);
        app.get("/listLanches.peb", listLancheController.get);

        PedidoDAO pedidoDAO = new JDBCPedidoDAO(FabricaConexoes.getInstance());
        PedidoRepository pedidoRepository = new ImplPedidoRepository(pedidoDAO, bebidaDAO, lancheDAO);
        AddPedidoController addPedidoController = new AddPedidoController(pedidoRepository, bebidaRepository,
                lancheRepository);
        ListPedidoController listPedidoController = new ListPedidoController(pedidoRepository);

        app.get("/addPedido.peb", addPedidoController.get);
        app.post("/addPedido.peb", addPedidoController.post);

        app.get("/listPedidos.peb", listPedidoController.get);
    }

    // app.get("/Pedido/add", addPedidoController.get);
    // app.get("/listPedido.peb", listPedidoController.get);
    // app.post("/add",addController.post);
    // app.get("/list",listController.get);

    // app.get("/addTarefa",addTarefaController.get);
    // app.post("/addTarefa",addTarefaController.post);
    // app.get("/listTarefa",listTarefaController.get);

}
