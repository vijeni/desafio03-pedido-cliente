package org.example;

public class Pedido {
    private Sabor sabor;
    private Endereco endereco;
    private boolean isEncerrado;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Pedido(Sabor sabores, Endereco endereco) {
        this.sabor = sabores;
        this.isEncerrado = false;
        this.endereco = endereco;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }

    public boolean isEncerrado() {
        return isEncerrado;
    }

    public void encerrar() {
        this.isEncerrado = true;
    }
}
