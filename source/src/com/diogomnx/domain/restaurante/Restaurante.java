package com.diogomnx.domain.restaurante;

import com.diogomnx.domain.compras.Cardapio;
import com.diogomnx.domain.pessoa.Funcionario;
import com.diogomnx.domain.compras.ItemCardapio;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    // Atributos do restaurante
    private String nome;             // Nome do restaurante
    private String endereco;         // Endereço do restaurante
    private List<Mesa> mesas;        // Lista de mesas disponíveis no restaurante
    private List<Funcionario> funcionarios; // Lista de funcionários do restaurante
    private Cardapio cardapio;       // Cardápio do restaurante

    // Construtor que inicializa os atributos e cria listas vazias para mesas e funcionários
    public Restaurante(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.mesas = new ArrayList<>();      // Inicializa a lista de mesas
        this.funcionarios = new ArrayList<>();  // Inicializa a lista de funcionários
        this.cardapio = new Cardapio();         // Inicializa o cardápio
    }

    // Getter para obter o cardápio do restaurante
    public Cardapio getCardapio() {
        return cardapio;
    }

    // Getter para obter a lista de funcionários
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    // Getter para obter a lista de mesas
    public List<Mesa> getMesas() {
        return mesas;
    }

    // Método para adicionar um item ao cardápio
    public void addItemCardapio(ItemCardapio item) {
        this.cardapio.addItem(item);  // Adiciona o item ao cardápio
    }

    // Método para adicionar uma mesa à lista de mesas
    public void addMesa(Mesa mesa) {
        this.mesas.add(mesa);  // Adiciona a mesa à lista
    }

    // Método para buscar uma mesa disponível com base na capacidade necessária
    public Mesa buscarMesaDisponivel(int capacidade) {
        // Percorre todas as mesas do restaurante
        for (Mesa mesa : mesas) {
            // Se a mesa estiver disponível e tiver a capacidade necessária
            if (mesa.isDisponivel() && mesa.getCapacidade() >= capacidade) {
                return mesa;  // Retorna a mesa disponível
            }
        }
        return null;  // Se não encontrar mesa disponível, retorna null
    }

    // Método que inicializa o sistema do restaurante (configuração inicial)
    public void inicializarSistema() {
        // Exibe uma mensagem indicando que o sistema foi inicializado
        System.out.println("Sistema do restaurante " + nome + " inicializado.");
    }

    // Método que gera uma representação em string do restaurante
    @Override
    public String toString() {
        return "Restaurante{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", mesas=" + mesas +
                ", funcionarios=" + funcionarios +
                ", cardapio=" + cardapio +
                '}';  // Retorna informações do restaurante em formato de string
    }
}
