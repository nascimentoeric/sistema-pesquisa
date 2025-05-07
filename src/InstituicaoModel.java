import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;


public class InstituicaoModel {

    public static void create(InstituicaoBean a, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement(
            "INSERT INTO instituicao (id_instituicao, nome, tipo, pais) VALUES (?, ?, ?, ?)"
        );
        st.setInt(1, a.getIdInstituicao());
        st.setString(2, a.getNome());
        st.setString(3, a.getTipo());
        st.setString(4, a.getPais());
        st.execute();
        st.close();
    }

    public static HashSet<InstituicaoBean> listAll(Connection con) throws SQLException {
        Statement st = con.createStatement();
        HashSet<InstituicaoBean> list = new HashSet<>();
        String sql = "SELECT id_instituicao, nome, tipo, pais FROM instituicao";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            InstituicaoBean inst = new InstituicaoBean(
                result.getInt("id_instituicao"),
                result.getString("nome"),
                result.getString("tipo"),
                result.getString("pais")
            );
            list.add(inst);
        }
        result.close();
        st.close();
        return list;
    }

    public static void remove(int id, Connection con) throws SQLException {
        String sql = "DELETE FROM instituicao WHERE id_instituicao = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);
        st.execute();
        st.close();
    }

    public static void update(InstituicaoBean a, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement(
            "UPDATE instituicao SET nome = ?, tipo = ?, pais = ? WHERE id_instituicao = ?"
        );
        st.setString(1, a.getNome());
        st.setString(2, a.getTipo());
        st.setString(3, a.getPais());
        st.setInt(4, a.getIdInstituicao());
        st.execute();
        st.close();
    }
}
