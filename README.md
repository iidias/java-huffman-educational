# 📚 Projeto Estrutura de Dados - Visualizador do Algoritmo de Huffman

Atividade desenvolvido em **Java** para a disciplina de **Estrutura de Dados I**, com o objetivo de simular e visualizar o funcionamento lógico do Algoritmo de Huffman, um dos métodos mais eficientes de compressão de dados sem perda.

Diferente de compressores comuns, esta aplicação foca na **didática da estrutura**, exibindo o passo a passo da construção da árvore binária e a geração dos códigos.

## 📌 Objetivo do Projeto

Desenvolver uma aplicação que receba uma mensagem de texto e demonstre a aplicação prática de estruturas de dados (Árvores Binárias e Filas de Prioridade) para:
1. Analisar a frequência de caracteres.
2. Construir a Árvore de Huffman "bottom-up".
3. Gerar a tabela de códigos binários variáveis.
4. Calcular e exibir a eficiência da compressão (comparativo de bits).

## 🛠️ Tecnologias Utilizadas

* **Java** (JDK 8+)
* **POO** (Programação Orientada a Objetos)
* **Collections Framework** (Mapas e Filas)
* **Estruturas de Dados:** Árvores Binárias, Filas de Prioridade, HashMaps.
* **Lógica Matemática:** Cálculo de frequência e manipulação de strings binárias.

## 🎯 Funcionalidades

* **Análise de Frequência:** Contagem detalhada de cada caractere da mensagem.
* **Visualização da Árvore:** Log textual que mostra quais nós estão sendo unidos a cada etapa (step-by-step).
* **Tabela de Codificação:** Exibição do dicionário gerado (Caractere -> Binário).
* **Codificação e Decodificação:** Conversão da string original para a versão comprimida e vice-versa.
* **Estatísticas de Compressão:** Relatório matemático comparando o tamanho original vs. comprimido.

## 🔍 Exemplo de Execução

Abaixo, um exemplo real de uso do sistema processando a entrada "Igor":

```text
Digite a mensagem: Igor

Mensagem original: Igor

Frequência dos caracteres:
’I’ ? 1
’g’ ? 1
’o’ ? 1
’r’ ? 1

Mensagem original em binário:
’I’ ? 01001001
’g’ ? 01100111
’o’ ? 01101111
’r’ ? 01110010

Unindo árvores :
 - 'I' com freq 1
 - 'g' com freq 1
 ? Nova árvore com freq 2

Unindo árvores :
 - 'o' com freq 1
 - 'r' com freq 1
 ? Nova árvore com freq 2

Unindo árvores :
 - '*' com freq 2
 - '*' com freq 2
 ? Nova árvore com freq 4

Tabela de Códigos de Huffman:
’I’ ? 00
’g’ ? 01
’o’ ? 10
’r’ ? 11

Mensagem codificada: 00011011
Mensagem decodificada: Igor

--- Comparação ---
 Tamanho original (bits): 32
 Tamanho codificado (bits): 8
 Fator de compressão : 75,00% de economia
```

## ▶️ Como Executar

Para rodar este projeto na sua máquina local, você precisará ter o **Java (JDK)** instalado e configurado no seu PATH.

### 📋 Pré-requisitos

* **Java JDK 8** ou superior.
* **Git** (opcional, para clonar o repositório).

### 🚀 Rodando a aplicação

1.  **Clone o repositório** (ou baixe o código fonte):
    ```bash
    git clone [https://github.com/SEU-USUARIO/NOME-DO-REPO.git](https://github.com/SEU-USUARIO/NOME-DO-REPO.git)
    ```

2.  **Acesse a pasta do projeto** pelo terminal:
    ```bash
    cd NOME-DO-REPO
    ```

3.  **Compile o código Java**:
    ```bash
    javac *.java
    ```

4.  **Execute o programa**:
    *(Substitua `Main` pelo nome da classe que contém o método main do seu projeto)*
    ```bash
    java Main
    ```
