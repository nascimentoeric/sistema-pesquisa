import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class InstituicaoController {
    
    public void criarInstituicao(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados da nova Instituição:");
        System.out.print("ID da Instituição: ");
        int id = input.nextInt();
        input.nextLine(); // consumir quebra de linha
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Tipo: ");
        String tipo = input.nextLine();
        System.out.print("País: ");
        String pais = input.nextLine();

        InstituicaoBean inst = new InstituicaoBean(id, nome, tipo, pais);
        InstituicaoModel.create(inst, con);
        System.out.println("Instituição cadastrada com sucesso!");
    }

    public void listarInstituicoes(Connection con) throws SQLException {
        HashSet<InstituicaoBean> todas = InstituicaoModel.listAll(con);
        Iterator<InstituicaoBean> it = todas.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public void removerInstituicao(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        listarInstituicoes(con);
        System.out.print("Informe o ID da Instituição a ser removida: ");
        int id = input.nextInt();
        InstituicaoModel.remove(id, con);
        System.out.println("Instituição removida com sucesso.");
    }

    public void alterarInstituicao(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        listarInstituicoes(con);
        System.out.print("Informe o ID da Instituição a ser alterada: ");
        int id = input.nextInt();
        input.nextLine(); // consumir quebra de linha
        System.out.print("Novo nome: ");
        String nome = input.nextLine();
        System.out.print("Novo tipo: ");
        String tipo = input.nextLine();
        System.out.print("Novo país: ");
        String pais = input.nextLine();

        InstituicaoBean inst = new InstituicaoBean(id, nome, tipo, pais);
        InstituicaoModel.update(inst, con);
        System.out.println("Instituição atualizada com sucesso.");
    }
}
