import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class OrientandoController {

    public void criarOrientando(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados do novo orientando:");
        System.out.print("ID do Orientando: ");
        int idOrientando = input.nextInt();
        input.nextLine(); 
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Nível Acadêmico: ");
        String nivel = input.nextLine();
        System.out.print("ID do Projeto: ");
        int idProjeto = input.nextInt();

        OrientandoBean o = new OrientandoBean(idOrientando, nome, email, nivel, idProjeto);
        OrientandoModel.create(o, con);
        System.out.println("Orientando cadastrado com sucesso!");
    }

    public void listarOrientandos(Connection con) throws SQLException {
        HashSet<OrientandoBean> todos = OrientandoModel.listAll(con);
        Iterator<OrientandoBean> it = todos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public void removerOrientando(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        listarOrientandos(con);
        System.out.print("Informe o ID do Orientando a ser removido: ");
        int id = input.nextInt();
        OrientandoModel.remove(id, con);
        System.out.println("Orientando removido com sucesso.");
    }

    public void alterarOrientando(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        listarOrientandos(con);
        System.out.print("Informe o ID do Orientando a ser alterado: ");
        int idOrientando = input.nextInt();
        input.nextLine(); // consumir quebra de linha
        System.out.print("Novo nome: ");
        String nome = input.nextLine();
        System.out.print("Novo email: ");
        String email = input.nextLine();
        System.out.print("Novo nível acadêmico: ");
        String nivel = input.nextLine();
        System.out.print("Novo ID do Projeto: ");
        int idProjeto = input.nextInt();

        OrientandoBean o = new OrientandoBean(idOrientando, nome, email, nivel, idProjeto);
        OrientandoModel.update(o, con);
        System.out.println("Orientando atualizado com sucesso.");
    }
}
