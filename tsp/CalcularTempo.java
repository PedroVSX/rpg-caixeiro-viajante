import java.io.FileWriter;
import java.io.IOException;

public class CalcularTempo {

    public static void main(String[] args) throws IOException {
//        TSPTimer.main(new String[]{String.valueOf(1000)});
        int n = 1_000;
        double tempoMenorAumento, tempoVizinhoProximo;

        try (FileWriter fileWriter = new FileWriter("tempos.txt")){
            System.out.println("Calculando tempo...");

            fileWriter.write("""
                    | n    | Tempo vizinho mais próximo (s) | Tempo menor aumento (s) |
                    | ---- | ------------------------------ | ----------------------- |
                    """);
            do {
                System.out.println("lendo arquivo...");
                tempoMenorAumento = TSPTimer.menorAumento(n);
                tempoVizinhoProximo = TSPTimer.vizinhoProximo(n);

                String linhaTempo = String.format("""
                        |  %d  | %.4f                           | %.4f                    |
                        """,n,tempoVizinhoProximo,tempoMenorAumento);

                fileWriter.write(linhaTempo);
                n*=2;

            } while (!(tempoMenorAumento > 60d) || !(tempoVizinhoProximo > 60d));

            System.out.println("O tempo foi calculado");
        } catch (Exception e){
            e.getStackTrace();
        }
    }
}