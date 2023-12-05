
package ifpr.pgua.eic.tads.contatos.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.FabricaConexoes;
// import ifpr.pgua.eic.tads.contatos.model.repositories.Lanche;
import ifpr.pgua.eic.tads.contatos.model.Lanche;

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
    public List<Lanche> listar() {
        // Implemente a lógica para poder criar a listar as bebidas do banco de dados
        return null;
    }
}
