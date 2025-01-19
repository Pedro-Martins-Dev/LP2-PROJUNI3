package Model.pontoeletronico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

public class Operacoes 
{
    public static Funcionario cadastrarFuncionario()
    {
        Funcionario funcionario = new Funcionario(null, 0, null, null, null, null, 0, null, null, null, null, 0, null);

        funcionario.setNome(Entradas.entradaNome());
        funcionario.setCpf(Entradas.entradaCPF());
        funcionario.setDataNascimento(Entradas.entradaDataNascimento());
        funcionario.setGenero(Entradas.entradaGenero());
        funcionario.setCargo(Entradas.entradaCargo());
        funcionario.setEndereco(Entradas.entradaEndereco());
        funcionario.setCargaHorariaDiaria(Entradas.entradaCargaHoraria());

        return funcionario;
    }

    public static Funcionario procurarFuncionario(BancoDAO bancoDAO) 
    {
        try 
        {
            System.out.println("Digite o CPF do funcionário que deseja procurar:");
            int cpf = Entradas.entradaCPF();
    
            if (bancoDAO.getArrayFuncionarios().size() == 0) 
            {
                throw new Exception("Funcionário não encontrado.");
            } 
            else 
            {
                for (Pessoa funcionario : bancoDAO.getArrayFuncionarios()) 
                {
                    if (funcionario != null && funcionario.getCpf() == cpf) 
                    {
                        return (Funcionario) funcionario;
                    }
                }
                throw new Exception("Funcionário não encontrado.");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Funcionário não encontrado.");
            return null;
        }
    }
    

    public static Map<LocalDate, ArrayList<LocalDateTime>> registrarHorario(Funcionario funcionario)
    {
        try
        {
            Map<LocalDate, ArrayList<LocalDateTime>> horasTrabalhadasDia = funcionario.getHorasTrabalhadasDia();

            int opcao = -1;

            System.out.println("""
                    \nVocê deseja realmente registrar seu horário?
    
                    1 - Sim, quero registrar meu horário
                    2 - Não, quero voltar para o menu principal\n""");
            
            switch(opcao)
            {
                case 1:
    
                    LocalDate data = LocalDate.now();
                    LocalDateTime hora = LocalDateTime.now();
    
                    if(horasTrabalhadasDia.containsKey(data))
                    {
                        if(horasTrabalhadasDia.get(data).size() == 4)
                        {
                            System.out.println("Você já bateu o ponto 4 vezes hoje. Não é possível bater o ponto mais de 4 vezes.");
                            break;
                        }
                        else
                        {
                            horasTrabalhadasDia.get(data).add(hora);
                            break;
                        }
                        
                    }
                    else
                    {
                        ArrayList<LocalDateTime> horas = new ArrayList<LocalDateTime>();
                        horas.add(hora);
                        horasTrabalhadasDia.put(data, horas);
                        break;
                    }
                case 2:
                    System.out.println("Voltar para o menu principal.");
                    break;
            }
    
            return horasTrabalhadasDia;
        }
        catch (Exception e)
        {
            System.out.println("Funcionário não encontrado.");
            return null;
        }
    }

    public static void visualizarHorario(Funcionario funcionario)
    {
        Map<LocalDate, ArrayList<LocalDateTime>> horasTrabalhadasDia = funcionario.getHorasTrabalhadasDia();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        if(horasTrabalhadasDia.size() == 0)
        {
            System.out.println("Não há batidas de ponto registradas.");
        }
        else
        {
            //ta pegando as horas de trabalho do dia
            for (LocalDate data : horasTrabalhadasDia.keySet()) 
            { 
                ArrayList<LocalDateTime> horas = horasTrabalhadasDia.get(data); 
                System.out.println("Batidas de ponto na data de: " + data.toString()); 
                int contador = 1; 

                if (horas.size() <= 4) 
                { 
                    for (LocalDateTime hora : horas) 
                    { 
                        System.out.println(contador + "° batida: " + hora.format(formatter));
                        contador++; 
                    } 
                } 
            } 
        }
    }

    public static void imprimirFuncionarios(BancoDAO bancoDAO)
    {        
        System.out.println("Funcionários cadastrados:");
        System.out.println("\nExistem" + bancoDAO.getArrayFuncionarios().size() + " funcionários cadastrados.");

        bancoDAO.getArrayFuncionarios().forEach(funcionario -> 
        {
            System.out.println("\n");
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("CPF: " + funcionario.getCpf());
            System.out.println("Data de nascimento: " + funcionario.getDataNascimento());
            System.out.println("Gênero: " + funcionario.getGenero());
            System.out.println("Cargo: " + funcionario.getCargo());
            System.out.println("Endereço: " + funcionario.getEndereco().getRua() + ", " + funcionario.getEndereco().getNumero() + ", " + funcionario.getEndereco().getBairro() + ", " + funcionario.getEndereco().getCidade());
            System.out.println("Carga horária: " + funcionario.getCargaHorariaDiaria());
        });
    }

    public static void gerarRelatorio(Funcionario funcionario)
    {
        System.out.println("Relatório de frequência do funcionário " + funcionario.getNome());
        System.out.println("Horas extras: " + BancoHoras.calcularHorasExtras(funcionario));
        System.out.println("Horas negativas: " + BancoHoras.calcularHorasNegativas(funcionario));
        BancoHoras.imprimirHorasTrabalhadas(funcionario);
    }
}


