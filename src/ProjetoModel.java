import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class ProjetoModel {

    public static void create(ProjetoBean projeto, Connection con) throws SQLException {
    String sql = "INSERT INTO projeto (id_coordenador, id_instituicao, titulo, area_pesquisa, data_inicio, data_fim) VALUES (?,?,?,?,?,?)";
    PreparedStatement st = con.prepareStatement(sql);
    st.setInt(1, projeto.getIdCoordenador());
    st.setInt(2, projeto.getIdInstituicao());
    st.setString(3, projeto.getTitulo());
    st.setString(4, projeto.getAreaPesquisa());
    st.setDate(5, projeto.getDataInicio());
    st.setDate(6, projeto.getDataFim());
    st.executeUpdate();
    st.close();
}


    public static HashSet<ProjetoBean> listAll(Connection con) throws SQLException {
        HashSet<ProjetoBean> list = new HashSet<>();
        String sql = "SELECT id_projeto, id_coordenador, id_instituicao, titulo, area_pesquisa, data_inicio, data_fim FROM projeto";
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);

        while (result.next()) {
            ProjetoBean p = new ProjetoBean(
                result.getInt("id_projeto"),
                result.getInt("id_coordenador"),
                result.getInt("id_instituicao"),
                result.getString("titulo"),
                result.getString("area_pesquisa"),
                result.getDate("data_inicio"),
                result.getDate("data_fim")
            );
            list.add(p);
        }

        result.close();
        st.close();
        return list;
    }

    public static void remove(int idProjeto, Connection con) throws SQLException {
        String sql = "DELETE FROM projeto WHERE id_projeto = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, idProjeto);
        st.execute();
        st.close();
    }
    
    public static boolean exists(int idProjeto, Connection con) throws SQLException {
    String sql = "SELECT 1 FROM projeto WHERE id_projeto = ?";
    PreparedStatement st = con.prepareStatement(sql);
    st.setInt(1, idProjeto);
    ResultSet rs = st.executeQuery();
    boolean exists = rs.next();
    rs.close();
    st.close();
    return exists;
}

public static int getNextId(Connection con) throws SQLException {
    String sql = "SELECT COALESCE(MAX(id_projeto), 0) + 1 FROM projeto";
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(sql);
    rs.next();
    int nextId = rs.getInt(1);
    rs.close();
    st.close();
    return nextId;
}

}

