
package ifpr.pgua.eic.tads.contatos.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.entities.FabricaConexoes;
import ifpr.pgua.eic.tads.contatos.model.entities.Lanche;
import ifpr.pgua.eic.tads.contatos.model.entities.Pedido;

public class JDBCLancheDAO implements LancheDAO {

    FabricaConexoes fabricaConexoes;

    public JDBCLancheDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Resultado<Lanche> criar(Lanche lanche) {
        try {
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con
                    .prepareStatement("INSERT INTO lanches (nome_lanche, valor_lanche) VALUES (?, ?)");

            pstm.setString(1, lanche.getNome());
            pstm.setDouble(2, lanche.getValor());

            pstm.executeUpdate();

            con.close();
            return Resultado.sucesso("Lanche foi com sucesso", lanche);
        } catch (SQLException e) {
            return Resultado.erro("Erro ao cadastrar lanche: " + e.getMessage());
        }
    }

    @Override
    public Resultado<List<Lanche>> listar() {
        ArrayList<Lanche> lista = new ArrayList<>();
        try {
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM lanches");

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_lanche");
                String nome = rs.getString("nome_lanche");
                Double valor = rs.getDouble("valor_lanche");

                Lanche lanche = new Lanche(id, nome, valor);

                lista.add(lanche);
            }
            con.close();
            return Resultado.sucesso("Lanches carregados", lista);
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }

    }

    @Override
    public Resultado<Lanche> buscarLanchePedido(Pedido pedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarLanchePedido'");
    }

}
