import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PesquisadorController {

    public void criarPesquisador(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados do pesquisador:");
        System.out.print("ID do Pesquisador: ");
        int idPesquisador = input.nextInt();
        input.nextLine(); 
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Instituição: ");
        String instituicao = input.nextLine();

        PesquisadorBean p = new PesquisadorBean(idPesquisador, nome, email, instituicao);
        PesquisadorModel.create(p, con);
        System.out.println("Pesquisador cadastrado com sucesso!");
    }

    public void listarPesquisadores(Connection con) throws SQLException {
        HashSet<PesquisadorBean> todos = PesquisadorModel.listAll(con);
        Iterator<PesquisadorBean> it = todos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public void removerPesquisador(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        listarPesquisadores(con);
        System.out.print("Informe o ID do pesquisador a ser removido: ");
        int idPesquisador = input.nextInt();

        PesquisadorModel.remove(idPesquisador, con);
        System.out.println("Pesquisador removido com sucesso.");
    }

    public void alterarPesquisador(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        listarPesquisadores(con);
        System.out.print("Informe o ID do pesquisador a ser alterado: ");
        int idPesquisador = input.nextInt();
        input.nextLine(); // limpar buffer
        System.out.print("Novo nome: ");
        String nome = input.nextLine();
        System.out.print("Novo email: ");
        String email = input.nextLine();
        System.out.print("Nova instituição: ");
        String instituicao = input.nextLine();

        PesquisadorBean p = new PesquisadorBean(idPesquisador, nome, email, instituicao);
        PesquisadorModel.update(p, con);
        System.out.println("Pesquisador atualizado com sucesso.");
    }
}
