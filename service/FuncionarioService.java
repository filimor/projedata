package service;

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
}
