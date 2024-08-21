import java.util.Scanner;

public class Estoque {
    static int numProdutos = 0;
    public static void imprimirMensagem(String msg, int status){
        switch (msg) {
            case "CADASTRAR" -> {
                switch (status) {
                    case 1:
                        System.out.println("Produto cadastrado com sucesso.");
                        break;
                    case 0:
                        System.out.println("ERRO: Produto já cadastrado no sistema!");
                        break;
                    case -1:
                        System.out.println("ERRO: Não há memória disponível para realizar o cadastro!");
                        break;
                    default:
                        System.out.println("ERRO! Parâmetros informados incorretamente!");
                        break;
                }
            }
            case "EXCLUIR" -> {
                switch (status) {
                    case 1:
                        System.out.println("Produto excluído com sucesso.");
                        break;
                    case -1:
                        System.out.println("ERRO: Produto não existe no sistema!");
                        break;
                    default:
                        System.out.println("ERRO! Parâmetros informados incorretamente!");
                        break;
                }
            }
            case "VENDER" -> {
                switch (status) {
                    case 1:
                        System.out.println("Venda realizada com sucesso.");
                        break;
                    case -1:
                        System.out.println("ERRO: Não existe quantidade em estoque suficiente para a realizar a venda!");
                        break;
                    case -2:
                        System.out.println("ERRO: Produto não cadastrado!");
                        break;
                    case -3:
                        System.out.println("ERRO: Quantidade inválida!");
                        break;
                    default:
                        System.out.println("ERRO! Parâmetros informados incorretamente!");
                        break;
                }
            }
            default -> System.out.println("ERRO! Parâmetros informados incorretamente!");
        }
    }
    public static int cadastrarProduto(String[][] produtos, int codigo, String descricao, int qtd, double preco){
        if (numProdutos <= 10){
            if(numProdutos != 0){
                for(int i = 0; i < numProdutos; i++){
                    if(String.valueOf(codigo).equals(produtos[numProdutos - 1][0])){ //caso codigo ja exista
                        return 0;
                    }
                }
            }

            produtos[numProdutos][0] = String.valueOf(codigo);
            produtos[numProdutos][1] = descricao;
            produtos[numProdutos][2] = String.valueOf(qtd);
            produtos[numProdutos][3] = String.valueOf(preco);
            numProdutos++;
            return 1; //cadastrado com sucesso
        }else{
            return -1; //sem memoria para cadastrar
        }
    }
    public static int excluirProduto(String[][] produtos, int codigo){
        for(int i = 0; i < numProdutos; i++){
            if(String.valueOf(codigo).equals(produtos[numProdutos - 1][0])){
                produtos[i][0] = "";
                produtos[i][1] = "";
                produtos[i][2] = "";
                produtos[i][3] = "";
                numProdutos--;

                return 1;
            }
        }

        return -1;
    }
    public static int venderProduto(String[][] produtos, int codigo, int qtd){
        if(qtd <= 0){
            return -3;
        }

        for(int i = 0; i < numProdutos; i++){
            if(String.valueOf(codigo).equals(produtos[numProdutos - 1][0])){
                int qtdPrevia = Integer.parseInt(produtos[i][2]);
                if(qtdPrevia >= qtd){
                    int qtdNova = qtdPrevia - qtd;
                    produtos[i][2] = String.valueOf(qtdNova);
                    return 1;
                }else{
                    return -1; //sem qtd em estoque
                }
            }
        }

        return -2;
    }
    public static void imprimirProdutos(String[][] produtos){
        for(int i = 0; i < numProdutos; i++){
            if(i == 0){
                System.out.println("======================================");
            }
            System.out.println();
            System.out.println("Código: " + produtos[i][0]);
            System.out.println();
            System.out.println("Produto: " + produtos[i][1]);
            System.out.println();
            System.out.println("Quantidade: " + produtos[i][2]);
            System.out.println();
            System.out.println("Preço: R$ " + produtos[i][3]);
            System.out.println();
            if(i != numProdutos - 1){
                System.out.println("======================================");
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[][] produtos = new String[10][4];
        int codigo, qtd, status;
        String descricao;
        double preco;

        while(true){
            System.out.println("======================================");
            System.out.println("Qual operação você gostaria de fazer?");
            System.out.println("1 - Cadastrar um produto");
            System.out.println("2 - Excluir um produto");
            System.out.println("3 - Verificar os produtos");
            System.out.println("4 - Vender um produto");
            System.out.println("0 - Fechar o programa");
            System.out.println("======================================");
            System.out.print("Digite um número: ");
            int escolha = sc.nextInt();

            switch (escolha){
                case 1:
                    System.out.println("============== CADASTRO ==============");
                    System.out.print("Digite o código do produto: ");
                    codigo = sc.nextInt();
                    System.out.print("Digite a descrição do produto: ");
                    descricao = sc.next();
                    System.out.print("Digite a quantidade a ser cadastrada: ");
                    qtd = sc.nextInt();
                    System.out.print("Digite o preço unitário do produto: ");
                    preco = sc.nextDouble();

                    status = cadastrarProduto(produtos, codigo, descricao, qtd, preco);

                    imprimirMensagem("CADASTRAR", status);
                    break;
                case 2:
                    System.out.println("============== EXCLUSÃO ==============");
                    System.out.print("Digite o código do produto: ");
                    codigo = sc.nextInt();

                    status = excluirProduto(produtos, codigo);

                    imprimirMensagem("EXCLUIR", status);
                    break;
                case 3:
                    imprimirProdutos(produtos);
                    break;
                case 4:
                    System.out.println("=============== VENDA ================");
                    System.out.print("Digite o código do produto: ");
                    codigo = sc.nextInt();
                    System.out.print("Digite a quantidade vendida: ");
                    qtd = sc.nextInt();

                    status = venderProduto(produtos, codigo, qtd);

                    imprimirMensagem("VENDER", status);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
}
