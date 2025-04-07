package com.diogomnx.domain.pessoa;

import com.diogomnx.domain.compras.ItemCardapio;
import com.diogomnx.domain.compras.Pedido;

public class Cozinheiro extends Funcionario {

    // Construtor da classe Cozinheiro, que herda de Funcionario
    public Cozinheiro(String nome, String idFuncionario) {
        super(nome, idFuncionario);  // Chama o construtor da classe Funcionario, que inicializa o nome e o ID
    }

    // Sobrescrita do método executarTarefa() para a classe Cozinheiro
    @Override
    public void executarTarefa() {
        // Exibe a mensagem indicando que o cozinheiro está preparando o pedido
        System.out.println("O cozinheiro está preparando o pedido.");
    }
}
