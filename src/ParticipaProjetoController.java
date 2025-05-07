import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ParticipaProjetoController {

    public void criarParticipacao(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados da participação do pesquisador em projeto:");
        System.out.print("ID do Pesquisador: ");
        int idPesquisador = input.nextInt();
        System.out.print("ID do Projeto: ");
        int idProjeto = input.nextInt();
        input.nextLine(); 
        System.out.print("Papel: ");
        String papel = input.nextLine();

        ParticipaProjetoBean p = new ParticipaProjetoBean(idPesquisador, idProjeto, papel);
        ParticipaProjetoModel.create(p, con);
        System.out.println("Participação cadastrada com sucesso!");
    }

    public void listarParticipacoes(Connection con) throws SQLException {
        HashSet<ParticipaProjetoBean> todas = ParticipaProjetoModel.listAll(con);
        Iterator<ParticipaProjetoBean> it = todas.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public void removerParticipacao(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        listarParticipacoes(con);
        System.out.print("Informe o ID do Pesquisador: ");
        int idPesquisador = input.nextInt();
        System.out.print("Informe o ID do Projeto: ");
        int idProjeto = input.nextInt();

        ParticipaProjetoModel.remove(idPesquisador, idProjeto, con);
        System.out.println("Participação removida com sucesso.");
    }

    public void alterarParticipacao(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        listarParticipacoes(con);
        System.out.print("Informe o ID do Pesquisador: ");
        int idPesquisador = input.nextInt();
        System.out.print("Informe o ID do Projeto: ");
        int idProjeto = input.nextInt();
        input.nextLine(); // consumir quebra de linha
        System.out.print("Novo papel: ");
        String papel = input.nextLine();

        ParticipaProjetoBean p = new ParticipaProjetoBean(idPesquisador, idProjeto, papel);
        ParticipaProjetoModel.update(p, con);
        System.out.println("Participação atualizada com sucesso.");
    }
}
