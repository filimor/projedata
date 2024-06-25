package repository;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.Funcionario;

public class FuncionarioRepository {
    private ArrayList<Funcionario> funcionarios;

    public FuncionarioRepository() {
        this.funcionarios = new ArrayList<Funcionario>();
    }

    public ArrayList<Funcionario> ObterTodos() {
        return new ArrayList<Funcionario>(this.funcionarios);
    }

    public Funcionario ObterPorNome(String nome) {
        return this.funcionarios.stream()
                .filter(x -> x.Nome.equals(nome))
                .findFirst()
                .orElse(null);
    }

    public void Inserir(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public Funcionario Atualizar(String nome, Funcionario funcionarioNovo) {
        var funcionario = this.ObterPorNome(nome);

        funcionario.Nome = funcionarioNovo.Nome;
        funcionario.DataNascimento = funcionarioNovo.DataNascimento;
        funcionario.Salario = funcionarioNovo.Salario;
        funcionario.Funcao = funcionarioNovo.Funcao;

        return funcionario;
    }

    public void Remover(String nome) {
        this.funcionarios.removeIf(x -> x.Nome.equals(nome));
    }

    public ArrayList<Funcionario> Pesquisar(Predicate<Funcionario> condicao) {
        return new ArrayList<Funcionario>(this.funcionarios.stream()
                .filter(condicao)
                .collect(Collectors.toList()));
    }
}
