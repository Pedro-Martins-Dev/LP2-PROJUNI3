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
    private static ArrayList<Funcionario> funcionarios;

    BancoDAO() 
    {
        funcionarios = new ArrayList<Funcionario>();
    }

    public ArrayList<Funcionario> getArrayFuncionarios() 
    {
        if (funcionarios == null) 
        {
            funcionarios = new ArrayList<Funcionario>();
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
            saida.writeObject(bancoDAO); 
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
            bancoDAO = (BancoDAO) entrada.readObject(); 
        } 
        catch (IOException | ClassNotFoundException e) 
        { 
            e.printStackTrace();
        }

        return this;
    }
}