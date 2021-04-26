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

                KartaPlatnicza kp = KartaPlatnicza.parseData(data);
                if (kp.getProducentKarty().equals(Producenci.VISA)) {
                    KartaPlatniczaVisa kpVisa = new KartaPlatniczaVisa(
                            kp.getImie(), kp.getNazwisko(), kp.getNumerKarty(), kp.getPIN(), kp.getSrodki());
                    klienci.add(kpVisa);
                } else if (kp.getProducentKarty().equals(Producenci.MASTERCARD)) {
                    KartaPlatniczaMastercard kpMastercard = new KartaPlatniczaMastercard(
                            kp.getImie(), kp.getNazwisko(), kp.getNumerKarty(), kp.getPIN(), kp.getSrodki());
                    klienci.add(kpMastercard);
                } else {
                    System.out.println("Nie wspieramy twojej karty!");
                }
            }
//            for(KartaPlatnicza kl: klienci)
//            {
//                System.out.println(kl.toString());
//            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.print("Wystąpił błąd pliku!");
        }

    }
}