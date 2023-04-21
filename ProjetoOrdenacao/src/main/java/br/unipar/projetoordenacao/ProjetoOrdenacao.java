package br.unipar.projetoordenacao;

import javax.swing.JOptionPane;

/**
 *
 * @author Kauan e Lucas
 */
public class ProjetoOrdenacao {

    public static void main(String[] args) {

        int tipo = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da ordenação desejada: \n 1 - SelectionSort \n "
                + "2 - InserctionSort \n 3 - BubbleSort"));

        int qtd = Integer.parseInt(JOptionPane.showInputDialog("Qual o tamanho do vetor desejado:"));

        int[] vetorInteiros = new int[qtd];

        for (int i = 0; i < qtd; i++) {

            int input = Integer.parseInt(JOptionPane.showInputDialog("Insira os valores do vetor: "));
            vetorInteiros[i] = input;
        }

        System.out.println("Vetor original");

        for (int i = 0; i < vetorInteiros.length; i++) {

            System.out.println("Vetor não ordenado[" + i + "] = " + vetorInteiros[i]);

        }

        if (tipo == 1) {

            long inicio = System.nanoTime();
            
            for (int i = 0; i < vetorInteiros.length - 1; i++) {

                int posMenor = i;

                for (int j = i + 1; j < vetorInteiros.length; j++) {

                    if (vetorInteiros[j] < vetorInteiros[posMenor]) {

                        posMenor = j;

                    }
                }

                if (posMenor != i) {

                    int aux = vetorInteiros[i];
                    vetorInteiros[i] = vetorInteiros[posMenor];
                    vetorInteiros[posMenor] = aux;

                }

            }
            
            System.out.println("Metodo selecionado SelectionSort");

            long fim = System.nanoTime();
            long tempoExecucao = fim - inicio;            
            
            for (int i = 0; i < vetorInteiros.length; i++) {

                System.out.println("Vetor[" + i + "] = " + vetorInteiros[i]);
                
            }
            
            System.out.println("Tempo de execução: " + tempoExecucao + "ns");
            
        } else if (tipo == 2) {

            int chave, j;
            long inicio = System.nanoTime();
            
            for (int i = 0; i < vetorInteiros.length; i++) {
                chave = vetorInteiros[i];

                for (j = i - 1; j >= 0 && vetorInteiros[j] > chave; j--) {

                    vetorInteiros[j + 1] = vetorInteiros[j];

                }

                vetorInteiros[j + 1] = chave;

            }
            
            System.out.println("Metodo selecionado InserctionSort");

            long fim = System.nanoTime();
            long tempoExecucao = fim - inicio;            
            
            for (int i = 0; i < vetorInteiros.length; i++) {
                System.out.println("Vetor[" + i + "] = " + vetorInteiros[i]);
            }
            
            System.out.println("Tempo de execução: " + tempoExecucao + "ns");
            
        } else if (tipo == 3) {
            boolean troca = true;
            long inicio = System.nanoTime();
            
            while (troca) {

                troca = false;
                for (int i = 0; i < vetorInteiros.length - 1; i++) {
                    if (vetorInteiros[i] > vetorInteiros[i + 1]) {
                        int aux = vetorInteiros[i];
                        vetorInteiros[i] = vetorInteiros[i + 1];
                        vetorInteiros[i + 1] = aux;
                        troca = true;
                    }
                }

            }

            System.out.println("Metodo selecionado BubbleSort");
            
            long fim = System.nanoTime();
            long tempoExecucao = fim - inicio;
            
            for (int i = 0; i < vetorInteiros.length; i++) {

                System.out.println("Vetor[" + i + "] = " + vetorInteiros[i]);
                

            }
            
            System.out.println("Tempo de execução: " + tempoExecucao + "ns");

        } else {
            System.out.println("Escolha incorreta");
        }

    }
}
