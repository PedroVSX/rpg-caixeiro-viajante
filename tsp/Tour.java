/* *****************************************************************************
 * Grupo:
 * Alunos integrantes: Pedro Vieira, Samir Alves, Luiz Arthur, Rafael Luka, Leonardo Coelho
 *
 * Descrição: Esta classe define o tipo de dado Tour implementando uma
 * Lista Encadeada Circular e definindo métodos para permitir a implementação
 * de duas heurísticas para encontrar boas soluções para o TSP.
 **************************************************************************** */

 import edu.princeton.cs.algs4.StdIn;
 import edu.princeton.cs.algs4.StdOut;
 import edu.princeton.cs.algs4.StdDraw;

 public class Tour {
    private class Node {
        private Point p; // valor do ponto do nó
        private Node next; // ponteiro para o próximo nó
    }

    private Node start; // primeiro nó na lista encadeada

    // cria um ciclo vazio
    public Tour() {
        start = new Node();
    }

    // cria o ciclo de 4 pontos a->b->c->d->a (para depuração)
    public Tour(Point a, Point b, Point c, Point d) {
        start = new Node();
        Node b1 = new Node();
        Node c1 = new Node();
        Node d1 = new Node();
        start.p = a;
        b1.p = b;
        c1.p = c;
        d1.p = d;
        start.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = start;
    }

    // retorna o número de pontos neste ciclo
    public int size() {
        if (start.p == null) {
            return 0;
        } else {
            int counter = 0;
            Node current = start;
            do {
                current = current.next;
                counter += 1;
            } while (!current.equals(start));
            return counter;
        }
    }

    // retorna o comprimento deste ciclo
    public double length() {
        if (start.p == null) {
            return 0.0;
        } else {
            double distance = 0.0;
            Node current = start;
            do {
                distance += current.p.distanceTo(current.next.p);
                current = current.next;
            } while (!current.equals(start));
            return distance;
        }
    }

    // retorna uma representação em string deste ciclo
    public String toString() {
        if (start.p == null) {
            return "";
        } else {
            Node current = start;
            StringBuilder str = new StringBuilder();
            do {
                str.append(current.p.toString() + "\n");
                current = current.next;
            } while (!current.equals(start));
            return str.toString();
        }
    }

    // desenha este ciclo na tela padrão
    public void draw() {
        if (start.p != null && start.next != null) {
            Node current = start;
            do {
                current.p.drawTo(current.next.p);
                current = current.next;
            } while (!current.equals(start));
        }
    }

    // insere p usando a heurística do vizinho mais próximo
    public void insertNearest(Point p) {
        if (start.p == null) {
            start.p = p;
            start.next = start;
            return;
        }

        Node nearest = start;
        double minDistance = p.distanceTo(start.p);
        Node current = start.next;

        while (current != start) {
            double dist = p.distanceTo(current.p);
            if (dist < minDistance) {
                minDistance = dist;
                nearest = current;
            }
            current = current.next;
        }

        Node newNode = new Node();
        newNode.p = p;
        newNode.next = nearest.next;
        nearest.next = newNode;
    }

    // insere p usando a heurística do menor aumento
    public void insertSmallest(Point p) {
        if (start.p == null) {
            start.p = p;
            start.next = start;
            return;
        }
    
        Node best = start;
        double minIncrease = Double.MAX_VALUE;
        Node current = start;

        do {
            double increase = current.p.distanceTo(p) + p.distanceTo(current.next.p)
                              - current.p.distanceTo(current.next.p);
            if (increase < minIncrease) {
                minIncrease = increase;
                best = current;
            }
            current = current.next;
        } while (current != start);
    
        Node newNode = new Node();
        newNode.p = p;
        newNode.next = best.next;
        best.next = newNode;
    }

    // testa esta classe chamando todos os construtores e métodos de instância
    public static void main(String[] args) {
        // define 4 pontos, vértices de um quadrado
        Point a = new Point(1.0, 1.0);
        Point b = new Point(1.0, 4.0);
        Point c = new Point(4.0, 4.0);
        Point d = new Point(4.0, 1.0);

        // cria o ciclo a -> b -> c -> d -> a
        Tour squareTour = new Tour(a, b, c, d);

        // imprime o número de pontos na saída padrão
        int size = squareTour.size();
        StdOut.println("# de pontos = " + size);

        // imprime o comprimento do ciclo na saída padrão
        double length = squareTour.length();
        StdOut.println("Comprimento do ciclo = " + length);

        // imprime o ciclo na saída padrão
        StdOut.println(squareTour);

        StdDraw.setXscale(0, 6);
        StdDraw.setYscale(0, 6);

        Point e = new Point(5.0, 6.0);
        squareTour.insertNearest(e);
        squareTour.insertSmallest(e);
        squareTour.draw();
    }
}
