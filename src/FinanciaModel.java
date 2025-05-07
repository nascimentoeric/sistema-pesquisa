import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class FinanciaModel {

    public static void create(FinanciaBean f, Connection con) throws SQLException {
        String sql = "INSERT INTO financia (id_instituicao, id_projeto) VALUES (?, ?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, f.getIdInstituicao());
        st.setInt(2, f.getIdProjeto());
        st.execute();
        st.close();
    }

    public static HashSet<FinanciaBean> listAll(Connection con) throws SQLException {
        HashSet<FinanciaBean> list = new HashSet<>();
        String sql = "SELECT f.id_instituicao, i.nome AS nome_instituicao,\n" +
"               f.id_projeto, p.titulo AS nome_projeto\n" +
"        FROM financia f\n" +
"        JOIN instituicao i ON f.id_instituicao = i.id_instituicao\n" +
"        JOIN projeto p ON f.id_projeto = p.id_projeto";
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);

        while (result.next()) {
            FinanciaBean f = new FinanciaBean(
                result.getInt("id_instituicao"),
                result.getString("nome_instituicao"),
                result.getInt("id_projeto"),
                result.getString("nome_projeto")
            );
            list.add(f);
        }

        result.close();
        st.close();
        return list;
    }

    public static void remove(int idInstituicao, int idProjeto, Connection con) throws SQLException {
        String sql = "DELETE FROM financia WHERE id_instituicao = ? AND id_projeto = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, idInstituicao);
        st.setInt(2, idProjeto);
        st.execute();
        st.close();
    }
    
    public static ResultSet listarProjetosComInstituicoesFinanciadas(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        String sql = "SELECT inst.id_instituicao, inst.nome AS nome_instituicao, " +
                     "proj.id_projeto, proj.titulo AS nome_projeto " +
                     "FROM instituicao inst " +
                     "JOIN financia fin ON inst.id_instituicao = fin.id_instituicao " +
                     "JOIN projeto proj ON fin.id_projeto = proj.id_projeto";
        return stmt.executeQuery(sql);
    }

}
