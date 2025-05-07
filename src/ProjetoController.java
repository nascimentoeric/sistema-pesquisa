import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.sql.ResultSet;

public class ProjetoController {

    public void criarProjeto(Connection con) throws SQLException {
    Scanner input = new Scanner(System.in);

    System.out.println("Insira os dados do projeto:\n");
    new PesquisadorController().listarPesquisadores(con);
    System.out.print("ID do Coordenador: ");
    int idCoordenador = input.nextInt();
    new InstituicaoController().listarInstituicoes(con);
    System.out.print("ID da Instituição: ");
    int idInstituicao = input.nextInt();
    input.nextLine(); 
    System.out.print("Título: ");
    String titulo = input.nextLine();
    System.out.print("Área de Pesquisa: ");
    String areaPesquisa = input.nextLine();

    System.out.print("Data de Início (yyyy-mm-dd): ");
    Date dataInicio = Date.valueOf(input.nextLine());
    System.out.print("Data de Fim (yyyy-mm-dd): ");
    Date dataFim = Date.valueOf(input.nextLine());

    
    ProjetoBean projeto = new ProjetoBean(0, idCoordenador, idInstituicao, titulo, areaPesquisa, dataInicio, dataFim);
    ProjetoModel.create(projeto, con);
    System.out.println("Projeto cadastrado com sucesso!");
}



    public void listarProjetos(Connection con) throws SQLException {
        HashSet<ProjetoBean> todos = ProjetoModel.listAll(con);
        Iterator<ProjetoBean> it = todos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public void removerProjeto(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        listarProjetos(con);
        System.out.print("Informe o ID do Projeto a ser removido: ");
        int idProjeto = input.nextInt();

        ProjetoModel.remove(idProjeto, con);
        System.out.println("Projeto removido com sucesso.");
    }
    

}
