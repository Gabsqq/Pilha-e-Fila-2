import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 1;
                }
            }
        }
        
        System.out.println("Matriz inicial:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
            }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a coordenada x inicial: ");
        int startX = scanner.nextInt();
        System.out.print("Digite a coordenada y inicial: ");
        int startY = scanner.nextInt();

        System.out.print("Digite o valor de preenchimento: ");
        int fillValue = scanner.nextInt();

        System.out.print("Escolha o algoritmo (1-Pilha, 2-Fila): ");

        int escolha = scanner.nextInt();
        
       if (escolha == 2){
            Fila fila = new Fila();
            Fila.FloodFillQ Q = fila.new FloodFillQ();
            Q.performFloodFill(matrix, startX, startY, matrix[startY][startX], fillValue);
       }else if (escolha == 1) {
            Pilha pilha = new Pilha();
            Pilha.FloodFillP P = pilha.new FloodFillP();
            P.performFloodFill(matrix, startX, startY, matrix[startY][startX], fillValue);
       }
        
}

}



