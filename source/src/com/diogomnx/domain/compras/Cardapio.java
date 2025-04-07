package com.diogomnx.domain.compras;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private List<ItemCardapio> itens;

    public Cardapio() {
        this.itens = new ArrayList<>();
    }

    public void addItem(ItemCardapio item) {
        itens.add(item);
    }

    public List<ItemCardapio> getItens() {
        return itens;
    }
}