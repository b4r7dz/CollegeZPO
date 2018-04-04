package ZPO.Lab01.Task2;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        int liczba = 0b1101_1011;
        String number = Integer.toString(liczba);
        int numberD = Integer.parseInt(number);
        long numberI;

        Scanner scr = new Scanner(System.in);

        String menu = scr.nextLine();

        switch (menu) {
            case "dziesiec":
                System.out.println(numberD);
                break;

            case "trzy":
                numberI = asBase3(numberD);
                System.out.println(numberI);
                    break;

            case "szesnascie":
                number = Integer.toString(numberD, 16);
                System.out.println(number);
            default:
                System.out.println("Wrong input");

        }

    }

    public static long asBase3(int num) {
        long ret = 0, factor = 1;
        while (num > 0) {
            ret += num % 3 * factor;
            num /= 3;
            factor *= 10;
        }
        return ret;
    }

}
