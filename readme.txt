*****************************************************************************************************
T290 - Resolução de Problemas com Grafos
Orientador: Prof. Me Ricardo Carubbi
*****************************************************************************************************

Trabalho 2: Problema do Caixeiro Viajante

Horas para completar o trabalho (opcional):

Q1. Explique como você implementou a heurística de inserção pelo vizinho mais próximo.
Comente também como você atualiza as ligações da lista encadeada circular após inserir o novo ponto.

Resposta: Essa heurística foi implementada no método "Tour.insertNearest(Point p)". Se o ciclo atual estiver vazio o ponto "p" é adicionado no ciclo e aponta para si, quando o ciclo já possui pontos o algoritmo percorre cada arresta do ciclo e calcula a distância entre o ponto atual e novo ponto "p". Quando o vizinho mais próximo e identificado o novo ponto "p" é inserido após o ponto atual. Quando o novo ponto "p" é inserido o ponteiro "next" é atualizado para armazenar a referência ao proximo nó do "nearest", após isso o ponteiro "next" do nó "nearest" é atualizado para armazenar a referência do novo nó, inserido o ponto "p" após o nó "nearest". Dessa forma as ligações entre os nós da lista encadeada é mantida, preservando a sua estrutura circular.

Q2. Explique como você implementou a heurística de menor aumento.
Liste apenas as diferenças em relação à heurística de inserção pelo vizinho mais próximo.

Resposta: Essa heurística foi implementada no método "Tour.insertSmallest(Point p)". Se o ciclo atual estiver vazio o ponto "P" é adicionado no ciclo e aponta para si, quando o ciclo já possui pontos o algoritmo percorre cada arresta do ciclo, e para ciclo, calcula o valor do comprimento total do ciclo se o ponto "P" fosse adicionado entre esses dois pontos. Ou seja, ele compara o valor da nova rota com a atual, a rota quer apresentar o menor aumento e armazenada. Ao final da iteração um novo ponto é adicionado no local que causa o menor aumento possível no comprimento desse ciclo, isso é feito criando um novo nó, na lista encadeada, com o ponto "p" e ajustando os ponteiros da lista encadeada para manter sua estrutura circular. A diferença entre essas duas heurísticas estão na forma inserção do ponto "p" no ciclo a do vizinho mais proximo visa inserir um novo ponto onde a distância entre ele e o ponto atual for a mais próxima, a do menor aumento visa inserir um novo ponto no ciclo onde a inserção do mesmo causa o menor aumento possível do ciclo.

Q3. Explique por que é melhor usar uma lista encadeada circular em vez de um vetor.
Considere a complexidade das operações de inserção e remoção de pontos.

Resposta: Uma lista encadeada circular ofereçe melhor inserção e remoção por possuir uma complexidade de O(1), diferente dos vetores que possuem uma complexidade de O(N), e por também representar um ciclo natural do TSP, já que o último ponto se conecta com o primeiro sem necessidade de tratamento especial.

Q4. Preencha os comprimentos calculados pelas suas heurísticas.

| Arquivo de dados | Vizinho mais próximo | Menor aumento |
| ---------------- | -------------------- | ------------- |
| tsp10.txt        | 1566.1363            | 1655.7462     |
| tsp100.txt       | 7389.9296            | 4887.2190     |
| tsp1000.txt      | 27868.7106           | 17265.6281    |
| usa13509.txt     | 77449.9794           | 45074.7769    |
| tsp85900.txt     | 125660.3433          | 82621.6659    |

Q5. Realize duas análises de tempo

Comente se o valor de \(b\) encontrado é coerente com a análise teórica da complexidade de seu algoritmo.

- Estime o tempo de execução (em segundos) de cada heurística como uma função de \(n\), usando expressões da forma: \(a \times n^b\), onde \(b\) é um inteiro.
- Explique como você determinou cada uma das respostas.
- Para obter seus pontos de dados, execute as duas heurísticas para \(n = 1000\) e dobre \(n\) repetidamente até que o tempo de execução ultrapasse 60 segundos.
- Você pode usar o **TSPTimer** para ajudar, conforme indicado na lista de verificação.
- Se usar, execute com a opção **-Xint** para desativar otimizações do compilador.
- Se para \(n = 1000\) o tempo já ultrapassar 60 segundos, seu código está muito lento. Veja a lista de verificação para sugestões de correção.

Resposta:
Vizinho mais próximo:
A inserção do primeiro é constante, já o segundo compara com 1 ponto, o terceiro com 2, o quarto com 3 e assim em diante.
Portanto, teríamos o seguinte: 1+2+3+4+...+(n-2)+(n-1)
Que é igual a: (n*(n-1)) / 2
Que portanto é: n^2 / 2
Assim, a complexidade seria: O(n^2)

Menor aumento:
A inserção do primeiro também é constante, o segundo compara com 1 aresta, o terceiro com 2 e assim por diante.
Teríamos portanto: 1+2+3+4+...+(n-2)+(n-1)
Que é igual a: (n*(n-1)) / 2
Que portanto é: n^2 / 2
Assim, a complexidade seria: O(n^2)

| n    | Tempo vizinho mais próximo (s) | Tempo menor aumento (s) |
| ---- | ------------------------------ | ----------------------- |
| 1000 | 0,0040                         | 0,0110                  |
| 2000 | 0,0100                         | 0,0160                  |
| 4000 | 0,0300                         | 0,0450                  |
| 8000 | 0,1970                         | 0,2280                  |
| 16000| 1,2240                         | 1,2630                  |
| 32000| 5,9060                         | 6,0850                  |
| 64000| 25,8410                        | 26,3520                 |
|128000| 122,6960                       | 74,1610                 |
