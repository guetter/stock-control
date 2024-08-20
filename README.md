# Sistema de Controle de Estoque

## Projeto de conclusão da cadeira de **Computação Aplicada à Solução de Problemas**

Este é um projeto simples em Java para o gerenciamento de um sistema de controle de estoque. O sistema armazena as informações dos produtos em uma matriz de Strings, que possui 10 linhas e 4 colunas. Cada coluna representa uma informação específica sobre o produto:

- **Coluna 1:** Código do produto
- **Coluna 2:** Descrição do produto
- **Coluna 3:** Quantidade em estoque
- **Coluna 4:** Preço do produto

## Funcionalidades

### 1. Cadastro de Produto (`cadastrarProduto`)

- **Descrição:** Permite cadastrar um novo produto na matriz.
- **Parâmetros:** Matriz, Código, Descrição, Quantidade, Preço.
- **Retorno:**
  - `1` - Produto cadastrado com sucesso.
  - `0` - Produto já cadastrado.
  - `-1` - Não há mais espaço disponível para novos cadastros.

### 2. Exclusão de Produto (`excluirProduto`)

- **Descrição:** Remove um produto cadastrado na matriz.
- **Parâmetros:** Matriz, Código do produto.
- **Retorno:**
  - `1` - Produto excluído com sucesso.
  - `-1` - Produto não cadastrado.

### 3. Impressão de Produtos (`imprimirProdutos`)

- **Descrição:** Exibe todos os produtos cadastrados na matriz, apresentando-os da seguinte forma:
Código: xxxx
Produto: xxxx
Quantidade: xxxx
Preço: xxxx
- **Parâmetros:** Matriz.

### 4. Venda de Produto (`venderProduto`)

- **Descrição:** Realiza a venda de um produto, descontando a quantidade vendida do estoque.
- **Parâmetros:** Matriz, Código do produto, Quantidade a ser vendida.
- **Retorno:**
- `1` - Venda realizada com sucesso.
- `-1` - Estoque insuficiente.
- `-2` - Produto não cadastrado.
- `-3` - Quantidade inválida (zero ou negativa).

### 5. Impressão de Mensagens (`imprimirMensagem`)

- **Descrição:** Exibe mensagens apropriadas com base no resultado das operações realizadas.
- **Parâmetros:** String de comando (ex: "CADASTRAR", "EXCLUIR", "VENDER") e um valor inteiro que indica o resultado da operação.
- **Mensagens:**
- **Para "CADASTRAR":**
  - `1` - "Produto cadastrado com sucesso."
  - `0` - "ERRO: Produto já cadastrado no sistema!"
  - `-1` - "ERRO: Não há memória disponível para realizar o cadastro!"
- **Para "EXCLUIR":**
  - `1` - "Produto excluído com sucesso."
  - `-1` - "ERRO: Produto não existe no sistema!"
- **Para "VENDER":**
  - `1` - "Venda realizada com sucesso."
  - `-1` - "ERRO: Não existe quantidade em estoque suficiente para realizar a venda!"
  - `-2` - "ERRO: Produto não cadastrado!"
  - `-3` - "ERRO: Quantidade inválida!"
- **Outros:** "ERRO! Parâmetros informados incorretamente!"

## Estrutura do Projeto

- **Classe Principal:** `Estoque`
- **Matriz:** `String[][] estoque` - 10 linhas x 4 colunas.
- **Métodos Principais:**
- `cadastrarProduto`
- `excluirProduto`
- `imprimirProdutos`
- `venderProduto`
- `imprimirMensagem`

## Como Executar

Para executar o projeto, compile a classe `Estoque` e chame os métodos de acordo com as funcionalidades desejadas. Verifique as mensagens de retorno para garantir que as operações foram realizadas com sucesso.
