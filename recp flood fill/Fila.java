public class Fila <T> {
    private static class Node<T>{
        public Fila.Node <T> next;
        public T data;

    }

    private Node<T> front;
    private Node<T> rear;

    public Fila (){
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void add(T value){
        var node  = new Node<T>();
        node.data  = value;
        if (isEmpty()) {
            front = node;
            rear  = node;
        }else{
            node.next = front;
            front = node;
        }
    }

    public T remove() {
        if(isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public void clear() {
        front = null;
        rear = null;
    }

    public class FloodFillQ {
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

            Fila <Position> Q = new Fila<>();
            Q.add(new Position(startX, startY));

            while (!Q.isEmpty()) {
                Position current = Q.remove();
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
            
    
                Q.add(new Position(x, y - 1)); 
                Q.add(new Position(x, y + 1)); 
                Q.add(new Position(x - 1, y)); 
                Q.add(new Position(x + 1, y)); 
                
            
            }


        }
    }

}