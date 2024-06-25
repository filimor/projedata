import java.math.BigDecimal;
import java.time.LocalDate;

import model.Funcionario;
import service.FuncionarioService;

public class Principal {
        public static void main(String[] args) {
                var funcionarioService = new FuncionarioService();

                // 3.1 - Inserir todos os funcionários, na mesma ordem e informações da tabela.

                System.out.println("🟦 3.1 - Inserir todos os funcionários, na mesma ordem e informações da tabela.\n");

                funcionarioService.Inserir(new Funcionario(
                                "Maria",
                                LocalDate.of(2000, 10, 18),
                                BigDecimal.valueOf(2009.44),
                                "Operador"));
                funcionarioService.Inserir(new Funcionario(
                                "João",
                                LocalDate.of(1990, 05, 12),
                                BigDecimal.valueOf(2284.38),
                                "Operador"));
                funcionarioService.Inserir(new Funcionario(
                                "Caio",
                                LocalDate.of(1961, 05, 02),
                                BigDecimal.valueOf(9836.14),
                                "Coordenador"));
                funcionarioService.Inserir(new Funcionario(
                                "Miguel",
                                LocalDate.of(1988, 10, 14),
                                BigDecimal.valueOf(19119.8),
                                "Diretor"));
                funcionarioService.Inserir(new Funcionario(
                                "Alice",
                                LocalDate.of(1995, 01, 05),
                                BigDecimal.valueOf(2234.68),
                                "Recepcionista"));
                funcionarioService.Inserir(new Funcionario(
                                "Heitor",
                                LocalDate.of(1999, 11, 19),
                                BigDecimal.valueOf(1582.72),
                                "Operador"));
                funcionarioService.Inserir(new Funcionario(
                                "Arthur",
                                LocalDate.of(1993, 03, 31),
                                BigDecimal.valueOf(4071.84),
                                "Contador"));
                funcionarioService.Inserir(new Funcionario(
                                "Laura",
                                LocalDate.of(1994, 07, 8),
                                BigDecimal.valueOf(3017.45),
                                "Gerente"));
                funcionarioService.Inserir(new Funcionario(
                                "Heloísa",
                                LocalDate.of(2003, 05, 24),
                                BigDecimal.valueOf(1606.85),
                                "Eletricista"));
                funcionarioService.Inserir(new Funcionario(
                                "Helena",
                                LocalDate.of(1996, 9, 02),
                                BigDecimal.valueOf(2799.93),
                                "Gerente"));

                for (Funcionario funcionario : funcionarioService.ObterTodos()) {
                        System.out.println(String.format("%s %s %s %s", funcionario.Nome, funcionario.DataNascimento,
                                        funcionario.Salario, funcionario.Funcao));
                }

                // 3.1 - Inserir todos os funcionários, na mesma ordem e informações da tabela.

                System.out.println("\n🟦 3.2 - Remover o funcionário 'João' da lista..\n");

                funcionarioService.Remover("João");

                for (Funcionario funcionario : funcionarioService.ObterTodos()) {
                        System.out.println(String.format("%s %s %s %s", funcionario.Nome, funcionario.DataNascimento,
                                        funcionario.Salario, funcionario.Funcao));
                }
        }
}
