package com.diogomnx.domain.compras;

public class ItemCardapio {
    private String nome;        // Nome do item do cardápio (por exemplo, "Hambúrguer", "Pizza")
    private double preco;       // Preço do item
    private String categoria;   // Categoria do item (por exemplo, "Entrada", "Prato Principal", "Sobremesa")

    // Construtor que inicializa o nome, preço e categoria do item
    public ItemCardapio(String nome, double preco, String categoria) {
        this.nome = nome;       // Define o nome do item
        this.preco = preco;     // Define o preço do item
        this.categoria = categoria; // Define a categoria do item
    }

    // Método getter para obter o nome do item
    public String getNome() {
        return nome;
    }

    // Método setter para definir o nome do item
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para obter o preço do item
    public double getPreco() {
        return preco;
    }

    // Método setter para definir o preço do item
    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Método getter para obter a categoria do item
    public String getCategoria() {
        return categoria;
    }

    // Método setter para definir a categoria do item
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
