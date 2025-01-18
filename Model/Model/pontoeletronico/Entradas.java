package Model.pontoeletronico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import Model.enuns.*;

public class Entradas 
{
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static Scanner scanner = new Scanner(System.in);

    public static String entradaNome()
    {
        System.out.println("\nInsira o nome: ");
        String nome = scanner.nextLine();
        return nome;
    }

    public static int entradaCPF()
    {
        System.out.println("\nInsira o CPF (apenas numeros): ");
        try
        {
            int cpf = scanner.nextInt();
            scanner.nextLine();
            
            return cpf;
        }
        catch (Exception e)
        {
            System.out.println("\nCPF inválido. Insira apenas números.");
            return entradaCPF();
        }
    }

    public static LocalDate entradaDataNascimento() 
    { 
        LocalDate dataNascimento = null; 
        boolean dataValida = false; 

        while (!dataValida) 
        { 
            try 
            { 
                System.out.println("\nInsira a data de nascimento (dd/MM/yyyy): ");
                String data = scanner.nextLine();

                if (data.length() != 10) 
                { 
                    throw new DateTimeParseException("Data inválida", data, 0);
                } 
                dataNascimento = LocalDate.parse(data, formatter);
                dataValida = true;
            } 
            catch (DateTimeParseException e) 
            { 
                System.out.println("\nData inválida. Esse dado deve ser inserido no formato (dd/MM/yyyy)."); 
            } 
        } 

        return dataNascimento; 
    }

    public static Genero entradaGenero()
    {
        System.out.println("\nInsira o gênero: ");
        System.out.println("1 - Masculino");
        System.out.println("2 - Feminino");
        System.out.println("3 - Outro");

        int genero = scanner.nextInt();
        scanner.nextLine();

        switch (genero)
        {
            case 1:
                return Genero.MASCULINO;
            case 2:
                return Genero.FEMININO;
            case 3:
                return Genero.OUTRO;
            default:
                return Genero.OUTRO;
        }
    }

    public static Cargos entradaCargo()
    {
        System.out.println("""
                \nQual o cargo do funcionario?
                 
                1 - Departamento Pessoal
                2 - Desenvolvedor
                3 - Gestor
                4 - Lider
                5 - Analista

                Insira o número correspondente ao cargo do funcionário: 
                \n""");

            int cargofun;
            try
            {
                cargofun = scanner.nextInt();
                scanner.nextLine();
            }
            catch (Exception e)
            {
                System.out.println("\nCargo inválido. Insira um número inteiro.");
                return entradaCargo();
            }
    
            switch (cargofun)
            {
                case 1:
                    return Cargos.DEPARTAMENTO_PESSOAL;
                case 2:
                    return Cargos.DESENVOLVEDOR;
                case 3:
                    return Cargos.GESTOR;
                case 4:
                    return Cargos.LIDER;
                case 5:
                    return Cargos.ANALISTA;
                default:
                    return Cargos.ANALISTA;
    }
}

    public static Endereco entradaEndereco()
    {
        Endereco endereco = new Endereco(null, 0, null, null, null);

        System.out.println("Insira a rua: ");
        endereco.setRua(scanner.nextLine());

        System.out.println("Insira o numero: ");
        endereco.setNumero(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Insira o bairro: ");
        endereco.setBairro(scanner.nextLine());

        System.out.println("Insira a cidade: ");
        endereco.setCidade(scanner.nextLine());

        System.out.println("Insira o cep: ");
        endereco.setCep(scanner.nextLine());

        return endereco;
    }

    public static double entradaCargaHoraria()
    {
        System.out.println("\nInsira a carga horária: ");
        double cargaHoraria = scanner.nextDouble();
        scanner.nextLine();

        return cargaHoraria;
    }

    public static int entradaSenha()
    {
        System.out.println("\nInsira a senha: ");
        
        try 
        {
            int senha = scanner.nextInt();
            scanner.nextLine();
            return senha;
        } 
        catch (Exception e) 
        {
            System.out.println("\nSenha inválida. Insira um número inteiro.");
            return entradaSenha();
        }
    }

    public static boolean verificarPermissao()
    {
        System.out.println("""
                Qual o seu tipo de usuário?
                1 - Departamento Pessoal
                2 - Desenvolvedor
                3 - Gestor
                4 - Lider
                5 - Analista
                """);
        int opcoes = scanner.nextInt();
        scanner.nextLine();

        switch(opcoes)
        {
            case 1:
                System.out.println("Você é funcionário do Departamento Pessoal");
                return true;
            case 2:
                System.out.println("Você é funcionário Desenvolvedor");
                return false;
            case 3:
                System.out.println("Você é funcionário Gestor");
                return true;

            case 4:
                System.out.println("Você é funcionário Lider");
                return false;

            case 5:
                System.out.println("Você é funcionário Analista");
                return false;

            default:
                System.out.println("Você não é funcionário da empresa");
                return false;
        }
    }
}
