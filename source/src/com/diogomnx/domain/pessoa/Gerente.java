package com.diogomnx.domain.pessoa;

public class Gerente extends Funcionario {

    // Construtor da classe Gerente, que herda de Funcionario
    // O construtor inicializa o nome e o ID do gerente, que são passados para o construtor da classe Pai (Funcionario)
    public Gerente(String nome, String idFuncionario) {
        super(nome, idFuncionario); // Chama o construtor da classe Funcionario para inicializar os atributos
    }

    // Método sobrescrito da classe pai (Funcionario) que define a tarefa do gerente
    @Override
    public void executarTarefa() {
        // O gerente executa a tarefa de gerenciar as reservas, imprimindo uma mensagem
        System.out.println("O gerente está gerenciando as reservas...");
    }
}
