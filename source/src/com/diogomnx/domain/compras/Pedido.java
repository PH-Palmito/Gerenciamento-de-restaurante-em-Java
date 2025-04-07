package com.diogomnx.domain.compras;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    // Lista que armazena os itens do pedido
    private List<ItemCardapio> itens = new ArrayList<>();
    // Variável para armazenar o valor total do pedido
    private Double valorTotal;

    // Método para adicionar um item ao pedido
    public void addItem(ItemCardapio item){
        itens.add(item);  // Adiciona o item à lista de itens do pedido
    }

    // Método para calcular o valor total do pedido
    public double calcularTotal(){
        double total = 0.0;  // Inicializa o total como 0
        // Percorre a lista de itens e soma o preço de cada item ao total
        for (ItemCardapio item : itens) {
            total += item.getPreco();  // Soma o preço de cada item ao total
        }
        return total;  // Retorna o valor total do pedido
    }

    // Getter para obter a lista de itens do pedido
    public List<ItemCardapio> getItens() {
        return itens;
    }

    // Setter para definir a lista de itens do pedido
    public void setItens(List<ItemCardapio> itens) {
        this.itens = itens;
    }

    // Getter para obter o valor total do pedido
    public Double getValorTotal() {
        return valorTotal;
    }

    // Setter para definir o valor total do pedido
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
