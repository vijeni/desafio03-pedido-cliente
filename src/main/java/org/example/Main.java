package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean executando = true;

        do{
            System.out.println("=======Bem vindo a Vineji pizza! Onde a pizza tem o sabor da itália!=======\n");
            System.out.println("Selecione a opção que mais te atenda no momento:\n");
            System.out.println("1 - Criar conta\n");
            System.out.println("2 - Selecionar sabores\n");
            System.out.println("3 - Finalizar pedido e emitir recibo .txt\n");
            System.out.println("4 - Sair.\n");

            Scanner scn = new Scanner(System.in);
            int opc = scn.nextInt();
            switch (opc){
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                default:
                    break;
            }



        }while (executando);
    }
}