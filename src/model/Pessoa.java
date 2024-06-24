package src.model;

import java.time.LocalDate;

public abstract class Pessoa {
    public String Nome;
    public LocalDate DataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        Nome = nome;
        DataNascimento = dataNascimento;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public LocalDate getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        DataNascimento = dataNascimento;
    }
}