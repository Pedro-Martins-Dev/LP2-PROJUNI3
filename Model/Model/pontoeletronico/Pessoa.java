package Model.pontoeletronico;

import java.io.Serializable;
import java.time.LocalDate;

import Model.enuns.*;

public abstract class Pessoa implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String nome;
    private long cpf;
    private LocalDate dataNascimento;
    private Genero genero;
    private Cargos cargo;
    private Endereco endereco;
    private double cargaHorariaDiaria;

    public Pessoa(String nome, long cpf, LocalDate dataNascimento, Genero genero, Cargos cargo, Endereco endereco, double cargaHorariaDiaria)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.cargo = cargo;
        this.endereco = endereco;
        this.cargaHorariaDiaria = cargaHorariaDiaria;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public long getCpf()
    {
        return cpf;
    }

    public void setCpf(long cpf)
    {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() 
    {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) 
    {
        this.dataNascimento = dataNascimento;
    }

    public Genero getGenero() 
    {
        return genero;
    }

    public void setGenero(Genero genero) 
    {
        this.genero = genero;
    }

    public Endereco getEndereco() 
    {
        return endereco;
    }

    public void setEndereco(Endereco endereco) 
    {
        this.endereco = endereco;
    }

    public Cargos getCargo() 
    {
        return cargo;
    }

    public void setCargo(Cargos cargo) 
    {
        this.cargo = cargo;
    }

    public double getCargaHorariaDiaria() 
    {
        return cargaHorariaDiaria;
    }

    public void setCargaHorariaDiaria(double cargaHorariaDiaria) 
    {
        this.cargaHorariaDiaria = cargaHorariaDiaria;
    }
}
