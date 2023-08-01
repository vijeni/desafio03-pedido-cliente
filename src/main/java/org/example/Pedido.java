package org.example;

public class Pedido {
    private Sabor sabor;
    private boolean isEncerrado;

    public Pedido(Sabor sabores) {
        this.sabor = sabores;
        this.isEncerrado = false;
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

    public void setEncerrado(boolean encerrado) {
        isEncerrado = encerrado;
    }
}
