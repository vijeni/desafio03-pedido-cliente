package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in).useDelimiter("\n");
    public List<Endereco> coletarEnderecos(){
        List<Endereco> enderecos = new ArrayList<>();
        System.out.println("\n ========= Cadastro de Endereço: ");
        int opc = 1;
        do{
            System.out.println("\n - Digite seu logradouro: ");
            String logradouro = input.next();
            System.out.println("\n - Digite o número de seu endereço: ");
            String numero = input.next();
            System.out.println("\n - Digite o bairro: ");
            String bairro = input.next();
            System.out.println("\n - Digite o CEP: ");
            String cep = input.next();
            enderecos.add(new Endereco(logradouro,bairro,numero,cep));
            System.out.println("\n ========= Endereço Cadastrado!]n");
            System.out.println("0 - Sair");
            System.out.println("2 - Cadastrar um novo endereço");
            opc = input.nextInt();
        }while (opc != 0);
        return enderecos;
    }
    public Cliente cadastrarPessoa(){
        System.out.println("\n =================== CRIAR CONTA ===================");
        System.out.println("\n - Digite seu nome: ");
        String nome = input.next();
        System.out.println("\n - Digite seu telefone: ");
        String telefone = input.next();
        List<Endereco> enderecos = coletarEnderecos();
        System.out.println("\n =================== CONTA CRIADA ===================");

        return new Cliente(nome, telefone, enderecos);
    }
    public static int menuPrincipal(){
        System.out.println("======= Pizzaria Vineji! Onde a pizza tem o sabor da Itália! =======\n");
        System.out.println("Operações:\n");
        System.out.println("1 - Clientes");
        System.out.println("2 - Pedidos");
        System.out.println("0 - Sair.\n");
        return input.nextInt();
    }
    public static void main(String[] args) {
        int opc;
        do {
            opc = menuPrincipal();
            switch (opc) {
                case 1: // Gerenciamento de Clientes
                    break;

                case 2: // Gerenciamento de Pedidos
                    break;

                case 0: // Sair
                    System.out.println("\nSaindo...");
                    break;

                default:
                    break;
            }
        } while (opc != 0);
    }
}