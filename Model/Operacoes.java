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
        funcionario.setCargaHoraria(Entradas.entradaCargaHoraria());

        return funcionario;
    }

}
