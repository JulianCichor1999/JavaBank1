package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<KartaPlatnicza> klienci = Reader.getKlienci();
        KartaPlatnicza kartaPlatnicza = Reader.getKarta(klienci);

//        lista opcji
        ArrayList<String> opcje = new ArrayList<>();
        opcje.add("Wyświetl środki");
        opcje.add("Wypłać pieniądze");
        opcje.add("Wpłać pieniądze");
        opcje.add("Wyjście");

        int wybranaOpcja;
        while (true) {
//            pobieramy opcje od uzytkownika
            System.out.printf("Sz. P. %s %s\n",kartaPlatnicza.getImie(),kartaPlatnicza.getNazwisko());
            System.out.println("Wybierz opcję:");
            for (int i = 0; i < opcje.size(); i++) {
                System.out.printf("%d: %s%n", i + 1, opcje.get(i));
            }

            try {
                wybranaOpcja = Integer.parseInt(scanner.nextLine());

                switch (wybranaOpcja) {
                    case 1:
                        kartaPlatnicza.wyswietlBalans();
                        break;
                    case 2:
                            System.out.print("Ile chcesz wypłacić pieniędzy: ");
                            kartaPlatnicza.wyplacPieniadze(Double.parseDouble(scanner.nextLine().replaceAll(",", ".")));
                        break;
                    case 3:
                        System.out.print("Ile chcesz wpłacic pieniędzy: ");
                        kartaPlatnicza.doliczSrodki(Double.parseDouble(scanner.nextLine()));
                        break;
                    case 4:
                        System.out.print("Dziękujemy!");
                        return;
                    default:
                        System.out.print("Nie ma takiego polecenia!");
                }

            } catch (NumberFormatException e) {

                System.out.println("Błędny format danych!");

            } catch (NiewystarczajaceSrodkiException | ZeroWyplataException e) {

                System.out.println(e.getMessage());

            }
        }
    }
}