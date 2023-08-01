package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in).useDelimiter("\n");
    static List<Cliente> clientes = new ArrayList<>();
    public static List<Endereco> coletarEnderecos(){
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
            System.out.println("\n ========= Endereço Cadastrado!\n");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar um novo endereço");
            opc = input.nextInt();
        }while (opc != 0);
        return enderecos;
    }
    public static Cliente cadastrarCliente(){
        System.out.println("\n =================== CADASTRAR CLIENTE ===================");
        System.out.println("\n - Digite o nome do cliente: ");
        String nome = input.next();
        System.out.println("\n - Digite o telefone do cliente: ");
        String telefone = input.next();
        List<Endereco> enderecos = coletarEnderecos();
        System.out.println("\n =================== CLIENTE CADASTRADO ===================");
        Cliente cliente  = new Cliente(nome, telefone, enderecos);
        clientes.add(cliente);
        return cliente;
    }
    public static int menuPrincipal(){
        System.out.println("======= Pizzaria Vineji! Onde a pizza tem o sabor da Itália! =======\n");
        System.out.println("- Selecione a opção desejada, digitando o número no menu:\n");
        System.out.println("1 - Clientes");
        System.out.println("2 - Pedidos");
        System.out.println("0 - Sair.\n");
        return input.nextInt();
    }
    public static void listarClientes() {
        for (Cliente cliente:
                clientes) {
            System.out.printf("\n- Nome: %s \n- Telefone: %s%n", cliente.getNome(), cliente.getTelefone());
        }
    }
    public static int pesquisarCliente() {
        Cliente clientePesquisado = null;
        int indexClientePesquisado = -1;
        System.out.println("\nDigite o nome do cliente que deseja ver informações:");
        String nomeCliente = input.next();
        int i = 0;
        for (Cliente cliente:
                clientes) {
            System.out.println(i);
            if(cliente.getNome().equals(nomeCliente)){
                clientePesquisado = cliente;
                indexClientePesquisado = i;
                System.out.println("\n");
                System.out.printf("- Nome: %s \n- Telefone: %s \n- Endereços:%n", cliente.getNome(), cliente.getTelefone());
                for (Endereco end:
                        cliente.getEnderecos()) {
                    System.out.printf(" --- Logradouro:  %s %s - %s ( %s )%n", end.getLogradouro(), end.getNumero(), end.getBairro(), end.getCep());
                }
                System.out.println("\n");
            }
            i+=1;
        }
        if (clientePesquisado == null){
            System.out.println("\nNenhuma pessoa foi encontrada com o nome: " + nomeCliente);
        }
        return indexClientePesquisado;
    }
    public static void editarCliente() {
        listarClientes();
        int indexClienteEditar = pesquisarCliente();
        System.out.println("\nEdite os valores que desejar, ou digite X nos valores que deseja manter inalterados:");
        System.out.printf("- Nome ( %s ): %n", clientes.get(indexClienteEditar).getNome());
        String novoNome = input.next();
        clientes.get(indexClienteEditar).setNome(novoNome.equalsIgnoreCase("X") ? clientes.get(indexClienteEditar).getNome() : novoNome );
        System.out.printf("- Telefone ( %s ): %n", clientes.get(indexClienteEditar).getTelefone());
        String telefone = input.next();
        clientes.get(indexClienteEditar).setTelefone(telefone.equalsIgnoreCase("X") ? clientes.get(indexClienteEditar).getTelefone() : telefone);
        System.out.println("\n =================== CLIENTE EDITADO ===================");

        System.out.println("\nDeseja alterar os seguintes endereços?");
        for (Endereco end:
                clientes.get(indexClienteEditar).getEnderecos()) {
            int i = 1;
            System.out.printf(" ( %s ) - Logradouro: %s  %s - %s ( %s ) %n", i, end.getLogradouro(), end.getNumero(), end.getBairro(), end.getCep());
            i++;
        }
        System.out.println("\nDigite o ID ( número entre parenteses ) do endereço que deseja editar, ou digite 0 para cancelar");
        int opc = input.nextInt();
        if(opc != 0){
            if (opc > clientes.get(indexClienteEditar).getEnderecos().size()){
                System.out.println("Valor inválido!");
            }else{
                System.out.println("\nEdite os valores que desejar, ou digite X nos valores que deseja manter inalterados:");
                System.out.printf("- Logradouro ( %s ): %n", clientes.get(indexClienteEditar).getEnderecos().get(opc-1).getLogradouro());
                String logradouro = input.next();
                clientes.get(indexClienteEditar).getEnderecos().get(opc-1).setLogradouro(logradouro.equalsIgnoreCase("X") ? clientes.get(indexClienteEditar).getEnderecos().get(opc-1).getLogradouro() : logradouro);

                System.out.printf("- Número ( %s ): %n", clientes.get(indexClienteEditar).getEnderecos().get(opc-1).getNumero());
                String numero = input.next();
                clientes.get(indexClienteEditar).getEnderecos().get(opc-1).setLogradouro(numero.equalsIgnoreCase("X") ? clientes.get(indexClienteEditar).getEnderecos().get(opc-1).getNumero() : numero);

                System.out.printf("- Bairro ( %s ): %n", clientes.get(indexClienteEditar).getEnderecos().get(opc-1).getBairro());
                String bairro = input.next();
                clientes.get(indexClienteEditar).getEnderecos().get(opc-1).setLogradouro(bairro.equalsIgnoreCase("X") ? clientes.get(indexClienteEditar).getEnderecos().get(opc-1).getBairro() : bairro);

                System.out.printf("- CEP ( %s ): %n", clientes.get(indexClienteEditar).getEnderecos().get(opc-1).getCep());
                String cep = input.next();
                clientes.get(indexClienteEditar).getEnderecos().get(opc-1).setLogradouro(cep.equalsIgnoreCase("X") ? clientes.get(indexClienteEditar).getEnderecos().get(opc-1).getCep() : cep);
                System.out.println("\n =================== ENDEREÇO EDITADO ===================");
            }
        }
    }
    public static void operacoesClientes(){
        int opc = 1;
        do{
            System.out.println("\n=================== GERENCIAR CLIENTES ===================\n");
            System.out.println("- Selecione o menu desejado:\n");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Editar Cliente");
            System.out.println("3 - Listar Clientes");
            System.out.println("4 - Pesquisar Cliente");
            System.out.println("0 - Sair.\n");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    editarCliente();
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
                    pesquisarCliente();
                    break;

                case 0: // Sair
                    System.out.println("\nSaindo...");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }
        }while (opc!=0);
    }
    public static void novoPedido(){
        System.out.println("- Selecione o cliente:");
        listarClientes();
        Sabor sabor = null;
        int indexCliente = pesquisarCliente();
        final Sabor[] sabores = Sabor.values();
        System.out.println("\n- Selecione o sabor de pizza, digitando seu número no cardápio:\n");
        for (int i = 0; i < sabores.length; i++) {
                System.out.println((i) + " - " + sabores[i].name());
            }
        int opc = input.nextInt();
        if (opc <= sabores.length) {
            sabor = sabores[opc];
            System.out.println("Você escolheu o sabor: " + sabor.name());
            clientes.get(indexCliente).addPedido(new Pedido(sabor));
            System.out.println("========== PEDIDO REALIZADO ==========\n");
        }else {
            System.out.println("Opção inválida ");
        }
    }
    public static void relatorioPedidos(){
        System.out.println("\n=========== RELATÓRIO DE PEDIDOS ===========");
        for (Cliente cliente:
             clientes) {
            for (Pedido pedido:
                 cliente.getPedidos()) {
                System.out.printf("\nPedido cliente %s: \n- Sabor: %s \n- Status: %s %n", cliente.getNome(), pedido.getSabor(), pedido.isEncerrado() ? "Encerrado": "Aberto");
            }
        }
    }
    public static void operacoesPedidos(){
        int opc = 1;
        do{
            System.out.println("\n=================== GERENCIAR PEDIDOS ===================\n");
            System.out.println("- Digite a opcão, digitando seu número no menu:\n");
            System.out.println("1 - Novo Pedido");
            System.out.println("2 - Relatório de Pedidos");
            System.out.println("3 - Encerrar um Pedido");
            System.out.println("4 - Reimprimir comprovante");
            System.out.println("0 - Sair.\n");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    novoPedido();
                    break;
                case 2:
                    relatorioPedidos();
                    break;
                case 3:
//                    encerrarPedido();
                    break;
                case 4:
//                    comprovantePedido();
                    break;

                case 0: // Sair
                    System.out.println("\nSaindo...");
                    break;

                default:
                    break;
            }
        }while (opc!=0);
    }
    public static void main(String[] args) {
        List<Endereco> ends = new ArrayList<>();
        ends.add(new Endereco("rua", "numero", "bairro", "cep"));
        clientes.add(new Cliente("Jean", "111111111", ends));
        clientes.add(new Cliente("Vinicius", "222222222", ends));
        int opc;
        do {
            opc = menuPrincipal();
            switch (opc) {
                case 1: // Gerenciamento de Clientes
                    operacoesClientes();
                    break;

                case 2: // Gerenciamento de Pedidos
                    operacoesPedidos();
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