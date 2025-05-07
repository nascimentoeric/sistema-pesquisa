import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class OrientandoModel {

    public static void create(OrientandoBean o, Connection con) throws SQLException {
        String sql = "INSERT INTO orientando (id_orientando, nome, email, nivel_academico, id_projeto) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, o.getIdOrientando());
        st.setString(2, o.getNome());
        st.setString(3, o.getEmail());
        st.setString(4, o.getNivelAcademico());
        st.setInt(5, o.getIdProjeto());
        st.execute();
        st.close();
    }

    public static HashSet<OrientandoBean> listAll(Connection con) throws SQLException {
        HashSet<OrientandoBean> list = new HashSet<>();
        String sql = "SELECT id_orientando, nome, email, nivel_academico, id_projeto FROM orientando";
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);

        while (result.next()) {
            OrientandoBean o = new OrientandoBean(
                result.getInt("id_orientando"),
                result.getString("nome"),
                result.getString("email"),
                result.getString("nivel_academico"),
                result.getInt("id_projeto")
            );
            list.add(o);
        }

        result.close();
        st.close();
        return list;
    }

    public static void remove(int idOrientando, Connection con) throws SQLException {
        String sql = "DELETE FROM orientando WHERE id_orientando = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, idOrientando);
        st.execute();
        st.close();
    }

    public static void update(OrientandoBean o, Connection con) throws SQLException {
        String sql = "UPDATE orientando SET nome = ?, email = ?, nivel_academico = ?, id_projeto = ? WHERE id_orientando = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, o.getNome());
        st.setString(2, o.getEmail());
        st.setString(3, o.getNivelAcademico());
        st.setInt(4, o.getIdProjeto());
        st.setInt(5, o.getIdOrientando());
        st.execute();
        st.close();
    }
}
