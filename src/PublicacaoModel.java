import java.sql.*;
import java.util.HashSet;

public class PublicacaoModel {

    public static int create(PublicacaoBean p, Connection con) throws SQLException {
        String sql = "INSERT INTO publicacoes (id_projeto, titulo, tipo, data_publicacao, doi) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, p.getIdProjeto());
            stmt.setString(2, p.getTitulo());
            stmt.setString(3, p.getTipo());
            stmt.setDate(4, p.getDataPublicacao());
            stmt.setString(5, p.getDoi());

            // Executa a inserção
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1); // Retorna o ID gerado
                    }
                }
            }
            return -1; // Caso algum erro aconteça
        }
    }

    public static HashSet<PublicacaoBean> listAll(Connection con) throws SQLException {
        HashSet<PublicacaoBean> list = new HashSet<>();
        String sql = "SELECT * FROM publicacao";
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);

        while (result.next()) {
            PublicacaoBean p = new PublicacaoBean(
                result.getInt("id_publicacao"),
                result.getInt("id_projeto"),
                result.getString("titulo"),
                result.getString("tipo"),
                result.getDate("data_publicacao"),
                result.getString("doi")
            );
            list.add(p);
        }

        result.close();
        st.close();
        return list;
    }

    public static void update(PublicacaoBean p, Connection con) throws SQLException {
        String sql = "UPDATE publicacao SET id_projeto = ?, titulo = ?, tipo = ?, data_publicacao = ?, doi = ? WHERE idpublicacao = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, p.getIdProjeto());
        st.setString(2, p.getTitulo());
        st.setString(3, p.getTipo());
        st.setDate(4, p.getDataPublicacao());
        st.setString(5, p.getDoi());
        st.setInt(6, p.getIdPublicacao());
        st.executeUpdate();
        st.close();
    }

    public static void remove(int idPublicacao, Connection con) throws SQLException {
        String sql = "DELETE FROM publicacao WHERE id_publicacao = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, idPublicacao);
        st.execute();
        st.close();
    }
    
    public static ResultSet listarPublicacoesComProjetoEPesquisador(Connection con) throws SQLException {
    Statement stmt = con.createStatement();
    String sql = "SELECT pub.titulo, pub.tipo, pub.data_publicacao, " +
                 "proj.titulo AS titulo_projeto, pes.nome AS nome_pesquisador " +
                 "FROM publicacao pub " +
                 "JOIN projeto proj ON pub.id_projeto = proj.id_projeto " +
                 "JOIN pesquisador pes ON proj.id_coordenador = pes.id_pesquisador";
    return stmt.executeQuery(sql);
}

}
