package org.example;

public class Pedido {
    private Sabores sabores;
    private boolean isEncerrado;

    public Pedido(Sabores sabores) {
        this.sabores = sabores;
        this.isEncerrado = false;
    }

    public Sabores getSabores() {
        return sabores;
    }

    public void setSabores(Sabores sabores) {
        this.sabores = sabores;
    }

    public boolean isEncerrado() {
        return isEncerrado;
    }

    public void setEncerrado(boolean encerrado) {
        isEncerrado = encerrado;
    }
}
