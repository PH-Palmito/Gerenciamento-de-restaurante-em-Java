package com.diogomnx.domain.pessoa;

import com.diogomnx.domain.compras.ItemCardapio;
import com.diogomnx.domain.compras.Pedido;

public abstract class Funcionario extends Pessoa {

    // Atributo que armazena o ID do funcionário
    private String idFuncionario;

    // Construtor que inicializa os atributos nome e idFuncionario
    public Funcionario(String nome, String idFuncionario) {
        super(nome);  // Chama o construtor da classe Pai (Pessoa) para inicializar o nome
        this.idFuncionario = idFuncionario;  // Inicializa o ID do funcionário
    }

    // Getter para obter o ID do funcionário
    public String getIdFuncionario() {
        return idFuncionario;
    }

    // Setter para definir o ID do funcionário
    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    // Método abstrato que deve ser implementado por todas as subclasses para executar a tarefa do funcionário
    public abstract void executarTarefa();
}
