package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        System.out.println("\nDigite o nome do cliente:");
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
        System.out.println("\n- Selecione o endereço do cliente:");
        int j = 1;
        for (Endereco end:
                clientes.get(indexCliente).getEnderecos()) {
            System.out.printf(" --- ( %s ) - Logradouro:  %s %s - %s ( %s )%n", j, end.getLogradouro(), end.getNumero(), end.getBairro(), end.getCep());
        }
        System.out.println("\n- Digite o número do endereço (presente entre parenteses):");
        int indexEndereco = input.nextInt()-1;
        final Sabor[] sabores = Sabor.values();
        System.out.println("\n- Selecione o sabor de pizza, digitando seu número no cardápio:\n");
        for (int i = 0; i < sabores.length; i++) {
                System.out.println((i) + " - " + sabores[i].name());
            }
        int opc = input.nextInt();
        if (opc <= sabores.length) {
            sabor = sabores[opc];
            System.out.println("Você escolheu o sabor: " + sabor.name());
            clientes.get(indexCliente).addPedido(new Pedido(sabor, clientes.get(indexCliente).getEnderecos().get(indexEndereco)));
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
    public static void operacoesPedidos() throws IOException {
        int opc = 1;
        do{
            System.out.println("\n=================== GERENCIAR PEDIDOS ===================\n");
            System.out.println("- Digite a opcão, digitando seu número no menu:\n");
            System.out.println("1 - Novo Pedido");
            System.out.println("2 - Relatório de Pedidos");
            System.out.println("3 - Encerrar um Pedido");
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
                    encerrarPedido();
                    break;
                case 0: // Sair
                    System.out.println("\nSaindo...");
                    break;

                default:
                    break;
            }
        }while (opc!=0);
    }

    private static void comprovantePedido(Cliente cliente, Pedido pedido) throws IOException {
        Date hoje = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy");
        String nomeArquivo = String.format("pedido%s-%s", cliente.getNome(), formato.format(hoje));
        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + String.format("/src/main/java/org/example/comprovantes/%s", nomeArquivo);

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("Cliente: " + cliente.getNome());
            printWriter.println("Telefone do Cliente: " + cliente.getTelefone());
            printWriter.println("======== Endereço De Entrega ========");
            printWriter.println("Logadouro: " + pedido.getEndereco().getLogradouro());
            printWriter.println("Número: " + pedido.getEndereco().getNumero());
            printWriter.println("Bairro: " + pedido.getEndereco().getBairro());
            printWriter.println("CEP: " + pedido.getEndereco().getCep());
            printWriter.close();
            System.out.println("Comprovante de Pedido emitido com sucesso em: " + filePath);
        } catch (IOException e) {
            System.err.println("Erro ao emitir o comprovante:");
            e.printStackTrace();
        }
    }

    private static void encerrarPedido() throws IOException {
        System.out.println("================= ENCERRAR PEDIDO =================\n");
        System.out.println("Escolha o cliente do pedido");
        listarClientes();
        int indexCliente = pesquisarCliente();
        System.out.println("Informe o pedido a ser encerrado:");
        int i = 1;
        for (Pedido pedido:
             clientes.get(indexCliente).getPedidos()) {
            System.out.printf("\n( %s ) - Pedido cliente %s: \n- Sabor: %s \n- Status: %s %n", i, clientes.get(indexCliente).getNome(), pedido.getSabor(), pedido.isEncerrado() ? "Encerrado": "Aberto");
            i++;
        }
        System.out.println("Digite o número do pedido:");
        int indexPedido = input.nextInt() -1;
        clientes.get(indexPedido).getPedidos().get(indexPedido).encerrar();
        System.out.println("Por favor, aguarde a impressão do comprovante, na pasta 'comprovantes' ...\n");
        comprovantePedido(clientes.get(indexCliente), clientes.get(indexPedido).getPedidos().get(indexPedido));
        System.out.println("================= PEDIDO ENCERRADO =================\n");
    }

    public static void main(String[] args) throws IOException {
        List<Endereco> ends = new ArrayList<>();
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