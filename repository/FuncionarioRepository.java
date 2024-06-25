package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.Funcionario;

public class FuncionarioRepository {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public FuncionarioRepository() {
    }

    public List<Funcionario> obterTodos() {
        return new ArrayList<>(this.funcionarios);
    }

    public Funcionario obterPorNome(String nome) {
        return this.funcionarios.stream()
                .filter(x -> x.getNome().equals(nome))
                .findFirst()
                .orElse(null);
    }

    public void inserir(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public Funcionario atualizar(String nome, Funcionario funcionarioNovo) {
        var funcionario = this.obterPorNome(nome);

        funcionario.setNome(funcionarioNovo.getNome());
        funcionario.setDataNascimento(funcionarioNovo.getDataNascimento());
        funcionario.setSalario(funcionarioNovo.getSalario());
        funcionario.setFuncao(funcionarioNovo.getFuncao());

        return funcionario;
    }

    public void remover(String nome) {
        this.funcionarios.removeIf(x -> x.getNome().equals(nome));
    }

    public List<Funcionario> pesquisar(Predicate<Funcionario> condicao) {
        return new ArrayList<>(this.funcionarios.stream()
                .filter(condicao)
                .collect(Collectors.toList()));
    }
}
