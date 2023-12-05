package ifpr.pgua.eic.tads.contatos.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.FabricaConexoes;
import ifpr.pgua.eic.tads.contatos.model.Pedido;

public class JDBCPedidoDAO implements PedidoDAO {

    private FabricaConexoes fabricaConexoes;

    public JDBCPedidoDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Resultado<Pedido> criar(Pedido Pedido) {
        try {
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO Pedidos (nome, valor) VALUES (?, ?)");

            pstm.setString(1, Pedido.getNome());
            pstm.setDouble(2, Pedido.getValor());

            pstm.executeUpdate();

            con.close();
            return Resultado.sucesso("Pedido cadastrada com sucesso", Pedido);
        } catch (SQLException e) {
            return Resultado.erro("Erro ao cadastrar Pedido: " + e.getMessage());
        }
    }

    @Override
    public List<Pedido> listar() {
        // Implemente a lógica para listar as bebidas do banco de dados
        return null;
    }
}
