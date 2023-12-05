package ifpr.pgua.eic.tads.contatos.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.Bebida;
import ifpr.pgua.eic.tads.contatos.model.FabricaConexoes;

public class JDBCBebidaDAO implements BebidaDAO {

    private FabricaConexoes fabricaConexoes;

    public JDBCBebidaDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Resultado<Bebida> criar(Bebida bebida) {
        try {
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO bebidas (nome, valor) VALUES (?, ?)");

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
    public List<Bebida> listar() {
        // Implemente a lógica para listar as bebidas do banco de dados
        return null;
    }
}
