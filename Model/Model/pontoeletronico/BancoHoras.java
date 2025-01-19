package Model.pontoeletronico;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BancoHoras
{
    public static void imprimirHorasTrabalhadas(Funcionario funcionario) 
    { 
        Scanner scanner = new Scanner(System.in); 
        
        System.out.println("Digite o ano (formato YYYY): "); 
        int ano = scanner.nextInt(); 
        scanner.nextLine();
        
        System.out.println("Digite o mês (formato MM): ");
        int mes = scanner.nextInt(); 
        scanner.nextLine();
        
        YearMonth mesAno = YearMonth.of(ano, mes); 
        
        Map<LocalDate, ArrayList<LocalDateTime>> horasTrabalhadasDia = funcionario.getHorasTrabalhadasDia();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss"); 
        System.out.println("Horas trabalhadas para o mês de " + mesAno + ":");
        for (LocalDate data : horasTrabalhadasDia.keySet()) 
        { 
            if (YearMonth.from(data).equals(mesAno)) 
            { 
                ArrayList<LocalDateTime> horas = horasTrabalhadasDia.get(data); 
                System.out.println("Data: " + data); 
                for (LocalDateTime hora : horas)
                { 
                    System.out.println("Ponto batido: " + hora.format(formatter)); 
                } 
                
                if (horas.size() >= 2) 
                { 
                    LocalDateTime inicio = horas.get(0); 
                    LocalDateTime fim = horas.get(horas.size() - 1); 
                    Duration horasTrabalhadas = Duration.between(inicio, fim); 
                    
                    System.out.println("Total de horas trabalhadas: " + horasTrabalhadas.toHours() + " horas e " + horasTrabalhadas.toMinutesPart() + " minutos\n"); 
                } 
                else 
                { 
                    System.out.println("Horas insuficientes para calcular a jornada de trabalho.\n"); 
                } 
            } 
        } 
        scanner.close();
    }
    
    /*public static void calcularHorasDia(Funcionario funcionario)
    {
        Scanner scanner = new Scanner(System.in); 

        System.out.println("Digite o ano (formato YYYY): "); 
        int ano = scanner.nextInt(); 
        scanner.nextLine();
        
        System.out.println("Digite o mês (formato MM): "); 
        int mes = scanner.nextInt(); 
        scanner.nextLine();

        YearMonth mesAno = YearMonth.of(ano, mes);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss"); 

        System.out.println("Horas trabalhadas para o mês de " + mesAno + ":"); 

        for (LocalDate data : funcionario.getHorasTrabalhadasDia().keySet()) 
        { 
            if (YearMonth.from(data).equals(mesAno)) 
            { 
                ArrayList<LocalDateTime> horas = funcionario.getHorasTrabalhadasDia().get(data); 
                System.out.println("Data: " + data); 

                for (LocalDateTime hora : horas) 
                { 
                    System.out.println("Ponto batido: " + hora.format(formatter)); 
                } 

                if (horas.size() >= 2) 
                { 
                    LocalDateTime inicio = horas.get(0); 
                    LocalDateTime fim = horas.get(horas.size() - 1); 
                    Duration horasTrabalhadas = Duration.between(inicio, fim); 
                    
                    System.out.println("Horas trabalhadas: " + horasTrabalhadas.toHours() + " horas e " + horasTrabalhadas.toMinutesPart() + " minutos\n"); 
                } 
                else 
                { 
                    System.out.println("Horas insuficientes para calcular a jornada de trabalho.\n"); 
                } 
            } 
        }
    } */

    public static Duration calcularHorasExtras(Funcionario funcionario) 
    { 
        Duration horasExtrasTotais = Duration.ZERO; 

        for (LocalDate data : funcionario.getHorasTrabalhadasDia().keySet()) 
        { 
            ArrayList<LocalDateTime> horas = funcionario.getHorasTrabalhadasDia().get(data); 
            if (horas.size() >= 2) 
            { 
                LocalDateTime inicio = horas.get(0);
                LocalDateTime fim = horas.get(horas.size() - 1); 

                Duration horasTrabalhadas = Duration.between(inicio, fim); 
                Duration cargaHoraria = Duration.ofHours((long) funcionario.getCargaHorariaDiaria()); 

                if (horasTrabalhadas.compareTo(cargaHoraria) > 0) 
                { 
                    Duration extras = horasTrabalhadas.minus(cargaHoraria); 
                    horasExtrasTotais = horasExtrasTotais.plus(extras); 
                } 
            } 
        } 
        return horasExtrasTotais; 
    }

    public static Duration calcularHorasNegativas(Funcionario funcionario) 
    { 
        Duration horasNegativasTotais = Duration.ZERO; 
        for (LocalDate data : funcionario.getHorasTrabalhadasDia().keySet()) 
        { 
            ArrayList<LocalDateTime> horas = funcionario.getHorasTrabalhadasDia().get(data); 
            if (horas.size() >= 4) 
            { 
                LocalDateTime inicio = horas.get(0); 
                LocalDateTime fim = horas.get(horas.size() - 1); 

                Duration horasTrabalhadas = Duration.between(inicio, fim); 
                Duration cargaHoraria = Duration.ofHours((long) funcionario.getCargaHorariaDiaria()); 

                if (horasTrabalhadas.compareTo(cargaHoraria) < 0) 
                { 
                    Duration negativas = cargaHoraria.minus(horasTrabalhadas); 
                    horasNegativasTotais = horasNegativasTotais.plus(negativas); 
                } 
            } 
        } 
        return horasNegativasTotais; 
    }  

    public static Map<YearMonth, Duration> calcularHorasTrabalhadas(Funcionario funcionario) 
    { 
        Map<YearMonth, Duration> horasTrabalhadasPorMes = new HashMap<>(); 

        for (LocalDate data : funcionario.getHorasTrabalhadasDia().keySet()) 
        { 
            ArrayList<LocalDateTime> horas = funcionario.getHorasTrabalhadasDia().get(data); 
            YearMonth mesAno = YearMonth.from(data); 

            if (horas.size() >= 2) 
            { 
                LocalDateTime inicio = horas.get(0); 
                LocalDateTime fim = horas.get(horas.size() - 1); 
                Duration horasTrabalhadas = Duration.between(inicio, fim); 
                horasTrabalhadasPorMes.putIfAbsent(mesAno, Duration.ZERO); 
                horasTrabalhadasPorMes.put(mesAno, horasTrabalhadasPorMes.get(mesAno).plus(horasTrabalhadas)); 
            } 
        } 
        return horasTrabalhadasPorMes; 
    }
}
