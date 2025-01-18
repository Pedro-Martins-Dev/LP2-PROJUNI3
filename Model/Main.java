import java.util.Scanner;

public class Main
{
    public static Scanner scanner = new Scanner(System.in);
        public static void main(String[] args) 
        {
            Funcionario funcionario = null;
            int opcoes = -1;
            
            System.out.println("Qual o tipo de usuário você é?");
            boolean podeCadastrarFuncionario = Entradas.verificarPermissao();

            if(podeCadastrarFuncionario)
            {
                do
                {
                    System.out.println("""
                    \nO que você deseja fazer?

                    1 - Registrar horário
                    2 - Visualização de horário de batida de ponto
                    3 - Geração de relatório de frequência
                    4 - Solicitação de alteração de horário de batida de ponto
                    5 - Registro de elogio/feedbacks para outros colaboradores
                    6 - Cadastrar funcionário
                    0 - Sair
            
                    Digite a opção desejada:""");
            
                    opcoes = scanner.nextInt();

                    switch (opcoes)
                    {
                        case 1:
                            System.out.println("Registrar horário horário");
                            break;

                        case 2:
                            System.out.println("visualização de horário de batida de ponto");
                            break;

                        case 3:
                            System.out.println("geração de relatório de frequência");
                            break;

                        case 4:
                            System.out.println("solicitação de alteração de horário de batida de ponto");
                            break;

                        case 5:
                            System.out.println("registro de elogio/feedbacks para outros colaboradores");
                            break;

                        case 6:
                            System.out.println("Cadastrar funcionário");
                            funcionario = Operacoes.cadastrarFuncionario();
                            break;

                        case 0:
                            System.out.println("Saindo...");
                            break;

                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                } while (opcoes != 0);

            }
            else
            {
                System.out.println("Você não tem permissão para cadastrar funcionários.");
            }
        scanner.close();
    }
}
