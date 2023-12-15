package ifpr.pgua.eic.tads.contatos.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.entities.FabricaConexoes;
import ifpr.pgua.eic.tads.contatos.model.entities.Pedido;

public class JDBCPedidoDAO implements PedidoDAO {
    private FabricaConexoes fabricaConexoes;

    public JDBCPedidoDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Resultado<Pedido> criar(Pedido pedido) {
        try {
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con
                    .prepareStatement("INSERT INTO pedidos (observacao, id_bebida, id_lanche) VALUES (?, ?, ?)");

            pstm.setString(1, pedido.getObservacao());
            pstm.setInt(2, pedido.getBebida());
            pstm.setInt(3, pedido.getLanche());

            pstm.executeUpdate();

            con.close();
            return Resultado.sucesso("Pedido cadastrado com sucesso", pedido);
        } catch (SQLException e) {
            return Resultado.erro("Erro ao cadastrar pedido: " + e.getMessage());
        }
    }

    @Override
    public Resultado<List<Pedido>> listar() {
        List<Pedido> pedidos = new ArrayList<>();

        try {
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement(
                    "SELECT * FROM pedidos inner join bebidas inner join lanches on pedidos.id_bebida = bebidas.id_bebida AND pedidos.id_lanche = lanches.id_lanche  \\r\\n"
                            + //
                            "\"\r\n" + //
                            "                            + //\r\n" + //
                            "                            \"ORDER BY `pedidos`.`id_pedido` ASC");

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");

                int bebida = rs.getInt("id_bebida");
                int lanche = rs.getInt("id_lanche");

                Pedido pedido = new Pedido(id, observacao, bebida, lanche);

                pedidos.add(pedido);
            }

            con.close();
            return Resultado.sucesso("Pedidos carregados", pedidos);
        } catch (SQLException e) {
            return Resultado.erro("Problema ao fazer seleção!! " + e.getMessage());
        }
    }
}
