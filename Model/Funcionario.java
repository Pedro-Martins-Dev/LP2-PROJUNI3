import Enuns.*;
import java.time.LocalDate;
import java.util.Map;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Funcionario extends Pessoa implements calcularHorasDia
{
    private LocalDateTime horasExtras;
    private LocalDateTime horaNegativas;
    private LocalDateTime horasTrabalhadasMes;
    private LocalDateTime horasDia;
    //o local date vai guardar os dias das batidas e o local time vai guardar os horários da batidas.
    private Map<LocalDate, ArrayList<LocalDateTime>> horasTrabalhadasDia;
    
    Funcionario(String nome, long cpf, LocalDate dataNascimento, Genero genero, String cargo, Endereco endereco, double cargaHoraria, LocalDateTime horasExtras, LocalDateTime horaNegativas, LocalDateTime horasTrabalhadasMes, LocalDateTime horasDia, arraylist<LocalTime> horasTrabalhadasDia) {
        super(nome, cpf, dataNascimento, genero, cargo, endereco, cargaHoraria);
        this.horasExtras = horasExtras;
        this.horaNegativas = horaNegativas;
        this.horasTrabalhadasMes = horasTrabalhadasMes;
        this.horasDia = horasDia;
        this.horasTrabalhadasDia = horasTrabalhadasDia;
    }

    public Map<LocalDate, ArrayList<LocalDateTime>> calcularHorasDia(Map<LocalDate, ArrayList<LocalDateTime>> horasTrabalhadasDia, LocalDate EntradaPonto)
    {
        if(horasTrabalhadasDia.size() == 0)
        {
            return null;
        }
        else if(horasTrabalhadasDia.size() <=4)
        {
            int batidasDia = 1;

            switch (horasDia.size())
            {
                case 1:
                    horasDia.add(horasTrabalhadasDia.get(0));
                    break;
            }
        }


        return horasTrabalhadasDia;
    }

    public LocalDateTime getHorasExtras()
    {
        return horasExtras;
    }

    public void setHorasExtras(LocalDateTime horasExtras)
    {
        this.horasExtras = horasExtras;
    }

    public LocalDateTime getHoraNegativas()
    {
        return horaNegativas;
    }

    public void setHoraNegativas(LocalDateTime horaNegativas)
    {
        this.horaNegativas = horaNegativas;
    }

    public LocalDateTime getHorasTrabalhadasMes()
    {
        return horasTrabalhadasMes;
    }

    public void setHorasTrabalhadasMes(LocalDateTime horasTrabalhadasMes)
    {
        this.horasTrabalhadasMes = horasTrabalhadasMes;
    }

    public LocalDateTime getHorasDia()
    {
        return horasDia;
    }

    public void setHorasDia(LocalDateTime horasDia)
    {
        this.horasDia = horasDia;
    }

    public Map<LocalDate, ArrayList<LocalDateTime>> getHorasTrabalhadasDia()
    {
        return horasTrabalhadasDia;
    }

    public void setHorasTrabalhadasDia(Map<LocalDate, ArrayList<LocalDateTime>> horasTrabalhadasDia)
    {
        this.horasTrabalhadasDia = horasTrabalhadasDia;
    }
}