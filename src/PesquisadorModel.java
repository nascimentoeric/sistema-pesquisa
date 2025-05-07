import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class PesquisadorModel {

    public static void create(PesquisadorBean p, Connection con) throws SQLException {
        String sql = "INSERT INTO pesquisador (id_pesquisador, nome, email, instituicao) VALUES (?, ?, ?, ?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, p.getIdPesquisador());
        st.setString(2, p.getNome());
        st.setString(3, p.getEmail());
        st.setString(4, p.getInstituicao());
        st.execute();
        st.close();
    }

    public static HashSet<PesquisadorBean> listAll(Connection con) throws SQLException {
        HashSet<PesquisadorBean> list = new HashSet<>();
        String sql = "SELECT id_pesquisador, nome, email, instituicao FROM pesquisador";
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);

        while (result.next()) {
            PesquisadorBean p = new PesquisadorBean(
                result.getInt("id_pesquisador"),
                result.getString("nome"),
                result.getString("email"),
                result.getString("instituicao")
            );
            list.add(p);
        }

        result.close();
        st.close();
        return list;
    }

    public static void remove(int idPesquisador, Connection con) throws SQLException {
        String sql = "DELETE FROM pesquisador WHERE id_pesquisador = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, idPesquisador);
        st.execute();
        st.close();
    }

    public static void update(PesquisadorBean p, Connection con) throws SQLException {
        String sql = "UPDATE pesquisador SET nome = ?, email = ?, instituicao = ? WHERE id_pesquisador = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, p.getNome());
        st.setString(2, p.getEmail());
        st.setString(3, p.getInstituicao());
        st.setInt(4, p.getIdPesquisador());
        st.execute();
        st.close();
    }
}
