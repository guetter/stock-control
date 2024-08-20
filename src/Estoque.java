import java.util.Scanner;

public class Estoque {
    static int numProdutos = 0;
    public static void imprimirMensagem(String msg, int status){
        if(msg.equals("CADASTRAR")){
            switch(status){
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
        }else if(msg.equals("EXCLUIR")){
            switch(status){
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
        }else if(msg.equals("VENDER")){
            switch(status){
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
        }else{
            System.out.println("ERRO! Parâmetros informados incorretamente!");
        }
    }
    public static int cadastrarProduto(String[][] produtos, int codigo, String descricao, int qtd, double preco){
        if (numProdutos <= 10){
            numProdutos++;

            return 1; //cadastrado com sucesso
        }else{
            return -1; //sem memoria para cadastrar
        }
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
            System.out.println("Preço: " + produtos[i][3]);
            System.out.println();
            System.out.println("======================================");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[][] produtos = new String[10][4];

        while(true){
            System.out.println("======================================");
            System.out.println("Qual operação você gostaria de fazer?");
            System.out.println("1 - Cadastrar um produto");
            System.out.println("2 - Excluir um produto");
            System.out.println("3 - Verificar os produtos");
            System.out.println("4 - Vender um produto");
            System.out.println("0 - Fechar o programa");
            System.out.println("======================================");
            System.out.printf("Digite um número: ");
            int escolha = sc.nextInt();
            System.out.println("======================================");

            switch (escolha){
                case 1:
                    System.out.println("==== CADASTRO ====");
                    System.out.printf("Digite o código do produto: ");
                    int codigo = sc.nextInt();
                    System.out.println("Digite a descrição do produto: ");
                    String descricao = sc.next();
                    System.out.printf("Digite a quantidade a ser cadastrada: ");
                    int qtd = sc.nextInt();
                    System.out.printf("Digite o preço unitário do produto: ");
                    double preco = sc.nextDouble();

                    int status = cadastrarProduto(produtos, codigo, descricao, qtd, preco);

                    imprimirMensagem("CADASTRAR", status);
                    break;
                case 2:
                    System.out.println(escolha);
                    break;
                case 3:
                    imprimirProdutos(produtos);
                    break;
                case 4:
                    System.out.println(escolha);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
}
