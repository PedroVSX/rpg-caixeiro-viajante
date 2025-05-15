package Handlers;

import java.util.Scanner;

public class InputHandler {
    
    private Scanner input;;

    public InputHandler() {
        input = new Scanner(System.in);
    }

    public String getString() {
        String str = input.nextLine();

        while (str.isEmpty()) {
            System.out.print("Entrada inválida. Tente novamente: ");
            str = input.nextLine();
        }

        return str;
    }

    public int getInt() {
        String num = input.nextLine();

        while (!num.matches("\\d+")) {
            System.out.print("Número inválido. Tente novamente: ");
            num = input.nextLine();
        }

        return Integer.parseInt(num);
    }

    public int getInt(int min, int max) {
        int num = getInt();

        while (num < min || num > max) {
            System.out.print("Número inválido. Tente novamente: ");
            num = getInt();
        }

        return num;
    }

}
