package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<KartaPlatnicza> klienci = Reader.getKlienci();
        KartaPlatnicza kartaPlatnicza = Reader.getKarta(klienci);

        ArrayList<String> opcje = new ArrayList<>();
        opcje.add("Wyświetl środki");
        opcje.add("Wypłać pieniądze");
//        opcje.add("Wpłać pieniądze");

        System.out.println("Wybierz opcje:");
        for (int i = 0; i < opcje.size(); i++) {
            System.out.printf("%d: %s%n", i + 1, opcje.get(i));
        }
        int wybranaOpcja = -1;
        try {
            wybranaOpcja = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Nie ma takiej opcji!");
        }

        switch (wybranaOpcja) {
            case 1:
                kartaPlatnicza.wyswietlBalans();
                break;
            case 2:
                try {
                    kartaPlatnicza.wyplacPieniadze(Integer.parseInt(scanner.nextLine()));
                } catch (NumberFormatException e) {
                    System.out.println("Błędny format danych!");
                }
                break;
            case 3:
//                ...
                break;
            default:
                System.out.println("Nie ma takiej opcji!");
        }

        scanner.close();
    }
}