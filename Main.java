
public class Main {
    public static void main(String[] args) {
        System.out.println("Problema da Mochila - Algoritmo de Programação Dinâmica"); 
        int[] pesos = {12, 1, 4, 2, 1};
        int[] valores = {4, 2, 10, 1, 2};
        int capacidade = 15;
        System.out.println("Valor máximo: " + mochila(pesos, valores, capacidade));
    }

    public static int mochila(int[] pesos, int[] valores, int capacidade) {
        int[][] tabela = new int[pesos.length + 1][capacidade + 1]; // tabela de valores

        for (int i = 0; i <= pesos.length; i++) { 
            for (int j = 0; j <= capacidade; j++) { 
                // se o item for 0 ou a capacidade for 0, o valor é 0
                if (i == 0 || j == 0) { 
                    // inicializa a tabela com 0
                    tabela[i][j] = 0; 
                    // se o peso do item for menor ou igual a capacidade
                } else if (pesos[i - 1] <= j) { 
                    // o valor máximo é o valor do item mais o valor máximo da capacidade restante
                    tabela[i][j] = Math.max(valores[i - 1] + tabela[i - 1][j - pesos[i - 1]], tabela[i - 1][j]); 
                } else {
                    // se o peso do item for maior que a capacidade, o valor máximo é o valor máximo da capacidade anterior
                    tabela[i][j] = tabela[i - 1][j]; 
                }
            }
        }
        // retorna o valor máximo da capacidade
        return tabela[pesos.length][capacidade]; 
    }
}