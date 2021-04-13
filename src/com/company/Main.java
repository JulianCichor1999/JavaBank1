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
            Scanner myReader = new Scanner(plik);
            while(myReader.hasNext())
            {
                String data = myReader.nextLine();
                String[] clients = data.split(",");
                String imie = clients[0];
                String nazwisko = clients[1];
                String numerKonta = clients[2];
                String numerPIN = clients[3];
                double srodki = Double.parseDouble(clients[4]);
                String producentKarty = clients[5];
                KartaPlatnicza k = new KartaPlatnicza(imie,nazwisko,numerKonta,numerPIN,srodki,producentKarty);
                klienci.add(k);
            }
            for(KartaPlatnicza kl: klienci)
            {
                System.out.println(kl.toString());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.print("Wystąpił błąd pliku!");
        }

    }
}