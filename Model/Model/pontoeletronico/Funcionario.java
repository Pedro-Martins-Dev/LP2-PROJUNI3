package Model.pontoeletronico;

import java.time.LocalDate;
import java.util.Map;
import java.util.ArrayList;
import java.time.LocalDateTime;
import Model.enuns.*;

public class Funcionario extends Pessoa
{
    private static final long serialVersionUID = 1L;

    private LocalDateTime horasExtras;
    private LocalDateTime horaNegativas;
    private LocalDateTime horasTrabalhadasMes;
    private LocalDateTime horasDia;
    private int senha;
    //o local date vai guardar os dias das batidas e o local time vai guardar os horários da batidas.
    private Map<LocalDate, ArrayList<LocalDateTime>> horasTrabalhadasDia;

    Funcionario(String nome, long cpf, LocalDate dataNascimento, Genero genero, Cargos cargo, Endereco endereco, double cargaHoraria, LocalDateTime horasExtras, LocalDateTime horaNegativas, LocalDateTime horasTrabalhadasMes, LocalDateTime horasDia, int senha, Map<LocalDate, ArrayList<LocalDateTime>> horasTrabalhadasDia) 
    {
        super(nome, cpf, dataNascimento, genero, cargo, endereco, cargaHoraria);
        this.horasExtras = horasExtras;
        this.horaNegativas = horaNegativas;
        this.horasTrabalhadasMes = horasTrabalhadasMes;
        this.horasDia = horasDia;
        this.senha = senha;
        this.horasTrabalhadasDia = horasTrabalhadasDia;
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

    public int getSenha() 
    {
        return senha;
    }

    public void setSenha(int senha) 
    {
        this.senha = senha;
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