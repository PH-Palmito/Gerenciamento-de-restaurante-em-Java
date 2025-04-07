package com.diogomnx.domain.restaurante;

import com.diogomnx.domain.compras.ItemCardapio;
import com.diogomnx.domain.pessoa.Cozinheiro;
import com.diogomnx.domain.pessoa.Funcionario;
import com.diogomnx.domain.pessoa.Garcom;
import com.diogomnx.domain.pessoa.Gerente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaRestaurante {
    private final Restaurante restaurante;  // Objeto do tipo Restaurante, para gerenciar as mesas, cardápio, etc.
    private List<Funcionario> funcionarios; // Lista de funcionários do restaurante

    // Construtor que inicializa o sistema de restaurante com a instância de Restaurante
    public SistemaRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;  // Inicializa o restaurante passado como argumento
        this.funcionarios = new ArrayList<>();  // Cria a lista de funcionários vazia
    }

    // Método para adicionar uma mesa ao restaurante
    public void adicionarMesa(Scanner input) {
        // Solicita ao usuário o número e a capacidade da mesa
        System.out.print("Número da Mesa: ");
        int numero = input.nextInt();
        System.out.print("Capacidade da Mesa: ");
        int capacidade = input.nextInt();

        // Cria uma nova mesa e a adiciona ao restaurante
        restaurante.addMesa(new Mesa(numero, capacidade));
        System.out.println("Mesa adicionada com sucesso.");
    }

    // Método para listar todas as mesas do restaurante
    public void listarMesas() {
        // Exibe as informações das mesas com formatação de tabela
        System.out.printf("%-10s %-15s\n", "Número", "Capacidade");
        for (Mesa mesa : restaurante.getMesas()) {
            // Exibe o número e a capacidade de cada mesa
            System.out.printf("%-10d %-15d\n", mesa.getNumeroMesa(), mesa.getCapacidade());
        }
    }

    // Método para listar as mesas ordenadas por capacidade
    public void listarMesasOrdenadas() {
        // Ordena as mesas com base na capacidade
        restaurante.getMesas().sort((m1, m2) -> Integer.compare(m1.getCapacidade(), m2.getCapacidade()));
        // Chama o método listarMesas() para exibir a lista ordenada
        listarMesas();
    }

    // Método para buscar uma mesa disponível com capacidade mínima
    public void buscarMesaPorCapacidade(Scanner input) {
        System.out.print("Capacidade mínima: ");
        int capacidade = input.nextInt();

        // Busca uma mesa disponível com a capacidade requerida
        Mesa mesa = restaurante.buscarMesaDisponivel(capacidade);

        if (mesa != null) {
            // Se uma mesa for encontrada, exibe suas informações
            System.out.println("Mesa encontrada: " + mesa.getNumeroMesa() + " com capacidade de " + mesa.getCapacidade());
        } else {
            // Se não houver mesa disponível, informa o usuário
            System.out.println("Nenhuma mesa encontrada com essa capacidade.");
        }
    }

    // Método para adicionar um item ao cardápio do restaurante
    public void adicionarItemCardapio(Restaurante restaurante, Scanner input) {
        input.nextLine(); // Limpa o buffer do scanner
        // Solicita as informações do item de cardápio ao usuário
        System.out.print("Nome do Item: ");
        String nome = input.nextLine();
        System.out.print("Preço do Item: ");
        double preco = input.nextDouble();
        input.nextLine(); // Limpa o buffer do scanner
        System.out.print("Categoria do Item: ");
        String categoria = input.nextLine();

        // Cria um novo item de cardápio e o adiciona ao cardápio do restaurante
        restaurante.addItemCardapio(new ItemCardapio(nome, preco, categoria));
        System.out.println("Item adicionado ao cardápio.");
    }

    // Método para listar todos os itens do cardápio
    public void listarCardapio(Restaurante restaurante) {
        // Exibe os itens do cardápio com formatação
        System.out.printf("%-20s %-10s %-15s\n", "Nome", "Preço", "Categoria");
        for (var item : restaurante.getCardapio().getItens()) {
            // Exibe o nome, preço e categoria de cada item no cardápio
            System.out.printf("%-20s R$%-10.2f %-15s\n", item.getNome(), item.getPreco(), item.getCategoria());
        }
    }

    // Método para adicionar um novo funcionário ao restaurante
    public void adicionarFuncionario(Scanner input) {
        System.out.print("Digite o nome do funcionário: ");
        String nomeFuncionario = input.next();

        // Solicita ao usuário o tipo de funcionário
        System.out.println("Escolha o tipo de funcionário:");
        System.out.println("1. Garçom");
        System.out.println("2. Gerente");
        System.out.println("3. Cozinheiro");
        int tipoFuncionario = input.nextInt();

        System.out.print("Digite o ID do funcionário: ");
        String idFuncionario = input.next();

        Funcionario funcionario = null;
        // Cria o tipo de funcionário de acordo com a opção escolhida
        switch (tipoFuncionario) {
            case 1:
                funcionario = new Garcom(nomeFuncionario, idFuncionario);  // Cria um Garçom
                break;
            case 2:
                funcionario = new Gerente(nomeFuncionario, idFuncionario);  // Cria um Gerente
                break;
            case 3:
                funcionario = new Cozinheiro(nomeFuncionario, idFuncionario);  // Cria um Cozinheiro
                break;
            default:
                System.out.println("Opção inválida.");  // Se a opção não for válida
        }

        // Se o funcionário for criado com sucesso, adiciona à lista de funcionários
        if (funcionario != null) {
            funcionarios.add(funcionario);
            System.out.println(funcionario.getNome() + " foi adicionado com sucesso!");
        }
    }

    // Método para listar todos os funcionários do restaurante
    public void listarFuncionarios() {
        System.out.println("\n=== Lista de Funcionários ===");
        for (Funcionario funcionario : funcionarios) {
            // Exibe o nome e o ID de cada funcionário
            System.out.println(funcionario.getNome() + " - " + funcionario.getIdFuncionario());
        }
    }
}
