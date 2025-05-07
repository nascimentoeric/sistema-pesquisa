import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class ParticipaProjetoModel {

    public static void create(ParticipaProjetoBean p, Connection con) throws SQLException {
        String sql = "INSERT INTO participa_projeto (id_pesquisador, id_projeto, papel) VALUES (?, ?, ?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, p.getIdPesquisador());
        st.setInt(2, p.getIdProjeto());
        st.setString(3, p.getPapel());
        st.execute();
        st.close();
    }

    public static HashSet<ParticipaProjetoBean> listAll(Connection con) throws SQLException {
        HashSet<ParticipaProjetoBean> list = new HashSet<>();
        String sql = "SELECT id_pesquisador, id_projeto, papel FROM participa_projeto";
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);

        while (result.next()) {
            ParticipaProjetoBean p = new ParticipaProjetoBean(
                result.getInt("id_pesquisador"),
                result.getInt("id_projeto"),
                result.getString("papel")
            );
            list.add(p);
        }

        result.close();
        st.close();
        return list;
    }

    public static void remove(int idPesquisador, int idProjeto, Connection con) throws SQLException {
        String sql = "DELETE FROM participa_projeto WHERE id_pesquisador = ? AND id_projeto = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, idPesquisador);
        st.setInt(2, idProjeto);
        st.execute();
        st.close();
    }

    public static void update(ParticipaProjetoBean p, Connection con) throws SQLException {
        String sql = "UPDATE participa_projeto SET papel = ? WHERE id_pesquisador = ? AND id_projeto = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, p.getPapel());
        st.setInt(2, p.getIdPesquisador());
        st.setInt(3, p.getIdProjeto());
        st.execute();
        st.close();
    }
}
