package ifpr.pgua.eic.tads.contatos.model.daos;

import java.sql.SQLException;
import java.util.List;

import com.github.hugoperlin.results.Resultado;
import java.sql.Connection;
import java.sql.PreparedStatement;

import ifpr.pgua.eic.tads.contatos.model.Contato;
import ifpr.pgua.eic.tads.contatos.model.FabricaConexoes;

public class JDBCContatoDAO implements ContatoDAO {

    private FabricaConexoes fabricaConexoes;

    public JDBCContatoDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Resultado<Contato> criar(Contato contato) {
        try {
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con
                    .prepareStatement("INSERT INTO oo_contatos(nome, email, telefone) VALUES (?,?,?)");

            pstm.setString(1, contato.getNome());
            pstm.setString(2, contato.getEmail());
            pstm.setString(3, contato.getTelefone());

            pstm.executeUpdate();

            con.close();
            return Resultado.sucesso("Contato cadastrado ", contato);

        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado<List<Contato>> listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

}
