package ifpr.pgua.eic.tads.contatos.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.entities.Bebida;
import ifpr.pgua.eic.tads.contatos.model.entities.FabricaConexoes;
import ifpr.pgua.eic.tads.contatos.model.entities.Pedido;

public class JDBCBebidaDAO implements BebidaDAO {

    FabricaConexoes fabricaConexoes;

    public JDBCBebidaDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Resultado<Bebida> criar(Bebida bebida) {
        try {
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con
                    .prepareStatement("INSERT INTO bebidas (nome_bebida, valor_bebida) VALUES (?, ?)");

            pstm.setString(1, bebida.getNome());
            pstm.setDouble(2, bebida.getValor());

            pstm.executeUpdate();

            con.close();
            return Resultado.sucesso("Bebida cadastrada com sucesso", bebida);
        } catch (SQLException e) {
            return Resultado.erro("Erro ao cadastrar bebida: " + e.getMessage());
        }
    }

    @Override
    public Resultado<List<Bebida>> listar() {
        ArrayList<Bebida> lista = new ArrayList<>();
        try {
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement(
                    "SELECT * from bebidas inner JOIN pedidos on bebidas.id_bebida=pedidos.id_bebida WHERE pedidos.id_pedido=?");

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_bebida");
                String nome = rs.getString("nome_bebida");
                Double valor = rs.getDouble("valor_bebida");

                Bebida bebida = new Bebida(id, nome, valor);

                lista.add(bebida);
            }
            con.close();
            return Resultado.sucesso("Bebida carregada", lista);
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
        // return null;
    }

    @Override
    public Resultado<Bebida> buscarBebidaPedido(Pedido pedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarBebidaPedido'");
    }
}
