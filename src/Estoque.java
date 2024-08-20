import java.util.Scanner;

public class Estoque {
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
                    System.out.println(escolha);
                    break;
                case 2:
                    System.out.println(escolha);
                    break;
                case 3:
                    System.out.println(escolha);
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
