package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<KartaPlatnicza> klienci = Reader.getKlienci();
        KartaPlatnicza kartaPlatnicza = Reader.getKarta(klienci);

        boolean czyVisa = "visa".equals(kartaPlatnicza.getProducentKarty().toString());

//        lista opcji
        ArrayList<String> opcje = new ArrayList<>();
        opcje.add("Wyświetl środki");
        opcje.add("Wypłać pieniądze");
        if (czyVisa) {
            opcje.add("Wpłać pieniądze");
        }
        opcje.add("Wyjście");

        int wybranaOpcja = -1;
        while (true) {
//            pobieramy opcje od uzytkownika
            System.out.println("Wybierz opcje:");
            for (int i = 0; i < opcje.size(); i++) {
                System.out.printf("%d: %s%n", i + 1, opcje.get(i));
            }
            try {
                wybranaOpcja = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Nie ma takiej opcji!");
                continue;
            }


//            sprawdzanie jaka opcja jest wybrana
            if (!(wybranaOpcja != 4 && czyVisa || wybranaOpcja != 3 && !czyVisa)) {
                System.out.println("Zamknięto program");
                break;
            }

            if (wybranaOpcja == 1) {

                kartaPlatnicza.wyswietlBalans();

            } else if (wybranaOpcja == 2) {

                try {
                    System.out.print("Ile chcesz wypłacić pieniędzy: ");
                    kartaPlatnicza.wyplacPieniadze(Double.parseDouble(scanner.nextLine()));
                } catch (NumberFormatException e) {
                    System.out.println("Błędny format danych!");
                }

            } else if (wybranaOpcja == 3 && czyVisa) {

                try {
                    System.out.print("Ile chcesz wpłacic pieniędzy: ");
                    ((KartaPlatniczaVisa) kartaPlatnicza).doliczSrodki(Double.parseDouble(scanner.nextLine()));
                } catch (NumberFormatException e) {
                    System.out.println("Błędny format danych!");
                }

            } else {

                System.out.println("Nie ma takiej opcji!");

            }
        }


        scanner.close();
    }
}