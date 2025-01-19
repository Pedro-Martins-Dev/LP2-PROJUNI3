package Model.pontoeletronico;

import java.time.LocalDate;
import java.util.Map;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.io.Serializable;
import Model.enuns.*;

public class Funcionario extends Pessoa implements Serializable  
{
    private static final long serialVersionUID = 1L;
    private LocalDateTime horasExtras;
    private LocalDateTime horaNegativas;
    private LocalDateTime horasTrabalhadasMes;
    private LocalDateTime horasDia;
    private int senha;
    //o local date vai guardar os dias das batidas e o local time vai guardar os horários da batidas.
    private Map<LocalDate, ArrayList<LocalDateTime>> horasTrabalhadasDia;
    private Map<LocalDate, ArrayList<String>> elogios;

    Funcionario(String nome, long cpf, LocalDate dataNascimento, Genero genero, Cargos cargo, Endereco endereco, double cargaHoraria, LocalDateTime horasExtras, LocalDateTime horaNegativas, LocalDateTime horasTrabalhadasMes, LocalDateTime horasDia, int senha, Map<LocalDate, ArrayList<LocalDateTime>> horasTrabalhadasDia, Map<LocalDate, ArrayList<String>> elogios) 
    {
        super(nome, cpf, dataNascimento, genero, cargo, endereco, cargaHoraria);
        this.horasExtras = horasExtras;
        this.horaNegativas = horaNegativas;
        this.horasTrabalhadasMes = horasTrabalhadasMes;
        this.horasDia = horasDia;
        this.senha = senha;
        this.horasTrabalhadasDia = horasTrabalhadasDia;
        this.elogios = elogios;
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

    public Map<LocalDate, ArrayList<String>> getElogios() 
    {
        return elogios;
    }

    public void setElogios(Map<LocalDate, ArrayList<String>> elogios) 
    {
        this.elogios = elogios;
    }
}