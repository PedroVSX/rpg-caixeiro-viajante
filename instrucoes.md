<img src="imgs/UNIFOR_logo1b.png" width="400"> 

# T290 - Resolução de Problemas com Grafos
Orientador: Prof. Me Ricardo Carubbi

## T2 - Problema do Caixeira Viajante

<img src="imgs/logo.png" width="400"> 

### Introdução

Dado N pontos no plano, o objetivo do problema do caixeiro viajante (TSP) é visitar todos os pontos (e retornar ao ponto de partida) mantendo a distância total percorrida o mais curta possível. Você deve implementar duas heurísticas gulosas para encontrar boas (mas não necessariamente ótimas) soluções para o TSP.

<img src="imgs/TSP-1000.png" width="800"> 

### Perspectiva

A importância do TSP não está apenas em vendedores minimizando distâncias, mas em diversas aplicações: roteamento de veículos, perfuração de placas de circuito, projeto VLSI, controle de robôs, cristalografia de raios-X, escalonamento de tarefas e biologia computacional.

### Heurísticas Gulosas

O TSP é um problema de otimização combinatória notoriamente difícil. Em princípio, pode-se enumerar todos os ciclos e escolher o menor, mas o número de ciclos é tão grande (\~N!) que isso é impraticável. Para grandes N, não existe método eficiente conhecido para garantir o melhor ciclo.

Muitos métodos heurísticos foram estudados. Seu objetivo é implementar:

- **Heurística do Vizinho Mais Próximo:** Ler o próximo ponto e adicioná-lo ao ciclo após o ponto mais próximo.
- **Heurística do Menor Aumento:** Ler o próximo ponto e adicioná-lo onde causar o menor aumento no comprimento do ciclo.

### Tipo de dado Point

```java
public class Point {
    Point(double x, double y)  // cria o ponto (x, y)
    String toString()          // representação em string
    void draw()                // desenha o ponto
    void drawTo(Point that)    // desenha segmento até outro ponto
    double distanceTo(Point that)  // distância euclidiana
}
```

A classe `Point` é fornecida para uso.

### Tipo de dado Tour

Implemente a classe `Tour` representando o ciclo como uma lista encadeada circular de `Node`s:

```java
private class Node {
    private Point p;
    private Node next;
}
```

API da classe `Tour`:

```java
public class Tour {
    Tour()  // cria um ciclo vazio
    Tour(Point a, Point b, Point c, Point d) // cria ciclo a->b->c->d->a
    void show()
    void draw()
    int size()
    double distance()
    void insertNearest(Point p)
    void insertSmallest(Point p)
}
```

### Entrada e Testes

O formato de entrada é: dois inteiros w e h, seguidos por pares (x, y).

Exemplo de entrada (`tsp1000.txt`):

```
775 768
185.0411 457.8824
247.5023 299.4322
701.3532 369.7156
...
```

### Execução dos Clientes

Após implementar `Tour.java`, use:

```bash
java NearestInsertion < data/tsp1000.txt
```

```bash
java SmallestInsertion < data/tsp1000.txt
```

### Arquivos Fornecidos

Arquivos de teste, saídas esperadas, a classe `Point`, clientes `NearestInsertion`, `SmallestInsertion` e `TSPTimer`, e o modelo de `readme.txt` estão disponíveis.

### Análise

No `readme.txt`, estime o tempo de execução como função de N usando o `TSPTimer.java`.

Execute para N = 10.000 e dobre N até exceder 60 segundos.

## Entrega

Submeta pelo AVA `Tour.java` e `readme.txt`.