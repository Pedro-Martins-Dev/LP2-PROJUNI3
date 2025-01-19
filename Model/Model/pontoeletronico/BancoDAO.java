package Model.pontoeletronico;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class BancoDAO implements Serializable
{
    private static ArrayList<Pessoa> funcionarios;

    BancoDAO() 
    {
        funcionarios = new ArrayList<Pessoa>();
    }

    public ArrayList<Pessoa> getArrayFuncionarios() 
    {
        if (funcionarios == null) 
        {
            funcionarios = new ArrayList<Pessoa>();
        }

        return funcionarios;
    }

    public static void limpar() 
    { 
        funcionarios.clear(); 
    }

    public void serializar(BancoDAO bancoDAO, String filename) 
    { 
        try (ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(filename))) 
        { 
            for (Pessoa funcionario : bancoDAO.getArrayFuncionarios()) 
            {
                saida.writeObject(funcionario);
            }
            System.out.println("Objeto serializado com sucesso!"); 
        } 
        catch (IOException e) 
        { 
            System.out.println("Erro ao serializar: " + e.getMessage()); 
        }
    }

    public BancoDAO deserialize(BancoDAO bancoDAO, String serializado) 
    { 
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(serializado))) 
        { 
            while(true)
            {
                try
                {
                    Pessoa funcionario = (Pessoa) entrada.readObject();
                    bancoDAO.getArrayFuncionarios().add(funcionario);
                }
                catch (Exception e)
                {
                    break;
                }
            }  
        } 
        catch (IOException e) 
        { 
            e.printStackTrace();
        }

        return this;
    }
}