import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws SQLException {
        Conexao c = new Conexao();
        Connection con = c.getConnection();
        int op = 0;
        do{
            op = menu();
            try {
                switch (op) {
                    case 1: new PesquisadorController().criarPesquisador(con);
                            break;
                    case 2: new InstituicaoController().criarInstituicao(con);
                            break;
                    case 3: new OrientandoController().criarOrientando(con);
                            break;              
                    case 4: new FinanciaController().criarFinanciamento(con);
                            break;
                    case 5: new ProjetoController().criarProjeto(con);
                            break;
                    case 6: new PublicacaoController().criarPublicacao(con);
                            break;
                    case 7: new PesquisadorController().removerPesquisador(con);
                            break;
                    case 8: new InstituicaoController().removerInstituicao(con);
                            break;
                    case 9: new InstituicaoController().removerInstituicao(con);
                            break;  
                    case 10: new ProjetoController().removerProjeto(con);
                            break;
                    case 11: new PublicacaoController().removerPublicacao(con);
                            break;
                    case 12: new PesquisadorController().alterarPesquisador(con);
                            break;
                    case 13: new InstituicaoController().alterarInstituicao(con);
                            break;
                    case 14: new OrientandoController().alterarOrientando(con);
                            break; 
                    case 15: new PublicacaoController().atualizarPublicacao(con);
                            break; 
                    case 16: new PesquisadorController().listarPesquisadores(con);
                            break;
                    case 17: new InstituicaoController().listarInstituicoes(con);
                            break;
                    case 18: new OrientandoController().listarOrientandos(con);
                            break;
                    case 19: new FinanciaController().listarFinanciamentos(con);
                            break;
                    case 20: new ProjetoController().listarProjetos(con);
                            break;
                    case 21: new PublicacaoController().listarPublicacoes(con);
                            break;
                    case 22: new PublicacaoController().listarPublicacoesDetalhadas(con);
                            break;
                    case 23: new FinanciaController().listarProjetosComInstituicoesFinanciadas(con);
                            break;
                }
            }catch(SQLException ex) {
                
                System.out.println(ex.getMessage());
                continue;
            }
        } while(op>0 && op<24);  
        con.close();
    }    
    
    private static int menu() {
        System.out.println("============================================== MENU =============================================\n");
        System.out.println("SUGESTÃO: Antes de realizar qualquer operação que exija o ID do registro, "
                + "verifique o mesmo através das listagens");
        System.out.println("");
        System.out.println("");
        System.out.println("Digite o número da opção que deseja executar:\n ");
        System.out.println("INSERÇÕES ======================================================================================");
        System.out.println("1 - Inserir um novo pesquisador");
        System.out.println("2 - Inserir uma nova instituição");
        System.out.println("3 - Inserir um novo orientando");
        System.out.println("4 - Inserir um novo financiamento");
        System.out.println("5 - Inserir um novo projeto");
        System.out.println("6 - Inserir uma nova publicação\n");
        System.out.println("REMOÇÕES ========================================================================================");
        System.out.println("7 - Remover um pesquisador");
        System.out.println("8 - Remover uma instituição");
        System.out.println("9 - Remover um orientando");
        System.out.println("10 - Remover um projeto");
        System.out.println("11 - Remover uma publicação\n");
        System.out.println("ALTERAÇÕES ======================================================================================");
        System.out.println("12 - Alterar dados de um pesquisador");
        System.out.println("13 - Alterar dados de uma instituição");
        System.out.println("14 - Alterar dados de um orientando");
        System.out.println("15 - Alterar dados de uma publicação\n");
        System.out.println("LISTAGEM ========================================================================================");
        System.out.println("16 - Listar pesquisadores");
        System.out.println("17 - Listar instituições");
        System.out.println("18 - Listar orientandos");
        System.out.println("19 - Listar financiamentos");
        System.out.println("20 - Listar projetos");
        System.out.println("21 - Listar publicações");
        System.out.println("22 - Listar publicações com projeto e pesquisador");
        System.out.println("23 - Listar projetos com instituições e financiamento\n");
        System.out.println("Digite qualquer outro valor para sair");
        System.out.print("Sua opção: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
