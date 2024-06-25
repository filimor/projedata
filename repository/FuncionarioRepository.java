package repository;

import java.util.ArrayList;

import model.Funcionario;

public class FuncionarioRepository {
    private ArrayList<Funcionario> funcionarios;

    public FuncionarioRepository() {
        this.funcionarios = new ArrayList<Funcionario>();
    }

    public ArrayList<Funcionario> ObterTodos() {
        return new ArrayList<Funcionario>(this.funcionarios);
    }

    public void Inserir(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public void Remover(String nome) {
        this.funcionarios.removeIf(x -> x.Nome.equals(nome));
    }
}
