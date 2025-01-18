package Model.pontoeletronico;

import java.util.ArrayList;

public class BancoDAO 
{
    private static BancoDAO instance;
    private static ArrayList<Funcionario> funcionarios;

    public static BancoDAO getInstance() 
    {
        if (instance == null) 
        {
            instance = new BancoDAO();
        }
        return instance;
    }

    public ArrayList<Funcionario> getArrayFuncionarios() 
    {
        if(instance == null) 
        {
            BancoDAO.getInstance();
        }

        return funcionarios;
    }

    private BancoDAO() 
    {
        funcionarios = new ArrayList<Funcionario>();
    }

}