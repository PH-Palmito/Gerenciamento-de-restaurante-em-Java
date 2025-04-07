package com.diogomnx.domain.pessoa;

import com.diogomnx.domain.compras.Pedido;

public class Garcom extends Funcionario {

    // Construtor da classe Garcom, que herda de Funcionario
    // Ele inicializa o nome e o ID do garçom, que são passados para o construtor da classe Pai (Funcionario)
    public Garcom(String nome, String idFuncionario) {
        super(nome, idFuncionario); // Chama o construtor da classe Funcionario
    }

    // Método sobrescrito da classe pai (Funcionario) que define o que o garçom deve fazer
    @Override
    public void executarTarefa() {
        // O garçom executa a tarefa de atender a mesa, mostrando uma mensagem
        System.out.println("O garçom está atendendo a mesa...");
    }
}
