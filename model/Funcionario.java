package model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class Funcionario extends Pessoa {
    public BigDecimal Salario;
    public String Funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.Salario = salario;
        this.Funcao = funcao;
    }

    @Override
    public String toString() {
        var data = this.DataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        var salario = new DecimalFormat("#,##0.00").format(this.Salario);

        return String.format("%-15s\t%-10s\t%10s\t%s", this.Nome, data, salario, this.Funcao);
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
