public class Pilha <T> {
    private static class Node<T>{
        public Pilha.Node <T> previous;
        public T data;

    }

    private Node<T> top;

    public Pilha (){
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push (T value){
        var node  = new Node<T>();
        node.data  = value;
        node.previous = top;
        top = node;
    }

    public T pop() {
        if(isEmpty()) {
            throw new IllegalStateException("A Pilha está vazia");
        }
        T data = top.data;
        top = top.previous;
        return data;
    }

    public void clear() {
        top = null;
    }

    public class FloodFillP {
        public static class Position {
            int x;
            int y;

            public Position (int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        public static void performFloodFill(int[][] matrix, int startX, int startY, int targetValue, int fillValue) {
            int rows = matrix.length;
            int cols = matrix[0].length;

            if (startX < 0 && startX >= rows && startY < 0 && startY >=cols) {
                throw new IllegalArgumentException("Coordenadas Inválidas!");
            }

            int originalValue = matrix[startX][startY];
            if (originalValue == fillValue) {
                return;
            }

            Pilha <Position> P = new Pilha<>();
            P.push(new Position(startX, startY));

            while (!P.isEmpty()) {
                Position current = P.pop();
                int x = current.x;
                int y = current.y;
                if (x < 0 || x >= rows || y < 0 || y >= cols || matrix[x][y] != originalValue) {
                    continue;
                }
    
                matrix[x][y] = fillValue;
                for (int[] row : matrix) {
                    for (int value : row) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            
    
                P.push(new Position(x, y - 1)); 
                P.push(new Position(x, y + 1)); 
                P.push(new Position(x - 1, y)); 
                P.push(new Position(x + 1, y)); 
                
            
            }


        }
    }

}