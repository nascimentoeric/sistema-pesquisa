import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.sql.ResultSet;

public class PublicacaoController {

    public void criarPublicacao(Connection con) throws SQLException {
    Scanner input = new Scanner(System.in);
    System.out.println("Insira os dados da publicação:");

    new ProjetoController().listarProjetos(con);

    // Remover o input do ID, pois o banco de dados vai gerar automaticamente
    System.out.print("ID do Projeto: ");
    int idProjeto = input.nextInt();
    input.nextLine(); // Limpar o buffer de nova linha

    System.out.print("Título: ");
    String titulo = input.nextLine();

    System.out.print("Tipo: ");
    String tipo = input.nextLine();

    System.out.print("Data de Publicação (AAAA-MM-DD): ");
    String dataStr = input.nextLine();
    Date dataPublicacao = Date.valueOf(dataStr);

    System.out.print("DOI: ");
    String doi = input.nextLine();

    // Criação do objeto sem ID
    PublicacaoBean p = new PublicacaoBean(0, idProjeto, titulo, tipo, dataPublicacao, doi);

    // Criar a publicação no banco de dados, agora sem precisar passar o ID
    int idGerado = PublicacaoModel.create(p, con);
    System.out.println("Publicação cadastrada com sucesso! ID gerado: " + idGerado);
}

    public void listarPublicacoes(Connection con) throws SQLException {
        HashSet<PublicacaoBean> todas = PublicacaoModel.listAll(con);
        Iterator<PublicacaoBean> it = todas.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public void atualizarPublicacao(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        listarPublicacoes(con);

        System.out.print("Informe o ID da Publicação que deseja atualizar: ");
        int idPublicacao = input.nextInt();

        System.out.print("Novo ID do Projeto: ");
        int idProjeto = input.nextInt();
        input.nextLine();

        System.out.print("Novo Título: ");
        String titulo = input.nextLine();

        System.out.print("Novo Tipo: ");
        String tipo = input.nextLine();

        System.out.print("Nova Data de Publicação (AAAA-MM-DD): ");
        String dataStr = input.nextLine();
        Date dataPublicacao = Date.valueOf(dataStr);

        System.out.print("Novo DOI: ");
        String doi = input.nextLine();

        PublicacaoBean p = new PublicacaoBean(idPublicacao, idProjeto, titulo, tipo, dataPublicacao, doi);
        PublicacaoModel.update(p, con);
        System.out.println("Publicação atualizada com sucesso!");
    }

    public void removerPublicacao(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        listarPublicacoes(con);
        System.out.print("Informe o ID da Publicação que deseja remover: ");
        int idPublicacao = input.nextInt();

        PublicacaoModel.remove(idPublicacao, con);
        System.out.println("Publicação removida com sucesso.");
    }
    
    public void listarPublicacoesDetalhadas(Connection con) throws SQLException {
    ResultSet rs = PublicacaoModel.listarPublicacoesComProjetoEPesquisador(con);
    System.out.println("Título | Tipo | Data | Projeto | Pesquisador");
    System.out.println("--------------------------------------------------------");
    while (rs.next()) {
        System.out.printf("%s | %s | %s | %s | %s\n",
            rs.getString("titulo"),
            rs.getString("tipo"),
            rs.getDate("data_publicacao").toString(),
            rs.getString("titulo_projeto"),
            rs.getString("nome_pesquisador"));
    }
}

}
