*****************************************************************************************************
T290 - Resolução de Problemas com Grafos
Orientador: Prof. Me Ricardo Carubbi
*****************************************************************************************************

Trabalho 2: Problema do Caixeiro Viajante

Q1. Explique como você implementou a heurística de inserção pelo vizinho mais próximo.
Comente também como você atualiza as ligações da lista encadeada circular após inserir o novo ponto.

Resposta: Essa heurística foi implementada no método "insertNearest(Point p)". Se o ciclo ainda estiver vazio, o novo ponto é inserido como o primeiro elemento do ciclo. Neste caso, o nó inicial "start" recebe o ponto "p", e o ponteiro "next" desse nó aponta para si, formando um ciclo de um único ponto. Se o ciclo já contiver outros pontos, o algoritmo inicia com o ponto de início "start" como o mais proximo, e vai atualizando sempre que encontrar o outro nó cuja distância ao novo ponto seja menor.

Quando um novo ponto é inserido, o ponteiro "next" do nó mais próximo passa apontar para o novo nó, e depois o ponteiro "next" do novo nó passa a apontar para o nó que anteriormente vinha após "nearest".

Q2. Explique como você implementou a heurística de menor aumento.
Liste apenas as diferenças em relação à heurística de inserção pelo vizinho mais próximo.

Resposta: Essa heurística foi implementada no método "insertSmallest(Point p)". O processo começa verificando se o ciclo está vazio. Se estiver, o novo ponto "p" é adicionado como um único nó no ciclo. Nesse caso, o ponteiro "next" aponta para ele mesmo, formando um ciclo fechado de um único ponto. Quando o ciclo já possui pontos, o algoritmo percorre todos os pares consecutivos de pontos no ciclo para descobrir onde a inserção de "p" causaria o menor aumento na distância total. Para cada par de nós consecutivos, ele calcula o custo de inserir "p" entre eles. Esse custo é a diferença entre a soma das distâncias dos segmentos novos e a distância original entre "current.p" e "current.p.next".

A heurística de menor custo busca inserir um novo ponto busca inserir o novo ponto no local onde ele cause o menor aumento possível no comprimento total do ciclo. Em vez de considerar apenas a distância direta, ela percorre todos os pares consecutivos de pontos no ciclo e calcula o quanto a inserção do novo ponto entre eles aumentaria a distância total. Diferente da heurística do vizinho mais próximo onde o novo ponto é inserido logo após o ponto mais próximo já presente no ciclo. O algoritmo percorre todos os pontos existentes e mede a distância entre o novo ponto e cada um deles, a principal diferença entre as duas heurísticas são o critério de escolha do local de inserção: o vizinho mais próximo foca na menor distância entre dois pontos, a do menor aumento considera o efeito de inserção sobre o comprimento total do ciclo, resultando em soluções mais eficientes dependendo do contexto.

Q3. Explique por que é melhor usar uma lista encadeada circular em vez de um vetor.
Considere a complexidade das operações de inserção e remoção de pontos.

Resposta: Nesse contexto, o uso de uma lista encadeada circular é mais adequado porque facilita a representação de ciclos, permite inserções e remoções rápidas e evira o redimensionamento e manipulações de índices usados em um vetor.

Q4. Preencha os comprimentos calculados pelas suas heurísticas.

| Arquivo de dados | Vizinho mais próximo | Menor aumento |
| ---------------- | -------------------- | ------------- |
| tsp10.txt        | 1566.1363            | 1655.7462     |
| tsp100.txt       | 7389.9296            | 4887.2190     |
| tsp1000.txt      | 27868.7106           | 17265.6281    |
| usa13509.txt     | 77449.9794           | 45074.7769    |

Q5. Realize duas análises de tempo

Comente se o valor de \(b\) encontrado é coerente com a análise teórica da complexidade de seu algoritmo.

- Estime o tempo de execução (em segundos) de cada heurística como uma função de \(n\), usando expressões da forma: \(a \times n^b\), onde \(b\) é um inteiro.
- Explique como você determinou cada uma das respostas.
- Para obter seus pontos de dados, execute as duas heurísticas para \(n = 1000\) e dobre \(n\) repetidamente até que o tempo de execução ultrapasse 60 segundos.
- Você pode usar o **TSPTimer** para ajudar, conforme indicado na lista de verificação.
- Se usar, execute com a opção **-Xint** para desativar otimizações do compilador.
- Se para \(n = 1000\) o tempo já ultrapassar 60 segundos, seu código está muito lento. Veja a lista de verificação para sugestões de correção.

| n    | Tempo vizinho mais próximo (s) | Tempo menor aumento (s) |
| ---- | ------------------------------ | ----------------------- |
| 1000 | 0,0220                       | 0,0360                  |
| 2000 | 0,0220                       | 0,0350                  |
| 4000 | 0,0710                       | 0,1320                  |
| 8000 | 0,5790                       | 0,7040                  |
| 16000| 2,9050                       | 2,9930                  |
| 32000| 17,7370                      | 21,2970                 |
| 64000| 80,8680                      | 112,9650                |
