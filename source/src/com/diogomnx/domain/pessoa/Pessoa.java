package com.diogomnx.domain.pessoa;

public abstract class Pessoa {
    // Atributo privado que armazena o nome da pessoa
    private String nome;

    // Construtor que inicializa o nome da pessoa
    public Pessoa(String nome) {
        this.nome = nome;
    }

    // Método getter para obter o nome da pessoa
    public String getNome() {
        return nome;
    }

    // Método setter para definir o nome da pessoa
    public void setNome(String nome) {
        this.nome = nome;
    }
}
