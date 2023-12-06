
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

public class JDBCLancheDAO implements LancheDAO {

    private FabricaConexoes fabricaConexoes;

    public JDBCLancheDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Resultado<Lanche> criar(Lanche lanche) {
        try {
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO bebidas (nome, valor) VALUES (?, ?)");

            pstm.setString(1, lanche.getNome());
            pstm.setDouble(2, lanche.getValor());

            pstm.executeUpdate();

            con.close();
            return Resultado.sucesso("Bebida cadastrada com sucesso", lanche);
        } catch (SQLException e) {
            return Resultado.erro("Erro ao cadastrar bebida: " + e.getMessage());
        }
    }

    @Override
    public Resultado<List<Lanche>> listar() {
        ArrayList<Lanche> lista = new ArrayList<>();
        try {
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM oo_lanches");

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_lanche");
                String nome = rs.getString("nome_lanche");
                Double valor = rs.getDouble("valor_lanche");

                Lanche lanche = new Lanche(id, nome, valor);

                lista.add(lanche);
            }
            con.close();
            return Resultado.sucesso("Contatos carregados", lista);
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }

    }

}
