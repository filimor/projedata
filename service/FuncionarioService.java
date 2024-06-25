package service;

import java.math.BigDecimal;
import java.util.ArrayList;

import model.Funcionario;
import repository.FuncionarioRepository;

public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService() {
        funcionarioRepository = new FuncionarioRepository();
    }

    public ArrayList<Funcionario> ObterTodos() {
        return funcionarioRepository.ObterTodos();
    }

    public void Inserir(Funcionario funcionario) {
        this.funcionarioRepository.Inserir(funcionario);
    }

    public void Remover(String nome) {
        this.funcionarioRepository.Remover(nome);
    }

    public void DarAumento(double porcentagem) {
        for (Funcionario funcionario : funcionarioRepository.ObterTodos()) {
            var salarioNovo = funcionario.Salario.multiply(BigDecimal.valueOf(1 + porcentagem));
            var funcionarioNovo = new Funcionario(funcionario.Nome, funcionario.DataNascimento, salarioNovo,
                    funcionario.Funcao);
            funcionarioRepository.Atualizar(funcionario.Nome, funcionarioNovo);
        }
    }
}
