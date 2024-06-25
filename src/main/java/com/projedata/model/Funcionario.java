package src.main.java.com.projedata.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00");

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        // • informação de data deve ser exibido no formato dd/mm/aaaa;
        // • informação de valor numérico deve ser exibida no formatado com separador de
        // milhar como ponto e decimal como vírgula.
        var data = this.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        var salario = DECIMAL_FORMAT.format(this.salario);

        return String.format("%-15s\t%-10s\t%10s\t%s", this.nome, data, salario, this.funcao);
    }
}
