import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.sql.ResultSet;

public class FinanciaController {

    public void criarFinanciamento(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados do financiamento:\n");
        new InstituicaoController().listarInstituicoes(con);
        System.out.print("\nID da Instituição: ");        
        int idInstituicao = input.nextInt();
        new ProjetoController().listarProjetos(con);
        System.out.print("\nID do Projeto: ");
        int idProjeto = input.nextInt();

        FinanciaBean f = new FinanciaBean(idInstituicao, idProjeto);
        FinanciaModel.create(f, con);
        System.out.println("Financiamento cadastrado com sucesso!");
    }

    public void listarFinanciamentos(Connection con) throws SQLException {
        HashSet<FinanciaBean> todos = FinanciaModel.listAll(con);
        Iterator<FinanciaBean> it = todos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public void removerFinanciamento(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Lista de financiamentos: \n");
        listarFinanciamentos(con);
        System.out.print("\nLista de Instituições: \n");
        new InstituicaoController().listarInstituicoes(con);
        System.out.print("\nLista de Projetos: \n");
        new ProjetoController().listarProjetos(con);
        System.out.print("\nInforme o ID da Instituição: ");
        int idInstituicao = input.nextInt();
        System.out.print("\nInforme o ID do Projeto: ");
        int idProjeto = input.nextInt();

        FinanciaModel.remove(idInstituicao, idProjeto, con);
        System.out.println("Financiamento removido com sucesso.");
    }

    public void listarProjetosComInstituicoesFinanciadas(Connection con) throws SQLException {
        ResultSet rs = FinanciaModel.listarProjetosComInstituicoesFinanciadas(con);
        System.out.println("ID Instituição | Instituição | ID Projeto | Projeto");
        System.out.println("------------------------------------------------------------");

        while (rs.next()) {
            int idInstituicao = rs.getInt("id_instituicao");
            String nomeInstituicao = rs.getString("nome_instituicao");
            int idProjeto = rs.getInt("id_projeto");
            String nomeProjeto = rs.getString("nome_projeto");

            System.out.println(idInstituicao + " | " + nomeInstituicao + " | " + idProjeto + " | " + nomeProjeto);
        }
    }
  
}
