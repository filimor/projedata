package com.projedata.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.projedata.model.Funcionario;
import com.projedata.service.FuncionarioService;

public class Principal {
    static final double SALARIO_MINIMO = 1212.00;
    static FuncionarioService funcionarioService = new FuncionarioService();

    public static void main(String[] args) {
        inserirTodosOsFuncionarios();
        removerJoao();
        darAumentoDeDezPorCento();
        agruparFuncionariosEmUmMap();
        imprimirAniversariantesOutubroDezembro();
        imprimirMaisVelho();
        imprimirEmOrdemAlfabetica();
        imprimirTotalDosSalarios();
        imprimirQuantidadeSalariosMinimos();
    }

    private static void inserirTodosOsFuncionarios() {
        System.out.println(">> 3.1 - Inserir todos os funcionários, na mesma ordem e informações da tabela.\n");

        funcionarioService.inserir(List.of(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador"),
                new Funcionario("João", LocalDate.of(1990, 05, 12), BigDecimal.valueOf(2284.38), "Operador"),
                new Funcionario("Caio", LocalDate.of(1961, 05, 02), BigDecimal.valueOf(9836.14), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.8), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995, 01, 05), BigDecimal.valueOf(2234.68), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993, 03, 31), BigDecimal.valueOf(4071.84), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994, 07, 8), BigDecimal.valueOf(3017.45), "Gerente"),
                new Funcionario("Heloísa", LocalDate.of(2003, 05, 24), BigDecimal.valueOf(1606.85), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996, 9, 02), BigDecimal.valueOf(2799.93), "Gerente")));

        imprimirTodosOsFuncionarios();
    }

    private static void removerJoao() {
        System.out.println("\n>> 3.2 - Remover o funcionário 'João' da lista.");
        System.out.println(">> 3.3 - Imprimir todos os funcionários com todas suas informações\n");

        funcionarioService.remover("João");
        imprimirTodosOsFuncionarios();
    }

    private static void darAumentoDeDezPorCento() {
        System.out.println("\n>> 3.4 - Os funcionários receberam 10% de aumento de salário, atualizar a lista\n");

        funcionarioService.darAumento(0.1);
        imprimirTodosOsFuncionarios();
    }

    private static void agruparFuncionariosEmUmMap() {
        System.out.println(
                "\n>> 3.5 - Agrupar os funcionários por função em um MAP, sendo a chave a 'função' e o valor a 'lista de funcionários'.");
        System.out.println(">> 3.6 - Imprimir os funcionários, agrupados por função.\n");

        var funcionariosMap = new HashMap<String, ArrayList<Funcionario>>();
        for (var funcionario : funcionarioService.obterTodos()) {
            if (!funcionariosMap.containsKey(funcionario.getFuncao())) {
                funcionariosMap.put(funcionario.getFuncao(), new ArrayList<Funcionario>());
            }
            funcionariosMap.get(funcionario.getFuncao()).add(funcionario);
        }

        for (var entry : funcionariosMap.entrySet()) {
            System.out.println("*" + entry.getKey().toUpperCase() + ":");
            entry.getValue().forEach(System.out::println);
        }
    }

    private static void imprimirAniversariantesOutubroDezembro() {
        System.out.println("\n>> 3.8 - Imprimir os funcionários que fazem aniversário no mês 10 e 12.\n");

        var meses = List.of(10, 12);
        funcionarioService.pesquisarPorMesDeNascimento(meses).forEach(System.out::println);
    }

    private static void imprimirMaisVelho() {
        System.out.println(
                "\n>> 3.9 - Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.\n");

        Funcionario maisVelho = funcionarioService.obterTodos()
                .stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);
        var idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();

        System.out.println(String.format("Nome: %s, Idade: %s anos", maisVelho.getNome(), idade));
    }

    private static void imprimirEmOrdemAlfabetica() {
        System.out.println("\n>> 3.10 - Imprimir a lista de funcionários por ordem alfabética.\n");
        funcionarioService.obterPorOrdemAlfabetica().forEach(System.out::println);
    }

    private static void imprimirTotalDosSalarios() {
        System.out.println("\n>> 3.11 - Imprimir o total dos salários dos funcionários.\n");
        System.out.println(
                "Salário total: R$ " + Funcionario.DECIMAL_FORMAT.format(funcionarioService.obterSalarioTotal()));
    }

    private static void imprimirQuantidadeSalariosMinimos() {
        System.out.println("\n>> 3.12 - Imprimir quantos salários mínimos ganha cada funcionário.\n");

        funcionarioService.obterTodos().forEach(
                x -> System.out.println(
                        String.format("%-15s\t%5.2f", x.getNome(), x.getSalario().doubleValue() / SALARIO_MINIMO)));
    }

    private static void imprimirTodosOsFuncionarios() {
        funcionarioService.obterTodos().forEach(System.out::println);
    }
}
