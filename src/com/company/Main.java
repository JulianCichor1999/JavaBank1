package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static ArrayList<KartaPlatnicza> klienci = new ArrayList<>();
    public static void main(String[] args) {
        try {
            File plik = new File("klienci.csv");
            Scanner scanner = new Scanner(plik);
            while(scanner.hasNextLine())
            {
                String data = scanner.nextLine();

                String[] clients = data.split(",");
                String imie = clients[0];
                String nazwisko = clients[1];
                long numerKonta = Long.parseLong(clients[2].replaceAll("\\s+", ""));
                short numerPIN = Short.parseShort(clients[3]);
                double srodki = Double.parseDouble(clients[4]);

                if ("visa".equals(clients[5].toLowerCase())) {
                    KartaPlatniczaVisa kpVisa = new KartaPlatniczaVisa(imie, nazwisko, numerKonta, numerPIN, srodki);
                    klienci.add(kpVisa);
                } else if ("mastercard".equals(clients[5].toLowerCase())) {
                    KartaPlatniczaMastercard kpMastercard = new KartaPlatniczaMastercard(
                            imie, nazwisko, numerKonta, numerPIN, srodki);
                    klienci.add(kpMastercard);
                } else {
                    System.out.println("Nie wspieramy twojej karty!");
                }
            }
            for(KartaPlatnicza kl: klienci)
            {
                System.out.println(kl.toString());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.print("Wystąpił błąd pliku!");
        }

    }
}