import Handlers.InputHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        InputHandler input = new InputHandler();

        String[] files = {
            "data/tsp10.txt",
            "data/tsp100.txt",
            "data/tsp1000.txt",
            "data/tsp85900.txt",
            "data/usa13509.txt"
        };

        System.out.print(
            """
            *****************************************************************************
            Escolha um arquivo de entrada:
            1 - tsp10.txt
            2 - tsp100.txt
            3 - tsp1000.txt
            4 - tsp85900.txt
            5 - usa13509.txt
            *****************************************************************************
            Sua escolha:\s"""
        );

        int choice = input.getInt(1, 5);
        System.out.println("Arquivo escolhido: " + files[choice - 1]);

        String filePath = files[choice - 1];

        System.out.print(
            """
            *****************************************************************************
            Escolha a heurística:
            1 - Vizinho mais próximo (Nearest Insertion)
            2 - Menor Aumento (Smallest Insertion)
            *****************************************************************************
            Sua escolha:\s"""
        );

        int heuristic = input.getInt(1, 2);
        System.out.println("Heurística escolhida: " + (heuristic == 1 ? "Vizinho mais próximo" : "Menor Aumento"));

        try {
            // Redireciona a entrada padrão (System.in) para o arquivo
            System.setIn(new FileInputStream(filePath));

            // Executa o algoritmo como se fosse via linha de comando
            if (heuristic == 1) {
                NearestInsertion.main(new String[] {});
            } else {
                SmallestInsertion.main(new String[] {});
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + filePath);
        }
    }   
}
