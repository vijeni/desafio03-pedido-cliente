package org.example;

import java.util.List;

public class Cliente {
private String nome;
private List<Endereco> enderecos;
private String telefone;

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

    public Cliente(String nome, List<Endereco> enderecos, String telefone) {
        this.nome = nome;
        this.enderecos = enderecos;
        this.telefone = telefone;
    }
    public Cliente() {

    }
}
