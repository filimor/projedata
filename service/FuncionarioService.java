package service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import model.Funcionario;
import repository.FuncionarioRepository;

public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService() {
        funcionarioRepository = new FuncionarioRepository();
    }

    public List<Funcionario> obterTodos() {
        return funcionarioRepository.obterTodos();
    }

    public void inserir(Funcionario funcionario) {
        this.funcionarioRepository.inserir(funcionario);
    }

    public void inserir(List<Funcionario> funcionarios) {
        funcionarios.forEach(this.funcionarioRepository::inserir);
    }

    public void remover(String nome) {
        this.funcionarioRepository.remover(nome);
    }

    public void darAumento(double porcentagem) {
        for (Funcionario funcionario : funcionarioRepository.obterTodos()) {
            var salarioNovo = funcionario.getSalario().multiply(BigDecimal.valueOf(1 + porcentagem));
            var funcionarioNovo = new Funcionario(funcionario.getNome(), funcionario.getDataNascimento(), salarioNovo,
                    funcionario.getFuncao());
            funcionarioRepository.atualizar(funcionario.getNome(), funcionarioNovo);
        }
    }

    public BigDecimal obterSalarioTotal() {
        return obterTodos()
                .stream()
                .map(x -> x.getSalario())
                .reduce((x, y) -> x.add(y))
                .orElse(null);
    }

    public List<Funcionario> obterPorOrdemAlfabetica() {
        return obterTodos()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Funcionario> pesquisarPorMesDeNascimento(List<Integer> meses) {
        return funcionarioRepository.pesquisar(x -> meses.contains(x.getDataNascimento().getMonthValue()));
    }
}
