package Model.pontoeletronico;

import java.time.LocalDate;
import java.util.Scanner;

public class Main
{

    public static Scanner scanner = new Scanner(System.in);
        public static void main(String[] args) 
        {
            BancoDAO bancoDAO = new BancoDAO();
            bancoDAO.deserialize(bancoDAO, "bancoDAO.ser");

            int opcoes = -1;
            
            System.out.println("Qual o tipo de usuário você é?");
            boolean podeCadastrarFuncionario = Entradas.verificarPermissao();

            if(podeCadastrarFuncionario)
            {
                do
                {
                    Funcionario funcionario = new Funcionario(null, opcoes, null, null, null, null, opcoes, null, null, null, null, opcoes, null);

                    System.out.println("""
                    \nO que você deseja fazer?

                    1 - Registrar horário
                    2 - Visualização de horário de batida de ponto
                    3 - Geração de relatório de frequência
                    4 - Cadastrar funcionário
                    5- imprimir funcionários
                    0 - Sair
            
                    Digite a opção desejada:""");
            
                    opcoes = scanner.nextInt();

                    switch (opcoes)
                    {
                        case 1:
                            System.out.println("Registrar horário horário");
                            try
                            {
                                funcionario = Operacoes.procurarFuncionario(bancoDAO);
                                funcionario.setHorasTrabalhadasDia(Operacoes.registrarHorario(funcionario));
                            }
                            catch (Exception e)
                            {
                                System.out.println(e.getMessage());
                                break;
                            }
                            break;

                        case 2:
                            System.out.println(String.format("Visualização de horário de batida de ponto no dia %s\n", LocalDate.now().toString()));
                            try
                            {
                                funcionario = Operacoes.procurarFuncionario(bancoDAO);
                                Operacoes.visualizarHorario(funcionario);
                            }
                            catch (Exception e)
                            {
                                System.out.println(e.getMessage());
                                break;
                            }
                            break;

                        case 3:
                            System.out.println("geração de relatório de frequência");
                            try
                            {
                                funcionario = Operacoes.procurarFuncionario(bancoDAO);
                                Operacoes.gerarRelatorio(funcionario);
                            }
                            catch (Exception e)
                            {
                                System.out.println(e.getMessage());
                                break;
                            }
                            break;

                        case 4:
                            System.out.println("Cadastrar funcionário");
                            funcionario = Operacoes.cadastrarFuncionario();
                            bancoDAO.getArrayFuncionarios().add(funcionario);

                            break;

                        case 5:
                            System.out.println("Imprimir funcionários");
                            Operacoes.imprimirFuncionarios(bancoDAO);
                            break;

                        case 0:
                        System.out.println("Saindo...");
                        bancoDAO.serializar(bancoDAO, "bancoDAO.ser"); 
                        BancoDAO.limpar();
                        break;

                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                } while (opcoes != 0);

            }
            else
            {
                do
                {
                    Funcionario funcionario = new Funcionario(null, opcoes, null, null, null, null, opcoes, null, null, null, null, opcoes, null);

                    System.out.println("""
                    \nO que você deseja fazer?

                    1 - Registrar horário
                    2 - Visualização de horário de batida de ponto
                    3 - Geração de relatório de frequência de um funcionário especifico
                    4 - Cadastrar funcionário
                    5 - Imprimir funcionários
                    0 - Sair
            
                    Digite a opção desejada:""");
            
                    opcoes = scanner.nextInt();

                    switch (opcoes)
                    {
                        case 1:
                        System.out.println("Registrar horário horário");
                        try
                        {
                            funcionario = Operacoes.procurarFuncionario(bancoDAO);
                            funcionario.setHorasTrabalhadasDia(Operacoes.registrarHorario(funcionario));
                        }
                        catch (Exception e)
                        {
                            System.out.println(e.getMessage());
                            break;
                        }
                        break;

                        case 2:
                        System.out.println(String.format("Visualização de horário de batida de ponto no dia %s\n", LocalDate.now().toString()));
                        try
                        {
                            funcionario = Operacoes.procurarFuncionario(bancoDAO);
                            Operacoes.visualizarHorario(funcionario);
                        }
                        catch (Exception e)
                        {
                            System.out.println(e.getMessage());
                            break;
                        }
                        break;

                        case 3:
                        System.out.println("geração de relatório de frequência");
                        try
                        {
                            funcionario = Operacoes.procurarFuncionario(bancoDAO);
                            Operacoes.gerarRelatorio(funcionario);
                        }
                        catch (Exception e)
                        {
                            System.out.println(e.getMessage());
                            break;
                        }
                        break;

                        case 4:
                            System.out.println("Cadastrar funcionário");
                            funcionario = Operacoes.cadastrarFuncionario();
                            bancoDAO.getArrayFuncionarios().add(funcionario);
                            
                        break;

                        case 5:
                            System.out.println("Imprimir funcionários");
                            Operacoes.imprimirFuncionarios(bancoDAO);
                            break;

                        case 0:
                            System.out.println("Saindo...");
                            bancoDAO.serializar(bancoDAO, "bancoDAO.ser");
                            BancoDAO.limpar();
                            break;

                        default:
                            System.out.println("Opção inválida");
                            break;
                    }      
                } while (opcoes != 0);
            }
        scanner.close();
    }
}
