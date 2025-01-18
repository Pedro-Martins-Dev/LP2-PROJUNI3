import java.time.LocalDate;

import Model.enuns.Genero;
import Model.enuns.*;

public abstract class Pessoa
{
    private String nome;
    private long cpf;
    private LocalDate dataNascimento;
    private Genero genero;
    private Cargos cargo;
    private Endereco endereco;
    private double cargaHoraria;

    public Pessoa(String nome, long cpf, LocalDate dataNascimento, Genero genero, Cargos cargo, Endereco endereco, double cargaHoraria)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.cargo = cargo;
        this.endereco = endereco;
        this.cargaHoraria = cargaHoraria;
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

    public double getCargaHoraria() 
    {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) 
    {
        this.cargaHoraria = cargaHoraria;
    }
}
