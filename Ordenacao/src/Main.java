import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();

        System.out.println("Digite os números separados por espaço:");
        String[] entrada = scanner.nextLine().split(" ");
        for (String s : entrada) {
            numeros.add(Integer.parseInt(s));
        }

        ContextoDeOrdenacao contexto = new ContextoDeOrdenacao();

        System.out.println("Escolha o algoritmo de ordenação:");
        System.out.println("1 - Bubble Sort");
        System.out.println("2 - Selection Sort");
        System.out.println("3 - Insertion Sort");
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                contexto.setEstrategia(new OrdenacaoBubbleSort());
                break;
            case 2:
                contexto.setEstrategia(new OrdenacaoSelectionSort());
                break;
            case 3:
                contexto.setEstrategia(new OrdenacaoInsertionSort());
                break;
            default:
                System.out.println("Escolha inválida!");
                scanner.close();
                return;
        }

        System.out.println("Lista antes da ordenação: " + numeros);
        contexto.executarOrdenacao(numeros);
        System.out.println("Lista após a ordenação: " + numeros);

        scanner.close();
    }
}