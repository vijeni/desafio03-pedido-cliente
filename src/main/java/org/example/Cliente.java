package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private List<Endereco> enderecos;
    private String telefone;
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(String nome, String telefone, List<Endereco> enderecos) {
        this.nome = nome;
        this.enderecos = enderecos;
        this.telefone = telefone;
    }

    public Cliente() {    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
