package src.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class Funcionario extends Pessoa {
    public BigDecimal Salario;
    public String Funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.Salario = salario;
        this.Funcao = funcao;
    }

    public BigDecimal getSalario() {
        return Salario;
    }

    public void setSalario(BigDecimal salario) {
        Salario = salario;
    }

    public String getFuncao() {
        return Funcao;
    }

    public void setFuncao(String funcao) {
        Funcao = funcao;
    }
}
